package br.com.cwi.crescer.web;

// @author Gabriel
import br.com.cwi.crescer.entity.Ator;
import br.com.cwi.crescer.repository.AtorBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class AtorWeb {

    @EJB
    private AtorBean atorBean;
    
    private Ator ator;
    private List<Ator> atores;

    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorBean.findAll();
        this.atores.sort((a, b) -> a.getNome().compareTo(b.getNome()));
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void adicionar() {
        atorBean.insert(ator);
        String nome = this.getAtor().getNome();
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ator "+nome+" inserido com sucesso!", "Testes"));
    }
}
