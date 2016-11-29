package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PessoaDAO extends AbstractDAO<Pessoa, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void exportar() {

    }

}
