package br.com.cwi.crescer.temaspring.entity;

// @author Gabriel
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "FILME")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_FILME")
    private Long idFilme;

    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;

    @JoinColumn(name = "GENERO_ID_GENERO", referencedColumnName = "ID_GENERO")
    @ManyToOne(optional = false)
    private Genero genero;

    @Basic(optional = false)
    @Column(name = "DIRETOR")
    private String diretor;

    @Basic(optional = true)
    @Column(name = "DATADELANCAMENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeLancamento;

    @JoinColumn(name = "ELENCO_ID_ELENCO", referencedColumnName = "ID_ELENCO")
    @ManyToOne(optional = false)
    private Elenco elenco;

    @JoinColumn(name = "CLASSIFICACAO_ID_CLASSIFICACAO", referencedColumnName = "ID_CLASSIFICACAO")
    @ManyToOne(optional = false)
    private Classificacao classificacao;

    @JoinColumn(name = "IDIOMA_ID_IDIOMA", referencedColumnName = "ID_IDIOMA")
    @ManyToOne(optional = false)
    private Idioma idioma;

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Date getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(Date dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

}
