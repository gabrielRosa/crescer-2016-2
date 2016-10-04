public class ElfoNoturno extends Elfo{
    public ElfoNoturno (String nome){
        super(nome);
    }
    
    public ElfoNoturno (String nome, int quantidade){
        super(nome, quantidade);
    }

    @Override
    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        super.xp+=2;
        super.vida= this.vida - (super.vida/100)*5;
    }
}
