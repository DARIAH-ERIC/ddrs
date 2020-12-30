package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.IQuestionDAO;
import eu.dariah.has.ddrs.persistence.model.Question;
import eu.dariah.has.ddrs.persistence.model.Question_;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
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
    public List<Question> findAllOrderedDDRS() {
        return findAllOrdered("ddrs");
    }

    @Override
    public List<Question> findAllOrderedPSP() {
        return findAllOrdered("psp");
    }

    private List<Question> findAllOrdered(String ddrsOrPsp) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> from = criteriaQuery.from(Question.class);
        CriteriaQuery<Question> select = criteriaQuery.select(from);
        select.where(criteriaBuilder.equal(from.get(Question_.ddrsOrPsp), ddrsOrPsp));
        select.orderBy(criteriaBuilder.asc(from.get(Question_.questionOrder)));
        TypedQuery<Question> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public List<Question> findAllWrongOrderedDDRS() {
        return findAllWrongOrdered("ddrs");
    }

    @Override
    public List<Question> findAllWrongOrderedPSP() {
        return findAllWrongOrdered("psp");
    }

    private List<Question> findAllWrongOrdered(String ddrsOrPsp) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> from = criteriaQuery.from(Question.class);
        CriteriaQuery<Question> select = criteriaQuery.select(from);
        select.where(criteriaBuilder.equal(from.get(Question_.ddrsOrPsp), ddrsOrPsp));
        select.orderBy(criteriaBuilder.desc(from.get(Question_.questionOrder)));
        TypedQuery<Question> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public List<Question> findAllOrderedAndInUseDDRS() {
        return findAllOrderedAndInUse("ddrs");
    }

    @Override
    public List<Question> findAllOrderedAndInUsePSP() {
        return findAllOrderedAndInUse("psp");
    }

    private List<Question> findAllOrderedAndInUse(String ddrsOrPsp) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> from = criteriaQuery.from(Question.class);
        CriteriaQuery<Question> select = criteriaQuery.select(from);
        select.where(criteriaBuilder.equal(from.get(Question_.isInUse), true),
                criteriaBuilder.equal(from.get(Question_.ddrsOrPsp), ddrsOrPsp));
        select.orderBy(criteriaBuilder.asc(from.get(Question_.questionOrder)));
        TypedQuery<Question> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public int findHighestQuestionOrder() {
        CriteriaBuilder cb1 = entityManager.getCriteriaBuilder();
        CriteriaQuery<Number> cq1 = cb1.createQuery(Number.class);
        Root<Question> root = cq1.from(Question.class);
        cq1.select(cb1.max(root.get(Question_.questionOrder)));
        TypedQuery<Number> typedQuery = entityManager.createQuery(cq1);
        return typedQuery.getSingleResult().intValue();
    }
}