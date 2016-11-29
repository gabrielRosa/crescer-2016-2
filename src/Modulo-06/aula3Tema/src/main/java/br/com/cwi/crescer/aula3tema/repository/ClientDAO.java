package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;

public class ClientDAO implements IDAO<Client, Long> {

    final EntityManager entityManager;

    public ClientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Client client) {
        try {
            entityManager.getTransaction().begin();
            if (client.getIdClient() == null) {
                entityManager.persist(client);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Client t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Client t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdClient() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Client> list() {
        return entityManager.createQuery("select p from Client p").getResultList();
    }
}
