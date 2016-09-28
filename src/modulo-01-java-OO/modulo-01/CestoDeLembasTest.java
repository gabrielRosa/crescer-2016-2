import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CestoDeLembasTest{
    @Test
    public void numeroParLembas(){
        //Arrange
        CestoDeLembas lembas = new CestoDeLembas(12);
        boolean ret = false;
        //Act
        ret =lembas.podeDividirEmPares();
        //Assert
        assertTrue(ret);
    }
    
    @Test
    public void numeroNegativoLembas(){
        //Arrange
        CestoDeLembas lembas = new CestoDeLembas(-100);
        boolean ret = false;
        //Act
        ret =lembas.podeDividirEmPares();
        //Assert
        assertFalse(ret);
    }

    @Test
    public void numeroImparLembas(){
        //Arrange
        CestoDeLembas lembas = new CestoDeLembas(11);
        boolean ret = false;
        //Act
        ret =lembas.podeDividirEmPares();
        //Assert
        assertFalse(ret);
    }
}