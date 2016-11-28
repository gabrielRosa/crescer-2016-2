package br.com.cwi.crescer.aula2tema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MeuFileUtils {

    @SuppressWarnings("CallToPrintStackTrace")
    public void instrucao(final String instrucao) {
        final String[] dividirInstrucao = instrucao.split(" ");
        try {
            switch (dividirInstrucao[0]) {
                case "mk":
                    this.mk(dividirInstrucao[1]);
                    System.out.println("Comando executado com sucesso!");
                    break;
                case "rm":
                    this.rm(dividirInstrucao[1]);
                    System.out.println("Comando executado com sucesso!");
                    break;
                case "ls":
                    String[] retorno = this.ls(dividirInstrucao[1]);
                    for (String frase : retorno) {
                        System.out.println(frase);
                    }
                    break;
                case "mv":
                    this.mv(dividirInstrucao[1], dividirInstrucao[2]);
                    System.out.println("Comando executado com sucesso!");
                    break;
                default:
                    System.out.println("Comando não reconhecido");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private void mk(String nome) throws IOException {
        final File file = new File(nome);
        file.createNewFile();
    }

    private void rm(String nome) {
        final File file = new File(nome);
        if (file.isDirectory()) {
            throw new IllegalArgumentException("O arquivo é invalido!");
        }
        file.delete();
    }

    private String[] ls(String nome) {
        final File file = new File(nome);
        String[] retorno;
        if (file.isDirectory()) {
            File[] lista = file.listFiles();
            retorno = new String[lista.length];
            int cont = 0;
            for (File item : lista) {
                retorno[cont++] = item.getName();
            }
        } else {
            retorno = new String[1];
            retorno[0] = file.getAbsolutePath();
        }
        return retorno;
    }

    private void mv(String nome, String novoLocal) throws FileNotFoundException, IOException {
        final File file = new File(nome);
        if (file.isDirectory()) {
            throw new IllegalArgumentException("O arquivo é invalido!");
        }
        final File destino = new File(novoLocal+file.getName());
        if (!destino.exists()) {
            destino.createNewFile();
        }
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(destino);
        byte[] buffer = new byte[2048];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
        this.rm(nome);
    }
}
