package eu.dariah.has.ddrs.elasticsearch.model.psp;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.elasticsearch.model.ElasticSearchDDRSText;
import eu.dariah.has.ddrs.elasticsearch.model.ElasticSearchDDRSSchemeText;
import eu.dariah.has.ddrs.elasticsearch.model.ElasticSearchDDRSName;
import eu.dariah.has.ddrs.json.JsonViews;

import java.util.List;

/**
 * Created by yoann on 03.01.21.
 */
public class Publication {
    @JsonView(JsonViews.Public.class)
    private String identifier;
    @JsonView(JsonViews.Public.class)
    private String name;
    @JsonView(JsonViews.Public.class)
    private String description;
    @JsonView(JsonViews.Public.class)
    private String serviceProvider;
    @JsonView(JsonViews.Public.class)
    private List<ElasticSearchDDRSText> languages;
    @JsonView(JsonViews.Public.class)
    private List<ElasticSearchDDRSSchemeText> types;
    @JsonView(JsonViews.Public.class)
    private List<ElasticSearchDDRSSchemeText> disciplines;
    @JsonView(JsonViews.Public.class)
    private List<ElasticSearchDDRSText> accessPolicies;
    @JsonView(JsonViews.Public.class)
    private List<ElasticSearchDDRSName> licenses;

    public Publication() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public List<ElasticSearchDDRSText> getLanguages() {
        return languages;
    }

    public void setLanguages(List<ElasticSearchDDRSText> languages) {
        this.languages = languages;
    }

    public List<ElasticSearchDDRSSchemeText> getTypes() {
        return types;
    }

    public void setTypes(List<ElasticSearchDDRSSchemeText> types) {
        this.types = types;
    }

    public List<ElasticSearchDDRSSchemeText> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<ElasticSearchDDRSSchemeText> disciplines) {
        this.disciplines = disciplines;
    }

    public List<ElasticSearchDDRSText> getAccessPolicies() {
        return accessPolicies;
    }

    public void setAccessPolicies(List<ElasticSearchDDRSText> accessPolicies) {
        this.accessPolicies = accessPolicies;
    }

    public List<ElasticSearchDDRSName> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<ElasticSearchDDRSName> licenses) {
        this.licenses = licenses;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                ", languages=" + languages +
                ", types=" + types +
                ", disciplines=" + disciplines +
                ", accessPolicies=" + accessPolicies +
                ", licenses=" + licenses +
                '}';
    }
}
