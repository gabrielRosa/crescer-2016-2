import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class DwarveTest{

    @Test
    public void dwarveComVida(){
        //Arrange
        int vida =110;
        //Act
        Dwarve  bruceWayne = new Dwarve();
        //Assert
        assertEquals(bruceWayne.getVida(),110);
    }

}
