package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;

public class PessoaDAO implements IDAO<Pessoa, Long> {

    final EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Pessoa t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdPessoa() == null) {
                entityManager.persist(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Pessoa t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Pessoa t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdPessoa() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Pessoa> list() {
        return entityManager.createQuery("select p from PESSOA p").getResultList();
    }
}
