import java.util.*;
public class EstrategiaLittleMumu implements Estrategia{

    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        if(atacantes == null){
            return null;
        }
        List<Elfo> novaList = new ArrayList<>();
        int contNoturno=0, total=0;
        //so elfos vivos atacam e com flechas
        for(int i =0;i<atacantes.size();i++){
            if(atacantes.get(i).getStatus() == Status.VIVO && atacantes.get(i).getFlecha().getQuantidade()>0  && (atacantes.get(i) instanceof ElfoVerde || atacantes.get(i) instanceof ElfoNoturno)){    
                if(atacantes.get(i) instanceof ElfoVerde){
                    novaList.add(atacantes.get(i));
                }else{
                    novaList.add(atacantes.get(i));
                    contNoturno++;
                }
                total++;
            }
        }

        for(int i=0;i<novaList.size();i++){
            int a=(int)(total*0.30);
            if(a < contNoturno){
                if(novaList.get(i) instanceof ElfoNoturno){
                    novaList.remove(i);
                    contNoturno--;
                }
            }else{
                break;
            }
        }

        if(novaList.size()>0){
            ordenar(novaList);
        }
        return novaList;
    }

    private void ordenar(List<Elfo> novaList){
        for(int i=1;i<novaList.size();i++){
            Elfo atual = novaList.get(i);
            int j = i-1;
            while((j>=0) && (atual.getFlecha().getQuantidade()< novaList.get(i).getFlecha().getQuantidade())){
                novaList.set(j+1, novaList.get(j));
                j--;
            }
            novaList.set(j+1, atual);
        }
    }
}
