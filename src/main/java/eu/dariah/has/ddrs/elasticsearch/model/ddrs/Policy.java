package eu.dariah.has.ddrs.elasticsearch.model.ddrs;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class Policy {
    @JsonView(JsonViews.Public.class)
    private String name;
    @JsonView(JsonViews.Public.class)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
