package eu.dariah.has.ddrs.elasticsearch.model.ddrs;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

public class Re3dataType {
    @JsonView(JsonViews.Public.class)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
