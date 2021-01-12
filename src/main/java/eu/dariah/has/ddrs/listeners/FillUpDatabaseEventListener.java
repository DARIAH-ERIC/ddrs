package eu.dariah.has.ddrs.listeners;

/**
 * Created by yoann on 30.05.17.
 */
import eu.dariah.has.ddrs.elasticsearch.service.IndexChecker;
import eu.dariah.has.ddrs.persistence.dao.*;
import eu.dariah.has.ddrs.persistence.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashSet;

@Component
public class FillUpDatabaseEventListener {
    private final IResultTypeHierarchicalDAO resultTypeHierarchicalDAO;
    private final IQuestionDAO questionDAO;
    private final IContactRepositoryDAO contactRepositoryDAO;
    private final IDefaultRepositoryDAO defaultRepositoryDAO;
    private final ITranslationDAO translationDAO;

    @Autowired
    public FillUpDatabaseEventListener(IResultTypeHierarchicalDAO resultTypeHierarchicalDAO, IQuestionDAO questionDAO, IContactRepositoryDAO contactRepositoryDAO, IDefaultRepositoryDAO defaultRepositoryDAO, ITranslationDAO translationDAO) {
        this.resultTypeHierarchicalDAO = resultTypeHierarchicalDAO;
        this.questionDAO = questionDAO;
        this.contactRepositoryDAO = contactRepositoryDAO;
        this.defaultRepositoryDAO = defaultRepositoryDAO;
        this.translationDAO = translationDAO;
    }


    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        includeSubjects();
        includeCountries();
        includeRepositoryLanguages();
        includeKeywords();
        includeQuestionsDdrs();
        includeTypesPublications();
        includeLanguagesPublications();
        includeDisciplinesPublications();
        includeAccessPoliciesPublications();
        includeLicensesPublications();
        includeQuestionsPsp();
        includeContacts();
    }

    private void includeQuestionsDdrs() {
        Question question = new Question("institutions.country.raw", true, true, 1,
                resultTypeHierarchicalDAO.findOne(11L), new Translation("In which country are you based as a " +
                "researcher?"), new Translation("Please select the country where you work as a researcher or where " +
                "you would like to deposit your research data. You can also select European Union."), "ddrs");
        questionDAO.create(question);

        question = new Question("subjects.text.raw", false, true, 4, resultTypeHierarchicalDAO.findOne(1L),
                new Translation("What is your disciplinary field?"), new Translation("To search for more specific " +
                "results, please select the discipline most applicable to your research data."), "ddrs");
        questionDAO.create(question);

        question = new Question("repositoryLanguages.text.raw", true, false, 3,
                resultTypeHierarchicalDAO.findOne(47L),
                new Translation("Which languages should the repository have?"), new Translation("Tooltip for language" +
                " questions..."), "ddrs");
        questionDAO.create(question);

        question = new Question("keywords.text.raw", true, false, 2, resultTypeHierarchicalDAO.findOne(53L),
                new Translation("Which keywords should the repository have?"), new Translation("Tooltip for keyword " +
                "questions..."), "ddrs");
        questionDAO.create(question);
    }

    private void includeQuestionsPsp() {
        Question question = new Question("types.scheme", true, true, 1,
                resultTypeHierarchicalDAO.findOne(59L), new Translation("What type of output would you like to " +
                "publish?"), new Translation("Tooltip for types of publication"), "psp");
        questionDAO.create(question);

        question = new Question("languages.text", true, true, 2,
                resultTypeHierarchicalDAO.findOne(79L), new Translation("In which language  would you like to " +
                "publish?"), new Translation("Tooltip for language of publication"), "psp");
        questionDAO.create(question);

        question = new Question("disciplines.scheme", true, false, 3,
                resultTypeHierarchicalDAO.findOne(97L), new Translation("For which disciplines would you like to " +
                "publish?"), new Translation("Tooltip for discipline of publication"), "psp");
        questionDAO.create(question);

        question = new Question("accessPolicies.text", true, false, 4,
                resultTypeHierarchicalDAO.findOne(129L), new Translation("What access policy would would you like to " +
                "publish?"), new Translation("Tooltip for Access Policies of publication"), "psp");
        questionDAO.create(question);

        question = new Question("licenses.name", true, true, 5,
                resultTypeHierarchicalDAO.findOne(136L), new Translation("What license would would you like to " +
                "publish?"), new Translation("Tooltip for license of publication"), "psp");
        questionDAO.create(question);
    }

    private void includeTypesPublications() {
        ResultTypeHierarchical typesPublications = new ResultTypeHierarchical();
        typesPublications.setCode("NONE");
        typesPublications.setTranslation(new Translation("Types of Publications"));
        resultTypeHierarchicalDAO.create(typesPublications);

        ResultTypeHierarchical journal =
                createResultTypeHierarchical(IndexChecker.TypePublications.JOURNAL.getScheme(), 1,
                        IndexChecker.TypePublications.JOURNAL.getName(), typesPublications);
        ResultTypeHierarchical megajournal =
                createResultTypeHierarchical(IndexChecker.TypePublications.MEGA_JOURNAL.getScheme(), 2,
                        IndexChecker.TypePublications.MEGA_JOURNAL.getName(), typesPublications);
        ResultTypeHierarchical journalarticle =
                createResultTypeHierarchical(IndexChecker.TypePublications.JOURNAL_ARTICLE.getScheme(), 3,
                        IndexChecker.TypePublications.JOURNAL_ARTICLE.getName(), typesPublications);
        ResultTypeHierarchical workingpaper =
                createResultTypeHierarchical(IndexChecker.TypePublications.WORKING_PAPER.getScheme(), 4,
                        IndexChecker.TypePublications.WORKING_PAPER.getName(), typesPublications);
        ResultTypeHierarchical phdthesis =
                createResultTypeHierarchical(IndexChecker.TypePublications.PHD_THESIS.getScheme(), 5,
                        IndexChecker.TypePublications.PHD_THESIS.getName(), typesPublications);
        ResultTypeHierarchical monograph =
                createResultTypeHierarchical(IndexChecker.TypePublications.MONOGRAPH.getScheme(), 6,
                        IndexChecker.TypePublications.MONOGRAPH.getName(), typesPublications);
        ResultTypeHierarchical misc =
                createResultTypeHierarchical(IndexChecker.TypePublications.MISCELLANEA.getScheme(), 7,
                        IndexChecker.TypePublications.MISCELLANEA.getName(), typesPublications);
        ResultTypeHierarchical bookchapt =
                createResultTypeHierarchical(IndexChecker.TypePublications.BOOK_CHAPTER.getScheme(), 8,
                        IndexChecker.TypePublications.BOOK_CHAPTER.getName(), typesPublications);
        ResultTypeHierarchical textbook =
                createResultTypeHierarchical(IndexChecker.TypePublications.TEXTBOOK.getScheme(), 9,
                        IndexChecker.TypePublications.TEXTBOOK.getName(), typesPublications);
        ResultTypeHierarchical referencework =
                createResultTypeHierarchical(IndexChecker.TypePublications.REFERENCE_WORK.getScheme(), 10,
                        IndexChecker.TypePublications.REFERENCE_WORK.getName(), typesPublications);
        ResultTypeHierarchical bookseries =
                createResultTypeHierarchical(IndexChecker.TypePublications.BOOK_SERIES.getScheme(), 11,
                        IndexChecker.TypePublications.BOOK_SERIES.getName(), typesPublications);
        ResultTypeHierarchical workingpaperseries =
                createResultTypeHierarchical(IndexChecker.TypePublications.WORKING_PAPER_SERIES.getScheme(), 12,
                        IndexChecker.TypePublications.WORKING_PAPER_SERIES.getName(), typesPublications);
        ResultTypeHierarchical conferenceproceedings =
                createResultTypeHierarchical(IndexChecker.TypePublications.CONFERENCE_PROCEEDINGS.getScheme(), 13,
                        IndexChecker.TypePublications.CONFERENCE_PROCEEDINGS.getName(), typesPublications);
        ResultTypeHierarchical printededition =
                createResultTypeHierarchical(IndexChecker.TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION.getScheme(), 14,
                        IndexChecker.TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION.getName(), typesPublications);
        ResultTypeHierarchical digitaledition =
                createResultTypeHierarchical(IndexChecker.TypePublications.DIGITAL_SCHOLARLY_CRITICAL_EDITION.getScheme(), 15,
                        IndexChecker.TypePublications.DIGITAL_SCHOLARLY_CRITICAL_EDITION.getName(), typesPublications);
        ResultTypeHierarchical preprint =
                createResultTypeHierarchical(IndexChecker.TypePublications.PREPRINT.getScheme(), 16,
                        IndexChecker.TypePublications.PREPRINT.getName(), typesPublications);
        ResultTypeHierarchical blogposts =
                createResultTypeHierarchical(IndexChecker.TypePublications.BLOG_POSTS.getScheme(), 17,
                        IndexChecker.TypePublications.BLOG_POSTS.getName(), typesPublications);
        ResultTypeHierarchical audiovideo =
                createResultTypeHierarchical(IndexChecker.TypePublications.AUDIO_VIDEO_MATERIAL.getScheme(), 18,
                        IndexChecker.TypePublications.AUDIO_VIDEO_MATERIAL.getName(), typesPublications);
        ResultTypeHierarchical researchdata =
                createResultTypeHierarchical(IndexChecker.TypePublications.RESEARCH_DATA.getScheme(), 19,
                        IndexChecker.TypePublications.RESEARCH_DATA.getName(), typesPublications);

        typesPublications.addChildren(new LinkedHashSet<>(Arrays.asList(journal, megajournal, journalarticle,
                workingpaper, phdthesis, monograph, misc, bookchapt, textbook, referencework, bookseries,
                workingpaperseries, conferenceproceedings, printededition, digitaledition, preprint, blogposts,
                audiovideo, researchdata)));
        resultTypeHierarchicalDAO.update(typesPublications);
    }

    private void includeLanguagesPublications() {
        ResultTypeHierarchical languagePublications = new ResultTypeHierarchical();
        languagePublications.setCode("NONE");
        languagePublications.setTranslation(new Translation("Languages of Publications"));
        resultTypeHierarchicalDAO.create(languagePublications);

        ResultTypeHierarchical croatian = createResultTypeHierarchical(IndexChecker.Languages.CROATIAN.getCode(), 1,
                "Croatian", languagePublications);
        ResultTypeHierarchical dutch = createResultTypeHierarchical(IndexChecker.Languages.DUTCH.getCode(), 2,
                "Dutch", languagePublications);
        ResultTypeHierarchical english = createResultTypeHierarchical(IndexChecker.Languages.ENGLISH.getCode(), 3,
                "English", languagePublications);
        ResultTypeHierarchical french = createResultTypeHierarchical(IndexChecker.Languages.FRENCH.getCode(), 4,
                "French", languagePublications);
        Translation translation = french.getTranslation();
        translation.setFr("Français");
        translation.setDe("Französisch");
        translationDAO.update(translation);
        ResultTypeHierarchical german = createResultTypeHierarchical(IndexChecker.Languages.GERMAN.getCode(), 5,
                "German", languagePublications);
        ResultTypeHierarchical greekmodern =
                createResultTypeHierarchical(IndexChecker.Languages.GREEK_MODERN.getCode(), 6, "Greek (Modern)",
                        languagePublications);
        ResultTypeHierarchical italian = createResultTypeHierarchical(IndexChecker.Languages.ITALIAN.getCode(), 7,
                "Italian", languagePublications);
        ResultTypeHierarchical polish = createResultTypeHierarchical(IndexChecker.Languages.POLISH.getCode(), 8,
                "Polish", languagePublications);
        ResultTypeHierarchical portuguese =
                createResultTypeHierarchical(IndexChecker.Languages.PORTUGUESE.getCode() , 9, "Portuguese",
                        languagePublications);
        ResultTypeHierarchical norwegian = createResultTypeHierarchical(IndexChecker.Languages.NORWEGIAN.getCode(),
                10, "Norwegian", languagePublications);
        ResultTypeHierarchical slovenian = createResultTypeHierarchical(IndexChecker.Languages.SLOVENIAN.getCode(),
                11, "Slovenian", languagePublications);
        ResultTypeHierarchical spanish = createResultTypeHierarchical(IndexChecker.Languages.SPANISH.getCode(), 12,
                "Spanish", languagePublications);
        ResultTypeHierarchical swedish = createResultTypeHierarchical(IndexChecker.Languages.SWEDISH.getCode(), 13,
                "Swedish", languagePublications);
        ResultTypeHierarchical catalan = createResultTypeHierarchical(IndexChecker.Languages.CATALAN.getCode(), 14,
                "Catalan", languagePublications);
        ResultTypeHierarchical russian = createResultTypeHierarchical(IndexChecker.Languages.RUSSIAN.getCode(), 15,
                "Russian", languagePublications);
        ResultTypeHierarchical latin = createResultTypeHierarchical(IndexChecker.Languages.LATIN.getCode(), 16,
                "Latin", languagePublications);
        ResultTypeHierarchical greekancient =
                createResultTypeHierarchical(IndexChecker.Languages.GREEK_ANCIENT.getCode(), 17, "Greek (Ancient)",
                        languagePublications);

        languagePublications.addChildren(new LinkedHashSet<>(Arrays.asList(croatian, dutch, english, french, german,
                greekmodern, italian, polish, portuguese, norwegian, slovenian, spanish, swedish, catalan, russian,
                latin, greekancient)));
        resultTypeHierarchicalDAO.update(languagePublications);
    }

    private void includeDisciplinesPublications() {
        ResultTypeHierarchical disciplinesPublications = new ResultTypeHierarchical();
        disciplinesPublications.setCode("NONE");
        disciplinesPublications.setTranslation(new Translation("Disciplines of Publications"));
        resultTypeHierarchicalDAO.create(disciplinesPublications);

        ResultTypeHierarchical law =
                createResultTypeHierarchical(IndexChecker.Disciplines.LAW.getScheme(), 1,
                        IndexChecker.Disciplines.LAW.getName(), disciplinesPublications);
        ResultTypeHierarchical history =
                createResultTypeHierarchical(IndexChecker.Disciplines.HISTORY.getScheme(), 2,
                        IndexChecker.Disciplines.HISTORY.getName(), disciplinesPublications);
        ResultTypeHierarchical archeology =
                createResultTypeHierarchical(IndexChecker.Disciplines.ARCHEOLOGY.getScheme(), 3,
                        IndexChecker.Disciplines.ARCHEOLOGY.getName(), disciplinesPublications);
        ResultTypeHierarchical sociology =
                createResultTypeHierarchical(IndexChecker.Disciplines.SOCIOLOGY.getScheme(), 4,
                        IndexChecker.Disciplines.SOCIOLOGY.getName(), disciplinesPublications);
        ResultTypeHierarchical economics =
                createResultTypeHierarchical(IndexChecker.Disciplines.ECONOMICS_FINANCE.getScheme(), 5,
                        IndexChecker.Disciplines.ECONOMICS_FINANCE.getName(), disciplinesPublications);
        ResultTypeHierarchical geography =
                createResultTypeHierarchical(IndexChecker.Disciplines.GEOGRAPHY.getScheme(), 6,
                        IndexChecker.Disciplines.GEOGRAPHY.getName(), disciplinesPublications);
        ResultTypeHierarchical literature =
                createResultTypeHierarchical(IndexChecker.Disciplines.LITERATURE.getScheme(), 7,
                        IndexChecker.Disciplines.LITERATURE.getName(), disciplinesPublications);
        ResultTypeHierarchical linguistics =
                createResultTypeHierarchical(IndexChecker.Disciplines.LINGUISTICS.getScheme(), 8,
                        IndexChecker.Disciplines.LINGUISTICS.getName(), disciplinesPublications);
        ResultTypeHierarchical business =
                createResultTypeHierarchical(IndexChecker.Disciplines.BUSINESS_ADMINISTRATION.getScheme(), 9,
                        IndexChecker.Disciplines.BUSINESS_ADMINISTRATION.getName(), disciplinesPublications);
        ResultTypeHierarchical political =
                createResultTypeHierarchical(IndexChecker.Disciplines.POLITICAL_SCIENCE.getScheme(), 10,
                        IndexChecker.Disciplines.POLITICAL_SCIENCE.getName(), disciplinesPublications);
        ResultTypeHierarchical education =
                createResultTypeHierarchical(IndexChecker.Disciplines.EDUCATION.getScheme(), 11,
                        IndexChecker.Disciplines.EDUCATION.getName(), disciplinesPublications);
        ResultTypeHierarchical anthropology =
                createResultTypeHierarchical(IndexChecker.Disciplines.ANTHROPOLOGY_ETHNOLOGY.getScheme(), 12,
                        IndexChecker.Disciplines.ANTHROPOLOGY_ETHNOLOGY.getName(), disciplinesPublications);
        ResultTypeHierarchical library =
                createResultTypeHierarchical(IndexChecker.Disciplines.LIBRARY_INFORMATION_SCIENCE.getScheme(), 13,
                        IndexChecker.Disciplines.LIBRARY_INFORMATION_SCIENCE.getName(), disciplinesPublications);
        ResultTypeHierarchical art =
                createResultTypeHierarchical(IndexChecker.Disciplines.ART_HISTORY.getScheme(), 14,
                        IndexChecker.Disciplines.ART_HISTORY.getName(), disciplinesPublications);
        ResultTypeHierarchical architecture =
                createResultTypeHierarchical(IndexChecker.Disciplines.ARCHITECTURE.getScheme(), 15,
                        IndexChecker.Disciplines.ARCHITECTURE.getName(), disciplinesPublications);
        ResultTypeHierarchical space =
                createResultTypeHierarchical(IndexChecker.Disciplines.SPACE_MANAGEMENT.getScheme(), 16,
                        IndexChecker.Disciplines.SPACE_MANAGEMENT.getName(), disciplinesPublications);
        ResultTypeHierarchical philosophy =
                createResultTypeHierarchical(IndexChecker.Disciplines.PHILOSOPHY.getScheme(), 17,
                        IndexChecker.Disciplines.PHILOSOPHY.getName(), disciplinesPublications);
        ResultTypeHierarchical histphilo =
                createResultTypeHierarchical(IndexChecker.Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES.getScheme(), 18,
                        IndexChecker.Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES.getName(), disciplinesPublications);
        ResultTypeHierarchical psychology =
                createResultTypeHierarchical(IndexChecker.Disciplines.PSYCHOLOGY.getScheme(), 19,
                        IndexChecker.Disciplines.PSYCHOLOGY.getName(), disciplinesPublications);
        ResultTypeHierarchical musicology =
                createResultTypeHierarchical(IndexChecker.Disciplines.MUSICOLOGY.getScheme(), 20,
                        IndexChecker.Disciplines.MUSICOLOGY.getName(), disciplinesPublications);
        ResultTypeHierarchical religions =
                createResultTypeHierarchical(IndexChecker.Disciplines.RELIGIONS.getScheme(), 21,
                        IndexChecker.Disciplines.RELIGIONS.getName(), disciplinesPublications);
        ResultTypeHierarchical classical =
                createResultTypeHierarchical(IndexChecker.Disciplines.CLASSICAL.getScheme(), 22,
                        IndexChecker.Disciplines.CLASSICAL.getName(), disciplinesPublications);
        ResultTypeHierarchical environment =
                createResultTypeHierarchical(IndexChecker.Disciplines.ENVIRONMENTAL.getScheme(), 23,
                        IndexChecker.Disciplines.ENVIRONMENTAL.getName(), disciplinesPublications);
        ResultTypeHierarchical cultural =
                createResultTypeHierarchical(IndexChecker.Disciplines.CULTURAL_HERITAGE.getScheme(), 24,
                        IndexChecker.Disciplines.CULTURAL_HERITAGE.getName(), disciplinesPublications);
        ResultTypeHierarchical gender =
                createResultTypeHierarchical(IndexChecker.Disciplines.GENDER.getScheme(), 25,
                        IndexChecker.Disciplines.GENDER.getName(), disciplinesPublications);
        ResultTypeHierarchical methods =
                createResultTypeHierarchical(IndexChecker.Disciplines.METHODS_STATS.getScheme(), 26,
                        IndexChecker.Disciplines.METHODS_STATS.getName(), disciplinesPublications);
        ResultTypeHierarchical biology =
                createResultTypeHierarchical(IndexChecker.Disciplines.BIOLOGY_ANTHROPOLOGY.getScheme(), 27,
                        IndexChecker.Disciplines.BIOLOGY_ANTHROPOLOGY.getName(), disciplinesPublications);
        ResultTypeHierarchical demography =
                createResultTypeHierarchical(IndexChecker.Disciplines.DEMOGRAPHY.getScheme(), 28,
                        IndexChecker.Disciplines.DEMOGRAPHY.getName(), disciplinesPublications);
        ResultTypeHierarchical digitalhuma =
                createResultTypeHierarchical(IndexChecker.Disciplines.DIGITAL_HUMANITIES.getScheme(), 29,
                        IndexChecker.Disciplines.DIGITAL_HUMANITIES.getName(), disciplinesPublications);
        ResultTypeHierarchical communi =
                createResultTypeHierarchical(IndexChecker.Disciplines.COMMUNICATION.getScheme(), 30,
                        IndexChecker.Disciplines.COMMUNICATION.getName(), disciplinesPublications);
        ResultTypeHierarchical media =
                createResultTypeHierarchical(IndexChecker.Disciplines.MEDIA_SCIENCE.getScheme(), 31,
                        IndexChecker.Disciplines.MEDIA_SCIENCE.getName(), disciplinesPublications);

        disciplinesPublications.addChildren(new LinkedHashSet<>(Arrays.asList(law, history, archeology, sociology,
                economics, geography, literature, linguistics, business, political, education, anthropology, library,
                art, architecture, space, philosophy, histphilo, psychology, musicology, religions, classical,
                environment, cultural, gender, methods, biology, demography, digitalhuma, communi, media)));
        resultTypeHierarchicalDAO.update(disciplinesPublications);
    }

    private void includeAccessPoliciesPublications() {
        ResultTypeHierarchical accessPoliciesPublications = new ResultTypeHierarchical();
        accessPoliciesPublications.setCode("NONE");
        accessPoliciesPublications.setTranslation(new Translation("Access Policy of Publications"));
        resultTypeHierarchicalDAO.create(accessPoliciesPublications);

        ResultTypeHierarchical closed =
                createResultTypeHierarchical(IndexChecker.AccessPolicies.CLOSED.getCode(), 1,
                        IndexChecker.AccessPolicies.CLOSED.getName(), accessPoliciesPublications);
        ResultTypeHierarchical openHybrid =
                createResultTypeHierarchical(IndexChecker.AccessPolicies.OPEN_HYBRID.getCode(), 2,
                        IndexChecker.AccessPolicies.OPEN_HYBRID.getName(), accessPoliciesPublications);
        ResultTypeHierarchical openAPC =
                createResultTypeHierarchical(IndexChecker.AccessPolicies.OPEN_WITH_APC.getCode(), 3,
                        IndexChecker.AccessPolicies.OPEN_WITH_APC.getName(), accessPoliciesPublications);
        ResultTypeHierarchical openWithoutFee =
                createResultTypeHierarchical(IndexChecker.AccessPolicies.OPEN_WITHOUT_FEE.getCode(), 4,
                        IndexChecker.AccessPolicies.OPEN_WITHOUT_FEE.getName(), accessPoliciesPublications);
        ResultTypeHierarchical openWithEmbargo =
                createResultTypeHierarchical(IndexChecker.AccessPolicies.OPEN_WITH_EMBARGO.getCode(), 5,
                        IndexChecker.AccessPolicies.OPEN_WITH_EMBARGO.getName(), accessPoliciesPublications);
        ResultTypeHierarchical openWithoutEmbargo =
                createResultTypeHierarchical(IndexChecker.AccessPolicies.OPEN_WITHOUT_EMBARGO.getCode(), 6,
                        IndexChecker.AccessPolicies.OPEN_WITHOUT_EMBARGO.getName(), accessPoliciesPublications);

        accessPoliciesPublications.addChildren(new LinkedHashSet<>(Arrays.asList(closed, openHybrid, openAPC,
                openWithoutFee, openWithEmbargo, openWithoutEmbargo)));
        resultTypeHierarchicalDAO.update(accessPoliciesPublications);
    }

    private void includeLicensesPublications() {
        ResultTypeHierarchical licensesPublications = new ResultTypeHierarchical();
        licensesPublications.setCode("NONE");
        licensesPublications.setTranslation(new Translation("Licenses of Publications"));
        resultTypeHierarchicalDAO.create(licensesPublications);

        ResultTypeHierarchical allrights =
                createResultTypeHierarchical(IndexChecker.Licenses.ALL_RIGHTS_RESERVED.getCode(), 1,
                        IndexChecker.Licenses.ALL_RIGHTS_RESERVED.getName(), licensesPublications);
        ResultTypeHierarchical ccby =
                createResultTypeHierarchical(IndexChecker.Licenses.CC_BY.getCode(), 2,
                        IndexChecker.Licenses.CC_BY.getName(), licensesPublications);
        ResultTypeHierarchical ccbysa =
                createResultTypeHierarchical(IndexChecker.Licenses.CC_BY_SA.getCode(), 3,
                        IndexChecker.Licenses.CC_BY_SA.getName(), licensesPublications);
        ResultTypeHierarchical ccbync =
                createResultTypeHierarchical(IndexChecker.Licenses.CC_BY_NC.getCode(), 4,
                        IndexChecker.Licenses.CC_BY_NC.getName(), licensesPublications);
        ResultTypeHierarchical ccbyncsa =
                createResultTypeHierarchical(IndexChecker.Licenses.CC_BY_NC_SA.getCode(), 5,
                        IndexChecker.Licenses.CC_BY_NC_SA.getName(), licensesPublications);
        ResultTypeHierarchical ccbynd =
                createResultTypeHierarchical(IndexChecker.Licenses.CC_BY_ND.getCode(), 6,
                        IndexChecker.Licenses.CC_BY_ND.getName(), licensesPublications);
        ResultTypeHierarchical ccbyncnd =
                createResultTypeHierarchical(IndexChecker.Licenses.CC_BY_NC_ND.getCode(), 7,
                        IndexChecker.Licenses.CC_BY_NC_ND.getName(), licensesPublications);
        ResultTypeHierarchical gnugpl =
                createResultTypeHierarchical(IndexChecker.Licenses.GNU_GPL.getCode(), 8,
                        IndexChecker.Licenses.GNU_GPL.getName(), licensesPublications);
        ResultTypeHierarchical openfreemium =
                createResultTypeHierarchical(IndexChecker.Licenses.OPEN_FREEMIUM.getCode(), 9,
                        IndexChecker.Licenses.OPEN_FREEMIUM.getName(), licensesPublications);

        licensesPublications.addChildren(new LinkedHashSet<>(Arrays.asList(allrights, ccby, ccbysa, ccbync, ccbyncsa,
                ccbynd, ccbyncnd, gnugpl, openfreemium)));
        resultTypeHierarchicalDAO.update(licensesPublications);
    }

    private void includeCountries() {
        ResultTypeHierarchical countries = new ResultTypeHierarchical();
        countries.setCode("NONE");
        countries.setTranslation(new Translation("Countries"));
        resultTypeHierarchicalDAO.create(countries);
        defaultRepositoryDAO.create(new DefaultRepository("r3d100010468", countries));
        defaultRepositoryDAO.create(new DefaultRepository("r3d100011394", countries));
        defaultRepositoryDAO.create(new DefaultRepository("r3d100010066", countries));

        ResultTypeHierarchical austria = createResultTypeHierarchical("AUT", 1, "Austria", countries);
        ResultTypeHierarchical belgium = createResultTypeHierarchical("BEL", 2, "Belgium", countries);
        ResultTypeHierarchical bulgaria = createResultTypeHierarchical("BUL", 3, "Bulgaria", countries);
        ResultTypeHierarchical croatia = createResultTypeHierarchical("HRV", 4, "Croatia", countries);;
        ResultTypeHierarchical cyprus = createResultTypeHierarchical("CYP", 5, "Cyprus", countries);
        ResultTypeHierarchical czech = createResultTypeHierarchical("CZE", 6, "Czech Republic", countries);
        ResultTypeHierarchical denmark = createResultTypeHierarchical("DNK", 7, "Denmark", countries, "r3d100010486");
        ResultTypeHierarchical estonia = createResultTypeHierarchical("EST", 8, "Estonia", countries);
        ResultTypeHierarchical europeanUnion = createResultTypeHierarchical("EEC", 9, "European Union", countries);
        ResultTypeHierarchical finland = createResultTypeHierarchical("FIN", 10, "Finland", countries);
        ResultTypeHierarchical france = createResultTypeHierarchical("FRA", 11, "France", countries, "r3d100010151", "r3d100012102");
        ResultTypeHierarchical germany = createResultTypeHierarchical("DEU", 12, "Germany", countries, "r3d100011345");
        ResultTypeHierarchical greece = createResultTypeHierarchical("GRC", 13, "Greece", countries);
        ResultTypeHierarchical hungary = createResultTypeHierarchical("HUN", 14, "Hungary", countries);
        ResultTypeHierarchical iceland = createResultTypeHierarchical("ISL", 15, "Iceland", countries);
        ResultTypeHierarchical ireland = createResultTypeHierarchical("IRL", 16, "Ireland", countries);
        ResultTypeHierarchical italy = createResultTypeHierarchical("ITA", 17, "Italy", countries);
        ResultTypeHierarchical latvia = createResultTypeHierarchical("LTV", 18, "Latvia", countries);
        ResultTypeHierarchical lithuania = createResultTypeHierarchical("LTU", 19, "Lithuania", countries);
        ResultTypeHierarchical luxembourg = createResultTypeHierarchical("LUX", 20, "Luxembourg", countries);
        ResultTypeHierarchical malta = createResultTypeHierarchical("MLT", 21, "Malta", countries);
        ResultTypeHierarchical montenegro = createResultTypeHierarchical("MTN", 22, "Montenegro", countries);
        ResultTypeHierarchical netherlands = createResultTypeHierarchical("NLD", 23, "Netherlands", countries, "r3d100010214");
        ResultTypeHierarchical norway = createResultTypeHierarchical("NOR", 24, "Norway", countries, "r3d100010493");
        ResultTypeHierarchical poland = createResultTypeHierarchical("POL", 25, "Poland", countries);
        ResultTypeHierarchical portugal = createResultTypeHierarchical("PRT", 26, "Portugal", countries);
        ResultTypeHierarchical romania = createResultTypeHierarchical("ROU", 27, "Romania", countries);
        ResultTypeHierarchical serbia = createResultTypeHierarchical("SRB", 28, "Serbia", countries);
        ResultTypeHierarchical slovakia = createResultTypeHierarchical("SVK", 29, "Slovakia", countries);
        ResultTypeHierarchical slovenia = createResultTypeHierarchical("SVN", 30, "Slovenia", countries);
        ResultTypeHierarchical spain = createResultTypeHierarchical("ESP", 31, "Spain", countries);
        ResultTypeHierarchical sweden = createResultTypeHierarchical("SWE", 32, "Sweden", countries, "r3d100010146");
        ResultTypeHierarchical switzerland = createResultTypeHierarchical("CHE", 33, "Switzerland", countries, "r3d100012374");
        ResultTypeHierarchical turkey = createResultTypeHierarchical("TUR", 34, "Turkey", countries);
        ResultTypeHierarchical unitedKingdom = createResultTypeHierarchical("GBR", 35, "United Kingdom", countries, "r3d100010215");

        countries.addChildren(new LinkedHashSet<>(Arrays.asList(austria, belgium, bulgaria, croatia, cyprus, czech, denmark, estonia, europeanUnion, finland, france, germany, greece,
                hungary, iceland, ireland, italy, lithuania, luxembourg, latvia, malta, montenegro, netherlands, norway, poland, portugal, romania,
                serbia, slovakia, slovenia, spain, sweden, switzerland, turkey, unitedKingdom)));
        resultTypeHierarchicalDAO.update(countries);
    }

    private void includeRepositoryLanguages() {
        ResultTypeHierarchical repositoryLanguages = new ResultTypeHierarchical();
        repositoryLanguages.setCode("NONE");
        repositoryLanguages.setTranslation(new Translation("Repository Languages"));
        resultTypeHierarchicalDAO.create(repositoryLanguages);

        ResultTypeHierarchical french = createResultTypeHierarchical("fra", 1, "French", repositoryLanguages);
        Translation translation = french.getTranslation();
        translation.setFr("Français");
        translation.setDe("Französisch");
        translationDAO.update(translation);
        ResultTypeHierarchical german = createResultTypeHierarchical("deu", 2, "German", repositoryLanguages);
        ResultTypeHierarchical english = createResultTypeHierarchical("eng", 3, "English", repositoryLanguages);
        ResultTypeHierarchical finnish = createResultTypeHierarchical("fin", 4, "Finnish", repositoryLanguages);
        ResultTypeHierarchical croatian = createResultTypeHierarchical("hrv", 5, "Croatian", repositoryLanguages);

        repositoryLanguages.addChildren(new LinkedHashSet<>(Arrays.asList(french, german, english, finnish, croatian)));
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

        keywords.addChildren(new LinkedHashSet<>(Arrays.asList(corpora, history, linguistics, multidisciplinary, music)));
        resultTypeHierarchicalDAO.update(keywords);
    }

    private void includeSubjects() {
        //Root
        ResultTypeHierarchical humanities = new ResultTypeHierarchical();
        humanities.setCode("NONE");
        humanities.setTranslation(new Translation("Humanities"));
        resultTypeHierarchicalDAO.create(humanities);
//        defaultRepositoryDAO.create(new DefaultRepository("r3d100010468", humanities));
//        defaultRepositoryDAO.create(new DefaultRepository("r3d100011394", humanities));
//        defaultRepositoryDAO.create(new DefaultRepository("r3d100010066", humanities));

        //Level 1
        ResultTypeHierarchical ancientCultures = createResultTypeHierarchical("101 Ancient Cultures", 1, "Ancient Cultures", humanities);

        //Level 1
        ResultTypeHierarchical history = createResultTypeHierarchical("102 History", 2, "History", humanities);

        //Level 1
        ResultTypeHierarchical fineArts = createResultTypeHierarchical("103 Fine Arts, Music, Theatre and Media Studies", 3, "Fine Arts, Music, Theatre and Media Studies", humanities);

        //Level 1
        ResultTypeHierarchical linguistics = createResultTypeHierarchical("104 Linguistics",4,"Linguistics", humanities);

        //Level 1
        ResultTypeHierarchical literaryStudies = createResultTypeHierarchical("105 Literary Studies", 5, "Literary Studies", humanities);

        //Level 1
        ResultTypeHierarchical nonEuropean = createResultTypeHierarchical("106 Non-European Languages and Cultures, Social and Cultural Anthropology, Jewish Studies and Religious Studies", 6, "Non-European Languages and Cultures, Social and Cultural Anthropology, Jewish Studies and Religious Studies", humanities);

        //Level 1
        ResultTypeHierarchical theology = createResultTypeHierarchical("107 Theology", 7, "Theology", humanities);

        //Level 1
        ResultTypeHierarchical philosophy = createResultTypeHierarchical("108 Philosophy", 8, "Philosophy", humanities);

        //Level 1
        ResultTypeHierarchical other = createResultTypeHierarchical("OTHER", 8, "Other", humanities);

        humanities.addChildren(new LinkedHashSet<>(Arrays.asList(ancientCultures, history, fineArts, linguistics, literaryStudies, nonEuropean, theology, philosophy, other)));
        resultTypeHierarchicalDAO.update(humanities);
    }

    private ResultTypeHierarchical createResultTypeHierarchical(String code, int order, String englishTranslation, ResultTypeHierarchical parent, String... defaultRepositories) {
        ResultTypeHierarchical resultTypeHierarchical = new ResultTypeHierarchical(code, order, parent);
        resultTypeHierarchical.setTranslation(new Translation(englishTranslation));
        resultTypeHierarchicalDAO.create(resultTypeHierarchical);
        for(String defaultRepository : defaultRepositories)
            defaultRepositoryDAO.create(new DefaultRepository(defaultRepository, resultTypeHierarchical));
        
        return resultTypeHierarchical;
    }

    private void includeContacts() {
        ContactRepository contactRepository = new ContactRepository("r3d100010832", "yoann.moranville.dariah+test@gmail.com");
        contactRepositoryDAO.create(contactRepository);
    }
}
