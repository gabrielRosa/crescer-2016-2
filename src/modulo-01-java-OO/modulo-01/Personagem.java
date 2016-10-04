public class Personagem{
    protected String nome;
    protected Inventario inventario;
    protected Status status;
    protected int xp;

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

    public Status getStatus(){
        return this.status;
    }

    public int getXp(){
        return this.xp;
    }

    public Inventario getInventario(){
        return this.inventario;
    }
}
