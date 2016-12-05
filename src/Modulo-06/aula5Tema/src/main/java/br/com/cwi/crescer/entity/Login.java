package br.com.cwi.crescer.entity;

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
@Table(name = "LOGIN")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOGIN")
    @SequenceGenerator(name = "SEQ_LOGIN", sequenceName = "SEQ_LOGIN", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_LOGIN")
    private Long idLogin;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;

    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
