package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Contract;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ContractDAO extends AbstractDAO<Contract, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ContractDAO() {
        super(Contract.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
