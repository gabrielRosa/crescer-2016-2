import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class DwarvesTest{
    @Test
    public void dwarveNasceComNome(){
        //Arrange
        String nomeEsperado = "Bruce Wayne";
        //Act
        Dwarves  bruceWayne = new Dwarves(nomeEsperado);
        //Assert
        assertEquals(nomeEsperado,bruceWayne.getNome());
    }

    @Test
    public void dwarveComVida(){
        //Arrange
        int vida =110;
        //Act
        Dwarves  bruceWayne = new Dwarves("Dwarves");
        //Assert
        assertEquals(bruceWayne.getVida(),110);
    }

}
