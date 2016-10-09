public class NaoPodeAlistarException extends Exception{
    public NaoPodeAlistarException(){
        super("Nao pode alistar");
    }

    public NaoPodeAlistarException(String erro){
        super(erro);
    }
}
