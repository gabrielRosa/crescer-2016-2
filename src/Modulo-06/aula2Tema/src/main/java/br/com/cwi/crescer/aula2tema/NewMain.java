package br.com.cwi.crescer.aula2tema;

import java.io.IOException;

public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
//        MeuWriterUtils m = new MeuWriterUtils();
//        List<String> conteudo = new LinkedList<>();
//        conteudo.add("escrevi algo");
//        final String arquivo = "C:\\Users\\Gabriel\\Desktop\\TODO.txt";
//        m.escreverArquivo(arquivo, conteudo);
//        
//        MeuReaderUtils m2 = new MeuReaderUtils();
//        m2.exibirConteudo(arquivo);
//        
//        MeuFileUtils m3 = new MeuFileUtils();
//        m3.instrucao("mk C:\\Users\\Gabriel\\Desktop\\TODO2.txt");
//        m3.instrucao("rm C:\\Users\\Gabriel\\Desktop\\TODO2.txt");
//        m3.instrucao("ls C:\\Users\\Gabriel\\Desktop");
//        m3.instrucao("mk C:\\Users\\Gabriel\\Desktop\\TODO2.txt");
//        m3.instrucao("mv C:\\Users\\Gabriel\\Desktop\\TODO2.txt C:\\Users\\Gabriel\\Downloads\\");
//        
        MeuSQLUtils m4 = new MeuSQLUtils();
        m4.importarCsv("C:\\Users\\Gabriel\\Desktop\\sql.csv");
        m4.exportarCsv("C:\\Users\\Gabriel\\Desktop\\sqlExportado.csv");
    }
    
}
