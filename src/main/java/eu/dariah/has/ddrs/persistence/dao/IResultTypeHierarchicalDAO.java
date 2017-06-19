package eu.dariah.has.ddrs.persistence.dao;

import eu.dariah.has.ddrs.persistence.model.ResultTypeHierarchical;

import java.util.List;

/**
 * Created by yoann on 30.05.17.
 */
public interface IResultTypeHierarchicalDAO {
    ResultTypeHierarchical findOne(long id);
    List<ResultTypeHierarchical> findAll();
    void create(ResultTypeHierarchical resultTypeHierarchical);
    ResultTypeHierarchical update(ResultTypeHierarchical resultTypeHierarchical);
    void delete(ResultTypeHierarchical resultTypeHierarchical);
    void deleteById(long resultTypeHierarchicalId);
    ResultTypeHierarchical findByCode(String code);
}
