public class ExércitoDeElfos extends Exército{
    public ExércitoDeElfos(){
        super();
    }

    public void alistar(Personagem personagem){
        if(personagem instanceof ElfoVerde || personagem instanceof ElfoNoturno){
            super.adicionar(personagem);
        }
    }
    
    
}
