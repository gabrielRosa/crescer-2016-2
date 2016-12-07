package br.com.cwi.crescer.aula8.entity;

// @author Gabriel
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
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    private final static String SEQ_PESSOA = "SEQ_PESSOA";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_PESSOA)
    @SequenceGenerator(name = SEQ_PESSOA, sequenceName = SEQ_PESSOA, allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private Long idPessoa;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

}
