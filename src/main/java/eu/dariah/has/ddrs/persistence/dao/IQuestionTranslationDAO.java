package eu.dariah.has.ddrs.persistence.dao;

import eu.dariah.has.ddrs.persistence.model.QuestionTranslation;

import java.util.List;

/**
 * Created by yoann on 30.05.17.
 */
public interface IQuestionTranslationDAO {
    public QuestionTranslation findOne(long id);
    public List<QuestionTranslation> findAll();
    public void create(QuestionTranslation questionTranslation);
    public QuestionTranslation update(QuestionTranslation questionTranslation);
    public void delete(QuestionTranslation questionTranslation);
    public void deleteById(long questionTranslationId);
}
