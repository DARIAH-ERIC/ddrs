package eu.dariah.has.ddrs.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yoann on 14.06.17.
 */
@Entity
@Table(name = "contact_repository")
public class ContactRepository implements Serializable {
    @Id
    @SequenceGenerator(name="contact_repository_id_seq", sequenceName="contact_repository_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="contact_repository_id_seq")
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
