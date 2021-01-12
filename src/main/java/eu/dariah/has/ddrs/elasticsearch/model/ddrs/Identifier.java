package eu.dariah.has.ddrs.elasticsearch.model.ddrs;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class Identifier {
    @JsonView(JsonViews.Public.class)
    private String doi;
    @JsonView(JsonViews.Public.class)
    private int re3data;

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getRe3data() {
        return re3data;
    }

    public void setRe3data(int re3data) {
        this.re3data = re3data;
    }
}
