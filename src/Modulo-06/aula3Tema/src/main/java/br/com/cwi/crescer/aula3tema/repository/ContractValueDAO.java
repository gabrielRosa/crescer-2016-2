package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.ContractValue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class ContractValueDAO extends AbstractDAO<ContractValue, Long> {

    private final EntityManager entityManager;

    public ContractValueDAO(EntityManager entityManager) {
        super(ContractValue.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<ContractValue> contractValues = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_CONTRACT_VALUE");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COIN");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_PERIODICITY");
            bufferedWriter.append(";");
            bufferedWriter.append("VL_AMOUNT_CONTRACT_VALUE");
            bufferedWriter.append(";");
            bufferedWriter.append("VL_MONTHLY_USD");
            bufferedWriter.append(";");
            bufferedWriter.append("CONTRACT_ID_CONTRACT");
            bufferedWriter.newLine();
            contractValues.forEach(c -> {
                try {
                    bufferedWriter.append(String.valueOf(c.getIdContractValue()))
                            .append(";")
                            .append(c.getDsCoin())
                            .append(";")
                            .append(c.getDsPeriodicity())
                            .append(";")
                            .append(String.valueOf(c.getVlAmountContractValue()))
                            .append(";")
                            .append(String.valueOf(c.getVlMonthlyUsd()))
                            .append(";")
                            .append(String.valueOf(c.getContractIdContract().getIdContract()));
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
