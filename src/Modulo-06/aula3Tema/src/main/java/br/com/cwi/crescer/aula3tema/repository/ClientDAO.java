package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;

public class ClientDAO implements IDAO<Client, Long> {

    final EntityManager entityManager;

    public ClientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Client client) {
        try {
            entityManager.getTransaction().begin();
            if (client.getIdClient() == null) {
                entityManager.persist(client);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Client t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Client t) {
        try {
            entityManager.getTransaction().begin();
            if (t.getIdClient() != null) {
                entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Client> list() {
        return entityManager.createQuery("select * from Client ").getResultList();
    }

//    public void exportarCsv(final String nomeArquivoDestino, final String nomeTabela) throws IOException, SQLException {
//        HashMap<String, String> buscado = (HashMap<String, String>) this.busca("Select * from " + nomeTabela);
//        this.montarCsvParaArquivo(buscado, nomeArquivoDestino);
//    }
//
//    private void montarCsvParaArquivo(Map<String, String> dados, String nomeArquivo) throws IOException {
//        File file = new File(nomeArquivo);
//        try (final Writer writer = new FileWriter(nomeArquivo, false);
//                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
//            for (Map.Entry entry : dados.entrySet()) {
//                bufferedWriter.append(entry.getKey().toString());
//                bufferedWriter.append(";");
//                bufferedWriter.append(entry.getValue().toString());
//                bufferedWriter.newLine();
//            }
//            file.createNewFile();
//            bufferedWriter.flush();
//        }
//    }
//
//    private Map<String, String> busca(final String instrucao) throws SQLException {
//        HashMap<String, String> retorno = null;
//        try (final Connection connection = ConnectionUtils.getConnection();
//                final Statement statement = connection.createStatement();) {
//            ResultSet resultado = statement.executeQuery(instrucao);
//            ResultSetMetaData cabecalho = resultado.getMetaData();
//
//            retorno = new HashMap<>();
//            retorno.put(cabecalho.getColumnName(1), cabecalho.getColumnName(2));
//
//            while (resultado.next()) {
//                retorno.put(Long.toString(resultado.getLong(1)), resultado.getString(2));
//            }
//        }
//        return retorno;
//    }
}
