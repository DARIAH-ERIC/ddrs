package eu.dariah.has.ddrs.re3data.extra;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

/**
 * Created by yoann on 19.05.17.
 */
public class RepositoryDetail {
    @JsonView(JsonViews.Public.class)
    private String description;
    @JsonView(JsonViews.Public.class)
    private String lastUpdate;
    @JsonView(JsonViews.Public.class)
    private String contact;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
