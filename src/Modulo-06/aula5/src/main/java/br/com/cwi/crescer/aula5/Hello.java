package br.com.cwi.crescer.aula5;

//pegar as anotações certas
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Hello {

    private Pessoa pessoa;

    private List<Pessoa> pessoas;

    @PostConstruct
    public void init() {
        this.pessoa = new Pessoa();
        this.pessoas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Pessoa p = new Pessoa();
            p.setNome("Pessoa" + i);
            pessoas.add(p);
        }
    }

    public Hello() {
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
