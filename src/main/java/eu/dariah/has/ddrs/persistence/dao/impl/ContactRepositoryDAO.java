package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.IContactRepositoryDAO;
import eu.dariah.has.ddrs.persistence.dao.IDefaultRepositoryDAO;
import eu.dariah.has.ddrs.persistence.model.ContactRepository;
import eu.dariah.has.ddrs.persistence.model.ContactRepository_;
import eu.dariah.has.ddrs.persistence.model.DefaultRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by yoann on 14.06.17.
 */
@Repository
public class ContactRepositoryDAO extends AbstractJpaDAO<ContactRepository> implements IContactRepositoryDAO {
    public ContactRepositoryDAO() {
        super();
        setClazz(ContactRepository.class);
    }

    @Override
    public ContactRepository findByRepositoryId(String repositoryId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ContactRepository> criteriaQuery = criteriaBuilder.createQuery(ContactRepository.class);
        Root<ContactRepository> from = criteriaQuery.from(ContactRepository.class);
        CriteriaQuery<ContactRepository> select = criteriaQuery.select(from);
        select.where(criteriaBuilder.equal(from.get(ContactRepository_.respositoryIdentifier), repositoryId));
        TypedQuery<ContactRepository> typedQuery = entityManager.createQuery(select);
        List<ContactRepository> contactRepositories = typedQuery.getResultList();
        if(contactRepositories.size() == 0)
            return null;
        return contactRepositories.get(0);
    }
}
