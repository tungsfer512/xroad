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
package ee.ria.xroad.signer;

import ee.ria.xroad.common.CertificationServiceDiagnostics;
import ee.ria.xroad.common.SystemProperties;
import ee.ria.xroad.common.SystemPropertiesLoader;
import ee.ria.xroad.common.Version;
import ee.ria.xroad.common.util.AdminPort;
import ee.ria.xroad.common.util.JsonUtils;
import ee.ria.xroad.signer.certmanager.OcspClientWorker;
import ee.ria.xroad.signer.util.SignerUtil;

import akka.actor.ActorSystem;
import akka.actor.CoordinatedShutdown;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static ee.ria.xroad.common.SystemProperties.CONF_FILE_CENTER;
import static ee.ria.xroad.common.SystemProperties.CONF_FILE_CONFPROXY;
import static ee.ria.xroad.common.SystemProperties.CONF_FILE_NODE;
import static ee.ria.xroad.common.SystemProperties.CONF_FILE_PROXY;
import static ee.ria.xroad.common.SystemProperties.CONF_FILE_SIGNER;
import static ee.ria.xroad.signer.protocol.ComponentNames.OCSP_CLIENT;
import static ee.ria.xroad.signer.protocol.ComponentNames.SIGNER;

/**
 * Signer main program.
 */
@Slf4j
public final class SignerMain {

    private static final String APP_NAME = "xroad-signer";

    static {
        SystemPropertiesLoader.create()
                .withCommonAndLocal()
                .withLocalOptional(CONF_FILE_NODE)
                .withAtLeastOneOf(CONF_FILE_CENTER, CONF_FILE_PROXY, CONF_FILE_CONFPROXY)
                .with(CONF_FILE_SIGNER)
                .load();
        diagnosticsDefault = new CertificationServiceDiagnostics();
    }

    private static ActorSystem actorSystem;
    private static Signer signer;
    private static AdminPort adminPort;
    private static CertificationServiceDiagnostics diagnosticsDefault;

    private SignerMain() {
    }

    /**
     * Entry point to Signer.
     * @param args the arguments
     * @throws Exception if an error occurs
     */
    public static void main(String[] args) throws Exception {
        try {
            startup();
        } catch (Exception fatal) {
            log.error("FATAL", fatal);
            System.exit(1);
        }
    }

    private static void startup() throws Exception {
        Version.outputVersionInfo(APP_NAME);
        int signerPort = SystemProperties.getSignerPort();
        log.info("Starting Signer on port {}...", signerPort);

        actorSystem = ActorSystem.create(SIGNER, getConf(signerPort));
        signer = new Signer(actorSystem);
        adminPort = createAdminPort(SystemProperties.getSignerAdminPort());
        CoordinatedShutdown.get(actorSystem).addJvmShutdownHook(SignerMain::shutdown);
        signer.start();
        adminPort.start();
    }

    private static void shutdown() {
        log.info("Signer shutting down...");

        try {
            if (signer != null) {
                signer.stop();
                signer.join();
            }
        } catch (Exception e) {
            log.error("Error stopping signer", e);
        }

        try {
            if (adminPort != null) {
                adminPort.stop();
                adminPort.join();
            }
        } catch (Exception e) {
            log.error("Error stopping admin port", e);
        }

    }

    private static AdminPort createAdminPort(int signerPort) {
        AdminPort port = new AdminPort(signerPort);

        port.addHandler("/execute", new AdminPort.SynchronousCallback() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response) {
                try {
                    signer.execute();
                } catch (Exception ex) {
                    log.error("error occurred in execute handler", ex);
                }
            }
        });

        port.addHandler("/status", new AdminPort.SynchronousCallback() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response) {
                log.info("handler /status");
                CertificationServiceDiagnostics diagnostics = null;
                try {
                    Object value = SignerUtil.ask(
                            actorSystem.actorSelection("/user/" + OCSP_CLIENT), OcspClientWorker.DIAGNOSTICS);
                    diagnostics = (CertificationServiceDiagnostics) value;
                    if (diagnostics != null) {
                        diagnosticsDefault = diagnostics;
                    }
                } catch (Exception e) {
                    log.error("Error getting diagnostics status {}", e);
                }
                if (diagnostics == null) {
                    diagnostics = diagnosticsDefault;
                }
                try {
                    response.setCharacterEncoding("UTF8");
                    JsonUtils.getObjectWriter()
                            .writeValue(response.getWriter(), diagnostics);
                } catch (IOException e) {
                    log.error("Error writing response {}", e);
                }
            }
        });

        return port;
    }

    private static Config getConf(int signerPort) {
        Config conf = ConfigFactory.load().getConfig("signer-main")
                .withFallback(ConfigFactory.load());
        return conf.withValue("akka.remote.artery.canonical.port",
                ConfigValueFactory.fromAnyRef(signerPort));
    }
}
