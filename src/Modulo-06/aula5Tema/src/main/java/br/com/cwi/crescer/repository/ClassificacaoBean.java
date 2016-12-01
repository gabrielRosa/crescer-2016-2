package br.com.cwi.crescer.repository;

// @author Gabriel
import br.com.cwi.crescer.entity.Classificacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClassificacaoBean extends AbstractDao<Classificacao, Long> {

    @PersistenceContext(unitName = "tema5")
    private EntityManager entityManager;

    public ClassificacaoBean() {
        super(Classificacao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
