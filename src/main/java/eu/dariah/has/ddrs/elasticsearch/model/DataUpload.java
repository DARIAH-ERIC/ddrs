package eu.dariah.has.ddrs.elasticsearch.model;

import java.util.List;

public class DataUpload {
    private List<Re3dataText> restrictions;
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
