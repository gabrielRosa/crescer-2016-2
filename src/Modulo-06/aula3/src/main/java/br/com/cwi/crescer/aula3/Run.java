package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import br.com.cwi.crescer.aula3.repository.DAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManger;
        entityManger = emf.createEntityManager();
        
        Pessoa teste = new Pessoa();
        //teste.setIdPessoa(6l);
        teste.setNmPessoa("Gabriel8");
        DAO d = new DAO(entityManger);
        //d.insert(teste);
        //System.out.println(d.find(4l).getNmPessoa());
        //d.delete(teste);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        d.findAll().forEach(p -> System.out.println(p.getNmPessoa()));

        entityManger.close();
        emf.close();
    }
}
