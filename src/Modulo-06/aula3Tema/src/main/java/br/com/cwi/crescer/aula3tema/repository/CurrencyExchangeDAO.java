package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.CurrencyExchange;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class CurrencyExchangeDAO extends AbstractDAO<CurrencyExchange, Long> {

    private final EntityManager entityManager;

    public CurrencyExchangeDAO(EntityManager entityManager) {
        super(CurrencyExchange.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<CurrencyExchange> currencyExchanges = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_CURRENCY_EXCHANGE");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COIN");
            bufferedWriter.append(";");
            bufferedWriter.append("DT_CURRENCY_EXCHANGE");
            bufferedWriter.append(";");
            bufferedWriter.append("VL_RATE");
            bufferedWriter.newLine();
            currencyExchanges.forEach(c -> {
                try {
                    bufferedWriter.append(String.valueOf(c.getIdCurrencyExchange()))
                            .append(";")
                            .append(c.getDsCoin())
                            .append(";")
                            .append(String.valueOf(c.getDtCurrencyExchange()))
                            .append(";")
                            .append(String.valueOf(c.getVlRate()));
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
