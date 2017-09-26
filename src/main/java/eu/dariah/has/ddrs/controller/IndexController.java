package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import org.apache.log4j.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(IndexController.class);

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

    /**
     * Shows the login page in order to log the user in or to show an error when the login did not work
     * @param error A Boolean to display an error if the login failed, it will be returned by the Spring login mechanism
     * @return A String that points to the Thymeleaf HTML page within templates/ as configured in MvcConfiguration
     */
    @GetMapping(value = "/auth/login")
    public String getLoginPage(@RequestParam(value="error", required=false) boolean error, Model model) {
        model.addAttribute("error", error);
        return "auth/login";
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
