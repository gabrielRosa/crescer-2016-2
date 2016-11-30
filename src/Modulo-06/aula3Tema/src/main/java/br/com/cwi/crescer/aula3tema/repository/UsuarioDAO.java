package br.com.cwi.crescer.aula3tema.repository;

import br.com.cwi.crescer.aula3tema.entity.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

public class UsuarioDAO extends AbstractDAO<Usuario, Long> {

    private final EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        super(Usuario.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void exportar(final String localParaSalvar) throws IOException {
        List<Usuario> usuarios = super.list();
        File file = new File(localParaSalvar);
        try (final Writer writer = new FileWriter(localParaSalvar, false);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.append("ID_USUARIO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_EMAIL");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_SENHA");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_SITUACAO");
            bufferedWriter.append(";");
            bufferedWriter.append("DS_USER_NAME");
            bufferedWriter.append(";");
            bufferedWriter.append("NM_USUARIO");
            bufferedWriter.append(";");
            bufferedWriter.append("TP_PERMISSAO");
            bufferedWriter.newLine();
            usuarios.forEach(u -> {
                try {
                    bufferedWriter.append(String.valueOf(u.getIdUsuario()))
                            .append(";")
                            .append(u.getDsEmail())
                            .append(";")
                            .append(String.valueOf(u.getDsSenha()))
                            .append(";")
                            .append(u.getDsSituacao())
                            .append(";")
                            .append(u.getDsUserName())
                            .append(";")
                            .append(u.getNmUsuario())
                            .append(";")
                            .append(u.getTpPermissao());
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
