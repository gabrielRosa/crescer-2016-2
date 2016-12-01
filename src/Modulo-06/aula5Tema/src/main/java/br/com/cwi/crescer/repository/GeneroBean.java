package br.com.cwi.crescer.repository;

// @author Gabriel
import br.com.cwi.crescer.entity.Genero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GeneroBean extends AbstractDao<Genero, Long> {

    @PersistenceContext(unitName = "tema5")
    private EntityManager entityManager;

    public GeneroBean() {
        super(Genero.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
