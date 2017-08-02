package eu.dariah.has.ddrs.elasticsearch.model;

public class AdditionalName {
    private String language;
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
