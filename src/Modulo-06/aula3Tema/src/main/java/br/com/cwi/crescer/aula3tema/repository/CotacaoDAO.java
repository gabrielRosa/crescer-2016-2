package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;



public class CotacaoDAO implements IDAO<Cotacao, Long>{
    
    final EntityManager entityManager;

    public CotacaoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Cotacao t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdCotacao() == null) {
                entityManager.persist(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cotacao t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Cotacao t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdCotacao()!= null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Cotacao> list() {
        return entityManager.createQuery("select * from COTACAO ").getResultList();
    }
}
