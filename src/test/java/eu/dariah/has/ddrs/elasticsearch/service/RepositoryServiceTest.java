package eu.dariah.has.ddrs.elasticsearch.service;

import eu.dariah.has.ddrs.DdrsTest;
import eu.dariah.has.ddrs.elasticsearch.model.ddrs.Repository;
import eu.dariah.has.ddrs.model.SearchObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;


/**
 * Created by yoann on 18.07.17.
 * The Repository Service test class which tests interactions with Elastic Search
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryServiceTest extends DdrsTest {
    private static final Logger LOGGER = LogManager.getLogger(RepositoryServiceTest.class);
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private CacheManager cacheManager;
    private Cache cache;

    @Before
    public void setUp() {
        cache = this.cacheManager.getCache("repositorySearches");
    }

    @After
    public void tearDown() {
        cache.evict("repositorySearches");
    }

    /**
     * Retrieving one repository from ES via its internal identifier
     */
    @Test
    public void testFindOne() {
        LOGGER.info("testFindOne");

        Repository testRepository = repositoryService.findOne("1");
        assertNotNull(testRepository);
        assertEquals(100000002, testRepository.getIdentifier().getRe3data());
        assertEquals("10.17616/R31597", testRepository.getIdentifier().getDoi());
        assertNotNull(testRepository.getProviderTypes());
    }

    /**
     * Retrieving multiple repositories from ES - search by name
     */
    @Test
    public void testFindMultiple() {
        LOGGER.info("testFindMultiple");

        List<Repository> repositories = repositoryService.findByName("Repository");
        assertNotNull(repositories);
        assertFalse(repositories.isEmpty());
    }

    /**
     * Retrieving all repositories from ES
     */
    @Test
    public void testFindAll() {
        LOGGER.info("testFindAll");

        List<Repository> repositories = repositoryService.findAll();
        assertNotNull(repositories);
    }

    /**
     * Testing a real life query to ES, searching for French repositories
     * Keep in mind that this query also includes all default DDRS query parameters
     */
    @Test
    public void testSearchWithRestrictions() {
        LOGGER.info("testSearchWithRestrictions");

        SearchObject searchObject = new SearchObject();
        Map<String, String> searchParameters = new HashMap<>();
        searchParameters.put("institutions.country.raw", "FRA");
        searchObject.setSearchParameters(searchParameters);
        List<Repository> repositories = repositoryService.searchWithRestrictions(searchObject, new ArrayList<>());
        assertNotNull(repositories);
        assertEquals(5, repositories.size());
    }

    /**
     * Testing 2 times the same query one without a cache, one with a cache to see the difference in time
     */
    @Test
    public void testCacheable() {
        LOGGER.info("testCacheable");
        cache.clear();
        SearchObject searchObject = new SearchObject();
        Map<String, String> searchParameters = new HashMap<>();
        searchParameters.put("institutions.country.raw", "FRA");
        searchObject.setSearchParameters(searchParameters);

        long start = System.currentTimeMillis();
        repositoryService.searchWithRestrictions(searchObject, new ArrayList<>());
        long end = System.currentTimeMillis();
        long withoutCache = end - start;
        LOGGER.info("Re3Data without Caching: " + withoutCache + "ms");

        start = System.currentTimeMillis();
        repositoryService.searchWithRestrictions(searchObject, new ArrayList<>());
        end = System.currentTimeMillis();
        long withCache = end - start;
        LOGGER.info("Re3Data With Caching: " + withCache + "ms");
    }
}
