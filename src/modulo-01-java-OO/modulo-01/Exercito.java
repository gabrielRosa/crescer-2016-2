import java.util.ArrayList;
public interface Exercito{
    Elfo[] getContingente();

    void alistar(Elfo elfo) throws NaoPodeAlistarException;

    Elfo buscar(String nome);

    ArrayList<Elfo> buscar(Status status);
}
