package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.elasticsearch.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yoann on 12.06.17.
 */
@Controller
public class PspController {
    private final PublicationService publicationService;

    @Autowired
    public PspController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping(value = "/selectPsp")
    public String viewDetails(@RequestParam(value = "id") String identifier, Model model) {
        model.addAttribute("publication", publicationService.findOne(identifier));
        return "publication";
    }
}
