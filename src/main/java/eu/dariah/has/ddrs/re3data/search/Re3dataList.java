package eu.dariah.has.ddrs.re3data.search;

import org.springframework.cache.annotation.Cacheable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by yoannmoranville on 11/05/17.
 */

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class Re3dataList {

    @XmlElement(name = "repository")
    private Set<Repository> repositories;
    private Boolean hasError = false;

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError() {
        this.hasError = true;
    }

    @Cacheable("repositoryDetails")
    public Set<Repository> getRepositories() {
        if(repositories == null)
            return new LinkedHashSet<>();
        return repositories;
    }

    public void setRepository(Set<Repository> repositories) {
        this.repositories = repositories;
    }

    public void addRepository(Repository repository) {
        repositories = new LinkedHashSet<>(getRepositories());
        repositories.add(repository);
    }
}
