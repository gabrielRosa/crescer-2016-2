package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;

public class ServicoDAO implements IDAO<Servico, Long>{
    final EntityManager entityManager;

    public ServicoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Servico t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdServico() == null) {
                entityManager.persist(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Servico t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Servico t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdServico() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Servico> list() {
        return entityManager.createQuery("select * from SERVICO ").getResultList();
    }
}
