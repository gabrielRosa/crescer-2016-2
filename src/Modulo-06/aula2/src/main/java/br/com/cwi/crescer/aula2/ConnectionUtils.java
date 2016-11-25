package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String URL = "jdbc:oracle:thin:@<HOST>:<PORT>:<SID>";
    private static final String USER = "xa";
    private static final String PASS = "xa";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
