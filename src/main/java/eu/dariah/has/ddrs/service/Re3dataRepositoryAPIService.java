package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import eu.dariah.has.ddrs.persistence.model.DefaultRepository;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import eu.dariah.has.ddrs.re3data.search.Link;
import eu.dariah.has.ddrs.re3data.search.Re3dataList;
import eu.dariah.has.ddrs.re3data.search.Repository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by yoann on 22.05.17.
 */
@Service
public class Re3dataRepositoryAPIService {
    private static final Logger LOGGER = Logger.getLogger(Re3dataRepositoryAPIService.class);
    private static final String RE3DATA_URL = "http://www.re3data.org/api/beta/repository/";
    private final IResultTypeHierarchicalDAO resultTypeHierarchicalDAO;
    private RestTemplate restTemplate;

    @Autowired
    public Re3dataRepositoryAPIService(IResultTypeHierarchicalDAO resultTypeHierarchicalDAO) {
        this.resultTypeHierarchicalDAO = resultTypeHierarchicalDAO;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("repositoryDetails")
    public Re3Data findRe3Data(String link) {
        return restTemplate.getForObject(link, Re3Data.class);
    }

    @Cacheable("repositoryDetails")
    public Re3Data findRe3DataByIdentifier(String identifier) {
        String link = RE3DATA_URL + identifier;
        return restTemplate.getForObject(link, Re3Data.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void addDefaultRepositories(SearchObject searchObject, Re3dataList re3dataList) {
        Set<Repository> newSet = new LinkedHashSet<>(re3dataList.getRepositories().size());
        for(String key : searchObject.getSearchParameters().keySet()) {
            for(String code : searchObject.getSearchParameters().get(key)) {
                LOGGER.debug("Search for code: " + code);
                ResultTypeHierarchical resultTypeHierarchical = resultTypeHierarchicalDAO.findByCode(code);
                if(resultTypeHierarchical != null) {
                    LOGGER.debug("Found the code and search for his default repositories");
                    for(DefaultRepository defaultRepository : resultTypeHierarchical.getDefaultRepositories()) {
                        addRepository(defaultRepository.getRe3dataIdentifier(), newSet);
                    }

                    if(resultTypeHierarchical.getParent() != null) {
                        LOGGER.debug("Search for his parent's default repositories");
                        for (DefaultRepository defaultRepository : resultTypeHierarchical.getParent().getDefaultRepositories()) {
                            addRepository(defaultRepository.getRe3dataIdentifier(), newSet);
                        }
                    }
                }
            }
        }
        newSet.addAll(re3dataList.getRepositories());
        re3dataList.setRepository(newSet);
    }

    private void addRepository(String defaultRepositoryIdentifier, Set<Repository> newSet) {
        LOGGER.debug("-- Found default repository: " + defaultRepositoryIdentifier);
        Repository repository = new Repository();
        repository.setId(defaultRepositoryIdentifier);
        repository.setLink(new Link("http://www.re3data.org/api/beta/repository/" + defaultRepositoryIdentifier));
        newSet.add(repository);
    }
}
