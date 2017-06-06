package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yoann on 22.05.17.
 */
@Service
public class Re3dataRepositoryAPIService {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("repositoryDetails")
    public Re3Data findRe3Data(String link) {
        return restTemplate.getForObject(link, Re3Data.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
