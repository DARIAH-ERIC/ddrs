package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.elasticsearch.model.ddrs.Repository;
import eu.dariah.has.ddrs.elasticsearch.model.psp.Publication;
import eu.dariah.has.ddrs.elasticsearch.service.PublicationService;
import eu.dariah.has.ddrs.elasticsearch.service.RepositoryService;
import eu.dariah.has.ddrs.helper.DdrsHelper;
import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.service.Re3dataRepositoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by yoannmoranville on 12/05/17.
 */
@RestController
@SessionAttributes("searchObject")
public class AjaxController {
    private static final Logger LOGGER = LogManager.getLogger(AjaxController.class);

    private final Re3dataRepositoryService re3dataRepositoryService;
    private final RepositoryService repositoryService;
    private final PublicationService publicationService;

    @Autowired
    public AjaxController(Re3dataRepositoryService re3dataRepositoryService, RepositoryService repositoryService,
                          PublicationService publicationService) {
        this.re3dataRepositoryService = re3dataRepositoryService;
        this.repositoryService = repositoryService;
        this.publicationService = publicationService;
    }

    @RequestMapping(value = "/refreshResults")
    public ModelAndView getSearchResultViaAjax(@RequestBody SearchObject searchObject, @ModelAttribute("searchObject") SearchObject searchObject1) {
        searchObject1.setInternSearchParameters(searchObject.getInternSearchParameters());
        long start = System.currentTimeMillis();
        ModelAndView modelAndView = new ModelAndView("fragments/results_list :: resultsList");
        if(searchObject.getInternSearchParameters().get("ddrsOrPsp").get(0).equals("ddrs")) {
            Map<String, List<Repository>> repositories = new HashMap<>();
            try {
                int size = 0;
                List<String> identifiers = re3dataRepositoryService.getDefaultRepositories(true, searchObject);
                List<String> toNotSearch = identifiers;
                if (!identifiers.isEmpty()) {
                    List<Repository> europe = repositoryService.retrieveById(identifiers);
                    repositories.put("europe", europe);
                    size += europe.size();
                }

                identifiers = re3dataRepositoryService.getDefaultRepositories(false, searchObject);
                toNotSearch.addAll(identifiers);
                if (!identifiers.isEmpty()) {
                    List<Repository> national = repositoryService.retrieveById(identifiers);
                    repositories.put("national", national);
                    size += national.size();
                }

                List<Repository> search = repositoryService.searchWithRestrictions(searchObject, toNotSearch);
                repositories.put("search", search);
                size += search.size();

                modelAndView.addObject("results", size);
            } catch (RestClientException e) {
                LOGGER.error("There was an error in the RestTemplate", e);
                modelAndView.addObject("error", "error");
            }
            modelAndView.addObject("repositories", DdrsHelper.enhanceRepositories(repositories));
        } else {
            LOGGER.debug("We should be searching in our internal ES server for PSP data");
            List<Publication> publicationsFound = publicationService.searchWithRestrictions(searchObject);
            LOGGER.info("Found " + publicationsFound.size() + " publications!");
            modelAndView.addObject("publications", publicationsFound);
            modelAndView.addObject("results", publicationsFound.size());
        }
        LOGGER.debug("Full search done in " + (System.currentTimeMillis() - start) + "ms");
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