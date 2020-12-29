package eu.dariah.has.ddrs.controller;

import eu.dariah.has.ddrs.persistence.dao.*;
import eu.dariah.has.ddrs.persistence.model.*;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by yoann on 02.06.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final IQuestionDAO questionDAO;
    private final IResultTypeHierarchicalDAO resultTypeHierarchicalDAO;
    private final ITranslationDAO translationDAO;
    private final IContactRepositoryDAO contactRepositoryDAO;
    private final IDefaultRepositoryDAO defaultRepositoryDAO;

    private static final Logger LOGGER = LogManager.getLogger(AdminController.class);

    @Autowired
    public AdminController(IQuestionDAO questionDAO, IResultTypeHierarchicalDAO resultTypeHierarchicalDAO, ITranslationDAO translationDAO, IContactRepositoryDAO contactRepositoryDAO, IDefaultRepositoryDAO defaultRepositoryDAO) {
        this.questionDAO = questionDAO;
        this.resultTypeHierarchicalDAO = resultTypeHierarchicalDAO;
        this.translationDAO = translationDAO;
        this.contactRepositoryDAO = contactRepositoryDAO;
        this.defaultRepositoryDAO = defaultRepositoryDAO;
    }

    @RequestMapping(value = {"/", "/questions"}, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin(Model model) {
        model.addAttribute("questions", questionDAO.findAllOrdered());
        return "admin/questions";
    }

    @RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
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
                case "qu_top":
                    int currentOrder = question.getQuestionOrder();
                    question.setQuestionOrder(-1);
                    questionDAO.update(question);
                    for(Question restQuestion : questionDAO.findAllWrongOrdered()) {
                        if(restQuestion.getQuestionOrder() < currentOrder && restQuestion.getQuestionOrder() != -1) {
                            restQuestion.setQuestionOrder(restQuestion.getQuestionOrder() + 1);
                            questionDAO.update(restQuestion);
                        }
                    }
                    question.setQuestionOrder(1);
                    questionDAO.update(question);
                    break;
                case "qu_up":

                    break;
                case "qu_down":

                    break;
                case "qu_bottom":
                    currentOrder = question.getQuestionOrder();
                    question.setQuestionOrder(-1);
                    questionDAO.update(question);
                    for(Question restQuestion : questionDAO.findAllOrdered()) {
                        if(restQuestion.getQuestionOrder() > currentOrder) {
                            currentOrder++;
                            restQuestion.setQuestionOrder(restQuestion.getQuestionOrder() - 1);
                            questionDAO.update(restQuestion);
                        }
                    }
                    question.setQuestionOrder(currentOrder);
                    questionDAO.update(question);
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
                        resultTypeHierarchical.setTranslation(new Translation(englishTranslation));
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
        return new RedirectView("/admin/questions", true);
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public RedirectView save(@RequestParam(name = "name") String name,
                             @RequestParam(name = "english_translation") String englishTranslation,
                             @RequestParam(name = "tooltip_english") String tooltipEnglish) {
        ResultTypeHierarchical resultTypeHierarchical = new ResultTypeHierarchical("NONE", 0, null);
        resultTypeHierarchical.setTranslation(new Translation(StringUtils.capitalize(name)));
        resultTypeHierarchicalDAO.create(resultTypeHierarchical);
        Question question = new Question(name, true, false, questionDAO.findHighestQuestionOrder() + 1, 0, resultTypeHierarchical, new Translation(englishTranslation), new Translation(tooltipEnglish));
        questionDAO.create(question);

        return new RedirectView("/admin/questions", true);
    }

    @RequestMapping(value = "/translations", method = RequestMethod.GET)
    public String translations(Model model, @RequestParam(name = "tr", required = false) Long translationId) {
        model.addAttribute("questions", questionDAO.findAll());
        model.addAttribute("results", resultTypeHierarchicalDAO.findAll());
        model.addAttribute("savedTranslationId", translationId);
        return "admin/translations";
    }

    @RequestMapping(value = "/saveTranslation", method = RequestMethod.POST)
    public RedirectView saveTranslations(@RequestParam(name = "translationId") Long translationId,
                                         @RequestParam(name = "english") String english,
                                         @RequestParam(name = "german") String german,
                                         @RequestParam(name = "french") String french,
                                         @RequestParam(name = "dutch") String dutch) {

        Translation translation = translationDAO.findOne(translationId);
        translation.setEn(english);
        translation.setDe(german);
        translation.setFr(french);
        translation.setNl(dutch);
        translationDAO.update(translation);

        return new RedirectView("/admin/translations?tr="+translationId, true);
    }

    @RequestMapping(value = "/contactRepositories", method = RequestMethod.GET)
    public String viewContacts(Model model) {
        model.addAttribute("contactRepositories", contactRepositoryDAO.findAll());

        return "admin/contact_repositories";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public RedirectView addContact(@RequestParam(name = "repositoryId") String repositoryId,
                                   @RequestParam(name = "contact") String contact) {
        ContactRepository contactRepository = new ContactRepository();
        contactRepository.setRespositoryIdentifier(repositoryId);
        contactRepository.setContact(contact);
        contactRepositoryDAO.create(contactRepository);

        return new RedirectView("/admin/contactRepositories", true);
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.POST)
    public RedirectView editContact(@RequestParam(name = "contactRepositoryId") Long contactRepositoryId,
                                    @RequestParam(name = "contact") String contact) {
        ContactRepository contactRepository = contactRepositoryDAO.findOne(contactRepositoryId);
        contactRepository.setContact(contact);
        contactRepositoryDAO.update(contactRepository);

        return new RedirectView("/admin/contactRepositories", true);
    }


    @RequestMapping(value = "/defaultRepositories", method = RequestMethod.GET)
    public String viewDefaultRepositories(Model model) {
        model.addAttribute("results", resultTypeHierarchicalDAO.findAll());

        return "admin/default_repositories";
    }

    @RequestMapping(value = "/editDefaultRepositories", method = RequestMethod.POST)
    public RedirectView editDefaultRepositories(@RequestParam(name = "resultId") Long resultId,
                                                @RequestParam(name = "repositoryId") String repositoryId, RedirectAttributes redirectAttributes) {
        ResultTypeHierarchical resultTypeHierarchical = resultTypeHierarchicalDAO.findOne(resultId);
        if(StringUtils.isNotEmpty(repositoryId) && resultTypeHierarchical != null) {
            defaultRepositoryDAO.create(new DefaultRepository(repositoryId, resultTypeHierarchical));
            redirectAttributes.addFlashAttribute("savedResultId", resultId);
        }
        return new RedirectView("/admin/defaultRepositories", true);
    }

    @RequestMapping(value = "/deleteDefaultRepositories", method = RequestMethod.POST)
    public RedirectView deleteDefaultRepositories(@RequestParam(name = "defaultRepositoryId") Long repositoryId) {
        defaultRepositoryDAO.deleteById(repositoryId);
        return new RedirectView("/admin/defaultRepositories", true);
    }
}
