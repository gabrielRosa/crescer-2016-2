package br.com.cwi.crescer.repository;

// @author Gabriel
import br.com.cwi.crescer.entity.Filme;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FilmeBean extends AbstractDao<Filme, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public FilmeBean() {
        super(Filme.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
