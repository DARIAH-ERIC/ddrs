package eu.dariah.has.ddrs.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

import java.util.List;

public class DatabaseAccess {
    @JsonView(JsonViews.Public.class)
    private List<Re3dataText> restrictions;
    @JsonView(JsonViews.Public.class)
    private String type;

    public List<Re3dataText> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<Re3dataText> restrictions) {
        this.restrictions = restrictions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
