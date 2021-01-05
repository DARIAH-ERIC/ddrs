package eu.dariah.has.ddrs.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class ElasticSearchDDRSText {
    @JsonView(JsonViews.Public.class)
    private String text;

    public ElasticSearchDDRSText() {}

    public ElasticSearchDDRSText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
