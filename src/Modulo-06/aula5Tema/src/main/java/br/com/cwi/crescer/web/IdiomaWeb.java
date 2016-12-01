package br.com.cwi.crescer.web;

// @author Gabriel
import br.com.cwi.crescer.entity.Idioma;
import br.com.cwi.crescer.repository.IdiomaBean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class IdiomaWeb {

    @EJB
    private IdiomaBean idiomaBean;
    private Idioma idioma;
    private List<Idioma> idiomas;

    @PostConstruct
    public void init() {
        this.idioma = new Idioma();
    }

    public IdiomaBean getIdiomaBean() {
        return idiomaBean;
    }

    public void setIdiomaBean(IdiomaBean idiomaBean) {
        this.idiomaBean = idiomaBean;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public void adicionar() {
//        atorBean.insert(ator);
        idiomas = new ArrayList<>();
        idiomas.add(new Idioma());
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}
