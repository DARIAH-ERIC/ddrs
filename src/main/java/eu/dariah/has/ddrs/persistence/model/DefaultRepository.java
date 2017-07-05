package eu.dariah.has.ddrs.persistence.model;

import org.hibernate.annotations.*;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Parameter;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yoann on 13.06.17.
 */
@Entity
@Table(name = "default_repository")
public class DefaultRepository implements Serializable {
    @Id
    @GenericGenerator(
            name = "default_repository_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "default_repository_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator="default_repository_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private String re3dataIdentifier;

    @ManyToOne
    @JoinColumn(name="result_type_hierarchical_id", nullable=false)
    private ResultTypeHierarchical resultTypeHierarchical;

    public DefaultRepository() {}

    public DefaultRepository(String re3dataIdentifier, ResultTypeHierarchical resultTypeHierarchical) {
        this.re3dataIdentifier = re3dataIdentifier;
        this.resultTypeHierarchical = resultTypeHierarchical;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRe3dataIdentifier() {
        return re3dataIdentifier;
    }

    public void setRe3dataIdentifier(String re3dataIdentifier) {
        this.re3dataIdentifier = re3dataIdentifier;
    }

    public ResultTypeHierarchical getResultTypeHierarchical() {
        return resultTypeHierarchical;
    }

    public void setResultTypeHierarchical(ResultTypeHierarchical resultTypeHierarchical) {
        this.resultTypeHierarchical = resultTypeHierarchical;
    }
}
