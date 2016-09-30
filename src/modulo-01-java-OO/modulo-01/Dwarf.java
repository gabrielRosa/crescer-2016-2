public class Dwarf{
    private int vida;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private int xp;
    private Status status;

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome=nome;
        this.dataNascimento=dataNascimento;
        this.vida=110;
        this.status = Status.VIVO;
    }

    public Dwarf(){
        this(null, new DataTerceiraEra(1,1,1));
    }

    public void perderVida(){
        double numero = this.getNumeroSorte();
        if(numero <0)
            this.xp +=2;
        if(numero>100){
            if(this.vida>0)
                this.vida-=10;
            else
                this.vida=0;
        }
        if(this.vida==0)
            this.status = Status.MORTO;
    }

    public Status getStatus(){
        return this.status;
    }

    public int getVida(){
        return this.vida;
    }

    public int getXp(){
        return this.xp;
    }

    public double getNumeroSorte(){
        double valorInicialRetorno = 101.0;
        if(this.dataNascimento.ehBissexto() && vida >=80 && vida<=90){
            return valorInicialRetorno*-33;
        }else if(!this.dataNascimento.ehBissexto() && "Seixas".equals(this.nome) || "Meireles".equals(this.nome)){
            return valorInicialRetorno*33%100;
        }
        return valorInicialRetorno;
    }
}
