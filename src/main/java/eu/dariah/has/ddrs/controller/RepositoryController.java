package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.elasticsearch.service.RepositoryService;
import eu.dariah.has.ddrs.persistence.dao.IContactRepositoryDAO;
import eu.dariah.has.ddrs.persistence.model.ContactRepository;
import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import eu.dariah.has.ddrs.re3data.extra.RepositoryDetail;
import eu.dariah.has.ddrs.re3data.search.Link;
//import eu.dariah.has.ddrs.re3data.search.Repository;
import eu.dariah.has.ddrs.service.Re3dataRepositoryAPIService;
import eu.dariah.has.ddrs.service.RepositoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yoann on 12.06.17.
 */
@Controller
public class RepositoryController {

    private final Re3dataRepositoryAPIService re3dataRepositoryAPIService;
    private final RepositoryService repositoryService;
    private final IContactRepositoryDAO contactRepositoryDAO;

    @Autowired
    public RepositoryController(Re3dataRepositoryAPIService re3dataRepositoryAPIService, IContactRepositoryDAO contactRepositoryDAO, RepositoryService repositoryService) {
        this.re3dataRepositoryAPIService = re3dataRepositoryAPIService;
        this.contactRepositoryDAO = contactRepositoryDAO;
        this.repositoryService = repositoryService;
    }

    @RequestMapping(value = "/selectRepository", method = RequestMethod.GET)
    public String viewDetails(@RequestParam(value = "id") String identifier, Model model) {
        if(identifier.startsWith("re3"))
            identifier = identifier.replace("re3", "");
        Repository repository = repositoryService.searchByRe3Identifier(identifier);
        model.addAttribute("repository", repository);
        return "repository";
    }

//    @RequestMapping(value = "/selectRepository", method = RequestMethod.POST)
//    public String viewDetails(@RequestParam(value = "id") String identifier, @RequestParam Map<String, String> allRequestParameters, Model model) {
//        if(identifier.startsWith("re3"))
//            identifier = identifier.replace("re3", "");
//        Repository repository = repositoryService.searchByRe3Identifier(identifier);
//        model.addAttribute("repository", repository);
//        allRequestParameters.remove("_csrf");
//        allRequestParameters.remove("id");
//        model.addAttribute("allRequestParameters", allRequestParameters);
//        return "repository";
//    }

    @RequestMapping(value = "/contactForm", method = RequestMethod.GET)
    public String viewContactForm(@RequestParam(value = "id") String identifier, Model model) {
        model.addAttribute("repositoryId", identifier);
        return "contact_form";
    }

}
