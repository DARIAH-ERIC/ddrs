package eu.dariah.has.ddrs.persistence.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yoann on 13.06.17.
 */
@Entity
@Table(name = "default_repository")
public class DefaultRepository implements Serializable {
    @Id
    @SequenceGenerator(name="default_repository_id_seq", sequenceName="default_repository_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="default_repository_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private String re3dataIdentifier;

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
}
