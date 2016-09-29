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

    @Test 
    public void testNovoConstrutorDwarfDataTerceiraEraNome(){
        //arrange //act // assert
        Dwarf dwarf = new Dwarf("Dwarf", new DataTerceiraEra(12,02,1990));
    }

    @Test
    public void testGetNumeroSorteRetornoValorInicial(){
        //arrange
        Dwarf dwarf = new Dwarf("Dwarf", new DataTerceiraEra(12,02,1990));
        //act
        double ret = dwarf.getNumeroSorte();
        boolean test = 101.0==ret;
        //assert
        assertTrue(test);
    }

    @Test
    public void testGetNumeroSorteRetornoValorMultiplicaMenos33EBissexto(){
        //arrange
        Dwarf dwarf = new Dwarf("Dwarf", new DataTerceiraEra(12,02,1996));
        //act
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        double ret = dwarf.getNumeroSorte();
        boolean test = (101.0*-33)==ret;
        //assert
        assertTrue(test);
    }

    @Test
    public void testGetNumeroSorteRetornoValorMultiplicaMais33ENaoBissextoSeixas(){
        //arrange
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(12,02,1995));
        //act
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        double ret = dwarf.getNumeroSorte();
        boolean test = ((101.0*33)%100)==ret;
        //assert
        assertTrue(test);
    }

    @Test
    public void testGetNumeroSorteRetornoValorMultiplicaMais33ENaoBissextoMeireles(){
        //arrange
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(12,02,1995));
        //act
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        double ret = dwarf.getNumeroSorte();
        boolean test = ((101.0*33)%100)==ret;
        //assert
        assertTrue(test);
    }

    @Test
    public void testPerderVida(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        dwarf.perderVida();
        //assert
        assertEquals(0,dwarf.getXp());
    }

    @Test
    public void testMorteNegada(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        dwarf.perderVida();
        //assert
        assertEquals(Status.VIVO,dwarf.getStatus());
    }

    @Test
    public void testMorteConfirmada(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        for(int i=0;i<=11;i++){
            dwarf.perderVida();
        }
        //assert
        assertEquals(Status.MORTO,dwarf.getStatus());
    }

}
