package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Cotacao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class CotacaoDAO extends AbstractDAO<Cotacao, Long> {

    private final EntityManager entityManager;

    public CotacaoDAO(EntityManager entityManager) {
        super(Cotacao.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<Cotacao> cotacoes = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_COTACAO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_DOLLAR_AUSTRALIANO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_DOLLAR_CANADENSE");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_EURO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_FRANCO_SUICO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_LIBRA");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_REAL");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_YEN");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_COTACAO_YUAN");
            bufferedWriter.append(";");
            bufferedWriter.append("DT_COTACAO");
            bufferedWriter.newLine();
            cotacoes.forEach(c -> {
                try {
                    bufferedWriter.append(String.valueOf(c.getIdCotacao()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoDollarAustraliano()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoDollarCanadense()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoEuro()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoFrancoSuico()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoLibra()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoReal()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoYen()))
                            .append(";")
                            .append(String.valueOf(c.getDsCotacaoYuan()))
                            .append(";")
                            .append(String.valueOf(c.getDtCotacao()));
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
