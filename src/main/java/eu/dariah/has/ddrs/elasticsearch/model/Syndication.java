package eu.dariah.has.ddrs.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class Syndication {
    @JsonView(JsonViews.Public.class)
    private String type;
    @JsonView(JsonViews.Public.class)
    private String url;

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
