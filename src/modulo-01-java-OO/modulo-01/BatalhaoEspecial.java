import java.util.*;
public class BatalhaoEspecial{
    private HashMap<String,Elfo> contingente;

    public BatalhaoEspecial(){
        contingente = new HashMap<>();
    }

    public Elfo[] getContingente(){
        return contingente.values().toArray(new Elfo [contingente.size()]);
    }

    public void alistar(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            contingente.put(elfo.getNome(), elfo);
        }
    }

    public Elfo buscar(String nome){
        return contingente.get(nome);
    }

    public ArrayList<Elfo> buscar(Status status){
        ArrayList<Elfo> retorno = new ArrayList<>();
        for(String key : contingente.keySet()){
            if(contingente.get(key).getStatus() == status){
                retorno.add(contingente.get(key));
            }
        }
        return retorno;
    }
}
