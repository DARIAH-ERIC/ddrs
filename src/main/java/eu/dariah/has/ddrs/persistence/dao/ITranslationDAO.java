package eu.dariah.has.ddrs.persistence.dao;

import eu.dariah.has.ddrs.persistence.model.Translation;

import java.util.List;

/**
 * Created by yoann on 30.05.17.
 */
public interface ITranslationDAO {
    public Translation findOne(long id);
    public List<Translation> findAll();
    public void create(Translation translation);
    public Translation update(Translation translation);
    public void delete(Translation translation);
    public void deleteById(long translationId);
}
