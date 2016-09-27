
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
        Dwarves dwarve1 = new Dwarves("Dwarve1");
        int vida=dwarve1.getVida();
        int numeroDeFlechas =elfo1.numeroFlechas();
        //Act
        elfo1.caçarDwarves(dwarve1);
        //Assert
        assertEquals(dwarve1.getVida(),vida-10);
        assertEquals(elfo1.numeroFlechas(), numeroDeFlechas -1);
    }

    @Test
    public void elfoCaçaMuitoDwarves(){
        //Arrange
        Elfo elfo1 = new Elfo("Elfo1");
        Dwarves dwarve1 = new Dwarves("Dwarve1");	
        //Act
        for(int i=0;i<43;i++){
            elfo1.caçarDwarves(dwarve1);
        }
        //Assert
        assertEquals(dwarve1.getVida(),0);
        assertEquals(elfo1.numeroFlechas(), 31);
    }
}
