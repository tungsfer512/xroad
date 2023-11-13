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
import ee.ria.xroad.common.message.SoapMessageImpl;
import ee.ria.xroad.common.messagelog.AbstractLogManager;
import ee.ria.xroad.common.messagelog.MessageLogProperties;
import ee.ria.xroad.common.messagelog.MessageRecord;
import ee.ria.xroad.common.messagelog.RestLogMessage;
import ee.ria.xroad.common.messagelog.SoapLogMessage;
import ee.ria.xroad.common.messagelog.TimestampRecord;
import ee.ria.xroad.common.signature.SignatureData;
import ee.ria.xroad.common.util.CacheInputStream;
import ee.ria.xroad.common.util.JobManager;
import ee.ria.xroad.messagelog.archiver.LogArchiver;
import ee.ria.xroad.messagelog.archiver.LogCleaner;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.DeadLetter;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.testkit.TestActorRef;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigRenderOptions;
import com.typesafe.config.ConfigValueFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Slf4j
abstract class AbstractMessageLogTest {

    JobManager jobManager;
    ActorSystem actorSystem;
    LogManager logManager;

    protected final Path archivesPath = Paths.get("build/archive");

    @Getter
    private TestActorRef<LogManager> logManagerRef;
    private TestActorRef<LogArchiver> logArchiverRef;
    private TestActorRef<LogCleaner> logCleanerRef;

    void testSetUp() throws Exception {
        testSetUp(false);
    }

    private List<DeadLetter> deadLetters = new ArrayList<>();

    List<DeadLetter> getDeadLetters() {
        return deadLetters;
    }

    private void clearDeadLetters() {
        deadLetters = new ArrayList<>();
    }

    synchronized void addDeadLetter(DeadLetter d) {
        deadLetters.add(d);
    }

    public static class DeadLetterActor extends UntypedAbstractActor {

        private final AbstractMessageLogTest test;

        DeadLetterActor(AbstractMessageLogTest test) {
            this.test = test;
        }

        public void onReceive(Object message) {
            if (message instanceof DeadLetter) {
                log.info("dead letter: " + message);

                test.addDeadLetter((DeadLetter) message);
            }
        }
    }

    protected void testSetUp(boolean timestampImmediately) throws Exception {
        System.setProperty(SystemProperties.TEMP_FILES_PATH, "build/tmp");

        jobManager = new JobManager();
        clearDeadLetters();

        actorSystem = ActorSystem.create("Proxy", ConfigFactory.load()
                .getConfig("proxy")
                .withValue("akka.actor.provider", ConfigValueFactory.fromAnyRef("local"))); //remoting is not needed

        actorSystem.eventStream().subscribe(actorSystem.actorOf(Props.create(DeadLetterActor.class, this)),
                DeadLetter.class);

        System.setProperty(MessageLogProperties.TIMESTAMP_IMMEDIATELY, timestampImmediately ? "true" : "false");

        System.setProperty(MessageLogProperties.MESSAGE_BODY_LOGGING_ENABLED, "true");

        logManagerRef = TestActorRef.create(actorSystem, Props.create(getLogManagerImpl(), jobManager),
                MessageLog.LOG_MANAGER);

        if (!Files.exists(archivesPath)) {
            Files.createDirectory(archivesPath);
        }
        logArchiverRef = TestActorRef.create(actorSystem, Props.create(TestLogArchiver.class, archivesPath));
        logCleanerRef = TestActorRef.create(actorSystem, Props.create(TestLogCleaner.class));

        logManager = logManagerRef.underlyingActor();
    }

    // Use this to print Akka configuration out to log. May be useful when solving problems.
    protected void logAkkaConfiguration() {
        ConfigRenderOptions renderOpts = ConfigRenderOptions.defaults()
                .setOriginComments(false)
                .setComments(false)
                .setJson(false);
        String configString = ConfigFactory.load().root().render(renderOpts);

        log.info("akka configuration: {}", configString);
    }

    void testTearDown() throws Exception {
        jobManager.stop();
        Await.ready(actorSystem.terminate(), Duration.Inf());
        FileUtils.deleteDirectory(archivesPath.toFile());
    }

    protected Class<? extends AbstractLogManager> getLogManagerImpl() throws Exception {
        return LogManager.class;
    }

    void initLogManager() {
        signalTimestampingStatus(SetTimestampingStatusMessage.Status.SUCCESS);
    }

    /**
     * Sends time stamping status message to LogManager
     * @param status status message
     */
    private void signalTimestampingStatus(SetTimestampingStatusMessage.Status status) {
        logManagerRef.tell(new SetTimestampingStatusMessage(status), ActorRef.noSender());
    }

    protected void log(SoapMessageImpl message, SignatureData signature) throws Exception {
        logManager.log(new SoapLogMessage(message, signature, true));
    }

    protected void log(RestRequest message, SignatureData signatureData, byte[] body)
            throws Exception {
        final ByteArrayInputStream bos = new ByteArrayInputStream(body);
        final CacheInputStream cis = new CacheInputStream(bos, bos.available());

        final RestLogMessage logMessage = new RestLogMessage(message.getQueryId(),
                message.getClientId(),
                message.getServiceId(),
                message, signatureData,
                cis,
                true,
                message.getXRequestId());
        logManager.log(logMessage);
    }

    TimestampRecord timestamp(MessageRecord record) throws Exception {
        return logManager.timestamp(record.getId());
    }

    void startTimestamping() {
        logManager.taskQueueRef.tell(TaskQueue.START_TIMESTAMPING, ActorRef.noSender());
    }

    void startArchiving() {
        logArchiverRef.tell(LogArchiver.START_ARCHIVING, ActorRef.noSender());
    }

    void startCleaning() {
        logCleanerRef.tell(LogCleaner.START_CLEANING, ActorRef.noSender());
    }

    void awaitTermination() throws Exception {
        Await.result(actorSystem.whenTerminated(), Duration.Inf());
    }

    static void assertMessageRecord(Object o, String queryId) {
        assertNotNull(o);
        assertTrue(o instanceof MessageRecord);

        MessageRecord messageRecord = (MessageRecord) o;
        assertEquals(queryId, messageRecord.getQueryId());
    }

    static Object waitForMessageInTaskQueue() throws Exception {
        assertTrue(TestTaskQueue.waitForMessage());

        Object message = TestTaskQueue.getLastMessage();
        assertNotNull("Did not get message from task queue", message);

        return message;
    }

    static Timestamper.TimestampSucceeded waitForTimestampSuccessful() throws Exception {
        Object result = waitForMessageInTaskQueue();
        assertTrue("Got " + result, result instanceof Timestamper.TimestampSucceeded);

        return (Timestamper.TimestampSucceeded) result;
    }


}
