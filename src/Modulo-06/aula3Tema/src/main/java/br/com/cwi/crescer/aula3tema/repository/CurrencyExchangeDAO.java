package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.CurrencyExchange;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CurrencyExchangeDAO extends AbstractDAO<CurrencyExchange, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public CurrencyExchangeDAO() {
        super(CurrencyExchange.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
