package eu.dariah.has.ddrs.re3data.search;

import com.fasterxml.jackson.annotation.JsonView;
import eu.dariah.has.ddrs.json.JsonViews;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by yoannmoranville on 11/05/17.
 */
@XmlRootElement(name = "link")
@XmlAccessorType(XmlAccessType.FIELD)
public class Link {
    @JsonView(JsonViews.Public.class)
    @XmlAttribute
    private String href;

    public Link() {}

    public Link(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}