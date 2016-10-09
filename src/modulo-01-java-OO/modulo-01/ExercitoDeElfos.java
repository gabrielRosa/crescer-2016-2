import java.util.ArrayList;
public class ExercitoDeElfos implements Exercito{
    private ArrayList<Elfo> exercito;
    public ExercitoDeElfos(){
        exercito = new ArrayList<>();
    }

    public void alistar(Elfo elfo) throws NaoPodeAlistarException{
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.add(elfo);
        }else{
            throw  new NaoPodeAlistarException();
        }
    }

    public Elfo[] getContingente(){
        return exercito.toArray(new Elfo [exercito.size()]);
    }

    public Elfo buscar(String nome){
        for (Elfo elfo : exercito){
            if(elfo.getNome().equals(nome))
                return elfo;
        }
        return null;
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> array = new ArrayList<>();
        for(Elfo elfo : exercito){
            if(elfo.getStatus() == status)
                array.add(elfo);
        }
        return array;
    }

}
