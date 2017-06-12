package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Re3dataRepositoryAPIServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Re3dataRepositoryAPIServiceTest.class);

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private Re3dataRepositoryAPIService re3dataRepositoryAPIService;

    private TestRestTemplate restTemplate;
    private Cache cache;

    @Before
    public void setUp() {
        restTemplate = new TestRestTemplate();
        cache = this.cacheManager.getCache("repositoryDetails");
    }

    @After
    public void tearDown() {
        cache.evict("repositoryDetails");
    }

    @Test(expected = RestClientException.class)
    public void badUrl() throws Exception {
        restTemplate.getForObject("http://bad.url", Re3Data.class);
    }

    @Test
    public void returnEmptyR3Data() throws Exception {
        Re3Data re3Data = new Re3Data();
        assertEquals(0, re3Data.getRepository().size());

        try {
            re3Data = restTemplate.getForObject("http://bad.url", Re3Data.class);
        } catch (RestClientException e) {
        }
        assertEquals(0, re3Data.getRepository().size());
    }

    @Test
    public void getRe3DataInClassObject() throws Exception {
        Re3Data re3Data = restTemplate.getForObject("http://www.re3data.org/api/beta/repository/r3d100011933", Re3Data.class);
        assertThat(re3Data.getRepository().size(), greaterThan(-1));
    }

    @Test
    public void re3DataAccessTimes() {
        long start;
        long end;

        cache.clear();

        start = System.currentTimeMillis();
        re3dataRepositoryAPIService.findRe3Data("http://www.re3data.org/api/beta/repository/r3d100011933");
        end = System.currentTimeMillis();
        long withoutCache = end - start;
        LOGGER.info("Re3Data without Caching: " + withoutCache + "ms");

        start = System.currentTimeMillis();
        re3dataRepositoryAPIService.findRe3Data("http://www.re3data.org/api/beta/repository/r3d100011933");
        end = System.currentTimeMillis();
        long withCache = end - start;
        LOGGER.info("Re3Data With Caching: " + withCache + "ms");

        assertThat("Without cache must take much longer than with cache", withoutCache > (withCache*10));
    }
}