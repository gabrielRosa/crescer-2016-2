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
    public void dwarfAdcionaItem(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        dwarf.adicionarItem(new Item("Escudo", 2));
        //assert 
        //sem o get para fazer a verificação
    }

    @Test
    public void dwarfRemoverItem(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        dwarf.perderItem(new Item("Armadura", 2));
        //assert 
        //sem o get para fazer a verificação
    }

    @Test
    public void dwarfVivo(){
        //Arrange //Act
        Dwarf  bruceWayne = new Dwarf();
        //Assert
        assertEquals(Status.VIVO, bruceWayne.getStatus());
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
        for(int i=0;i<11;i++){
            dwarf.perderVida();
        }
        //assert
        assertEquals(Status.MORTO,dwarf.getStatus());
    }

    @Test
    public void testVidaPerde150DeVidaResultado0(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        for(int i=0;i<15;i++){
            dwarf.perderVida();
        }
        //assert
        assertEquals(0, dwarf.getVida());
    }

    @Test
    public void testVidaPerde100DeVidaResultado10(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        for(int i=0;i<10;i++){
            dwarf.perderVida();
        }
        //assert
        assertEquals(10, dwarf.getVida());
    }

    @Test
    public void testVidaPerde110DeVidaResultado0(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        for(int i=0;i<11;i++){
            dwarf.perderVida();
        }
        //assert
        assertEquals(0, dwarf.getVida());
    }

    @Test
    public void testVidaPerde10DeVidaResultado100(){
        //arrange
        Dwarf dwarf = new Dwarf();
        //act
        for(int i=0;i<1;i++){
            dwarf.perderVida();
        }
        //assert
        assertEquals(100, dwarf.getVida());
    }
    //TODO novos teste serao implementados
}
