public class ElfoVerde extends Elfo{

    public ElfoVerde(String nome){
        super(nome);
    }

    @Override
    public void ganharItem(Item item){
        if(item != null && "Espada de aço valiriano".equals(item.getDescricao()) || "Arco e Flecha de Vidro".equals(item.getDescricao())){
            super.ganharItem(item);
        }
    }
    //duvida neste metodo
    public void atirarFlecha(Dwarf dwarf){
        dwarf.perderVida();
        super.xp+=2;
    }

    @Override
    public void inicializarInventario(int quantidadeFlecha){
        inventario.adicionarItem(new Item("Arco de vidro", 1));
        inventario.adicionarItem(new Item("Flecha de vidro", 100));
    }
}
