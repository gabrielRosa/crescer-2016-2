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

        if(novaList.size()==0){
            return novaList;
        }

        //verifica se tem 50% de verde e 50% de noturno
        if(!(contVerde == contNoturno)){
            throw new ContingenteDesproporcionalException();
        }

        intercalar(novaList);

        return novaList;
    }

    private void intercalar(List<Elfo> novaList){
        for(int i=1;i<novaList.size();i++){
            if((novaList.get(i-1).getClass().equals(novaList.get(i).getClass()))){
                int j = i;
                Elfo auxiliar;
                while(j<novaList.size()){
                    if(!(novaList.get(i-1).getClass().equals(novaList.get(j).getClass()))){
                        auxiliar = novaList.get(i);
                        novaList.set(i, novaList.get(j));
                        novaList.remove(j);
                        novaList.add(auxiliar);
                        break;
                    }
                    j++;
                }
            }  
        }
    }
}

