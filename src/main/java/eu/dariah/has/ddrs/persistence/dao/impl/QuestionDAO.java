package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by yoann on 29.05.17.
 */
@Repository
public class QuestionDAO extends AbstractJpaDAO<Question> implements IQuestionDAO {
    public QuestionDAO() {
        super();
        setClazz(Question.class);
    }

    @Override
    public List<Question> findAllOrdered() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> from = criteriaQuery.from(Question.class);
        CriteriaQuery<Question> select = criteriaQuery.select(from);
        select.orderBy(criteriaBuilder.asc(from.get("questionOrder")));
        TypedQuery<Question> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public List<Question> findAllOrderedAndInUse() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> from = criteriaQuery.from(Question.class);
        CriteriaQuery<Question> select = criteriaQuery.select(from);
        select.where(criteriaBuilder.equal(from.get("isInUse"), true ));
        select.orderBy(criteriaBuilder.asc(from.get("questionOrder")));
        TypedQuery<Question> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public int findHighestQuestionOrder() {
        CriteriaBuilder cb1 = entityManager.getCriteriaBuilder();
        CriteriaQuery<Number> cq1 = cb1.createQuery(Number.class);
        Root<Question> root = cq1.from(Question.class);
        cq1.select(cb1.max(root.<Number>get("questionOrder")));
        TypedQuery<Number> typedQuery = entityManager.createQuery(cq1);
        return typedQuery.getSingleResult().intValue();
    }
}