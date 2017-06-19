package eu.dariah.has.ddrs.controller;

import com.fasterxml.jackson.annotation.JsonView;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yoannmoranville on 12/05/17.
 */
@RestController
public class AjaxController {
    private static final Logger LOGGER = Logger.getLogger(AjaxController.class);

    private final Re3dataRepositoryAPIService re3dataRepositoryAPIService;
    private final IContactRepositoryDAO contactRepositoryDAO;

    @Autowired
    public AjaxController(Re3dataRepositoryAPIService re3dataRepositoryAPIService, IContactRepositoryDAO contactRepositoryDAO) {
        this.re3dataRepositoryAPIService = re3dataRepositoryAPIService;
        this.contactRepositoryDAO = contactRepositoryDAO;
    }

    @JsonView(JsonViews.Public.class)
    @RequestMapping(value = "/refreshResults")
    public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchObject searchObject) {
        AjaxResponseBody result = new AjaxResponseBody();
        Re3dataQueryList re3dataQueryList = new Re3dataQueryList(searchObject);
        RestTemplate rest = new RestTemplate();

        Re3dataList re3dataList = new Re3dataList();
        long veryStart = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        try {
            re3dataList = rest.getForObject(re3dataQueryList.getUrl(), Re3dataList.class);
        } catch (RestClientException e) {
            LOGGER.error("There was an error in the RestTemplate", e);
            re3dataList.setHasError();
        }
        LOGGER.debug((System.currentTimeMillis() - start) + "ms for " + re3dataQueryList.getUrl());

        re3dataRepositoryAPIService.addDefaultRepositories(searchObject, re3dataList);

        LOGGER.debug("Size of repository list: " + re3dataList.getRepositories().size());
        for(Repository repository : re3dataList.getRepositories()) {
            start = System.currentTimeMillis();
            Re3Data re3Data = re3dataRepositoryAPIService.findRe3Data(repository.getLink().getHref());
            LOGGER.debug((System.currentTimeMillis() - start) + "ms for " + repository.getLink().getHref());
            if(re3Data.getRepository().size() > 0) {
                Re3Data.Repository repo = re3Data.getRepository().get(0);
                RepositoryBuilder.addRepositoryDetails(repository, repo, contactRepositoryDAO.findByRepositoryId(repository.getId()));
            }
        }
        LOGGER.info("It took " + (System.currentTimeMillis() - veryStart) + "ms for this search and the retrieval of the detailed data: " + re3dataQueryList.getUrl());

        if(re3dataList.getRepositories().size() > 0) {
            result.setCode("200");
            result.setMsg("");
            result.setRepositories(re3dataList.getRepositories());
        } else if(re3dataList.getHasError()) {
            result.setCode("500");
            result.setMsg("Error from Re3data endpoint...");
        } else {
            result.setCode("204");
            result.setMsg("No results...");
        }

        return result;
    }
}