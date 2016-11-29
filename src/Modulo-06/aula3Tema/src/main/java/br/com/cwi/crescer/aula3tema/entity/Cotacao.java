package br.com.cwi.crescer.aula3tema.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "COTACAO")
public class Cotacao implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COTACAO")
    @SequenceGenerator(name = "SEQ_COTACAO", sequenceName = "SEQ_COTACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_COTACAO")
    private Long idCotacao;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_AUSTRALIANO")
    private Long dsCotacaoDollarAustraliano;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_CANADENSE")
    private Long dsCotacaoDollarCanadense;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_EURO")
    private Long dsCotacaoDollarEuro;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_FRANCO_SUICO")
    private Long dsCotacaoDollarFrancoSuico;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_LIBRA")
    private Long dsCotacaoDollarLibra;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_REAL")
    private Long dsCotacaoDollarReal;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YEN")
    private Long dsCotacaoDollarYen;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YUAN")
    private Long dsCotacaoDollarYuan;

    @Basic(optional = false)
    @Column(name = "DT_COTACAO")
    private String dtCotacao;

    public Long getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Long idCotacao) {
        this.idCotacao = idCotacao;
    }

    public Long getDsCotacaoDollarAustraliano() {
        return dsCotacaoDollarAustraliano;
    }

    public void setDsCotacaoDollarAustraliano(Long dsCotacaoDollarAustraliano) {
        this.dsCotacaoDollarAustraliano = dsCotacaoDollarAustraliano;
    }

    public Long getDsCotacaoDollarCanadense() {
        return dsCotacaoDollarCanadense;
    }

    public void setDsCotacaoDollarCanadense(Long dsCotacaoDollarCanadense) {
        this.dsCotacaoDollarCanadense = dsCotacaoDollarCanadense;
    }

    public Long getDsCotacaoDollarEuro() {
        return dsCotacaoDollarEuro;
    }

    public void setDsCotacaoDollarEuro(Long dsCotacaoDollarEuro) {
        this.dsCotacaoDollarEuro = dsCotacaoDollarEuro;
    }

    public Long getDsCotacaoDollarFrancoSuico() {
        return dsCotacaoDollarFrancoSuico;
    }

    public void setDsCotacaoDollarFrancoSuico(Long dsCotacaoDollarFrancoSuico) {
        this.dsCotacaoDollarFrancoSuico = dsCotacaoDollarFrancoSuico;
    }

    public Long getDsCotacaoDollarLibra() {
        return dsCotacaoDollarLibra;
    }

    public void setDsCotacaoDollarLibra(Long dsCotacaoDollarLibra) {
        this.dsCotacaoDollarLibra = dsCotacaoDollarLibra;
    }

    public Long getDsCotacaoDollarReal() {
        return dsCotacaoDollarReal;
    }

    public void setDsCotacaoDollarReal(Long dsCotacaoDollarReal) {
        this.dsCotacaoDollarReal = dsCotacaoDollarReal;
    }

    public Long getDsCotacaoDollarYen() {
        return dsCotacaoDollarYen;
    }

    public void setDsCotacaoDollarYen(Long dsCotacaoDollarYen) {
        this.dsCotacaoDollarYen = dsCotacaoDollarYen;
    }

    public Long getDsCotacaoDollarYuan() {
        return dsCotacaoDollarYuan;
    }

    public void setDsCotacaoDollarYuan(Long dsCotacaoDollarYuan) {
        this.dsCotacaoDollarYuan = dsCotacaoDollarYuan;
    }

    public String getDtCotacao() {
        return dtCotacao;
    }

    public void setDtCotacao(String dtCotacao) {
        this.dtCotacao = dtCotacao;
    }
    
    
}
