/**
 * The MIT License
 * Copyright (c) 2019- Nordic Institute for Interoperability Solutions (NIIS)
 * Copyright (c) 2018 Estonian Information System Authority (RIA),
 * Nordic Institute for Interoperability Solutions (NIIS), Population Register Centre (VRK)
 * Copyright (c) 2015-2017 Estonian Information System Authority (RIA), Population Register Centre (VRK)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ee.ria.xroad.proxy.messagelog;

import ee.ria.xroad.common.SystemProperties;
import ee.ria.xroad.common.message.RestRequest;
import ee.ria.xroad.common.message.RestResponse;
import ee.ria.xroad.common.message.SoapMessageImpl;
import ee.ria.xroad.common.messagelog.AbstractLogManager;
import ee.ria.xroad.common.messagelog.FindByQueryId;
import ee.ria.xroad.common.messagelog.MessageRecord;
import ee.ria.xroad.common.messagelog.RestLogMessage;
import ee.ria.xroad.common.messagelog.SoapLogMessage;
import ee.ria.xroad.common.messagelog.TimestampMessage;
import ee.ria.xroad.common.messagelog.TimestampRecord;
import ee.ria.xroad.common.signature.SignatureData;
import ee.ria.xroad.common.util.CacheInputStream;
import ee.ria.xroad.common.util.JobManager;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import lombok.extern.slf4j.Slf4j;
import scala.concurrent.Await;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

import static ee.ria.xroad.common.ErrorCodes.X_LOGGING_FAILED_X;
import static ee.ria.xroad.common.ErrorCodes.X_TIMESTAMPING_FAILED_X;
import static ee.ria.xroad.common.ErrorCodes.translateException;
import static ee.ria.xroad.common.ErrorCodes.translateWithPrefix;

/**
 * Contains methods for saving entries to the message log.
 */
@Slf4j
public final class MessageLog {

    private static final int ASK_TIMEOUT = 120;

    public static final String LOG_MANAGER = "LogManager";

    private static final String LOG_MANAGER_IMPL_CLASS = SystemProperties.PREFIX + "proxy.messageLogManagerImpl";
    public static final String CONTROL_AWARE_DISPATCHER = "akka.control-aware-dispatcher";

    private static ActorRef logManager;

    private MessageLog() {
    }

    /**
     * Initializes the message log using the provided actor system. Use control aware mailbox.
     *
     * @param actorSystem the actor system
     * @param jobManager  the job manager
     * @return false if NullLogManager was initialized, true otherwise
     * @throws Exception if initialization fails
     */
    public static boolean init(ActorSystem actorSystem, JobManager jobManager) {
        Class<? extends AbstractLogManager> clazz = getLogManagerImpl();

        log.trace("Using implementation class: {}", clazz);

        logManager = actorSystem.actorOf(Props.create(clazz, jobManager).withDispatcher(CONTROL_AWARE_DISPATCHER),
                LOG_MANAGER);

        return NullLogManager.class != clazz;
    }

    /**
     * Save the message and signature to message log. Attachments are not logged.
     *
     * @param message    the message
     * @param signature  the signature
     * @param clientSide whether this message is logged by the client proxy
     * @param xRequestId (optional) additional request if to distinguish request/response pairs
     */
    public static void log(SoapMessageImpl message, SignatureData signature, boolean clientSide,
            String xRequestId) {
        try {
            ask(new SoapLogMessage(message, signature, clientSide, xRequestId));
        } catch (Exception e) {
            throw translateWithPrefix(X_LOGGING_FAILED_X, e);
        }
    }

    /**
     * Save the message and signature to message log. The message body is saved from an input stream.
     */
    public static void log(RestRequest message, SignatureData signature, CacheInputStream body, boolean clientside,
            String xRequestId) {
        try {
            ask(new RestLogMessage(message.getQueryId(), message.getClientId(), message.getServiceId(),
                    message, signature, body, clientside, xRequestId));
        } catch (Exception e) {
            throw translateWithPrefix(X_LOGGING_FAILED_X, e);
        }
    }

    /**
     * Save the message and signature to message log. The message body is saved from an input stream.
     */
    public static void log(RestRequest request, RestResponse message,
            SignatureData signature, CacheInputStream body, boolean clientside, String xRequestId) {
        try {
            ask(new RestLogMessage(request.getQueryId(), request.getClientId(), request.getServiceId(),
                    message, signature, body, clientside, xRequestId));
        } catch (Exception e) {
            throw translateWithPrefix(X_LOGGING_FAILED_X, e);
        }
    }

    public static void log(SoapMessageImpl message, SignatureData signature, boolean clientSide) {
        log(message, signature, clientSide, null);
    }

    public static void log(RestRequest message, SignatureData signature, CacheInputStream body, boolean clientside) {
        log(message, signature, body, clientside, null);
    }

    public static void log(RestRequest request, RestResponse message,
                           SignatureData signature, CacheInputStream body, boolean clientside) {
        log(request, message, signature, body, clientside, null);
    }

    /**
     * Returns a log record for a given message Query Id, start and end time.
     *
     * @param queryId   the message query id
     * @param startTime the start time
     * @param endTime   the end time
     * @return the log record or null, if log record is not found in database.
     */
    public static LogRecord findByQueryId(String queryId, Date startTime, Date endTime) {
        try {
            assertInitialized();
            log.trace("findByQueryId({}, {}, {})", queryId, startTime, endTime);
            return (LogRecord) ask(new FindByQueryId(queryId, startTime, endTime));
        } catch (Exception e) {
            throw translateException(e);
        }
    }

    /**
     * Returns a time-stamp record for a given message record.
     *
     * @param record the message record
     * @return the time-stamp record or null, if time-stamping failed.
     */
    public static TimestampRecord timestamp(MessageRecord record) {
        try {
            log.trace("timestamp()");
            return (TimestampRecord) ask(new TimestampMessage(record.getId()));
        } catch (Exception e) {
            throw translateWithPrefix(X_TIMESTAMPING_FAILED_X, e);
        }
    }

    @SuppressWarnings("unchecked")
    private static Class<? extends AbstractLogManager> getLogManagerImpl() {
        String logManagerImplClassName = System.getProperty(LOG_MANAGER_IMPL_CLASS, NullLogManager.class.getName());

        try {
            Class<?> clazz = Class.forName(logManagerImplClassName);

            return (Class<? extends AbstractLogManager>) clazz;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load log manager impl: " + logManagerImplClassName, e);
        }
    }

    private static void assertInitialized() {
        if (logManager == null) {
            throw new IllegalStateException("not initialized");
        }
    }

    private static Object ask(Object message) throws Exception {
        assertInitialized();

        Timeout timeout = new Timeout(ASK_TIMEOUT, TimeUnit.SECONDS);
        Object result = Await.result(Patterns.ask(logManager, message, timeout), timeout.duration());

        if (result instanceof Exception) {
            throw (Exception) result;
        } else {
            return result;
        }
    }
}
