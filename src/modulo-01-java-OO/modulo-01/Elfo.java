public class Elfo{
    private String nome;
    private int xp;
    private Status status;
    private Inventario inventario;

    public Elfo(String nome){
        this(nome, 42);
    }
    // == para comparar enum ou equals
    public Elfo(String nome, int quantidadeFlecha){
        this.nome=nome;
        this.inventario = new Inventario();
        this.inventario.adicionarItem(new Item("Arco",1));
        this.inventario.adicionarItem(new Item("Flecha", quantidadeFlecha >=0 ? quantidadeFlecha : 42));
        this.status = status.VIVO;
    }

    public Status getStatus(){
        return this.status;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getNome(){
        return this.nome;
    }

    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }

    public int getXp(){
        return this.xp;
    }

    public Item getArco(){
        return this.inventario.getItens().get(0);
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