package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Servico;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class ServicoDAO extends AbstractDAO<Servico, Long> {
    
    private final EntityManager entityManager;
    
    public ServicoDAO(EntityManager entityManager) {
        super(Servico.class);
        this.entityManager = entityManager;
    }
    
    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<Servico> servicos = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_SERVICO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_DESCRICAO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_PERIODICIDADE");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_SIMBOLO_MOEDA");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_SITUACAO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_WEBSITE");
            bufferedWriter.append(";");
            bufferedWriter.append("NM_SERVICO");
            bufferedWriter.append(";");
            bufferedWriter.append("VL_MENSAL_USD");
            bufferedWriter.append(";");
            bufferedWriter.append("VL_TOTAL_SERVICO");
            bufferedWriter.append(";");
            bufferedWriter.append("USUARIO_ID_USUARIO");
            bufferedWriter.newLine();
            servicos.forEach(s -> {
                try {
                    bufferedWriter.append(String.valueOf(s.getIdServico()))
                            .append(";")
                            .append(String.valueOf(s.getDsDescricao()))
                            .append(";")
                            .append(String.valueOf(s.getDsPeriodicidade()))
                            .append(";")
                            .append(String.valueOf(s.getDsSimboloMoeda()))
                            .append(";")
                            .append(String.valueOf(s.getDsSituacao()))
                            .append(";")
                            .append(String.valueOf(s.getDsWebsite()))
                            .append(";")
                            .append(String.valueOf(s.getNmServico()))
                            .append(";")
                            .append(String.valueOf(String.valueOf(s.getVlMensalUsd())))
                            .append(";")
                            .append(String.valueOf(String.valueOf(s.getVlTotalServico())))
                            .append(";")
                            .append(String.valueOf(String.valueOf(s.getUsuarioIdUsuario().getIdUsuario())));
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
