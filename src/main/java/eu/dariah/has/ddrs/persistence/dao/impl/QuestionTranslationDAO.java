package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.IQuestionTranslationDAO;
import eu.dariah.has.ddrs.persistence.model.QuestionTranslation;
import org.springframework.stereotype.Repository;

/**
 * Created by yoann on 30.05.17.
 */
@Repository
public class QuestionTranslationDAO extends AbstractJpaDAO<QuestionTranslation> implements IQuestionTranslationDAO {
    public QuestionTranslationDAO() {
        super();
        setClazz(QuestionTranslation.class);
    }
}
