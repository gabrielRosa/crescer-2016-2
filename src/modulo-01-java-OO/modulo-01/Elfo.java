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

    public int numeroFlechas(){
        return flecha.getQuantidade();
    }

    public boolean atirarFlecha(){
        if(flecha.getQuantidade()<=0){
            return false;
        }
        flecha.setQuantidade(flecha.getQuantidade()-1);
        xp++;
        return true;
    }

    public void caçarDwarves(Dwarves dwarves){
        if(dwarves.getVida()>0){
            if(this.atirarFlecha()){
                dwarves.setVida(dwarves.getVida()-10);
            }
        }
    }
}