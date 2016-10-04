public class ElfoNoturno extends Elfo{
    public ElfoNoturno (String nome){
        super(nome);
    }

    public ElfoNoturno (String nome, int quantidade){
        super(nome, quantidade);
    }

    @Override
    public void atirarFlecha(Dwarf dwarf){
        if(super.getStatus() == Status.VIVO){
            super.atirarFlecha(dwarf,3);
            super.vida= this.vida - (super.vida/100)*5;
            if((int)super.vida == 0){
                super.status = Status.MORTO;
            }
        }
    }
}
