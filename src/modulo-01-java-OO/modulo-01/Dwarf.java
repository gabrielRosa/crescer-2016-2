public class Dwarf{
    private int vida;
    private DataTerceiraEra dataNascimento;
    private String nome;

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this();
        this.nome=nome;
        this.dataNascimento=dataNascimento;
    }

    public Dwarf(){
        this.vida=110;
    }

    public void perderVida(){
        this.vida-=10;
    }

    public int getVida(){
        return this.vida;
    }

    public double getNumeroSorte(){
        double valorInicialRetorno = 101.0;
        if(this.dataNascimento.ehBissexto() && vida >=80 && vida<=90){
            return (valorInicialRetorno*-33);
        }else if((!this.dataNascimento.ehBissexto()) && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            return (valorInicialRetorno*33)%100;
        }
        return valorInicialRetorno;
    }
}
