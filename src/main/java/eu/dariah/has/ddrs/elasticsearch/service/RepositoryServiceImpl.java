package eu.dariah.has.ddrs.elasticsearch.service;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import io.searchbox.client.JestClient;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.mapping.PutMapping;
import org.apache.log4j.Logger;
import org.elasticsearch.common.io.ByteStreams;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }

    private SearchResult search(QueryBuilder queryBuilder) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("frontend")
                .addType("repository")
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }
}