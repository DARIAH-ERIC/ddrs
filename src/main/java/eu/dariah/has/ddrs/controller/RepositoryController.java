package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.persistence.dao.IContactRepositoryDAO;
import eu.dariah.has.ddrs.persistence.model.ContactRepository;
import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import eu.dariah.has.ddrs.re3data.extra.RepositoryDetail;
import eu.dariah.has.ddrs.re3data.search.Link;
import eu.dariah.has.ddrs.re3data.search.Repository;
import eu.dariah.has.ddrs.service.Re3dataRepositoryAPIService;
import eu.dariah.has.ddrs.service.RepositoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yoann on 12.06.17.
 */
@Controller
public class RepositoryController {

    private final Re3dataRepositoryAPIService re3dataRepositoryAPIService;
    private final IContactRepositoryDAO contactRepositoryDAO;

    @Autowired
    public RepositoryController(Re3dataRepositoryAPIService re3dataRepositoryAPIService, IContactRepositoryDAO contactRepositoryDAO) {
        this.re3dataRepositoryAPIService = re3dataRepositoryAPIService;
        this.contactRepositoryDAO = contactRepositoryDAO;
    }

    @RequestMapping(value = "/selectRepository", method = RequestMethod.GET)
    public String viewDetails(@RequestParam(value = "id") String identifier, Model model) {
        Re3Data re3Data = re3dataRepositoryAPIService.findRe3DataByIdentifier(identifier);
        if(re3Data.getRepository().size() > 0) {
            Re3Data.Repository repo = re3Data.getRepository().get(0);
            Repository repository = RepositoryBuilder.createRepository(repo, contactRepositoryDAO.findByRepositoryId(identifier));
            model.addAttribute("repository", repository);
        }
        return "repository";
    }

}
