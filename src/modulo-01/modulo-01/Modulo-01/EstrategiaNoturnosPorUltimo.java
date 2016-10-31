import java.util.ArrayList;
import java.util.List;

public class EstrategiaNoturnosPorUltimo implements Estrategia{

    @Override
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> novaList = new ArrayList<>();
        //so elfos vivos atacam
        for(int i =0;i<atacantes.size();i++){
            if(atacantes.get(i).getStatus() == Status.VIVO)
                novaList.add(atacantes.get(i));
        }
        //elfos verdes atacam primeiro e noturnos por ultimo
        if(novaList.size()>1){
            for(int i=0; i<novaList.size()-1;i++){
                if(novaList.get(i) instanceof ElfoNoturno){
                    Elfo elfoMomentaneo = novaList.get(i);
                    novaList.remove(i);
                    novaList.add(elfoMomentaneo);
                }
            }
        }
        return novaList;
    }

}
