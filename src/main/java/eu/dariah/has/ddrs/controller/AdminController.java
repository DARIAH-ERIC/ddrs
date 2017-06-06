package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import eu.dariah.has.ddrs.persistence.model.QuestionTranslation;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

/**
 * Created by yoann on 02.06.17.
 */
@Controller
public class AdminController {
    private final IQuestionDAO questionDAO;
    private final IResultTypeHierarchicalDAO resultTypeHierarchicalDAO;

    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    @Autowired
    public AdminController(IQuestionDAO questionDAO, IResultTypeHierarchicalDAO resultTypeHierarchicalDAO) {
        this.questionDAO = questionDAO;
        this.resultTypeHierarchicalDAO = resultTypeHierarchicalDAO;
    }

    @RequestMapping(value = "/admin/questions", method = RequestMethod.GET)
    public String admin(Model model) {
        model.addAttribute("questions", questionDAO.findAllOrdered());
        return "admin/questions";
    }

    @RequestMapping(value = "/admin/saveQuestion", method = RequestMethod.POST)
    public RedirectView save(@RequestParam(name = "select_question", required = false) Long resultTypeHierarchicalId,
                             @RequestParam(name = "questionId") Long questionId,
                             @RequestParam(name = "action") String action,
                             @RequestParam(name = "result_code", required = false) String code,
                             @RequestParam(name = "english_translation", required = false) String englishTranslation) {
        if(questionId != null && action != null) {
            Question question = questionDAO.findOne(questionId);
            switch(action) {
                case "top":
                    if(resultTypeHierarchicalId != null) {
                        ResultTypeHierarchical resultTypeHierarchical = resultTypeHierarchicalDAO.findOne(resultTypeHierarchicalId);
                        for(ResultTypeHierarchical sibling : resultTypeHierarchical.getParent().getChildren()) {
                            if(sibling.getResultTypeHierarchicalOrder() < resultTypeHierarchical.getResultTypeHierarchicalOrder()) {
                                sibling.setResultTypeHierarchicalOrder(sibling.getResultTypeHierarchicalOrder() + 1);
                                resultTypeHierarchicalDAO.update(sibling);
                            }
                        }
                        resultTypeHierarchical.setResultTypeHierarchicalOrder(1);
                        resultTypeHierarchicalDAO.update(resultTypeHierarchical);
                    }
                    break;
                case "up":
                    if(resultTypeHierarchicalId != null) {
                        ResultTypeHierarchical resultTypeHierarchical = resultTypeHierarchicalDAO.findOne(resultTypeHierarchicalId);
                        for(ResultTypeHierarchical sibling : resultTypeHierarchical.getParent().getChildren()) {
                            if(sibling.getResultTypeHierarchicalOrder() == resultTypeHierarchical.getResultTypeHierarchicalOrder() - 1) {
                                sibling.setResultTypeHierarchicalOrder(sibling.getResultTypeHierarchicalOrder() + 1);
                                resultTypeHierarchicalDAO.update(sibling);
                            }
                        }
                        resultTypeHierarchical.setResultTypeHierarchicalOrder(resultTypeHierarchical.getResultTypeHierarchicalOrder() - 1);
                        resultTypeHierarchicalDAO.update(resultTypeHierarchical);
                    }
                    break;
                case "down":
                    if(resultTypeHierarchicalId != null) {
                        ResultTypeHierarchical resultTypeHierarchical = resultTypeHierarchicalDAO.findOne(resultTypeHierarchicalId);
                        for(ResultTypeHierarchical sibling : resultTypeHierarchical.getParent().getChildren()) {
                            if(sibling.getResultTypeHierarchicalOrder() == resultTypeHierarchical.getResultTypeHierarchicalOrder() + 1) {
                                sibling.setResultTypeHierarchicalOrder(sibling.getResultTypeHierarchicalOrder() - 1);
                                resultTypeHierarchicalDAO.update(sibling);
                            }
                        }
                        resultTypeHierarchical.setResultTypeHierarchicalOrder(resultTypeHierarchical.getResultTypeHierarchicalOrder() + 1);
                        resultTypeHierarchicalDAO.update(resultTypeHierarchical);
                    }
                    break;
                case "bottom":
                    if(resultTypeHierarchicalId != null) {
                        ResultTypeHierarchical resultTypeHierarchical = resultTypeHierarchicalDAO.findOne(resultTypeHierarchicalId);
                        int orderAddition = 0;
                        for(ResultTypeHierarchical sibling : resultTypeHierarchical.getParent().getChildren()) {
                            if(sibling.getResultTypeHierarchicalOrder() > resultTypeHierarchical.getResultTypeHierarchicalOrder()) {
                                orderAddition++;
                                sibling.setResultTypeHierarchicalOrder(sibling.getResultTypeHierarchicalOrder() - 1);
                                resultTypeHierarchicalDAO.update(sibling);
                            }
                        }
                        resultTypeHierarchical.setResultTypeHierarchicalOrder(resultTypeHierarchical.getResultTypeHierarchicalOrder() + orderAddition);
                        resultTypeHierarchicalDAO.update(resultTypeHierarchical);
                    }
                    break;
                case "inuse":
                    question.setInUse(!question.getInUse());
                    questionDAO.update(question);
                    break;
                case "add":
                    LOGGER.info(code + " - " + englishTranslation);
                    if(StringUtils.isNotBlank(code) && StringUtils.isNotBlank(englishTranslation)) {
                        int highestOrder = 0;
                        ResultTypeHierarchical parent = question.getResultTypeHierarchical();
                        for(ResultTypeHierarchical res : parent.getChildren()) {
                            if(res.getResultTypeHierarchicalOrder() > highestOrder) {
                                highestOrder = res.getResultTypeHierarchicalOrder();
                            }
                        }
                        ResultTypeHierarchical resultTypeHierarchical = new ResultTypeHierarchical(code, highestOrder+1, parent);
                        resultTypeHierarchical.setQuestionTranslation(new QuestionTranslation(englishTranslation));
                        resultTypeHierarchicalDAO.create(resultTypeHierarchical);
                        parent.addChild(resultTypeHierarchical);
                        resultTypeHierarchicalDAO.update(parent);
                    }
                    break;
                case "delete":
                    if(resultTypeHierarchicalId != null) {
                        LOGGER.info("Removing " + resultTypeHierarchicalId);
                        resultTypeHierarchicalDAO.deleteById(resultTypeHierarchicalId);
                    }
                    break;
            }
        }
        return new RedirectView("/admin/questions");
    }
}
