package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Client;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class ClientDAO extends AbstractDAO<Client, Long> {

    private final EntityManager entityManager;

    public ClientDAO(EntityManager entityManager) {
        super(Client.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<Client> clients = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_CLIENT");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_EMAIL");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_PASSWORD");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_PREFERRED_COIN");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_STATE");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_USER_NAME");
            bufferedWriter.append(";");
            bufferedWriter.append("NM_CLIENT");
            bufferedWriter.append(";");
            bufferedWriter.append("TP_PERMISSION");
            bufferedWriter.newLine();
            clients.forEach(c -> {
                try {
                    bufferedWriter.append(String.valueOf(c.getIdClient()))
                            .append(";")
                            .append(c.getDsEmail())
                            .append(";")
                            .append(c.getDsPassword())
                            .append(";")
                            .append(c.getDsPreferredCoin())
                            .append(";")
                            .append(c.getDsState())
                            .append(";")
                            .append(c.getDsUserName())
                            .append(";")
                            .append(c.getNmClient())
                            .append(";")
                            .append(c.getTpPermission());
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
