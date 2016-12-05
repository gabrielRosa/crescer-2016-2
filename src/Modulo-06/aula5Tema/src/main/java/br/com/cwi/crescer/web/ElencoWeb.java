package br.com.cwi.crescer.web;

// @author Gabriel
import br.com.cwi.crescer.entity.Elenco;
import br.com.cwi.crescer.repository.ElencoBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ElencoWeb {

    @EJB
    private ElencoBean elencoBean;
    private Elenco elenco;
    private List<Elenco> elencos;

    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoBean.findAll();
        this.elencos.sort((a, b) -> a.getNome().compareTo(b.getNome()));
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public void adicionar() {
        elencoBean.insert(elenco);
        String nome = this.getElenco().getNome();
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "O elenco " + nome + " foi inserido com sucesso!:)", "teste"));
    }

}
