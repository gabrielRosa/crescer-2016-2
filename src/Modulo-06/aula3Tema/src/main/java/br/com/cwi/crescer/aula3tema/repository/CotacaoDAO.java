package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Cotacao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CotacaoDAO extends AbstractDAO<Cotacao, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public CotacaoDAO() {
        super(Cotacao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
