

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
}
