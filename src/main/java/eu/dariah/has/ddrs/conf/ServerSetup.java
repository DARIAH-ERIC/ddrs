package eu.dariah.has.ddrs.conf;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerSetup {

    @Value("${ddrs.ajp.port}")
    int ajpPort;

    @Value("${ddrs.ajp.enabled}")
    boolean ajpEnabled;

    @Bean
    public WebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

        if (ajpEnabled) {
            Connector ajpConnector = new Connector("AJP/1.3");
            ajpConnector.setPort(ajpPort);
            ajpConnector.setSecure(false);
            ajpConnector.setScheme("http");
            ajpConnector.setAllowTrace(false);
            tomcat.addAdditionalTomcatConnectors(ajpConnector);
        }

        return tomcat;
    }

}