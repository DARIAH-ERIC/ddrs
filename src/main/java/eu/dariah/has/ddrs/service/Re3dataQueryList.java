package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.model.SearchObject;

import java.util.List;

/**
 * Created by yoannmoranville on 12/05/17.
 */
public class Re3dataQueryList {
    private static final String URL_PREFIX = "http://www.re3data.org/api/beta/repositories?";
    private static final String URL_AND = "&";

    private static final String QUERY = "query=";
    private static final String SUBJECTS = "subjects[]=";
    private static final String COUNTRIES = "countries[]=";
    private static final String KEYWORDS = "keywords[]=";
    private static final String REPOSITORY_LANGUAGES = "repositoryLanguages[]=";

    private static final String SUBJECT_HUMANITIES = "11 Humanities";

    private String url;

    public String getUrl() {
        return url;
    }

    public Re3dataQueryList(SearchObject searchObject) {
        StringBuilder stringBuilder = new StringBuilder(URL_PREFIX);
        stringBuilder.append(QUERY);

        searchObject.getSubjects().add(SUBJECT_HUMANITIES);

        addSubjects(stringBuilder, searchObject.getSubjects());
        addCountries(stringBuilder, searchObject.getCountries());
        addKeywords(stringBuilder, searchObject.getKeywords());
        addRepositoryLanguages(stringBuilder, searchObject.getRepositoryLanguages());

        url = stringBuilder.toString();
    }

    private void addCountries(StringBuilder stringBuilder, List<String> countries) {
        addList(stringBuilder, COUNTRIES, countries);
    }
    private void addKeywords(StringBuilder stringBuilder, List<String> keywords) {
        addList(stringBuilder, KEYWORDS, keywords);
    }
    private void addSubjects(StringBuilder stringBuilder, List<String> subjects) {
        addList(stringBuilder, SUBJECTS, subjects);
    }
    private void addRepositoryLanguages(StringBuilder stringBuilder, List<String> repositoryLanguages) {
        addList(stringBuilder, REPOSITORY_LANGUAGES, repositoryLanguages);
    }

    private void addList(StringBuilder stringBuilder, String filterName, List<String> toBeAdded) {
        for(String contentType : toBeAdded) {
            stringBuilder.append(URL_AND).append(filterName).append(contentType);
        }
    }
}
