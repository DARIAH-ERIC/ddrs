package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Created by yoannmoranville on 09/05/17.
 */
@Controller
@SessionAttributes("searchObject")
public class IndexController {
    private final IQuestionDAO questionDAO;

    private static final Logger LOGGER = LogManager.getLogger(IndexController.class);

    @Autowired
    public IndexController(IQuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @ModelAttribute("searchObject")
    public SearchObject getSearchObject() {
        return new SearchObject();
    }

    @GetMapping(value = {"/", "/index"})
    public String index(@ModelAttribute("searchObject") SearchObject searchObject, Model model) {
        model.addAttribute("searchObject", searchObject);
        List<Question> allUsedQuestions = questionDAO.findAllOrderedAndInUse();
        model.addAttribute("questions", allUsedQuestions);
        return "index";
    }

    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }

    @GetMapping(value = "/suggest")
    public String suggest() {
        return "suggest";
    }

    /**
     * Shows the access denied error page if users try to access a restricted page
     * @return A String that points to the Thymeleaf HTML page within templates/ as configured in MvcConfiguration
     */
    @RequestMapping(value = "/access-denied", method = {RequestMethod.POST, RequestMethod.GET})
    public String errorAccessDenied(Model model) {
        model.addAttribute("error", "Access denied");
        return "errors/accessDenied";
    }
}
