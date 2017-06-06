package eu.dariah.has.ddrs.re3data.search;

import org.springframework.cache.annotation.Cacheable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoannmoranville on 11/05/17.
 */

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class Re3dataList {

    @XmlElement(name = "repository")
    private List<Repository> repositories;
    private Boolean hasError = false;

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    @Cacheable("repositoryDetails")
    public List<Repository> getRepositories() {
        if(repositories == null)
            return new ArrayList<>();
        return repositories;
    }

    public void setRepository(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
