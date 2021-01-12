package eu.dariah.has.ddrs.elasticsearch.service;

import eu.dariah.has.ddrs.elasticsearch.model.psp.Publication;
import eu.dariah.has.ddrs.model.SearchObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by yoann on 19.07.17.
 */
public interface PublicationService {
    int MAX_TRIES = 10;
    void createIndex();
    void createMapping(String mappingJson) throws IOException;
    String save(Publication publication, boolean refresh);
    String save(Publication publication);
    Boolean delete(String publicationId, boolean refresh);
    Boolean delete(String publicationId);
    Publication findOne(String id);
    List<Publication> findAll();
    List<String> findAllIdentifiers();
    List<Publication> searchWithRestrictions(SearchObject searchObject);
    List<Publication> searchWithRestrictions(SearchObject searchObject, int tries);
    List<Publication> findByName(String name);
}
