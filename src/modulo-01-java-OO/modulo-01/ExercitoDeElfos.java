import java.util.ArrayList;
public class ExercitoDeElfos{
    private ArrayList<Elfo> exercito;
    public ExercitoDeElfos(){
        exercito = new ArrayList<>();
    }

    public void alistar(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.add(elfo);
        }
    }

    public Elfo[] getExercito(){
        return exercito.toArray(new Elfo [exercito.size()]);
    }

    public Elfo buscar(String nome){
        for (Elfo elfo : exercito){
            if(elfo.getNome().equals(nome))
                return elfo;
        }
        return null;
    }

}
