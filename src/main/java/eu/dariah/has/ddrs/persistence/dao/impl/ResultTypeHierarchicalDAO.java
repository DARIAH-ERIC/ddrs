package eu.dariah.has.ddrs.persistence.dao.impl;

import eu.dariah.has.ddrs.persistence.dao.AbstractJpaDAO;
import eu.dariah.has.ddrs.persistence.dao.IResultTypeHierarchicalDAO;
import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
