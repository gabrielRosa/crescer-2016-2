public class Elfo{
    private String nome;
    private Item arco;
    private Item flecha;
    private int xp;

    public Elfo(String nome){
        this.nome=nome;
        this.arco= new Item("Arco",1);
        this.flecha=new Item("Flecha", 42);
        this.xp =0;
    }

    public Elfo(String nome, int quantidadeFlecha){
        this.nome=nome;
        this.arco= new Item("Arco",1);
        this.flecha=new Item("Flecha", quantidadeFlecha);
        this.xp =0;
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

    @Override
    public String toString(){
        boolean flechaNoSingular = this.flecha.getQuantidade() < 2;
        boolean experienciaNoSingular = this.xp < 2;
        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            this.flecha.getQuantidade(),
            flechaNoSingular ? "flecha" : "flechas",
            this.xp,
            experienciaNoSingular ? "nível" : "níveis");
        //return this.nome + " possui " + this.flecha.getQuantidade() + " flecha(s) e " + this.xp + " nível(s) de experiência.";
    }

    public void atirarFlecha(Dwarf dwarf){
        if(flecha.getQuantidade()>0){
            flecha.setQuantidade(flecha.getQuantidade()-1);
            this.xp++;
            dwarf.perderVida();
        }
    }
}