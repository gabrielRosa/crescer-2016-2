package br.com.cwi.crescer.entity;

// @author Gabriel
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ELENCO")
public class Elenco implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ELENCO")
    @SequenceGenerator(name = "SEQ_ELENCO", sequenceName = "SEQ_ELENCO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_ELENCO")
    private Long idElenco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ator> ator;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    public Long getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

    public List<Ator> getAtor() {
        return ator;
    }

    public void setAtor(List<Ator> ator) {
        this.ator = ator;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
