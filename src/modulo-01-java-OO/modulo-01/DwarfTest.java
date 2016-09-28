import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class DwarfTest{

    @Test
    public void dwarfComVida(){
        //Arrange
        int vida =110;
        //Act
        Dwarf  bruceWayne = new Dwarf();
        //Assert
        assertEquals(bruceWayne.getVida(),110);
    }

    @Test
    public void dwarfPerde10Vida(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act 
        dwarf.perderVida();
        //assert
        assertEquals(dwarf.getVida(),100);
    }
    
    @Test
    public void dwarfPerde20Vida(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act 
        dwarf.perderVida();
        dwarf.perderVida();
        //assert
        assertEquals(dwarf.getVida(),90);
    }

}
