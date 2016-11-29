package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.ContractValue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ContractValueDAO extends AbstractDAO<ContractValue, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ContractValueDAO() {
        super(ContractValue.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
