package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.elasticsearch.service.RepositoryService;
import eu.dariah.has.ddrs.persistence.dao.IContactRepositoryDAO;
import eu.dariah.has.ddrs.persistence.model.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/selectRepository")
    public String viewDetails(@RequestParam(value = "id") String identifier, Model model) {
        if(identifier.startsWith("r3d"))
            identifier = identifier.replace("r3d", "");
        Repository repository = repositoryService.searchByRe3Identifier(identifier);
        ContactRepository contactRepository = contactRepositoryDAO.findByRepositoryId("r3d" + identifier);
        if(contactRepository != null)
            model.addAttribute("ddrscontact", contactRepository.getContact());
        model.addAttribute("repository", repository);
        return "repository";
    }

    @GetMapping(value = "/contactForm")
    public String viewContactForm(@RequestParam(value = "id") String identifier, Model model) {
        if(identifier.startsWith("r3d"))
            identifier = identifier.replace("r3d", "");
        Repository repository = repositoryService.searchByRe3Identifier(identifier);
        model.addAttribute("repository", repository);
        return "contact_form";
    }

    @PostMapping(value = "/sendResults")
    public String sendResults(Model model) {
        return "results_sent";
    }

}
