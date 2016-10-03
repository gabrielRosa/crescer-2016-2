import java.util.ArrayList;

public class HobbitContador{ 
    public int calcularDiferenca(ArrayList <ArrayList<Integer>> arrayDePares){
        int retorno =0;
        for(int i=0;i<arrayDePares.size();i++){
            int produto = arrayDePares.get(i).get(0) * arrayDePares.get(i).get(1);
            int primeiro = arrayDePares.get(i).get(0);
            int segundo = arrayDePares.get(i).get(1);
            int auxiliar=0;
            int mmc=0;
            if (segundo>primeiro){
                primeiro ^= segundo;
                segundo ^= primeiro;
                primeiro ^= segundo;
            }
            if ((primeiro%segundo)==0){
                mmc=primeiro;
            }else{
                for (int j=2;j<=segundo;j++){
                    auxiliar=primeiro*j;
                    if ((auxiliar%segundo)==0){
                        mmc=auxiliar;
                        break;
                    }
                }
            }
            retorno += produto - mmc;
        }
        return retorno;
    }
}
