package eu.dariah.has.ddrs.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

import java.util.List;

public class Institution {
    @JsonView(JsonViews.Public.class)
    private List<AdditionalName> additionalNames;
    @JsonView(JsonViews.Public.class)
    private List<Re3dataText> contacts;
    @JsonView(JsonViews.Public.class)
    private String country;
    @JsonView(JsonViews.Public.class)
    private List<Re3dataText> identifiers;
    @JsonView(JsonViews.Public.class)
    private String name;
    @JsonView(JsonViews.Public.class)
    private String nameLanguage;
    @JsonView(JsonViews.Public.class)
    private String responsabilityEndDate;
    @JsonView(JsonViews.Public.class)
    private String responsabilityStartDate;
    @JsonView(JsonViews.Public.class)
    private List<Re3dataText> responsabilityTypes;
    @JsonView(JsonViews.Public.class)
    private String type;
    @JsonView(JsonViews.Public.class)
    private String url;

    public List<AdditionalName> getAdditionalNames() {
        return additionalNames;
    }

    public void setAdditionalNames(List<AdditionalName> additionalNames) {
        this.additionalNames = additionalNames;
    }

    public List<Re3dataText> getContacts() {
        return contacts;
    }

    public void setContacts(List<Re3dataText> contacts) {
        this.contacts = contacts;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Re3dataText> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Re3dataText> identifiers) {
        this.identifiers = identifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }

    public String getResponsabilityEndDate() {
        return responsabilityEndDate;
    }

    public void setResponsabilityEndDate(String responsabilityEndDate) {
        this.responsabilityEndDate = responsabilityEndDate;
    }

    public String getResponsabilityStartDate() {
        return responsabilityStartDate;
    }

    public void setResponsabilityStartDate(String responsabilityStartDate) {
        this.responsabilityStartDate = responsabilityStartDate;
    }

    public List<Re3dataText> getResponsabilityTypes() {
        return responsabilityTypes;
    }

    public void setResponsabilityTypes(List<Re3dataText> responsabilityTypes) {
        this.responsabilityTypes = responsabilityTypes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
