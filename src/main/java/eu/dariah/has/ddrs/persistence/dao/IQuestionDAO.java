package eu.dariah.has.ddrs.persistence.dao;

import eu.dariah.has.ddrs.persistence.model.Question;

import java.util.List;

/**
 * Created by yoann on 30.05.17.
 */
public interface IQuestionDAO {
    public Question findOne(long id);
    public List<Question> findAll();
    public void create(Question question);
    public Question update(Question question);
    public void delete(Question question);
    public void deleteById(long questionId);
    public List<Question> findAllOrderedDDRS();
    public List<Question> findAllOrderedPSP();
    public List<Question> findAllWrongOrderedDDRS();
    public List<Question> findAllWrongOrderedPSP();
    public List<Question> findAllOrderedAndInUseDDRS();
    public List<Question> findAllOrderedAndInUsePSP();
    public int findHighestQuestionOrder();
}
