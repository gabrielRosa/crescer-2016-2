public class CestoDeLembas
{
    private int quantidade;
    public CestoDeLembas(int quantidade){
        this.quantidade = quantidade;
    }

    public boolean podeDividirEmPares(){
        int personagens=2;
        double div =this.quantidade/personagens;
        if(div>1 && div<=100){
            return true;
        }
        return false;
    }
}
