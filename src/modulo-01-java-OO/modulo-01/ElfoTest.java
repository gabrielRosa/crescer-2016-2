
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome(){
        //Arrange
        String nomeEsperado = "Bruce Wayne";
        //Act
        Elfo bruceWayne = new Elfo(nomeEsperado);
        //Assert
        assertEquals(nomeEsperado,bruceWayne.getNome());
    }

    @Test
    public void elfoNasceComArco(){
    }

    @Test
    public void elfoNasceCom42Flechas(){
        //act
        Elfo elfoDoTeste = new Elfo("Elrond");
        //assert
        assertEquals("Flecha", elfoDoTeste.getFlecha().getDescricao());

    }

    @Test
    public void elfoAtiraUmaFlecha(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        legolas.atirarFlecha();
        //assert
        assertEquals(41, legolas.getFlecha().getQuantidade());
        assertEquals(1, legolas.getXp());
    }

    @Test
    public void elfoAtiraDuasFlecha(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        legolas.atirarFlecha();
        legolas.atirarFlecha();
        //assert
        assertEquals(40, legolas.getFlecha().getQuantidade());
        assertEquals(2, legolas.getXp());
    }

    @Test
    public void elfoAtira42Flecha(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        for(int i=0;i<42;i++){
            legolas.atirarFlecha();
        }
        //assert
        assertEquals(0, legolas.getFlecha().getQuantidade());
        assertEquals(42, legolas.getXp());
    }

    @Test
    public void elfoCaçaDwarves(){
        //Arrange
        Elfo elfo1 = new Elfo("Elfo1");
        Dwarve dwarve1 = new Dwarve();
        int numeroDeFlechas =elfo1.getFlecha().getQuantidade();
        //Act
        elfo1.caçarDwarve(dwarve1);
        //Assert
        assertEquals(100, dwarve1.getVida());
        assertEquals(41, elfo1.getFlecha().getQuantidade()); 
    }

    @Test
    public void elfoCaçaMuitoDwarve(){
        //Arrange
        Elfo elfo1 = new Elfo("Elfo1");
        Dwarve dwarve1 = new Dwarve();	
        //Act
        for(int i=0;i<12;i++){
            elfo1.caçarDwarve(dwarve1);
        }
        //Assert
        assertEquals(dwarve1.getVida(),0);
        assertEquals(elfo1.getFlecha().getQuantidade(), 31);
    }
}
