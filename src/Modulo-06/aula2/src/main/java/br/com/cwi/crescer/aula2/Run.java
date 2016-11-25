package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.SQLException;

public class Run {

    public static void main(String[] args) {
        try (final Connection connection = ConnectionUtils.getConnection()){
            
        } catch (SQLException ex) {
            
        }
    }
}
