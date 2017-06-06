package eu.dariah.has.ddrs.persistence.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yoann on 29.05.17.
 */
public abstract class AbstractJpaDAO<T extends Serializable> {
    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Transactional
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        System.out.println("Delete now?");
        delete(entity);
        System.out.println("Deleted?");
    }
}
