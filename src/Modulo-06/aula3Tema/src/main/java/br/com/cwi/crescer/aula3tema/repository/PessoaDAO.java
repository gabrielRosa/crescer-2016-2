package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Pessoa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class PessoaDAO extends AbstractDAO<Pessoa, Long> {

    private final EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager) {
        super(Pessoa.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<Pessoa> pessoas = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_PESSOA");
            bufferedWriter.append(";");
            bufferedWriter.append("NM_PESSOA");
            bufferedWriter.newLine();
            pessoas.forEach(p -> {
                try {
                    bufferedWriter.append(String.valueOf(p.getIdPessoa())).append(";").append(p.getNmPessoa());
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            file.createNewFile();
            bufferedWriter.flush();
        }
    }

}
