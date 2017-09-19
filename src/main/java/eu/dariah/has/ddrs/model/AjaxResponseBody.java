package eu.dariah.has.ddrs.model;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;
import eu.dariah.has.ddrs.elasticsearch.model.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by yoannmoranville on 12/05/17.
 */
public class AjaxResponseBody {

    @JsonView(JsonViews.Public.class)
    private String msg;

    @JsonView(JsonViews.Public.class)
    private String code;

    @JsonView(JsonViews.Public.class)
    private List<Repository> repositories;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}