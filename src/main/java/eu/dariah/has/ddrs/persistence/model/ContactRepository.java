package eu.dariah.has.ddrs.persistence.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yoann on 14.06.17.
 */
@Entity
@Table(name = "contact_repository")
public class ContactRepository implements Serializable {
    @Id
    @GenericGenerator(
            name = "contact_repository_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "contact_repository_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator="contact_repository_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    private String respositoryIdentifier;

    private String contact;

    public ContactRepository() {}

    public ContactRepository(String repositoryIdentifier, String contact) {
        this.respositoryIdentifier = repositoryIdentifier;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespositoryIdentifier() {
        return respositoryIdentifier;
    }

    public void setRespositoryIdentifier(String respositoryIdentifier) {
        this.respositoryIdentifier = respositoryIdentifier;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
