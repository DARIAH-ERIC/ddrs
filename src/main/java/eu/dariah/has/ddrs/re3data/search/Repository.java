package eu.dariah.has.ddrs.re3data.search;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;
import eu.dariah.has.ddrs.re3data.extra.RepositoryDetail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yoannmoranville on 11/05/17.
 */

@XmlRootElement(name = "repository")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {
    @JsonView(JsonViews.Public.class)
    private String id;
    @JsonView(JsonViews.Public.class)
    private String name;
    @JsonView(JsonViews.Public.class)
    private Link link;
    @JsonView(JsonViews.Public.class)
    private RepositoryDetail repositoryDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public RepositoryDetail getRepositoryDetail() {
        return repositoryDetail;
    }

    public void setRepositoryDetail(RepositoryDetail repositoryDetail) {
        this.repositoryDetail = repositoryDetail;
    }
}
