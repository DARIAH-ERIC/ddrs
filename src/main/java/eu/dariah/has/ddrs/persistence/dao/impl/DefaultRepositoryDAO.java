package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.IDefaultRepositoryDAO;
import eu.dariah.has.ddrs.persistence.model.DefaultRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yoann on 14.06.17.
 */
@Repository
public class DefaultRepositoryDAO extends AbstractJpaDAO<DefaultRepository> implements IDefaultRepositoryDAO {
    public DefaultRepositoryDAO() {
        super();
        setClazz(DefaultRepository.class);
    }
}
