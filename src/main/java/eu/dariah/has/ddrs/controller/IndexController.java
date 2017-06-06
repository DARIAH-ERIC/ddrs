package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import eu.dariah.has.ddrs.persistence.model.QuestionTranslation;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yoannmoranville on 09/05/17.
 */
@Controller
public class IndexController {
    private final IQuestionDAO questionDAO;

    private static final Logger LOGGER = Logger.getLogger(IndexController.class);

    @Autowired
    public IndexController(IQuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("searchObject", new SearchObject());

        List<Question> allUsedQuestions = questionDAO.findAllOrderedAndInUse();
        model.addAttribute("questions", allUsedQuestions);

        return "index";
    }
}
