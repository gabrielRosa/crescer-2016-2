public class Elfo extends Personagem{
    protected double vida;

    public Elfo(String nome){
        this(nome, 42);
    }
    // == para comparar enum ou equals
    //mehor chamar o super em vez do this.nome=nome
    public Elfo(String nome, int quantidadeFlecha){
        super(nome);
        this.inventario.adicionarItem(new Item("Arco",1));
        this.inventario.adicionarItem(new Item("Flecha", quantidadeFlecha >=0 ? quantidadeFlecha : 42));
        this.vida=100;
    }
    //TODO arrumar o index
    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }

    public Item getArco(){
        return this.inventario.getItens().get(0);
    }

    public double getVida(){
        return this.vida;
    }

    public String toString(){
        return this.nome + " possui " + this.getFlecha().getQuantidade()+" flechas e " + this.xp+ " níveis de experiência.";
    }

    public void atirarFlecha(Dwarf dwarf){
        if(getFlecha().getQuantidade()>0){
            getFlecha().setQuantidade(getFlecha().getQuantidade()-1);
            this.xp++;
            dwarf.perderVida();
        }
    }
}