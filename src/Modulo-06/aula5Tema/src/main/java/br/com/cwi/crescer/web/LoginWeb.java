package br.com.cwi.crescer.web;

// @author Gabriel
import br.com.cwi.crescer.entity.Login;
import br.com.cwi.crescer.repository.LoginBean;
import br.com.cwi.crescer.util.FacesUtils;
import static br.com.cwi.crescer.util.UserDetails.USER_AUTH;
import br.com.cwi.crescer.validador.LoginCriacaoValidador;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginWeb {

    @EJB
    private LoginBean loginBean;

    private Login login;

    @PostConstruct
    public void init() {
        this.login = new Login();
    }

    public String getLoggedUsername() {
        final Login logon;
        logon = (Login) FacesUtils.getSession().getAttribute(USER_AUTH);
        return logon == null ? null : logon.getNome();
    }

    public String logon() {
        FacesUtils.getSession().setAttribute(USER_AUTH, this.login);
        return "index";
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "logout";
    }

    public void criarLogin() {
        if (LoginCriacaoValidador.validarCriacaoLogin(login)) {
            loginBean.insert(login);
        }
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
