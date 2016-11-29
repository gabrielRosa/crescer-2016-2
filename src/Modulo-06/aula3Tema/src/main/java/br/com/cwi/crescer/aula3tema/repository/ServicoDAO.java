package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Servico;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ServicoDAO extends AbstractDAO<Servico, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ServicoDAO() {
        super(Servico.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
