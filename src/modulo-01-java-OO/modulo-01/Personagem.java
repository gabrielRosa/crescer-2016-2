public class Personagem{
    protected String nome;
    protected Inventario inventario;
    protected Status status;
    protected int xp;
    protected double vida;

    public Personagem(String nome){
        this.nome= nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getNome(){
        return this.nome;
    }

    public double getVida(){
        return this.vida;
    }

    public Status getStatus(){
        return this.status;
    }

    public int getXp(){
        return this.xp;
    }

    public Inventario getInventario(){
        return this.inventario;
    }
    //duvida quanto ao metodo
    public void perderItem(Item item){
        this.inventario.getItens().remove(item);
    }

    public void ganharItem(Item item){
        this.inventario.getItens().add(item);
    }
}
