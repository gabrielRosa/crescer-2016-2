import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CestoDeLembasTest{
    @Test
    public void testeLembas(){
        //Arrange
        CestoDeLembas lembas = new CestoDeLembas(12);
        boolean ret = false;
        //Act
        ret =lembas.podeDividirEmPares();
        //Assert
        assertEquals(true, ret);
    }
    
        @Test
    public void testeLembas2(){
        //Arrange
        CestoDeLembas lembas = new CestoDeLembas(10);
        boolean ret = false;
        //Act
        ret =lembas.podeDividirEmPares();
        //Assert
        assertEquals(false, ret);
    }
}