package eu.dariah.has.ddrs.elasticsearch.service;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.model.SearchObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by yoann on 19.07.17.
 */
public interface RepositoryService {
    void createIndex();
    void createMapping(String mappingJson) throws IOException;
    String save(Repository repository, boolean refresh);
    String save(Repository repository);
    Boolean delete(String repositoryId, boolean refresh);
    Boolean delete(String repositoryId);
    Repository findOne(String id);
    List<Repository> findAll();
    Repository searchByRe3Identifier(String identifier);
    List<Repository> searchWithRestrictions(SearchObject searchObject, List<String> r3dIdentifiers);
    List<Repository> findByName(String name);
}
