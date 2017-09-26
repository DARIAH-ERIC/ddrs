package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.elasticsearch.service.RepositoryService;
import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.service.Re3dataRepositoryAPIService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestClientException;
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
    private final RepositoryService repositoryService;

    @Autowired
    public AjaxController(Re3dataRepositoryAPIService re3dataRepositoryAPIService, RepositoryService repositoryService) {
        this.re3dataRepositoryAPIService = re3dataRepositoryAPIService;
        this.repositoryService = repositoryService;
    }

    @RequestMapping(value = "/refreshResults")
    public ModelAndView getSearchResultViaAjax(@RequestBody SearchObject searchObject, @ModelAttribute("searchObject") SearchObject searchObject1) {
        searchObject1.setInternSearchParameters(searchObject.getInternSearchParameters());

        long start = System.currentTimeMillis();
        List<eu.dariah.has.ddrs.elasticsearch.model.Repository> repositories = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("fragments/results_list :: resultsList");
        try {
            repositories = repositoryService.searchWithRestrictions(searchObject, re3dataRepositoryAPIService.getDefaultRepositories(searchObject));
        } catch (RestClientException e) {
            LOGGER.error("There was an error in the RestTemplate", e);
            modelAndView.addObject("error", "error");
        }
        LOGGER.debug((System.currentTimeMillis() - start) + "ms");
        modelAndView.addObject("repositories", repositories);
        return modelAndView;
    }

    /**
     * Clears the session so that users go back to the index page with a new http session
     */
    @PostMapping(value = "/clear")
    @ResponseStatus(value = HttpStatus.OK)
    public void clear(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
    }
}