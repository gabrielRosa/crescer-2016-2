package br.com.cwi.crescer.aula2tema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MeuReaderUtils {

    public void exibirConteudo(final String nome) throws IOException {
        
        if(!ValidaçãoDeArquivo.existeArquivo(nome)){
            throw new IllegalArgumentException("O arquivo solucitado não existe!");
        }
        
        if(!ValidaçãoDeArquivo.isTxt(nome)){
            throw new IllegalArgumentException("O arquivo solicitado é incompatível!");
        }
        final Reader reader = new FileReader(nome);
        final BufferedReader bufferReader = new BufferedReader(reader);
        bufferReader.lines().forEach(System.out::println);
    }
}
