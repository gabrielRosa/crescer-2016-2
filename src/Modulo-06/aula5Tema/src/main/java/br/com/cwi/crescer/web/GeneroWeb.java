package br.com.cwi.crescer.web;

// @author Gabriel
import br.com.cwi.crescer.entity.Genero;
import br.com.cwi.crescer.repository.GeneroBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class GeneroWeb {

    @EJB
    private GeneroBean generoBean;
    private Genero genero;
    private List<Genero> generos;

    @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos = generoBean.findAll();
        this.generos.sort((a, b) -> a.getNome().compareTo(b.getNome()));
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public void adicionarDescricao() {
        generoBean.insert(this.genero);
        String nome = this.getGenero().getNome();
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "O gênero " + nome + " foi inserido com sucesso!", "teste"));
    }
}
