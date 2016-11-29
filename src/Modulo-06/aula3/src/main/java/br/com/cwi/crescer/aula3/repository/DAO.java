package br.com.cwi.crescer.aula3.repository;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import static org.hibernate.criterion.MatchMode.ANYWHERE;
import org.hibernate.criterion.Restrictions;

public class DAO implements IDAO<Pessoa, Long> {

    private final EntityManager entityManger;

    public DAO(EntityManager entityManger) {
        this.entityManger = entityManger;
    }

    @Override
    public void insert(Pessoa t) {
        if (entityManger.isOpen()) {
            entityManger.getTransaction().begin();
            try {
                entityManger.persist(t);
                entityManger.getTransaction().commit();
            } catch (Exception e) {
                e.getMessage();
                entityManger.getTransaction().rollback();
            }
        }
    }

    @Override
    public Pessoa find(Long id) {
        Pessoa pessoa = null;

        if (entityManger.isOpen()) {
            pessoa = entityManger.find(Pessoa.class, id);
        }
        return pessoa;
    }

    @Override
    public void delete(Pessoa t) {
        if (entityManger.isOpen()) {
            entityManger.getTransaction().begin();
            try {
                entityManger.remove(t);
                entityManger.getTransaction().commit();
            } catch (Exception e) {
                entityManger.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<Pessoa> findAll() {
        return entityManger.createQuery("Select p from Pessoa p").getResultList();
    }

    @Override
    public List<Pessoa> findByName(String nome) {
        final Session session = entityManger.unwrap(Session.class);
        final Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.like("nmPessoa", nome, ANYWHERE));
        return criteria.list();
    }

    @Override
    public List<Pessoa> findByName(Pessoa pessoa) {
        final Session session = entityManger.unwrap(Session.class);
        final Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Example.create(pessoa));
        return criteria.list();
    }

}
