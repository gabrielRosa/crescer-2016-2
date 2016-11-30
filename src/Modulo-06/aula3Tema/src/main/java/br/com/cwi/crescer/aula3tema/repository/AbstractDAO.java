package br.com.cwi.crescer.aula3tema.repository;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractDAO<T, ID> implements IDAO<T, ID> {

    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        try {
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().persist(t);
            this.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            this.getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public void delete(T t) {
        try {
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().remove(t);
            this.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            this.getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public List<T> list() {
        return this.getEntityManager().createQuery("SELECT p FROM " + clazz.getName() +" p").getResultList();
    }

    @Override
    public void update(T t) {
        try {
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().merge(t);
            this.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            this.getEntityManager().getTransaction().rollback();
        }
    }

}
