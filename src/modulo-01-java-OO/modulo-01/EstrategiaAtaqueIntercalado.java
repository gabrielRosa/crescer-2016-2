import java.util.*;
public class EstrategiaAtaqueIntercalado implements Estrategia{

    @Override
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ContingenteDesproporcionalException{
        List<Elfo> novaList = new ArrayList<>();
        int contVerde =0,contNoturno=0;
        //so elfos vivos atacam
        for(int i =0;i<atacantes.size();i++){
            if(atacantes.get(i).getStatus() == Status.VIVO){
                if(atacantes.get(i) instanceof ElfoVerde){
                    novaList.add(atacantes.get(i));
                    contVerde++;
                } else if(atacantes.get(i) instanceof ElfoNoturno){
                    novaList.add(atacantes.get(i));
                    contNoturno++;
                }
            }
        }
        //verifica se tem 50% de verde e 50% de noturno
        if(!(contVerde == contNoturno)){
            throw new ContingenteDesproporcionalException();
        }

        if(novaList.size()==0){
            return novaList;
        }

        for(int i =0;i<novaList.size();i++){
            for(int j =0;j<novaList.size()-1;j++){
                if(novaList.get(j) instanceof ElfoNoturno){
                    Elfo aux = novaList.get(j);
                    novaList.set(j, novaList.get(j+1));
                    novaList.set(j+1, aux);
                }
            }
        }

        return null;
    }
}

