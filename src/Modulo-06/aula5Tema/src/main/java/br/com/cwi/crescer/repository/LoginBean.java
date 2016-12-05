package br.com.cwi.crescer.repository;

// @author Gabriel
import br.com.cwi.crescer.entity.Login;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean extends AbstractDao<Login, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public LoginBean() {
        super(Login.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
