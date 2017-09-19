package eu.dariah.has.ddrs.elasticsearch.service;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.model.SearchObject;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by yoann on 18.07.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryServiceTest {
    private static final Logger LOGGER = Logger.getLogger(RepositoryServiceTest.class);
    @Autowired
    private RepositoryService repositoryService;

//    @Test
    public void testCreateMapping() {
        LOGGER.info("testCreateIndex");
        repositoryService.createIndex();
    }

    @Test
    public void emptyTest() {}

//    @Test
//    public void testSave() {
//        LOGGER.info("testSave");
//        Repository repository = new Repository("1", "Repository in France");
//        Institution institution = new Institution();
//        institution.setUrl("Institution URL");
//        repository.setInstitutions(Collections.singletonList(institution));
//        String repositorySavedId = repositoryService.save(repository, true);
//
//        assertNotNull(repositorySavedId);
//        assertEquals(repository.getId(), repositorySavedId);
//    }

//    @Test
    public void testFindOne() {
        LOGGER.info("testFindOne");
//        Repository repository = new Repository("2", "Repository in France - 2");
//        repositoryService.save(repository, true);

        Repository testRepository = repositoryService.findOne("1");
        assertNotNull(testRepository);
        assertEquals(100000002, testRepository.getIdentifier().getRe3data());
        assertEquals("10.17616/R31597", testRepository.getIdentifier().getDoi());
        assertNotNull(testRepository.getProviderTypes());
//        assertEquals(testRepository.getName(), repository.getName());
    }
//
//    @Test
//    public void testDelete() {
//        LOGGER.info("testDelete");
//        Repository repository = new Repository("3", "Repository in France - 3");
//        repositoryService.save(repository, true);
//
//        Boolean result = repositoryService.delete("3", true);
//        assertTrue(result);
//
//        Repository testRepository = repositoryService.findOne(repository.getId());
//        assertNull(testRepository);
//    }
//
//    @Test
    public void testFindMultiple() {
        LOGGER.info("testFindMultiple");
//        Repository repository = new Repository("4", "Repository in France - 4");
//        repositoryService.save(repository, true);
//
//        repository = new Repository("5", "Repository in France - 5");
//        repositoryService.save(repository, true);

        List<Repository> repositories = repositoryService.findByName("Repository");
        assertFalse(repositories.isEmpty());
        assertEquals(0, repositories.size());
    }
//
//    @Test
    public void testFindAll() {
        LOGGER.info("testFindAll");
//        Repository repository = new Repository("6", "Repository in France - 6");
//        repositoryService.save(repository, true);
//
//        repository = new Repository("7", "Waw another one!!");
//        repositoryService.save(repository, true);

        List<Repository> repositories = repositoryService.findAll();
        assertNotNull(repositories);
        assertEquals(2, repositories.size());
    }

//    @Test
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
//
//    @After
//    public void afterDeleteAll() {
//        LOGGER.info("afterDeleteAll");
//        repositoryService.delete("1", true);
//        repositoryService.delete("2", true);
//        repositoryService.delete("3", true);
//        repositoryService.delete("4", true);
//        repositoryService.delete("5", true);
//        repositoryService.delete("6", true);
//        repositoryService.delete("7", true);
//    }
}
