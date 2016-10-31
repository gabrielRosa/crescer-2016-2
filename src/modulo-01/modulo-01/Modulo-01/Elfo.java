public class Elfo extends Personagem{
    //final para finalizar a classe ou seja não pode herda-la
    private static int quantidadeElfos;
    public Elfo(String nome){
        this(nome, 42);
    }
    // == para comparar enum ou equals
    //mehor chamar o super em vez do this.nome=nome
    public Elfo(String nome, int quantidadeFlecha){
        super(nome);
        this.vida=100;
        inicializarInventario(quantidadeFlecha);
        quantidadeElfos++;
    }
    //TODO arrumar o index
    public Item getFlecha(){
        return this.inventario.getItens().get(1);
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        Elfo.quantidadeElfos--;
    }

    public static int getQuantidadeElfos(){
        return quantidadeElfos;
    }

    public Item getArco(){
        return this.inventario.getItens().get(0);
    }

    public String toString(){
        return this.nome + " possui " + this.getFlecha().getQuantidade()+" flechas e " + this.xp+ " níveis de experiência.";
    }

    public void atirarFlecha(Dwarf dwarf){
        atirarFlecha(dwarf, 1);
    }

    public void inicializarInventario(int quantidadeFlecha){
        this.inventario.adicionarItem(new Item("Arco",1));
        this.inventario.adicionarItem(new Item("Flecha", quantidadeFlecha >=0 ? quantidadeFlecha : 42));
    }

    protected void atirarFlecha(Dwarf dwarf, int fatorExperiencia){
        if(getFlecha().getQuantidade()>0){
            getFlecha().setQuantidade(getFlecha().getQuantidade()-1);
            this.xp += 1 * fatorExperiencia;
            dwarf.perderVida();
        }
    }

}