package eu.dariah.has.ddrs.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class Re3dataText {
    @JsonView(JsonViews.Public.class)
    private String text;

    public Re3dataText() {}

    public Re3dataText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
