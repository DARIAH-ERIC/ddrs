package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(@ModelAttribute("searchObject") SearchObject searchObject, Model model) {
        model.addAttribute("searchObject", searchObject);
        List<Question> allUsedQuestions = questionDAO.findAllOrderedAndInUse();
        model.addAttribute("questions", allUsedQuestions);
        return "index";
    }

    @ModelAttribute("searchObject")
    public SearchObject getSearchObject() {
        return new SearchObject();
    }

//    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
//    public String index(Model model, @RequestParam Map<String, String> allRequestParameters) {
//        model.addAttribute("searchObject", new SearchObject());
//        allRequestParameters.remove("_csrf");
//        model.addAttribute("allRequestParameters", allRequestParameters);
//        List<Question> allUsedQuestions = questionDAO.findAllOrderedAndInUse();
//        model.addAttribute("questions", allUsedQuestions);
//
//        return "index";
//    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value="error", required=false) boolean error, Model model) {
        model.addAttribute("error", error);
        return "auth/login";
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String errorAccessDenied(Model model) {
        model.addAttribute("error", "Access denied");
        return "errors/accessDenied";
    }
    @RequestMapping(value = "/access-denied", method = RequestMethod.POST)
    public String errorAccessDeniedPost(Model model) {
        model.addAttribute("error", "Access denied");
        return "errors/accessDenied";
    }
}
