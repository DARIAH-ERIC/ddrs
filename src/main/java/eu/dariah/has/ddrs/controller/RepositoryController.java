package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.elasticsearch.service.RepositoryService;
import eu.dariah.has.ddrs.helper.DdrsHelper;
import eu.dariah.has.ddrs.persistence.dao.IContactRepositoryDAO;
import eu.dariah.has.ddrs.persistence.model.ContactRepository;
import eu.dariah.has.ddrs.service.RecaptchaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yoann on 12.06.17.
 */
@Controller
public class RepositoryController {
    private final RepositoryService repositoryService;
    private final IContactRepositoryDAO contactRepositoryDAO;
    private final RecaptchaService captchaService;

    @Value("${recaptcha.site}")
    private String recaptchaSite;

    @Autowired
    public RepositoryController(IContactRepositoryDAO contactRepositoryDAO, RepositoryService repositoryService, RecaptchaService captchaService) {
        this.contactRepositoryDAO = contactRepositoryDAO;
        this.repositoryService = repositoryService;
        this.captchaService = captchaService;
    }

    @GetMapping(value = "/selectRepository")
    public String viewDetails(@RequestParam(value = "id") String identifier, Model model) {
        if(identifier.startsWith("r3d"))
            identifier = identifier.replace("r3d", "");
        Repository repository = repositoryService.searchByRe3Identifier(identifier);
        ContactRepository contactRepository = contactRepositoryDAO.findByRepositoryId("r3d" + identifier);
        if(contactRepository != null)
            model.addAttribute("ddrscontact", contactRepository.getContact());
        model.addAttribute("repository", DdrsHelper.addCountriesToRepository(repository));
        return "repository";
    }

    @GetMapping(value = "/contactForm")
    public String viewContactForm(@RequestParam(value = "id") String identifier, Model model) {
        if(identifier.startsWith("r3d"))
            identifier = identifier.replace("r3d", "");
        Repository repository = repositoryService.searchByRe3Identifier(identifier);
        model.addAttribute("repository", DdrsHelper.addCountriesToRepository(repository));
        model.addAttribute("recaptchaSite", recaptchaSite);
        return "contact_form";
    }

    @PostMapping(value = "/sendResults")
    public String sendResults(Model model, @RequestParam(value = "id") String identifier, @RequestParam(name="g-recaptcha-response") String recaptchaResponse, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String captchaVerifyMessage =
                captchaService.verifyRecaptcha(ip, recaptchaResponse);

        if (StringUtils.isNotEmpty(captchaVerifyMessage)) {
            if(identifier.startsWith("r3d"))
                identifier = identifier.replace("r3d", "");
            Repository repository = repositoryService.searchByRe3Identifier(identifier);
            model.addAttribute("repository", DdrsHelper.addCountriesToRepository(repository));
            model.addAttribute("recaptchaSite", recaptchaSite);
            model.addAttribute("error", captchaVerifyMessage);
            return "contact_form";
        }
        return "results_sent";
    }
}
