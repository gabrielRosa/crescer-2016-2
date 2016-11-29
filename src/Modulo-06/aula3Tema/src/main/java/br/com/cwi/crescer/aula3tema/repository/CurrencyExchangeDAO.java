package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;



public class CurrencyExchangeDAO implements IDAO<CurrencyExchange, Long> {
    
    final EntityManager entityManager;

    public CurrencyExchangeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(CurrencyExchange t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdCurrencyExchange() == null) {
                entityManager.persist(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(CurrencyExchange t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(CurrencyExchange t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdCurrencyExchange() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<CurrencyExchange> list() {
        return entityManager.createQuery("select * from CURRENCY_EXCHANGE ").getResultList();
    }
}
