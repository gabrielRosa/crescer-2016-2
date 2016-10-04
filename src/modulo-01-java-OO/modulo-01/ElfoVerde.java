public class ElfoVerde extends Elfo{

    public ElfoVerde(String nome){
        super(nome);
        super.perderItem(super.getFlecha());
        super.perderItem(super.getArco());
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
}
