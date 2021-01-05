package eu.dariah.has.ddrs.elasticsearch.model.ddrs;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.elasticsearch.model.ElasticSearchDDRSText;
import eu.dariah.has.ddrs.json.JsonViews;

import java.util.List;

public class DataUpload {
    @JsonView(JsonViews.Public.class)
    private List<ElasticSearchDDRSText> restrictions;
    @JsonView(JsonViews.Public.class)
    private String type;

    public List<ElasticSearchDDRSText> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<ElasticSearchDDRSText> restrictions) {
        this.restrictions = restrictions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
