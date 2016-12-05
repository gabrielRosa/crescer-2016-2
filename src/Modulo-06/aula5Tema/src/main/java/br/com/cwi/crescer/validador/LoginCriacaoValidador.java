package br.com.cwi.crescer.validador;

// @author Gabriel
import br.com.cwi.crescer.entity.Login;

// TODO: refatorar classe
public class LoginCriacaoValidador {


    public static boolean validarCriacaoLogin(Login login) {
        return ehNovo(login);
    }

    private static boolean ehNovo(Login login) {
        return true;
    }
}
