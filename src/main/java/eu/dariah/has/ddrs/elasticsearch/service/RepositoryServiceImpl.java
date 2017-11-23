package eu.dariah.has.ddrs.elasticsearch.service;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import io.searchbox.client.JestClient;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.mapping.PutMapping;
import io.searchbox.params.Parameters;
import org.apache.log4j.Logger;
import org.elasticsearch.common.io.ByteStreams;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by yoann on 19.07.17.
 */
@Service
public class RepositoryServiceImpl implements RepositoryService {
    private static final Logger LOGGER = Logger.getLogger(RepositoryServiceImpl.class);
    private final JestClient jestClient;

    @Autowired
    public RepositoryServiceImpl(JestClient jestClient) {
        this.jestClient = jestClient;
    }


    @Override
    public void createIndex() {
        try {
            InputStream mappingFile = getClass().getClassLoader().getResourceAsStream("elasticsearch/mappingElasticsearch.json");
            String mappingJson = new String(ByteStreams.toByteArray(mappingFile));
            boolean indexExists = jestClient.execute(new IndicesExists.Builder("frontend").build()).isSucceeded();
            if (indexExists) {
                jestClient.execute(new DeleteIndex.Builder("frontend").build());
            }
            LOGGER.info("Creating elasticsearch index");
            jestClient.execute(new CreateIndex.Builder("frontend").build());
            createMapping(mappingJson);
        } catch (Exception e) {
            LOGGER.error("There was an error while creating an index.", e);
        }
    }

    @Override
    public void createMapping(String mappingJson) throws IOException {
        LOGGER.info("Updating elasticsearch type mapping");
        jestClient.execute(new PutMapping.Builder("frontend", "repository", mappingJson).build());
    }

    @Override
    public String save(Repository repository, boolean refresh) {
        try {
            Index index = new Index.Builder(repository).refresh(refresh).index("frontend").type("repository").build();
            DocumentResult documentResult = jestClient.execute(index);
            return documentResult.getId();
        } catch (IOException e) {
            LOGGER.error("There was an error while saving the repository.", e);
        }
        return null;
    }

    @Override
    public String save(Repository repository) {
        return save(repository, false);
    }

    @Override
    public Boolean delete(String repositoryId, boolean refresh) {
        try {
            Delete delete = new Delete.Builder(repositoryId).refresh(refresh).index("frontend").type("repository").build();
            DocumentResult result = jestClient.execute(delete);
            return result.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("There was an error while deleting a repository.", e);
        }
        return false;
    }

    @Override
    public Boolean delete(String repositoryId) {
        return delete(repositoryId, false);
    }

    @Override
    public Repository findOne(String id) {
        try {
            Get get = new Get.Builder("frontend", id).build();
            DocumentResult result = jestClient.execute(get);
            return result.getSourceAsObject(Repository.class);
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving a repository from its identifier.", e);
        }
        return null;
    }

    private SearchResult search(QueryBuilder queryBuilder) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("frontend")
                .addType("repository")
                .setParameter(Parameters.SIZE, 500)
                .build();
        return jestClient.execute(search);
    }

    @Override
    public List<Repository> findAll() {
        try {
            SearchResult searchResult = search(QueryBuilders.queryStringQuery("*:*"));
            List<SearchResult.Hit<Repository, Void>> hits = searchResult.getHits(Repository.class);
            return hits.stream().map(h -> h.source).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving all the repositories.", e);
        }
        return null;
    }

    @Override
    public List<Repository> findByName(String name) {
        try {
            SearchResult searchResult = search(QueryBuilders.fuzzyQuery("name", name));
            List<SearchResult.Hit<Repository, Void>> hits = searchResult.getHits(Repository.class);
            return hits.stream().map(h -> h.source).collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving a repository by its name.", e);
        }
        return null;
    }

    private QueryBuilder createQueryBuilder(SearchObject searchObject, String key, List<String> defaultShoulds, List<String> mustNots) {
        List<String> shoulds = defaultShoulds;
        if(searchObject.getInternSearchParameters().containsKey(key)) {
            shoulds = searchObject.getInternSearchParameters().get(key);
        }

        BoolQueryBuilder boolQueryBuilder = boolQuery();
        for(String should : shoulds) {
            boolQueryBuilder.should(termQuery(key, should));
        }
        boolQueryBuilder.minimumNumberShouldMatch(1);
        for (String mustNot : mustNots) {
            boolQueryBuilder.mustNot(termQuery(key, mustNot));
        }

        return boolQueryBuilder;
    }

    @Override
    @Cacheable("repositorySearches")
    public Repository searchByRe3Identifier(String identifier) {
        BoolQueryBuilder boolQueryBuilder = boolQuery().must(termQuery("identifier.re3data", identifier));
        try {
            SearchResult searchResult = search(boolQueryBuilder);
            List<SearchResult.Hit<Repository, Void>> hits = searchResult.getHits(Repository.class);
            if(hits.size() > 0)
                return hits.get(0).source;
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving the repository from its re3data identifier.", e);
        }
        return null;
    }

    @Override
    @Cacheable("repositoryIdentifiers")
    public List<Repository> retrieveById(List<String> r3dIdentifiers) {
        return retrieveById(r3dIdentifiers, 1);
    }

    @Override
    @Cacheable("repositoryIdentifiers")
    public List<Repository> retrieveById(List<String> r3dIdentifiers, int tries) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for(String r3dIdentifier : r3dIdentifiers) {
            boolQueryBuilder
                    .should(termQuery("identifier.re3data", r3dIdentifier.replace("r3d", "")));
        }
        boolQueryBuilder.minimumNumberShouldMatch(1);
        try {
            SearchResult searchResult = search(boolQueryBuilder);
            List<SearchResult.Hit<Repository, Void>> hits = searchResult.getHits(Repository.class);
            return hits.stream().map(h -> h.source).collect(Collectors.toList());
        } catch (SocketTimeoutException ste) {
            if(tries < 10) {
                LOGGER.error("Socket Timeout Exception... We launch it again...");
                return retrieveById(r3dIdentifiers, tries + 1);
            }
            LOGGER.error("Socket Timeout Exception... Too often, we stop...");
            return null;
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving the repositories from a list of identifiers.", e);
        }
        return null;
    }

    @Override
    @Cacheable("repositorySearches")
    public List<Repository> searchWithRestrictions(SearchObject searchObject, List<String> r3dIdentifiers) {
        return searchWithRestrictions(searchObject, r3dIdentifiers, 1);
    }

    @Override
    @Cacheable("repositorySearches")
    public List<Repository> searchWithRestrictions(SearchObject searchObject, List<String> r3dIdentifiers, int tries) {
        final String SUBJECTS_TEXT_RAW = "subjects.text.raw";
        final String PID_SYSTEMS_TEXT_RAW = "pidSystems.text";
        final String DATA_UPLOADS_TYPE_RAW = "dataUploads.type.raw";
        final String INSTITUTIONS_COUNTRY_RAW = "institutions.country.raw";

        BoolQueryBuilder boolQueryBuilder = QueryBuilders
                .boolQuery();
//        boolQueryBuilder.must(termQuery("dataUploads.restrictions.text.raw", "institutional membership"));
        for(String key : searchObject.getInternSearchParameters().keySet()) {
            if(! key.equals(SUBJECTS_TEXT_RAW) && !key.equals(PID_SYSTEMS_TEXT_RAW) & !key.equals(DATA_UPLOADS_TYPE_RAW) &&!key.equals(INSTITUTIONS_COUNTRY_RAW)) {
                boolQueryBuilder.must(
                        createQueryBuilder(searchObject, key, Collections.emptyList(), Collections.emptyList())
                );
            }
        }
        boolQueryBuilder.must(
                createQueryBuilder(searchObject, SUBJECTS_TEXT_RAW, Arrays.asList("1 Humanities and Social Sciences", "11 Humanities"), Collections.emptyList())
        ).must(
                createQueryBuilder(searchObject, PID_SYSTEMS_TEXT_RAW, Arrays.asList("ARK", "DOI", "PURL", "URN", "hdl", "other"), Collections.singletonList("none"))
        ).must(
                createQueryBuilder(searchObject, DATA_UPLOADS_TYPE_RAW, Arrays.asList("open", "restricted"), Collections.singletonList("closed"))
        ).must(
                createQueryBuilder(searchObject, INSTITUTIONS_COUNTRY_RAW, Arrays.asList("AUT", "BEL", "BUL", "HRV", "CYP", "CZE", "DNK", "EST", "EEC", "FIN", "FRA", "DEU", "GRC", "HUN", "ISL", "IRL", "ITA", "LTV", "LTU", "LUX", "MLT", "MTN", "NLD", "NOR", "POL", "PRT", "ROU", "SRB", "SVK", "SVN", "ESP", "SWE", "CHE", "TUR", "GBR"), Collections.emptyList())
        );

        BoolQueryBuilder mainBoolQueryBuilder = QueryBuilders.boolQuery()
                    .should(boolQueryBuilder);
        for(String r3dIdentifier : r3dIdentifiers) {
            mainBoolQueryBuilder
                    .mustNot(termQuery("identifier.re3data", r3dIdentifier.replace("r3d", "")).boost(1000f));
        }
        mainBoolQueryBuilder.minimumNumberShouldMatch(1);

        try {
            SearchResult searchResult = search(mainBoolQueryBuilder);
            List<SearchResult.Hit<Repository, Void>> hits = searchResult.getHits(Repository.class);
            return hits.stream().map(h -> h.source).collect(Collectors.toList());
        } catch (SocketTimeoutException ste) {
            if(tries < 10) {
                LOGGER.error("Socket Timeout Exception... We launch it again...");
                return searchWithRestrictions(searchObject, r3dIdentifiers, tries + 1);
            }
            LOGGER.error("Socket Timeout Exception... Too often, we stop...");
            return null;
        } catch (IOException e) {
            LOGGER.error("There was an error while retrieving the repositories via a complex search.", e);
        }
        return null;
    }
}