package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

public class UsuarioDAO implements IDAO<Usuario, Long> {

    final EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Usuario t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdUsuario() == null) {
                entityManager.persist(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Usuario t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Usuario t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdUsuario() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Usuario> list() {
        return entityManager.createQuery("select * from USUARIO ").getResultList();
    }
}
