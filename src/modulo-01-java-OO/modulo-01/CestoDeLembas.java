public class CestoDeLembas{
    private int quantidade;

    public CestoDeLembas(int quantidade){
        this.quantidade = quantidade;
    }

    public boolean podeDividirEmPares(){
        return (this.quantidade>2 && this.quantidade<=100 && this.quantidade%2==0);
    }
}
