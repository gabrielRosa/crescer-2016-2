package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Client;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ClientDAO extends AbstractDAO<Client, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ClientDAO() {
        super(Client.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
