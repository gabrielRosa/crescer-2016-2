package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UsuarioDAO extends AbstractDAO<Usuario, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
