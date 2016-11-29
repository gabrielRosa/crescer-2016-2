package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

public class ContractValueDAO implements IDAO<ContractValue, Long>{
        final EntityManager entityManager;

    public ContractValueDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(ContractValue t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdContractValue() == null) {
                entityManager.persist(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(ContractValue t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(ContractValue t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdContractValue() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<ContractValue> list() {
        return entityManager.createQuery("select * from CONTRACT_VALUE ").getResultList();
    }
}
