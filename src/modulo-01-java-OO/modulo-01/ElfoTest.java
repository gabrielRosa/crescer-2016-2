
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
