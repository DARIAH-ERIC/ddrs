package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.elasticsearch.service.RepositoryService;
import eu.dariah.has.ddrs.persistence.dao.IContactRepositoryDAO;
import eu.dariah.has.ddrs.persistence.model.ContactRepository;
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
    private final RepositoryService repositoryService;
    private final IContactRepositoryDAO contactRepositoryDAO;

    @Autowired
    public RepositoryController(IContactRepositoryDAO contactRepositoryDAO, RepositoryService repositoryService) {
        this.contactRepositoryDAO = contactRepositoryDAO;
        this.repositoryService = repositoryService;
    }

    @RequestMapping(value = "/selectRepository", method = RequestMethod.GET)
    public String viewDetails(@RequestParam(value = "id") String identifier, Model model) {
        if(identifier.startsWith("r3d"))
            identifier = identifier.replace("r3d", "");
        Repository repository = repositoryService.searchByRe3Identifier(identifier);
        ContactRepository contactRepository = contactRepositoryDAO.findByRepositoryId("r3d" + identifier);
        if(contactRepository != null)
            model.addAttribute("contact", contactRepository.getContact());
        model.addAttribute("repository", repository);
        return "repository";
    }

    @RequestMapping(value = "/contactForm", method = RequestMethod.GET)
    public String viewContactForm(@RequestParam(value = "id") String identifier, Model model) {
        model.addAttribute("repositoryId", identifier);
        return "contact_form";
    }

}
