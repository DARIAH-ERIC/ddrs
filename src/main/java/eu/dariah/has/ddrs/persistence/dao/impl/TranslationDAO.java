package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.ITranslationDAO;
import eu.dariah.has.ddrs.persistence.model.Translation;
import org.springframework.stereotype.Repository;

/**
 * Created by yoann on 30.05.17.
 */
@Repository
public class TranslationDAO extends AbstractJpaDAO<Translation> implements ITranslationDAO {
    public TranslationDAO() {
        super();
        setClazz(Translation.class);
    }
}
