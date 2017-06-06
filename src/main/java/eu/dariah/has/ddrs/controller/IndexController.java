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

        Question countryQuestion = questionDAO.findOne(2L);
        model.addAttribute("countries", countryQuestion);

        Question subjectQuestion = questionDAO.findOne(1L);
        model.addAttribute("subjects", subjectQuestion);

        Question keywordQuestion = questionDAO.findOne(4L);
        model.addAttribute("keywords", keywordQuestion);

        Question languageQuestion = questionDAO.findOne(3L);
        model.addAttribute("repositoryLanguages", languageQuestion);

        model.addAttribute("selectedCountries", Collections.EMPTY_LIST);
        model.addAttribute("selectedSubjects", Collections.EMPTY_LIST);
        model.addAttribute("selectedKeywords", Collections.EMPTY_LIST);
        model.addAttribute("selectedRepositoryLanguages", Collections.EMPTY_LIST);
        return "index";
    }
}
