package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import eu.dariah.has.ddrs.persistence.model.DefaultRepository;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Re3dataRepositoryService {
    private static final Logger LOGGER = LogManager.getLogger(Re3dataRepositoryService.class);
    private final IResultTypeHierarchicalDAO resultTypeHierarchicalDAO;

    public Re3dataRepositoryService(IResultTypeHierarchicalDAO resultTypeHierarchicalDAO) {
        this.resultTypeHierarchicalDAO = resultTypeHierarchicalDAO;
    }

    public List<String> getDefaultRepositories(boolean retrieveParent, SearchObject searchObject) {
        List<String> defaultRepositoryIdentifiers = new ArrayList<>();
        for(String key : searchObject.getInternSearchParameters().keySet()) {
            for(String code : searchObject.getInternSearchParameters().get(key)) {
                LOGGER.debug("Search for code: " + code);
                ResultTypeHierarchical resultTypeHierarchical = resultTypeHierarchicalDAO.findByCode(code);
                if(resultTypeHierarchical != null) {
                    if(!retrieveParent) {
                        LOGGER.debug("Found the code and search for his default repositories");
                        for (DefaultRepository defaultRepository : resultTypeHierarchical.getDefaultRepositories()) {
                            defaultRepositoryIdentifiers.add(defaultRepository.getRe3dataIdentifier());
                        }
                    }
                    if(retrieveParent && resultTypeHierarchical.getParent() != null) {
                        LOGGER.debug("Search for his parent's default repositories");
                        for (DefaultRepository defaultRepository : resultTypeHierarchical.getParent().getDefaultRepositories()) {
                            defaultRepositoryIdentifiers.add(defaultRepository.getRe3dataIdentifier());
                        }
                    }
                }
            }
        }
        return defaultRepositoryIdentifiers;
    }
}
