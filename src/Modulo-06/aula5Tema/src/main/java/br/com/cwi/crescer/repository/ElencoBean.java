package br.com.cwi.crescer.repository;

// @author Gabriel
import br.com.cwi.crescer.entity.Elenco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ElencoBean extends AbstractDao<Elenco, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ElencoBean() {
        super(Elenco.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
