package eu.dariah.has.ddrs.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class Re3dataSchemeText {
    @JsonView(JsonViews.Public.class)
    private String scheme;
    @JsonView(JsonViews.Public.class)
    private String text;

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
