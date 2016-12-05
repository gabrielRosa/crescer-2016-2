package br.com.cwi.crescer.repository;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 * @param <T>
 * @param <ID>
 *
 */
public abstract class AbstractDao<T, ID> implements IDao<T, ID> {

    public abstract EntityManager getEntityManager();
    private T entity;
    private List<T> list;
    private final Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        this.getEntityManager().merge(t);
    }

    @Override
    public void delete(T t) {
        this.getEntityManager().remove(t);
    }

    @Override
    public T find(ID id) {
        return this.getEntityManager().find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return this.getEntityManager().createQuery("SELECT p FROM " + clazz.getName() + " p").getResultList();
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
