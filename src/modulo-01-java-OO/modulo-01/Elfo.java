public class Elfo{
    private String nome;
    private Item arco;
    private Item flecha;
    private double xp;

    public Elfo(String nome){
        this.nome=nome;
        this.arco= new Item("Arco",1);
        this.flecha=new Item("Flecha", 42);
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

    public void atirarFlecha(){
        flecha.setQuantidade(flecha.getQuantidade()-1);
        xp++;
    }

    public void caçarDwarve(Dwarve dwarve){
        if(dwarve.getVida()>0){
                atirarFlecha();
                dwarve.setVida(dwarve.getVida()-10);
        }
    }
}