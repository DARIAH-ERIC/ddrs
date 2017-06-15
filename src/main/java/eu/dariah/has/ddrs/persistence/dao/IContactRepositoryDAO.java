package eu.dariah.has.ddrs.persistence.dao;

import eu.dariah.has.ddrs.persistence.model.ContactRepository;

import java.util.List;

/**
 * Created by yoann on 14.06.17.
 */
public interface IContactRepositoryDAO {
    public ContactRepository findOne(long id);
    public List<ContactRepository> findAll();
    public void create(ContactRepository contactRepository);
    public ContactRepository update(ContactRepository contactRepository);
    public void delete(ContactRepository contactRepository);
    public void deleteById(long contactRepositoryId);

    public ContactRepository findByRepositoryId(String repositoryId);
}
