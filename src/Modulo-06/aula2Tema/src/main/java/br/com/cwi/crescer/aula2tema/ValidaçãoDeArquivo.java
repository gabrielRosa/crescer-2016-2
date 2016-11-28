package br.com.cwi.crescer.aula2tema;

import java.io.File;

class ValidaçãoDeArquivo {

    protected static boolean existeArquivo(final String nome) {
        final File file = new File(nome);
        return file.exists();
    }

    protected static boolean isTxt(final String nome) {
        final File file = new File(nome);
        final String arquivo = file.getAbsolutePath();
        return arquivo.endsWith(".txt");
    }
}
