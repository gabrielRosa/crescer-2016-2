package br.com.cwi.crescer.aula2tema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MeuSQLUtils {



    public void instrucao(String nomeArquivo) throws FileNotFoundException, SQLException {
        final List<String> comando = this.lerComando(nomeArquivo);
        this.executarInstrucao(comando);
    }

    public void importarCsv(String nomeArquivo) throws FileNotFoundException {

    }

    public void exportarCsv(final String nomeArquivoDestino,final String nomeTabela) throws IOException, SQLException {
        HashMap<String, String> buscado = (HashMap<String, String>) this.busca("Select * from " + nomeTabela);
        this.montarCsvParaArquivo(buscado, nomeArquivoDestino);
    }

    private void montarCsvParaList(List<String> instrucoes) {
        String[] cabecalho = instrucoes.get(0).split(";");

        arquivo = new String[instrucoes.size()][cabecalho.length];

        int cont = 0;
        for (String coluna : cabecalho) {
            arquivo[0][cont++] = coluna;
        }

        for (int i = 1; i < instrucoes.size(); i++) {
            String[] colunas = instrucoes.get(i).split(";");
            System.arraycopy(colunas, 0, arquivo[i], 0, colunas.length);
        }
    }

    private void montarCsvParaArquivo(Map<String, String> dados,String nomeArquivo ) throws IOException{
        File file = new File(nomeArquivo);
        try(final Writer writer = new FileWriter(nomeArquivo, false);
               final BufferedWriter bufferedWriter = new BufferedWriter(writer);){
            for(Entry entry: dados.entrySet()){
                bufferedWriter.append(entry.getKey().toString());
                bufferedWriter.append(";");
                bufferedWriter.append(entry.getValue().toString());
                bufferedWriter.newLine();
            }
            file.createNewFile();
            bufferedWriter.flush();
        }
    }

    private List<String> lerComando(String nomeArquivo) throws FileNotFoundException {
        final Reader reader = new FileReader(nomeArquivo);
        final BufferedReader bufferReader = new BufferedReader(reader);

        final ArrayList<String> comando = new ArrayList<>();
        bufferReader.lines().forEach(l -> comando.add(l));
        return comando;
    }

    private void executarInstrucao(List<String> comando) {
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            try {
                for (String linha : comando) {
                    final ResultSet resultSet = statement.executeQuery(linha);
                    resultSet.
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    private void update(String instrucao) throws SQLException {
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            statement.executeUpdate(instrucao);
        }
    }

    private Map<String, String> busca(final String instrucao) throws SQLException {
        HashMap<String, String> retorno = null;
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            ResultSet resultado = statement.executeQuery(instrucao);
            ResultSetMetaData cabecalho = resultado.getMetaData();

            retorno = new HashMap<>();
            retorno.put(cabecalho.getColumnName(1), cabecalho.getColumnName(2));

            while (resultado.next()) {
                retorno.put(Long.toString(resultado.getLong(1)), resultado.getString(2));
            }
        }
        return retorno;
    }

}
