package eu.dariah.has.ddrs.elasticsearch.model.ddrs;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class AdditionalName {
    @JsonView(JsonViews.Public.class)
    private String language;
    @JsonView(JsonViews.Public.class)
    private String text;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AdditionalName{" +
                "language='" + language + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
