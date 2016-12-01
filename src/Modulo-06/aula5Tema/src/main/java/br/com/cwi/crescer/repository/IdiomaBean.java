package br.com.cwi.crescer.repository;

// @author Gabriel
import br.com.cwi.crescer.entity.Idioma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class IdiomaBean extends AbstractDao<Idioma, Long> {

    @PersistenceContext(unitName = "tema5")
    private EntityManager entityManager;

    public IdiomaBean() {
        super(Idioma.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
