package br.com.cwi.crescer.repository;

// @author Gabriel
import br.com.cwi.crescer.entity.Ator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AtorBean extends AbstractDao<Ator, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public AtorBean() {
        super(Ator.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
