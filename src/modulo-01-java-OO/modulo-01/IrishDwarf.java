public class IrishDwarf{
    private int vida;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private int xp;
    private Status status;
    private Inventario inventario;

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome=nome;
        this.dataNascimento=dataNascimento;
        this.vida=110;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }

    public IrishDwarf(){
        this(null, new DataTerceiraEra(1,1,1));
    }

    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }

    public Inventario getInventario(){
        return this.inventario;
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

    public Status getStatus(){
        return this.status;
    }

    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333){
            for(int j=0;j<this.inventario.getItens().size();j++){
                int numero=0;
                //Alternativa otimizada abaixo
                //int resultado = quantidadeAbsoluta * (quantidadeAbsoluta + 1) / 2;
                for(int i=Math.abs(this.inventario.getItens().get(j).getQuantidade()); i!=0 ;i--){
                    numero+=i;
                }
                this.inventario.getItens().get(j).aumentarUnidades(1000*numero);
            }
        }
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
