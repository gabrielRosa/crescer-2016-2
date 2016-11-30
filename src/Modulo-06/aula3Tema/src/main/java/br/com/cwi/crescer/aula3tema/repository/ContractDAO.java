package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Contract;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class ContractDAO extends AbstractDAO<Contract, Long> {

    private final EntityManager entityManager;

    public ContractDAO(EntityManager entityManager) {
        super(Contract.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<Contract> contracts = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_CONTRACT");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_DESCRIPTION");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_STATE");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_WEBSITE");
            bufferedWriter.append(";");
            bufferedWriter.append("NM_CONTRACT");
            bufferedWriter.append(";");
            bufferedWriter.append("CLIENT_ID_CLIENT");
            bufferedWriter.newLine();
            contracts.forEach(c -> {
                try {
                    bufferedWriter.append(String.valueOf(c.getIdContract()))
                            .append(";")
                            .append(c.getDsDescription())
                            .append(";")
                            .append(c.getDsState())
                            .append(";")
                            .append(c.getDsWebsite())
                            .append(";")
                            .append(c.getNmContract())
                            .append(";")
                            .append(String.valueOf(c.getClientIdClient().getIdClient()));
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
