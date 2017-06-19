package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical_;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by yoann on 30.05.17.
 */
@Repository
public class ResultTypeHierarchicalDAO extends AbstractJpaDAO<ResultTypeHierarchical> implements IResultTypeHierarchicalDAO {
    public ResultTypeHierarchicalDAO() {
        super();
        setClazz(ResultTypeHierarchical.class);
    }

    @Override
    public ResultTypeHierarchical findOne(long id) {
        ResultTypeHierarchical resultTypeHierarchical = entityManager.find(ResultTypeHierarchical.class, id);
        for(ResultTypeHierarchical children : resultTypeHierarchical.getChildren()) {
            children.getChildren();
        }
        return resultTypeHierarchical;
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        ResultTypeHierarchical resultTypeHierarchical = entityManager.find(ResultTypeHierarchical.class, id);
        resultTypeHierarchical.getParent().removeChild(resultTypeHierarchical);
        update(resultTypeHierarchical.getParent());
        delete(resultTypeHierarchical);
    }

    @Override
    public ResultTypeHierarchical findByCode(String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ResultTypeHierarchical> criteriaQuery = criteriaBuilder.createQuery(ResultTypeHierarchical.class);
        Root<ResultTypeHierarchical> from = criteriaQuery.from(ResultTypeHierarchical.class);
        CriteriaQuery<ResultTypeHierarchical> select = criteriaQuery.select(from);
        select.where(criteriaBuilder.equal(from.get(ResultTypeHierarchical_.code), code));
        TypedQuery<ResultTypeHierarchical> typedQuery = entityManager.createQuery(select);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
