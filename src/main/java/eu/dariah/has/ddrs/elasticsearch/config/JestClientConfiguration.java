package eu.dariah.has.ddrs.elasticsearch.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * Created by yoann on 19.07.17.
 */
@Configuration
public class JestClientConfiguration {
    private static final Logger LOGGER = LogManager.getLogger(JestClientConfiguration.class);

    @Value("${ddrs.elasticsearch.serverUri}")
    private String elasticsearchUri;

    @Value("${ddrs.elasticsearch.username}")
    private String elasticsearchUsername;

    @Value("${ddrs.elasticsearch.password}")
    private String elasticsearchPassword;

    @Bean
    public JestClient jestClient() {
        JestClientFactory factory = new JestClientFactory();
        LOGGER.info("Elastic Search Server Uri: " + elasticsearchUri);
        HttpClientConfig.Builder httpClientConfigBuilder = new HttpClientConfig.Builder(elasticsearchUri)
                .multiThreaded(true)
                .defaultMaxTotalConnectionPerRoute(2) //Per default this implementation will create no more than 2 concurrent connections per given route
                .maxTotalConnection(20); // and no more 20 connections in total

        if(StringUtils.isNotBlank(elasticsearchUsername) && StringUtils.isNotBlank(elasticsearchPassword))
            httpClientConfigBuilder.defaultCredentials(elasticsearchUsername, elasticsearchPassword);

        factory.setHttpClientConfig(httpClientConfigBuilder.build());
        return factory.getObject();
    }
}