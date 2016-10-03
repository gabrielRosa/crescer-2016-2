public class Dwarf extends Personagem{
    protected int vida;
    protected DataTerceiraEra dataNascimento;
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome);
        this.dataNascimento=dataNascimento;
        this.vida=110;
    }

    public Dwarf(){
        this(null, new DataTerceiraEra(1,1,1));
    }

    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }

    public void perderItem(Item item){
        this.inventario.removerItem(item);
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

    public void tentarSorte(){
        if(this.getNumeroSorte() ==-3333){
            inventario.aumentarUnidadesDosItens(1000);
        }
    }

    public int getVida(){
        return this.vida;
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
