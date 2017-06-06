package eu.dariah.has.ddrs.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoannmoranville on 10/05/17.
 */
public class SearchObject {
    private List<String> subjects;
    private List<String> countries;
    private List<String> keywords;
    private List<String> repositoryLanguages;

    public List<String> getSubjects() {
        if(subjects == null)
            return new ArrayList<>();
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getCountries() {
        if(countries == null)
            return new ArrayList<>();
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getKeywords() {
        if(keywords == null)
            return new ArrayList<>();
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getRepositoryLanguages() {
        if(repositoryLanguages == null)
            return new ArrayList<>();
        return repositoryLanguages;
    }

    public void setRepositoryLanguages(List<String> repositoryLanguages) {
        this.repositoryLanguages = repositoryLanguages;
    }
}
