package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Contract;
import java.util.List;
import javax.persistence.EntityManager;

public class ContractDAO implements IDAO<Contract, Long> {

    final EntityManager entityManager;

    public ContractDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Contract t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdContract() == null) {
                entityManager.persist(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Contract t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Contract t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdContract() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Contract> list() {
        return entityManager.createQuery("select * from CONTRACT ").getResultList();
    }

}
