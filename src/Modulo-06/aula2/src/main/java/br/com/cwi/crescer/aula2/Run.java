package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Run {

    public static void main(String[] args) {
        final String query = "SELECT 1 FROM PESSOA";
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {
                //..
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
