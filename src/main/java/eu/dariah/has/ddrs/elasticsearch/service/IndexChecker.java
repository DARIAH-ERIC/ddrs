package eu.dariah.has.ddrs.elasticsearch.service;

import eu.dariah.has.ddrs.elasticsearch.model.ElasticSearchDDRSName;
import eu.dariah.has.ddrs.elasticsearch.model.ElasticSearchDDRSSchemeText;
import eu.dariah.has.ddrs.elasticsearch.model.ElasticSearchDDRSText;
import eu.dariah.has.ddrs.elasticsearch.model.psp.Publication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class IndexChecker {
    private static final Logger LOGGER = LogManager.getLogger(IndexChecker.class);
    private PublicationService publicationService;

    @Autowired
    public IndexChecker(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    public void checkIndex() {
        try {
            publicationService.findAll();
        } catch (Exception e) {
            LOGGER.error("We got a problem! Probably we need to create the index!");
            try {
                publicationService.createIndex();
            } catch (Exception ex) {
                LOGGER.error("We could not create the index!", ex);
            }
        }

        try {
            publicationService.findAll();
            LOGGER.info("Ok, the index exists, so we continue...");
            if (!publicationService.findAll().isEmpty()) {
                LOGGER.error("We are emptying the index...");
                for (String identifier : publicationService.findAllIdentifiers()) {
                    publicationService.delete(identifier, true);
                }
            }
            if (publicationService.findAll().isEmpty()) {
                LOGGER.error("We are filling the index because it is empty!");
                saveAllPublicationServices();
            }
        } catch (Exception e) {
            LOGGER.error("We could not continue and hence save any data in the index!", e);
        }
    }

    private Publication createPublication(String name, String description, String serviceProvider, List<TypePublications> types,
                                          List<AccessPolicies> accessPolicies, List<Languages> languages,
                                          List<Licenses> licenses, List<Disciplines> disciplines) {
        Publication publication = new Publication();

        publication.setName(name);
        publication.setDescription(description);
        publication.setServiceProvider(serviceProvider);

        List<ElasticSearchDDRSSchemeText> elasticSearchDDRSSchemeTexts = new ArrayList<>();
        for(TypePublications type : types) {
            ElasticSearchDDRSSchemeText elasticSearchDDRSSchemeText = new ElasticSearchDDRSSchemeText();
            elasticSearchDDRSSchemeText.setScheme(type.getScheme());
            elasticSearchDDRSSchemeText.setText(type.getName());
            elasticSearchDDRSSchemeTexts.add(elasticSearchDDRSSchemeText);
        }
        publication.setTypes(elasticSearchDDRSSchemeTexts);

        List<ElasticSearchDDRSText> elasticSearchDDRSTexts = new ArrayList<>();
        for(AccessPolicies accessPolicy : accessPolicies)
            elasticSearchDDRSTexts.add(new ElasticSearchDDRSText(accessPolicy.toString()));
        publication.setAccessPolicies(elasticSearchDDRSTexts);

        elasticSearchDDRSTexts = new ArrayList<>();
        for(Languages language : languages)
            elasticSearchDDRSTexts.add(new ElasticSearchDDRSText(language.getCode()));
        publication.setLanguages(elasticSearchDDRSTexts);

        List<ElasticSearchDDRSName> elasticSearchDDRSNames = new ArrayList<>();
        for(Licenses license : licenses) {
            ElasticSearchDDRSName elasticSearchDDRSName = new ElasticSearchDDRSName();
            elasticSearchDDRSName.setName(license.getCode());
            elasticSearchDDRSNames.add(elasticSearchDDRSName);
        }
        publication.setLicenses(elasticSearchDDRSNames);

        elasticSearchDDRSSchemeTexts = new ArrayList<>();
        for(Disciplines discipline : disciplines) {
            ElasticSearchDDRSSchemeText elasticSearchDDRSSchemeText = new ElasticSearchDDRSSchemeText();
            elasticSearchDDRSSchemeText.setScheme(discipline.getScheme());
            elasticSearchDDRSSchemeText.setText(discipline.getName());
            elasticSearchDDRSSchemeTexts.add(elasticSearchDDRSSchemeText);
        }
        publication.setDisciplines(elasticSearchDDRSSchemeTexts);

        return publication;
    }

    private void saveAllPublicationServices() {
        Publication inriaPublication = createPublication("Episciences",
                "Description of the actual service, what does Episciences do...",
                "Inria, team ALMAnaCH",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.MEGA_JOURNAL,
                        TypePublications.JOURNAL_ARTICLE, TypePublications.WORKING_PAPER,
                        TypePublications.PHD_THESIS, TypePublications.MONOGRAPH, TypePublications.MISCELLANEA,
                        TypePublications.BOOK_CHAPTER, TypePublications.TEXTBOOK,
                        TypePublications.REFERENCE_WORK, TypePublications.BOOK_SERIES,
                        TypePublications.WORKING_PAPER_SERIES, TypePublications.CONFERENCE_PROCEEDINGS,
                        TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION, TypePublications.BLOG_POSTS),
                Collections.emptyList(),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH, Languages.GERMAN, Languages.ITALIAN,
                        Languages.SPANISH),
                Collections.emptyList(),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE,
                        Disciplines.GENDER, Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY,
                        Disciplines.DEMOGRAPHY));
        publicationService.save(inriaPublication);

        Publication iblpanPublication = createPublication("Service of IBL - PAN",
                "Description of the actual service, what does this service exactly do...",
                "Institute of Literary Research of the Polish Academy of Sciences (IBL PAN)",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.JOURNAL_ARTICLE,
                        TypePublications.MONOGRAPH, TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION,
                        TypePublications.RESEARCH_DATA),
                Collections.singletonList(AccessPolicies.OPEN_WITHOUT_FEE),
                Arrays.asList(Languages.ENGLISH, Languages.POLISH),
                Arrays.asList(Licenses.ALL_RIGHTS_RESERVED, Licenses.CC_BY_SA),
                Collections.singletonList(Disciplines.LITERATURE));
        publicationService.save(iblpanPublication);

        Publication cnrPublication = createPublication("Service of Italian National Research Council (CNR)",
                "Description of the actual service, what does this service exactly do...",
                "Italian National Research Council (CNR)",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.JOURNAL_ARTICLE,
                        TypePublications.PHD_THESIS, TypePublications.MONOGRAPH, TypePublications.MISCELLANEA,
                        TypePublications.BOOK_CHAPTER, TypePublications.TEXTBOOK,
                        TypePublications.REFERENCE_WORK, TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION,
                        TypePublications.AUDIO_VIDEO_MATERIAL),
                Collections.singletonList(AccessPolicies.OPEN_WITHOUT_FEE),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH, Languages.GERMAN, Languages.ITALIAN,
                        Languages.POLISH, Languages.PORTUGUESE, Languages.SPANISH),
                Arrays.asList(Licenses.CC_BY_NC_SA, Licenses.CC_BY_NC_ND),
                Arrays.asList(Disciplines.HISTORY, Disciplines.ARCHEOLOGY, Disciplines.SOCIOLOGY,
                        Disciplines.GEOGRAPHY, Disciplines.LITERATURE, Disciplines.LINGUISTICS,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CULTURAL_HERITAGE));
        publicationService.save(cnrPublication);

        Publication lexisPublication = createPublication("Service of Lexis",
                "Description of the actual service, what does this service exactly do...",
                "Lexis",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.MEGA_JOURNAL,
                        TypePublications.JOURNAL_ARTICLE, TypePublications.WORKING_PAPER,
                        TypePublications.PHD_THESIS, TypePublications.MONOGRAPH, TypePublications.MISCELLANEA,
                        TypePublications.BOOK_CHAPTER, TypePublications.TEXTBOOK,
                        TypePublications.REFERENCE_WORK, TypePublications.BOOK_SERIES,
                        TypePublications.WORKING_PAPER_SERIES, TypePublications.CONFERENCE_PROCEEDINGS,
                        TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION,
                        TypePublications.DIGITAL_SCHOLARLY_CRITICAL_EDITION,
                        TypePublications.PREPRINT),
                Arrays.asList(AccessPolicies.CLOSED, AccessPolicies.OPEN_HYBRID,
                        AccessPolicies.OPEN_WITH_APC, AccessPolicies.OPEN_WITHOUT_FEE,
                        AccessPolicies.OPEN_WITH_EMBARGO, AccessPolicies.OPEN_WITHOUT_EMBARGO),
                Arrays.asList(Languages.CROATIAN, Languages.DUTCH, Languages.ENGLISH, Languages.FRENCH,
                        Languages.GERMAN, Languages.GREEK_MODERN, Languages.ITALIAN, Languages.POLISH,
                        Languages.PORTUGUESE, Languages.NORWEGIAN, Languages.SLOVENIAN, Languages.SPANISH,
                        Languages.SWEDISH, Languages.CATALAN, Languages.RUSSIAN, Languages.LATIN,
                        Languages.GREEK_ANCIENT),
                Arrays.asList(Licenses.ALL_RIGHTS_RESERVED, Licenses.CC_BY, Licenses.CC_BY_SA,
                        Licenses.CC_BY_NC, Licenses.CC_BY_NC_SA, Licenses.CC_BY_ND, Licenses.CC_BY_NC_ND),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE,
                        Disciplines.GENDER, Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY,
                        Disciplines.DEMOGRAPHY, Disciplines.DIGITAL_HUMANITIES, Disciplines.COMMUNICATION,
                        Disciplines.MEDIA_SCIENCE));
        publicationService.save(lexisPublication);

        Publication ektPublication = createPublication("Service of EKT",
                "Description of the actual service, what does this service exactly do...",
                "National Documentation Centre (EKT/NHRF)",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.MONOGRAPH, TypePublications.TEXTBOOK,
                        TypePublications.BOOK_SERIES, TypePublications.CONFERENCE_PROCEEDINGS,
                        TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION),
                Arrays.asList(AccessPolicies.OPEN_WITHOUT_FEE, AccessPolicies.OPEN_WITH_EMBARGO),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH, Languages.GREEK_MODERN),
                Arrays.asList(Licenses.CC_BY, Licenses.CC_BY_NC, Licenses.CC_BY_NC_SA),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.LITERATURE,
                        Disciplines.LINGUISTICS, Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.ART_HISTORY, Disciplines.PHILOSOPHY,
                        Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES, Disciplines.PSYCHOLOGY,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL));
        publicationService.save(ektPublication);

        Publication openLibraryHumanitiesPublication = createPublication("Service of Open Library of Humanities (OLH)",
                "Description of the actual service, what does this service exactly do...",
                "Open Library of Humanities (OLH)",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.MEGA_JOURNAL,
                        TypePublications.JOURNAL_ARTICLE, TypePublications.MONOGRAPH,
                        TypePublications.BOOK_CHAPTER, TypePublications.REFERENCE_WORK,
                        TypePublications.CONFERENCE_PROCEEDINGS),
                Collections.singletonList(AccessPolicies.OPEN_WITHOUT_FEE),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH, Languages.GERMAN, Languages.ITALIAN),
                Arrays.asList(Licenses.CC_BY, Licenses.CC_BY_SA, Licenses.CC_BY_NC, Licenses.CC_BY_NC_SA,
                        Licenses.CC_BY_ND, Licenses.CC_BY_NC_ND),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE,
                        Disciplines.GENDER, Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY,
                        Disciplines.DEMOGRAPHY));
        publicationService.save(openLibraryHumanitiesPublication);

        Publication openEditionPublication = createPublication("Hypotheses.org",
                "Description of the actual service, what does Hypotheses.org do...",
                "OpenEdition",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.JOURNAL_ARTICLE,
                        TypePublications.WORKING_PAPER, TypePublications.MONOGRAPH,
                        TypePublications.MISCELLANEA, TypePublications.BOOK_CHAPTER,
                        TypePublications.BOOK_SERIES, TypePublications.BLOG_POSTS),
                Arrays.asList(AccessPolicies.CLOSED, AccessPolicies.OPEN_WITHOUT_FEE,
                        AccessPolicies.OPEN_WITH_EMBARGO, AccessPolicies.OPEN_WITHOUT_EMBARGO),
                Arrays.asList(Languages.CROATIAN, Languages.DUTCH, Languages.ENGLISH, Languages.FRENCH,
                        Languages.GERMAN, Languages.GREEK_MODERN, Languages.ITALIAN, Languages.POLISH,
                        Languages.PORTUGUESE, Languages.NORWEGIAN, Languages.SLOVENIAN, Languages.SPANISH,
                        Languages.SWEDISH),
                Arrays.asList(Licenses.ALL_RIGHTS_RESERVED, Licenses.CC_BY, Licenses.CC_BY_SA,
                        Licenses.CC_BY_NC, Licenses.CC_BY_NC_SA, Licenses.CC_BY_ND, Licenses.CC_BY_NC_ND,
                        Licenses.OPEN_FREEMIUM),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE,
                        Disciplines.GENDER, Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY,
                        Disciplines.DEMOGRAPHY));
        publicationService.save(openEditionPublication);

        Publication pkpPublication = createPublication("Service of PKP",
                "Description of the actual service, what does this service exactly do...",
                "Public Knowledge Project (PKP)",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.MEGA_JOURNAL,
                        TypePublications.JOURNAL_ARTICLE, TypePublications.WORKING_PAPER,
                        TypePublications.MONOGRAPH, TypePublications.BOOK_CHAPTER, TypePublications.TEXTBOOK,
                        TypePublications.BOOK_SERIES, TypePublications.WORKING_PAPER_SERIES,
                        TypePublications.CONFERENCE_PROCEEDINGS,
                        TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION, TypePublications.PREPRINT),
                Arrays.asList(AccessPolicies.CLOSED, AccessPolicies.OPEN_HYBRID,
                        AccessPolicies.OPEN_WITHOUT_FEE, AccessPolicies.OPEN_WITH_EMBARGO,
                        AccessPolicies.OPEN_WITHOUT_EMBARGO),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH),
                Arrays.asList(Licenses.ALL_RIGHTS_RESERVED, Licenses.CC_BY, Licenses.CC_BY_SA,
                        Licenses.CC_BY_NC, Licenses.CC_BY_NC_SA, Licenses.CC_BY_ND, Licenses.CC_BY_NC_ND,
                        Licenses.GNU_GPL),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE,
                        Disciplines.GENDER, Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY,
                        Disciplines.DEMOGRAPHY));
        publicationService.save(pkpPublication);

        Publication coimbraPublication = createPublication("Coimbra University Press",
                "Description of the actual service, what does this service exactly do...",
                "University of Coimbra - Coimbra University Press",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.JOURNAL_ARTICLE,
                        TypePublications.PHD_THESIS, TypePublications.MONOGRAPH, TypePublications.MISCELLANEA,
                        TypePublications.BOOK_CHAPTER, TypePublications.TEXTBOOK,
                        TypePublications.REFERENCE_WORK, TypePublications.BOOK_SERIES,
                        TypePublications.CONFERENCE_PROCEEDINGS,
                        TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION,
                        TypePublications.AUDIO_VIDEO_MATERIAL),
                Arrays.asList(AccessPolicies.OPEN_WITHOUT_FEE, AccessPolicies.OPEN_WITH_EMBARGO,
                        AccessPolicies.OPEN_WITHOUT_EMBARGO),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH, Languages.GERMAN, Languages.GREEK_MODERN,
                        Languages.ITALIAN, Languages.PORTUGUESE, Languages.SPANISH),
                Arrays.asList(Licenses.ALL_RIGHTS_RESERVED, Licenses.CC_BY_NC, Licenses.CC_BY_NC_ND),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE,
                        Disciplines.GENDER, Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY,
                        Disciplines.DEMOGRAPHY));
        publicationService.save(coimbraPublication);

        Publication liegePublication = createPublication("University of Liège Service",
                "Description of the actual service, what does this service exactly do...",
                "University of Liège",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.JOURNAL_ARTICLE,
                        TypePublications.WORKING_PAPER, TypePublications.PHD_THESIS,
                        TypePublications.MONOGRAPH, TypePublications.BOOK_CHAPTER, TypePublications.TEXTBOOK,
                        TypePublications.REFERENCE_WORK, TypePublications.CONFERENCE_PROCEEDINGS),
                Collections.singletonList(AccessPolicies.OPEN_WITHOUT_FEE),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH),
                Arrays.asList(Licenses.CC_BY, Licenses.CC_BY_SA, Licenses.CC_BY_NC, Licenses.CC_BY_NC_SA),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.CLASSICAL,
                        Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE, Disciplines.GENDER,
                        Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY, Disciplines.DEMOGRAPHY));
        publicationService.save(liegePublication);

        Publication ljubljanaPublication = createPublication("Service of University of Ljubljana, Faculty of Arts",
                "Description of the actual service, what does this service exactly do...",
                "University of Ljubljana, Faculty of Arts",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.JOURNAL_ARTICLE,
                        TypePublications.MONOGRAPH, TypePublications.BOOK_CHAPTER, TypePublications.TEXTBOOK,
                        TypePublications.BOOK_SERIES, TypePublications.CONFERENCE_PROCEEDINGS,
                        TypePublications.PRINTED_SCHOLARLY_CRITICAL_EDITION),
                Collections.singletonList(AccessPolicies.OPEN_WITHOUT_FEE),
                Arrays.asList(Languages.ENGLISH, Languages.SLOVENIAN),
                Arrays.asList(Licenses.ALL_RIGHTS_RESERVED, Licenses.CC_BY_SA),
                Arrays.asList(Disciplines.HISTORY, Disciplines.ARCHEOLOGY, Disciplines.SOCIOLOGY,
                        Disciplines.GEOGRAPHY, Disciplines.LITERATURE, Disciplines.LINGUISTICS,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.ARCHITECTURE, Disciplines.SPACE_MANAGEMENT,
                        Disciplines.PHILOSOPHY, Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES,
                        Disciplines.PSYCHOLOGY, Disciplines.MUSICOLOGY, Disciplines.RELIGIONS,
                        Disciplines.CLASSICAL, Disciplines.ENVIRONMENTAL, Disciplines.CULTURAL_HERITAGE,
                        Disciplines.GENDER, Disciplines.METHODS_STATS, Disciplines.BIOLOGY_ANTHROPOLOGY,
                        Disciplines.DEMOGRAPHY));
        publicationService.save(ljubljanaPublication);

        Publication milanPublication = createPublication("Service of University of Milan",
                "Description of the actual service, what does this service exactly do...",
                "University of Milan",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.BOOK_SERIES),
                Collections.singletonList(AccessPolicies.OPEN_WITHOUT_FEE),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH, Languages.GERMAN, Languages.ITALIAN,
                        Languages.PORTUGUESE, Languages.SPANISH),
                Arrays.asList(Licenses.CC_BY, Licenses.CC_BY_SA, Licenses.CC_BY_NC_SA, Licenses.CC_BY_NC_ND),
                Arrays.asList(Disciplines.LAW, Disciplines.ARCHEOLOGY, Disciplines.SOCIOLOGY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.ART_HISTORY,
                        Disciplines.PHILOSOPHY, Disciplines.MUSICOLOGY, Disciplines.CLASSICAL));
        publicationService.save(milanPublication);

        Publication turinPublication = createPublication("Service of University of Turin",
                "Description of the actual service, what does this service exactly do...",
                "University of Turin",
                Arrays.asList(TypePublications.JOURNAL, TypePublications.MONOGRAPH,
                        TypePublications.MISCELLANEA, TypePublications.TEXTBOOK, TypePublications.BOOK_SERIES,
                        TypePublications.CONFERENCE_PROCEEDINGS),
                Collections.singletonList(AccessPolicies.OPEN_WITHOUT_FEE),
                Arrays.asList(Languages.ENGLISH, Languages.FRENCH, Languages.GERMAN, Languages.ITALIAN,
                        Languages.SPANISH),
                Arrays.asList(Licenses.CC_BY, Licenses.CC_BY_SA,
                        Licenses.CC_BY_NC, Licenses.CC_BY_NC_SA, Licenses.CC_BY_ND, Licenses.CC_BY_NC_ND),
                Arrays.asList(Disciplines.LAW, Disciplines.HISTORY, Disciplines.ARCHEOLOGY,
                        Disciplines.SOCIOLOGY, Disciplines.ECONOMICS_FINANCE, Disciplines.GEOGRAPHY,
                        Disciplines.LITERATURE, Disciplines.LINGUISTICS, Disciplines.BUSINESS_ADMINISTRATION,
                        Disciplines.POLITICAL_SCIENCE, Disciplines.EDUCATION,
                        Disciplines.ANTHROPOLOGY_ETHNOLOGY, Disciplines.LIBRARY_INFORMATION_SCIENCE,
                        Disciplines.ART_HISTORY, Disciplines.PHILOSOPHY,
                        Disciplines.HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES, Disciplines.PSYCHOLOGY,
                        Disciplines.MUSICOLOGY, Disciplines.RELIGIONS, Disciplines.CLASSICAL,
                        Disciplines.CULTURAL_HERITAGE, Disciplines.GENDER, Disciplines.METHODS_STATS,
                        Disciplines.DEMOGRAPHY));
        publicationService.save(turinPublication);
    }

    public enum TypePublications {
        JOURNAL("Journal"),
        MEGA_JOURNAL("Mega Journal"),
        JOURNAL_ARTICLE("Journal Article"),
        WORKING_PAPER("Working Paper"),
        PHD_THESIS("PHD Thesis"),
        MONOGRAPH("Monograph"),
        MISCELLANEA("Miscellanea"),
        BOOK_CHAPTER("Book Chapter"),
        TEXTBOOK("Textbook"),
        REFERENCE_WORK("Reference work (dictionary, encyclopaedia, bibliographical resource, handbook, etc.)"),
        BOOK_SERIES("Book Series"),
        WORKING_PAPER_SERIES("Working Paper Series"),
        CONFERENCE_PROCEEDINGS("Conference Proceedings"),
        PRINTED_SCHOLARLY_CRITICAL_EDITION("Printed Scholarly/Critical Edition"),
        DIGITAL_SCHOLARLY_CRITICAL_EDITION("Digital Scholarly/Critical Edition"),
        PREPRINT("Preprint"),
        BLOG_POSTS("Blog Posts"),
        AUDIO_VIDEO_MATERIAL("Audio-Video Material"),
        RESEARCH_DATA("Research Data");

        private final String name;
        TypePublications(final String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public String getScheme() {
            return name.toLowerCase().replaceAll("\\s","");
        }
    }

    public enum AccessPolicies {
        CLOSED("closed", "Closed Access (traditional model, readers pay for access)"),
        OPEN_HYBRID("open_hybrid", "Open Access option in a subscription-based publication (so called 'hybrid journals')"),
        OPEN_WITH_APC("open_with_apc","Open Access with publication fee to be paid upfront (Article/Book Processing Charge)"),
        OPEN_WITHOUT_FEE("open_without_fee", "Open Access without a publication fee"),
        OPEN_WITH_EMBARGO("open_with_embargo", "Open Access with embargo"),
        OPEN_WITHOUT_EMBARGO("open_without_embargo", "Open Access without embargo");

        private final String code;
        private final String name;
        AccessPolicies(final String code, final String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
    }

    public enum Languages {
        CROATIAN("hr"), DUTCH("nl"), ENGLISH("en"), FRENCH("fr"), GERMAN("de"),
        GREEK_MODERN("el"), ITALIAN("it"), POLISH("pl"), PORTUGUESE("pt"), NORWEGIAN("no"),
        SLOVENIAN("sl"), SPANISH("es"), SWEDISH("sv"), CATALAN("ca"), RUSSIAN("ru"),
        LATIN("la"), GREEK_ANCIENT("el_ancient");

        private final String code;
        Languages(final String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }

    public enum Licenses {
        ALL_RIGHTS_RESERVED("all_rights_reserved", "All rights reserved ('traditional' copyright clause)"),
        CC_BY("cc_by", "Creative Commons Attribution (CC BY)"),
        CC_BY_SA("cc_by_sa", "Creative Commons Attribution + Share Alike (CC BY-SA)"),
        CC_BY_NC("cc_by_nc", "Creative Commons Attribution + Non-commercial (CC BY-NC)"),
        CC_BY_NC_SA("cc_by_nc_sa", "Creative Commons Attribution + Non-commercial + Share Alike (CC BY-NC-SA)"),
        CC_BY_ND("cc_by_nd", "Creative Commons Attribution + No Derivatives (CC BY-ND)"),
        CC_BY_NC_ND("cc_by_nc_nd", "Creative Commons Attribution + Non-commercial + No Derivatives (CC BY-NC-ND)"),
        GNU_GPL("gnu_gpl", "GNU General Public License (GNU GPL)"),
        OPEN_FREEMIUM("open_freemium", "Open Access freemium");

        private final String code;
        private final String name;
        Licenses(final String code, final String name) {
            this.code = code;
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }
    }

    public enum Disciplines {
        LAW("Law"),
        HISTORY("History"),
        ARCHEOLOGY("Archaeology and Prehistory"),
        SOCIOLOGY("Sociology"),
        ECONOMICS_FINANCE("Economics and Finance"),
        GEOGRAPHY("Geography"),
        LITERATURE("Literature"),
        LINGUISTICS("Linguistics"),
        BUSINESS_ADMINISTRATION("Business administration"),
        POLITICAL_SCIENCE("Political science"),
        EDUCATION("Education"),
        ANTHROPOLOGY_ETHNOLOGY("Social Anthropology and ethnology"),
        LIBRARY_INFORMATION_SCIENCE("Library and information sciences"),
        ART_HISTORY("Art and art history"),
        ARCHITECTURE("Architecture"),
        SPACE_MANAGEMENT("space management"),
        PHILOSOPHY("Philosophy"),
        HISTORY_PHILOSOPHY_SOCIOLOGY_SCIENCES("History, Philosophy and Sociology of Sciences"),
        PSYCHOLOGY("Psychology"),
        MUSICOLOGY("Musicology and performing arts"),
        RELIGIONS("Religions"),
        CLASSICAL("Classical studies"),
        ENVIRONMENTAL("Environmental studies"),
        CULTURAL_HERITAGE("Cultural heritage and museology"),
        GENDER("Gender studies"),
        METHODS_STATS("Methods and statistics"),
        BIOLOGY_ANTHROPOLOGY("Biological anthropology"),
        DEMOGRAPHY("Demography"),
        DIGITAL_HUMANITIES("Digital Humanities"),
        COMMUNICATION("Communication"),
        MEDIA_SCIENCE("Media Science");

        private final String name;
        Disciplines(final String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public String getScheme() {
             return name.toLowerCase().replaceAll("\\s","");
        }
    }
}
