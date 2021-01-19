package eu.dariah.has.ddrs.elasticsearch.service;

import com.google.common.base.Functions;
import eu.dariah.has.ddrs.elasticsearch.model.psp.Publication;
import eu.dariah.has.ddrs.model.SearchObject;
import io.searchbox.client.JestClient;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.mapping.PutMapping;
import io.searchbox.params.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.io.ByteStreams;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by yoann on 19.07.17.
 */
@Service
public class PublicationServiceImpl implements PublicationService {
    private static final Logger LOGGER = LogManager.getLogger(PublicationServiceImpl.class);
    private final JestClient jestClientPSP;

    @Autowired
    public PublicationServiceImpl(@Qualifier("jestClientPSP") JestClient jestClientPSP) {
        this.jestClientPSP = jestClientPSP;
    }


    @Override
    public void createIndex() {
        try {
            InputStream mappingFile = getClass().getClassLoader().getResourceAsStream("elasticsearch/mappingElasticsearch_PSP.json");
            String mappingJson = new String(ByteStreams.toByteArray(mappingFile));
            boolean indexExists = jestClientPSP.execute(new IndicesExists.Builder("frontend").build()).isSucceeded();
            if (indexExists) {
                jestClientPSP.execute(new DeleteIndex.Builder("frontend").build());
            }
            LOGGER.info("Creating elasticsearch index");
            jestClientPSP.execute(new CreateIndex.Builder("frontend").build());
            createMapping(mappingJson);
        } catch (Exception e) {
            LOGGER.error("There was an error while creating an index.", e);
        }
    }

    @Override
    public void createMapping(String mappingJson) throws IOException {
        LOGGER.info("Updating elasticsearch type mapping");
        jestClientPSP.execute(new PutMapping.Builder("frontend", "publication", mappingJson).build());
    }

    @Override
    public String save(Publication publication, boolean refresh) {
        try {
            Index index = new Index.Builder(publication).refresh(refresh).index("frontend").type("publication").build();
            DocumentResult documentResult = jestClientPSP.execute(index);
            return documentResult.getId();
        } catch (IOException e) {
            LOGGER.error("There was an error while saving the publication.", e);
        }
        return null;
    }

    @Override
    public String save(Publication publication) {
        return save(publication, false);
    }

    @Override
    public Boolean delete(String publicationId, boolean refresh) {
        try {
            Delete delete = new Delete.Builder(publicationId).refresh(refresh).index("frontend").type("publication").build();
            DocumentResult result = jestClientPSP.execute(delete);
            return result.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("There was an error while deleting a publication.", e);
        }
        return false;
    }

    @Override
    public Boolean delete(String publicationId) {
        return delete(publicationId, false);
    }

    @Override
    public Publication findOne(String id) {
        try {
            Get get = new Get.Builder("frontend", id).build();
            DocumentResult result = jestClientPSP.execute(get);
            return result.getSourceAsObject(Publication.class);
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving a publication from its identifier.", e);
        }
        return null;
    }

    private SearchResult search(QueryBuilder queryBuilder) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("frontend")
                .addType("publication")
                .setParameter(Parameters.SIZE, 500)
                .build();
        LOGGER.debug(searchSourceBuilder.toString());
        return jestClientPSP.execute(search);
    }

    @Override
    public List<Publication> findAll() {
        try {
            SearchResult searchResult = search(QueryBuilders.queryStringQuery("*:*"));
            List<SearchResult.Hit<Publication, Void>> hits = searchResult.getHits(Publication.class);
            return hits.stream().map(h -> new Publication(h.id, h.source)).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving all the publications", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<String> findAllIdentifiers() {
        try {
            SearchResult searchResult = search(QueryBuilders.queryStringQuery("*:*"));
            List<SearchResult.Hit<Publication, Void>> hits = searchResult.getHits(Publication.class);
            return hits.stream().map(h -> h.id).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving all the publications", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Publication> findByName(String name) {
        try {
            SearchResult searchResult = search(QueryBuilders.fuzzyQuery("name", name));
            List<SearchResult.Hit<Publication, Void>> hits = searchResult.getHits(Publication.class);
            return hits.stream().map(h -> new Publication(h.id, h.source)).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving a publication by its name.", e);
        }
        return null;
    }

    private QueryBuilder createQueryBuilder(SearchObject searchObject, String key) {
        List<String> shoulds = new ArrayList<>();
        if(searchObject.getInternSearchParameters().containsKey(key)) {
            shoulds = searchObject.getInternSearchParameters().get(key);
        }

        BoolQueryBuilder boolQueryBuilder = boolQuery();
        for(String should : shoulds) {
            //Some might start with "psp_" for the application but that's non existent in the index, so replace them
            boolQueryBuilder.should(termQuery(key, should.replace("psp_", "")));
        }
        boolQueryBuilder.minimumNumberShouldMatch(1);
        return boolQueryBuilder;
    }

    @Override
    @Cacheable("publicationSearches")
    public List<Publication> searchWithRestrictions(SearchObject searchObject) {
        return searchWithRestrictions(searchObject, 1);
    }

    @Override
    @Cacheable("publicationSearches")
    public List<Publication> searchWithRestrictions(SearchObject searchObject, int tries) {
//        final String TYPES_TEXT = "types.text";
//        final String DISCIPLINE_SCHEME = "disciplines.scheme";
//        final String LANGUAGE_TEXT = "languages.text";
        final String DDRS_OR_PSP = "ddrsOrPsp";

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for(String key : searchObject.getInternSearchParameters().keySet()) {
            if(!key.equals(DDRS_OR_PSP)) {
                boolQueryBuilder.must(
                        createQueryBuilder(searchObject, key)
                );
            }
        }

        BoolQueryBuilder mainBoolQueryBuilder = QueryBuilders.boolQuery().should(boolQueryBuilder);

        try {
            SearchResult searchResult = search(mainBoolQueryBuilder);
            List<SearchResult.Hit<Publication, Void>> hits = searchResult.getHits(Publication.class);
            return hits.stream().map(h -> new Publication(h.id, h.source)).collect(Collectors.toList());
        } catch (SocketTimeoutException ste) {
            if(tries < MAX_TRIES) {
                LOGGER.error("Socket Timeout Exception... We launch it again...");
                return searchWithRestrictions(searchObject, tries + 1);
            }
            LOGGER.error("Socket Timeout Exception... Too often, we stop...");
            return null;
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving the publications via a complex search.", e);
        }
        return null;
    }
}