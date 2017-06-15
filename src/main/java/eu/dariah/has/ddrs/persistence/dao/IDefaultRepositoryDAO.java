package eu.dariah.has.ddrs.persistence.dao;

import eu.dariah.has.ddrs.persistence.model.DefaultRepository;

import java.util.List;

/**
 * Created by yoann on 14.06.17.
 */
public interface IDefaultRepositoryDAO {
    public DefaultRepository findOne(long id);
    public List<DefaultRepository> findAll();
    public void create(DefaultRepository defaultRepository);
    public DefaultRepository update(DefaultRepository defaultRepository);
    public void delete(DefaultRepository defaultRepository);
    public void deleteById(long defaultRepositoryId);
}
