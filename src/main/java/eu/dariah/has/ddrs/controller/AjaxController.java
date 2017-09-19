package eu.dariah.has.ddrs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.elasticsearch.service.RepositoryService;
import eu.dariah.has.ddrs.model.AjaxResponseBody;
import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.json.JsonViews;
import eu.dariah.has.ddrs.persistence.dao.IContactRepositoryDAO;
import eu.dariah.has.ddrs.re3data.search.Re3dataList;
import eu.dariah.has.ddrs.re3data.search.Repository;
import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import eu.dariah.has.ddrs.service.Re3dataQueryList;
import eu.dariah.has.ddrs.service.Re3dataRepositoryAPIService;
import eu.dariah.has.ddrs.service.RepositoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoannmoranville on 12/05/17.
 */
@RestController
@SessionAttributes("searchObject")
public class AjaxController {
    private static final Logger LOGGER = Logger.getLogger(AjaxController.class);

    private final Re3dataRepositoryAPIService re3dataRepositoryAPIService;
    private final IContactRepositoryDAO contactRepositoryDAO;
    private final RepositoryService repositoryService;

    @Autowired
    public AjaxController(Re3dataRepositoryAPIService re3dataRepositoryAPIService, IContactRepositoryDAO contactRepositoryDAO, RepositoryService repositoryService) {
        this.re3dataRepositoryAPIService = re3dataRepositoryAPIService;
        this.contactRepositoryDAO = contactRepositoryDAO;
        this.repositoryService = repositoryService;
    }

    @JsonView(JsonViews.Public.class)
    @RequestMapping(value = "/refreshResultsOld")
    public AjaxResponseBody getSearchResultViaAjaxOld(@RequestBody SearchObject searchObject, @ModelAttribute("searchObject") SearchObject searchObject1) {
        searchObject1.setInternSearchParameters(searchObject.getInternSearchParameters());
        AjaxResponseBody result = new AjaxResponseBody();
//        Re3dataQueryList re3dataQueryList = new Re3dataQueryList(searchObject);
//        RestTemplate rest = new RestTemplate();

//        Re3dataList re3dataList = new Re3dataList();
        long veryStart = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        List<eu.dariah.has.ddrs.elasticsearch.model.Repository> repositories = new ArrayList<>();
        try {
//            re3dataList = rest.getForObject(re3dataQueryList.getUrl(), Re3dataList.class);
            repositories = repositoryService.searchWithRestrictions(searchObject, re3dataRepositoryAPIService.getDefaultRepositories(searchObject));
        } catch (RestClientException e) {
            LOGGER.error("There was an error in the RestTemplate", e);
//            re3dataList.setHasError();
        }
        LOGGER.debug((System.currentTimeMillis() - start) + "ms");

//        LOGGER.debug("Size of repository list: " + re3dataList.getRepositories().size());
//        for(Repository repository : re3dataList.getRepositories()) {
//            start = System.currentTimeMillis();
//            Re3Data re3Data = re3dataRepositoryAPIService.findRe3Data(repository.getLink().getHref());
//            LOGGER.debug((System.currentTimeMillis() - start) + "ms for " + repository.getLink().getHref());
//            if(re3Data.getRepository().size() > 0) {
//                Re3Data.Repository repo = re3Data.getRepository().get(0);
//                RepositoryBuilder.addRepositoryDetails(repository, repo, contactRepositoryDAO.findByRepositoryId(repository.getId()));
//            }
//        }
//        LOGGER.info("It took " + (System.currentTimeMillis() - veryStart) + "ms for this search and the retrieval of the detailed data: " + re3dataQueryList.getUrl());

        if(repositories.size() > 0) {
            result.setCode("200");
            result.setMsg("");
            result.setRepositories(repositories);
//        } else if(re3dataList.getHasError()) {
//            result.setCode("500");
//            result.setMsg("Error from Re3data endpoint...");
        } else {
            result.setCode("204");
            result.setMsg("No results...");
        }

        return result;
    }

    @RequestMapping(value = "/refreshResults")
    public ModelAndView getSearchResultViaAjax(@RequestBody SearchObject searchObject, @ModelAttribute("searchObject") SearchObject searchObject1) {
        searchObject1.setInternSearchParameters(searchObject.getInternSearchParameters());

        long start = System.currentTimeMillis();
        List<eu.dariah.has.ddrs.elasticsearch.model.Repository> repositories = new ArrayList<>();
        try {
            repositories = repositoryService.searchWithRestrictions(searchObject, re3dataRepositoryAPIService.getDefaultRepositories(searchObject));
        } catch (RestClientException e) {
            LOGGER.error("There was an error in the RestTemplate", e);
        }
        LOGGER.debug((System.currentTimeMillis() - start) + "ms");

        ModelAndView modelAndView = new ModelAndView("fragments/results_list :: resultsList");
        modelAndView.addObject("repositories", repositories);
        return modelAndView;
    }
}