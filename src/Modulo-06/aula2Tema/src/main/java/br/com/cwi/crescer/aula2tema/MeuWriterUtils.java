package br.com.cwi.crescer.aula2tema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class MeuWriterUtils {

    public void escreverArquivo(final String nomeArquivo, List<String> conteudo) throws IOException {
        if (!ValidaçãoDeArquivo.existeArquivo(nomeArquivo)) {
            throw new IllegalArgumentException("O arquivo solucitado não existe!");
        }
        
        if (!ValidaçãoDeArquivo.isTxt(nomeArquivo)) {
            throw new IllegalArgumentException("O arquivo solicitado é incompatível!");
        }
        
        final Writer writer = new FileWriter(nomeArquivo, true);
        final BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (int i = 0; i < conteudo.size(); i++) {
            bufferedWriter.newLine();
            bufferedWriter.append(conteudo.get(i));
        }
        bufferedWriter.flush();
    }

}
