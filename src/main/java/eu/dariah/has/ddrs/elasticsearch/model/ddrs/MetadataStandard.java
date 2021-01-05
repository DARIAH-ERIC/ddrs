package eu.dariah.has.ddrs.elasticsearch.model.ddrs;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class MetadataStandard {
    @JsonView(JsonViews.Public.class)
    private String metadataStandardName;
    @JsonView(JsonViews.Public.class)
    private String metadataStandardScheme;
    @JsonView(JsonViews.Public.class)
    private String metadataStandardUrl;

    public String getMetadataStandardName() {
        return metadataStandardName;
    }

    public void setMetadataStandardName(String metadataStandardName) {
        this.metadataStandardName = metadataStandardName;
    }

    public String getMetadataStandardScheme() {
        return metadataStandardScheme;
    }

    public void setMetadataStandardScheme(String metadataStandardScheme) {
        this.metadataStandardScheme = metadataStandardScheme;
    }

    public String getMetadataStandardUrl() {
        return metadataStandardUrl;
    }

    public void setMetadataStandardUrl(String metadataStandardUrl) {
        this.metadataStandardUrl = metadataStandardUrl;
    }
}
