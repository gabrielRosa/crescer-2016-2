package br.com.cwi.crescer.entity;

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
}
