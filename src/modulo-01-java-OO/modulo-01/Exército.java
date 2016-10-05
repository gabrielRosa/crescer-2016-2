import java.util.ArrayList;
public abstract class Exército{
    private ArrayList<Personagem> exercito;

    public Exército(){
        exercito = new ArrayList<>();
    }

    public abstract void alistar(Personagem personagem);

    protected void adicionar(Personagem personagem){
        exercito.add(personagem);
    }
}
