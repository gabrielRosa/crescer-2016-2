package br.com.cwi.crescer.aula2tema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MeuSQLUtils {

    private String[][] arquivo;

    public void instrucao(String nomeArquivo) throws FileNotFoundException {
        final Reader reader = new FileReader(nomeArquivo);
        final BufferedReader bufferReader = new BufferedReader(reader);

        List<String> instrucoes = new LinkedList<>();

        bufferReader.lines().forEach(i -> instrucoes.add(i));
        
        for(String linha:instrucoes){
            if(linha.startsWith("Select")){
                this.select(linha.substring(6).split(","));
            }
        }
    }

    private String[][] select(String[] colunas) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String item : arquivo[0]) {
            for (String coluna : colunas) {
                if (item.equals(coluna)) {
                    resultado.add(item);
                }
            }
        }
        String [][] retorno = new String[arquivo.length][resultado.size()];
        
        for(int i=0;i<arquivo.length;i++){
            int cont=0;
            for(int j=0;j<arquivo[i].length;j++){
                if(resultado.contains(arquivo[0][j])){
                    retorno[i][cont++] = arquivo[i][j];
                }
            }
        }
        return retorno;
    }

    public void importarCsv(String nomeArquivo) throws FileNotFoundException {
        final Reader reader = new FileReader(nomeArquivo);
        final BufferedReader bufferReader = new BufferedReader(reader);

        List<String> instrucoes = new LinkedList<>();

        bufferReader.lines().forEach(i -> instrucoes.add(i));
        this.montarCsvParaArray(instrucoes);
    }

    public void exportarCsv(String nomeArquivo) throws IOException {
        final Writer writer = new FileWriter(nomeArquivo, false);
        final BufferedWriter bufferedWriter = new BufferedWriter(writer);
        this.montarCsvParaArquivo(bufferedWriter);
    }

    private void montarCsvParaArray(List<String> instrucoes) {
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

    private void montarCsvParaArquivo(final BufferedWriter bufferedWriter) throws IOException {
        for (String[] arquivo1 : arquivo) {
            for (int j = 0; j < arquivo1.length; j++) {
                bufferedWriter.append(arquivo1[j]);
                if (j < arquivo1.length - 1) {
                    bufferedWriter.append(";");
                }
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

}
