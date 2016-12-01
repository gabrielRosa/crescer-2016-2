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
    }

    public ElencoBean getElencoBean() {
        return elencoBean;
    }

    public void setElencoBean(ElencoBean elencoBean) {
        this.elencoBean = elencoBean;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public void adicionar() {
        elencoBean.insert(elenco);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
