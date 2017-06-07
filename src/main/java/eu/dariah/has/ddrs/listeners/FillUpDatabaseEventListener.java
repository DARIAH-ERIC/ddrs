package eu.dariah.has.ddrs.listeners;

/**
 * Created by yoann on 30.05.17.
 */
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import eu.dariah.has.ddrs.persistence.model.Translation;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FillUpDatabaseEventListener {
    private final IResultTypeHierarchicalDAO resultTypeHierarchicalDAO;
    private final IQuestionDAO questionDAO;

    @Autowired
    public FillUpDatabaseEventListener(IResultTypeHierarchicalDAO resultTypeHierarchicalDAO, IQuestionDAO questionDAO) {
        this.resultTypeHierarchicalDAO = resultTypeHierarchicalDAO;
        this.questionDAO = questionDAO;
    }


    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        includeSubjects();
        includeCountries();
        includeRepositoryLanguages();
        includeKeywords();

        includeQuestions();
    }

    private void includeQuestions() {
        Question question = new Question("subjects", false, true, 2, 0, resultTypeHierarchicalDAO.findOne(1L), new Translation("In which subjects are you interested?"));
        questionDAO.create(question);

        question = new Question("countries", true, true, 1, 1, resultTypeHierarchicalDAO.findOne(34L), new Translation("From which country should the repository come from?"));
        questionDAO.create(question);

        question = new Question("repositoryLanguages", true, true, 3, 0, resultTypeHierarchicalDAO.findOne(40L), new Translation("Which languages should the repository have?"));
        questionDAO.create(question);

        question = new Question("keywords", true, false, 4, 0, resultTypeHierarchicalDAO.findOne(46L), new Translation("Which keywords should the repository have?"));
        questionDAO.create(question);
    }

    private void includeCountries() {
        ResultTypeHierarchical countries = new ResultTypeHierarchical();
        countries.setCode("NONE");
        countries.setTranslation(new Translation("Countries"));
        resultTypeHierarchicalDAO.create(countries);

        ResultTypeHierarchical france = createResultTypeHierarchical("FRA", 1, "France", countries);
        ResultTypeHierarchical germany = createResultTypeHierarchical("DEU", 2, "Germany", countries);
        ResultTypeHierarchical australia = createResultTypeHierarchical("AUS", 3, "Australia", countries);
        ResultTypeHierarchical austria = createResultTypeHierarchical("AUT", 4, "Austria", countries);
        ResultTypeHierarchical croatia = createResultTypeHierarchical("HRV", 5, "Croatia", countries);

        countries.addChildren(Arrays.asList(france, germany, australia, austria, croatia));
        resultTypeHierarchicalDAO.update(countries);
    }

    private void includeRepositoryLanguages() {
        ResultTypeHierarchical repositoryLanguages = new ResultTypeHierarchical();
        repositoryLanguages.setCode("NONE");
        repositoryLanguages.setTranslation(new Translation("Repository Languages"));
        resultTypeHierarchicalDAO.create(repositoryLanguages);

        ResultTypeHierarchical french = createResultTypeHierarchical("fra", 1, "French", repositoryLanguages);
        ResultTypeHierarchical german = createResultTypeHierarchical("deu", 2, "German", repositoryLanguages);
        ResultTypeHierarchical english = createResultTypeHierarchical("eng", 3, "English", repositoryLanguages);
        ResultTypeHierarchical finnish = createResultTypeHierarchical("fin", 4, "Finnish", repositoryLanguages);
        ResultTypeHierarchical croatian = createResultTypeHierarchical("hrv", 5, "Croatian", repositoryLanguages);

        repositoryLanguages.addChildren(Arrays.asList(french, german, english, finnish, croatian));
        resultTypeHierarchicalDAO.update(repositoryLanguages);
    }

    private void includeKeywords() {
        ResultTypeHierarchical keywords = new ResultTypeHierarchical();
        keywords.setCode("NONE");
        keywords.setTranslation(new Translation("Keywords"));
        resultTypeHierarchicalDAO.create(keywords);

        ResultTypeHierarchical corpora = createResultTypeHierarchical("corpora", 1, "Corpora", keywords);
        ResultTypeHierarchical history = createResultTypeHierarchical("history", 2, "History", keywords);
        ResultTypeHierarchical linguistics = createResultTypeHierarchical("linguistics", 3, "Linguistics", keywords);
        ResultTypeHierarchical multidisciplinary = createResultTypeHierarchical("multidisciplinary", 4, "Multidisciplinary", keywords);
        ResultTypeHierarchical music = createResultTypeHierarchical("music", 5, "Music", keywords);

        keywords.addChildren(Arrays.asList(corpora, history, linguistics, multidisciplinary, music));
        resultTypeHierarchicalDAO.update(keywords);
    }

    private void includeSubjects() {
        //Root
        ResultTypeHierarchical humanities = new ResultTypeHierarchical();
        humanities.setCode("NONE");
        humanities.setTranslation(new Translation("Humanities"));
        resultTypeHierarchicalDAO.create(humanities);

        //Level 1
        ResultTypeHierarchical ancientCultures = createResultTypeHierarchical("101 Ancient Cultures", 1, "Ancient Cultures", humanities);

        //Level 2
        ResultTypeHierarchical prehistory = createResultTypeHierarchical("10101 Prehistory", 1, "Prehistory", ancientCultures);
        ResultTypeHierarchical ancientHistory = createResultTypeHierarchical("10103 Ancient History", 2, "Ancient History", ancientCultures);
        ResultTypeHierarchical classicalArchaeology = createResultTypeHierarchical("10104 Classical Archaeology", 3, "Classical Archaeology", ancientCultures);
        ResultTypeHierarchical egyptology = createResultTypeHierarchical("10105 Egyptology and Ancient Near Eastern Studies", 4, "Egyptology and Ancient Near Eastern Studies", ancientCultures);

        ancientCultures.addChildren(Arrays.asList(prehistory, ancientHistory, classicalArchaeology, egyptology));
        resultTypeHierarchicalDAO.update(ancientCultures);

        //Level 1
        ResultTypeHierarchical history = createResultTypeHierarchical("102 History", 2, "History", humanities);

        //Level 2
        ResultTypeHierarchical medievalHistory = createResultTypeHierarchical("10201 Medieval History", 1, "Medieval History", history);
        ResultTypeHierarchical earlyModernHistory = createResultTypeHierarchical("10202 Early Modern History", 2, "Early Modern History", history);
        ResultTypeHierarchical modernAndCurrentHistory = createResultTypeHierarchical("10203 Modern and Current History", 3, "Modern and Current History", history);
        ResultTypeHierarchical historyOfScience = createResultTypeHierarchical("10204 History of Science", 4, "History of Science", history);

        history.addChildren(Arrays.asList(medievalHistory, earlyModernHistory, modernAndCurrentHistory, historyOfScience));
        resultTypeHierarchicalDAO.update(history);

        //Level 1
        ResultTypeHierarchical fineArts = createResultTypeHierarchical("103 Fine Arts, Music, Theatre and Media Studies", 3, "Fine Arts, Music, Theatre and Media Studies", humanities);

        //Level 2
        ResultTypeHierarchical artHistory = createResultTypeHierarchical("10301 Art History",1, "Art History", fineArts);
        ResultTypeHierarchical musicology = createResultTypeHierarchical("10302 Musicology", 2, "Musicology", fineArts);
        ResultTypeHierarchical theatre = createResultTypeHierarchical("10303 Theatre and Media Studies", 3, "Theatre and Media Studies", fineArts);

        fineArts.addChildren(Arrays.asList(artHistory, musicology, theatre));
        resultTypeHierarchicalDAO.update(fineArts);

        //Level 1
        ResultTypeHierarchical linguistics = createResultTypeHierarchical("104 Linguistics",4,"Linguistics", humanities);

        //Level 2
        ResultTypeHierarchical generalAndAppliedLinguistics = createResultTypeHierarchical("10401 General and Applied Linguistics", 1, "General and Applied Linguistics", linguistics);
        ResultTypeHierarchical individualLinguistics = createResultTypeHierarchical("10402 Individual Linguistics", 2, "Individual Linguistics", linguistics);
        ResultTypeHierarchical typology = createResultTypeHierarchical("10403 Typology, Non-European Languages, Historical Linguistics", 3, "Typology, Non-European Languages, Historical Linguistics", linguistics);

        linguistics.addChildren(Arrays.asList(generalAndAppliedLinguistics, individualLinguistics, typology));
        resultTypeHierarchicalDAO.update(linguistics);

        //Level 1
        ResultTypeHierarchical literaryStudies = createResultTypeHierarchical("105 Literary Studies", 5, "Literary Studies", humanities);

        //Level 2
        ResultTypeHierarchical europeanAndAmericanLiterature = createResultTypeHierarchical("10503 European and American Literature", 1, "European and American Literature", literaryStudies);
        ResultTypeHierarchical generalAndComparativeLiterature = createResultTypeHierarchical("10504 General and Comparative Literature and Cultural Studies", 2, "General and Comparative Literature and Cultural Studies", literaryStudies);

        literaryStudies.addChildren(Arrays.asList(europeanAndAmericanLiterature, generalAndComparativeLiterature));
        resultTypeHierarchicalDAO.update(literaryStudies);

        //Level 1
        ResultTypeHierarchical nonEuropean = createResultTypeHierarchical("106 Non-European Languages and Cultures, Social and Cultural Anthropology, Jewish Studies and Religious Studies", 6, "Non-European Languages and Cultures, Social and Cultural Anthropology, Jewish Studies and Religious Studies", humanities);

        //Level 2
        ResultTypeHierarchical socialAndCulturalAnthropology = createResultTypeHierarchical("10601 Social and Cultural Anthropology and Ethnology/Folklore", 1, "Social and Cultural Anthropology and Ethnology/Folklore", nonEuropean);
        ResultTypeHierarchical asianStudies = createResultTypeHierarchical("10602 Asian Studies", 2, "Asian Studies", nonEuropean);
        ResultTypeHierarchical africanAmericanAndOceaniaStudies = createResultTypeHierarchical("10603 African, American and Oceania Studies", 3, "African, American and Oceania Studies", nonEuropean);
        ResultTypeHierarchical islamicStudies = createResultTypeHierarchical("10604 Islamic Studies, Arabian Studies, Semitic Studies", 4, "Islamic Studies, Arabian Studies, Semitic Studies", nonEuropean);
        ResultTypeHierarchical religiousStudiesAndJewishStudies = createResultTypeHierarchical("10605 Religious Studies and Jewish Studies", 5, "Religious Studies and Jewish Studies", nonEuropean);

        nonEuropean.addChildren(Arrays.asList(socialAndCulturalAnthropology, asianStudies, africanAmericanAndOceaniaStudies, islamicStudies, religiousStudiesAndJewishStudies));
        resultTypeHierarchicalDAO.update(nonEuropean);

        //Level 1
        ResultTypeHierarchical theology = createResultTypeHierarchical("107 Theology", 7, "Theology", humanities);

        //Level 2
        ResultTypeHierarchical protestantTheology = createResultTypeHierarchical("10701 Protestant Theology", 1, "Protestant Theology", theology);
        ResultTypeHierarchical romanCatholicTheology = createResultTypeHierarchical("10702 Roman Catholic Theology", 2, "Roman Catholic Theology", theology);

        theology.addChildren(Arrays.asList(protestantTheology, romanCatholicTheology));
        resultTypeHierarchicalDAO.update(theology);

        //Level 1
        ResultTypeHierarchical philosophy = createResultTypeHierarchical("108 Philosophy", 8, "Philosophy", humanities);

        //Level 2
        ResultTypeHierarchical historyOfPhilosophy = createResultTypeHierarchical("10801 History of Philosophy", 1, "History of Philosophy", philosophy);

        philosophy.addChild(historyOfPhilosophy);
        resultTypeHierarchicalDAO.update(philosophy);

        humanities.addChildren(Arrays.asList(ancientCultures, history, fineArts, linguistics, literaryStudies, nonEuropean, theology, philosophy));
        resultTypeHierarchicalDAO.update(humanities);
    }

    private ResultTypeHierarchical createResultTypeHierarchical(String code, int order, String englishTranslation, ResultTypeHierarchical parent) {
        ResultTypeHierarchical resultTypeHierarchical = new ResultTypeHierarchical(code, order, parent);
        resultTypeHierarchical.setTranslation(new Translation(englishTranslation));
        resultTypeHierarchicalDAO.create(resultTypeHierarchical);
        
        return resultTypeHierarchical;
    }
}
