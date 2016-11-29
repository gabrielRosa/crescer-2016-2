package br.com.cwi.crescer.aula3tema.main;

import br.com.cwi.crescer.aula3tema.entity.Pessoa;
import br.com.cwi.crescer.aula3tema.repository.PessoaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNmPessoa("Gabriel");

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tema3");
        final EntityManager em = emf.createEntityManager();

        PessoaDAO dao = new PessoaDAO(em);

        dao.insert(p);

        dao.list().forEach(p1 -> System.out.println(p1.getNmPessoa()));

        em.close();
        emf.close();
    }

}
