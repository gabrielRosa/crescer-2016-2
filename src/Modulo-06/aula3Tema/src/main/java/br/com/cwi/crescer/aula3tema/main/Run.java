package br.com.cwi.crescer.aula3tema.main;

import br.com.cwi.crescer.aula3tema.entity.CurrencyExchange;
import br.com.cwi.crescer.aula3tema.entity.Pessoa;
import br.com.cwi.crescer.aula3tema.repository.PessoaDAO;
import java.io.IOException;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) throws IOException {
        Pessoa p = new Pessoa();
        p.setNmPessoa("Gabriel99");
        
        CurrencyExchange c = new CurrencyExchange();
        c.setDsCoin(" dsda");
        c.setVlRate(new BigDecimal(10));
        c.setIdCurrencyExchange(new BigDecimal(100.0));
        c.setDtCurrencyExchange(new byte[]{1,2});

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tema3");
        final EntityManager em = emf.createEntityManager();

        PessoaDAO dao = new PessoaDAO(em);

        //dao.insert(p);
        
        //dao.exportar("C:\\Users\\Gabriel\\Desktop\\aqui.txt");

        //dao.list().forEach(p1 -> System.out.println(p1.getNmPessoa()));
        //CurrencyExchangeDAO dao = new CurrencyExchangeDAO(em);
        //dao.insert(c);
        //dao.list().forEach(p1 -> System.out.println(p1.getDsCoin()));

        em.close();
        emf.close();
    }

}
