package br.com.cwi.crescer.web;

// @author Gabriel
import br.com.cwi.crescer.entity.Classificacao;
import br.com.cwi.crescer.entity.Elenco;
import br.com.cwi.crescer.entity.Filme;
import br.com.cwi.crescer.entity.Genero;
import br.com.cwi.crescer.entity.Idioma;
import br.com.cwi.crescer.repository.ClassificacaoBean;
import br.com.cwi.crescer.repository.ElencoBean;
import br.com.cwi.crescer.repository.FilmeBean;
import br.com.cwi.crescer.repository.GeneroBean;
import br.com.cwi.crescer.repository.IdiomaBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FilmeWeb {

    @EJB
    private FilmeBean filmeBean;
    @EJB
    private GeneroBean generoBean;

    @EJB
    private ClassificacaoBean classificacaoBean;

    @EJB
    private ElencoBean elencoBean;

    @EJB
    private IdiomaBean idiomaBean;
    private Filme filme;
    private List<Filme> filmes;
    private List<Genero> generos;
    private List<Classificacao> classificacoes;
    private List<Elenco> elencos;
    private List<Idioma> idiomas;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.limpar();
        this.filmes = filmeBean.findAll();
        this.filmes.sort((a, b) -> a.getTitulo().compareTo(b.getTitulo()));
    }

    public void limpar() {
        this.filmeBean.limpar();
        this.setGeneros(this.generoBean.findAll());
        this.setClassificacoes(this.classificacaoBean.findAll());
        this.setElencos(this.elencoBean.findAll());
        this.setIdiomas(this.idiomaBean.findAll());
    }

    public FilmeBean getFilmeBean() {
        return filmeBean;
    }

    public void setFilmeBean(FilmeBean filmeBean) {
        this.filmeBean = filmeBean;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public void adicionar() {
        filmeBean.insert(this.filme);
        String nome = this.filme.getTitulo();
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme " + nome + " inserido com sucesso!", "Testes"));
    }
}
