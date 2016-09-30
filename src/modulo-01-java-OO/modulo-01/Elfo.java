public class Elfo{
    private String nome;
    private Item arco;
    private Item flecha;
    private int xp;
    private Status status;

    public Elfo(String nome){
        this(nome, 42);
    }
    // == para comparar enum ou equals
    public Elfo(String nome, int quantidadeFlecha){
        this.nome=nome;
        this.arco= new Item("Arco",1);
        this.flecha=new Item("Flecha", quantidadeFlecha >=0 ? quantidadeFlecha : 42);
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
        return this.flecha;
    }

    public int getXp(){
        return this.xp;
    }

    public Item getArco(){
        return this.arco;
    }

    public String toString(){
        return this.nome + " possui " + this.flecha.getQuantidade()+" flechas e " + this.xp+ " níveis de experiência.";
    }

    public void atirarFlecha(Dwarf dwarf){
        if(flecha.getQuantidade()>0){
            flecha.setQuantidade(flecha.getQuantidade()-1);
            this.xp++;
            dwarf.perderVida();
        }
    }
}