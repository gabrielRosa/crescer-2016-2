public class ElfoNoturno extends Elfo{
    public ElfoNoturno (String nome){
        super(nome);
    }

    public ElfoNoturno (String nome, int quantidade){
    super(nome, quantidade);
    }
     */
    //nao é posssivel zerar, apenas chegar perto do 0
    @Override
    public void atirarFlecha(Dwarf dwarf){
        if(super.getStatus() == Status.VIVO && super.getFlecha().getQuantidade()>0){
            super.atirarFlecha(dwarf,3);
            super.vida= this.vida - (super.vida/100)*5;
            if((int)super.vida == 0){
                super.status = Status.MORTO;
            }
        }
    }
}
