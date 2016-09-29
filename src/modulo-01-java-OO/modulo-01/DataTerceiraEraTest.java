import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest{
    @Test
    public void testaConstrutorDataTerceiraEraDiaMesAno(){
        //arrange //act
        DataTerceiraEra data = new DataTerceiraEra(23,02,1997);
        //
        assertEquals(23, data.getDia());
        assertEquals(02, data.getMes());
        assertEquals(1997, data.getAno());
    }

    @Test
    public void testaEhBissextoFalso(){
        //arrange
        DataTerceiraEra data = new DataTerceiraEra(23,02,1997);
        //act
        boolean retorno = data.ehBissexto();
        //assert
        assertFalse(retorno);
    }
    
    @Test
    public void testaEhBissextoTrue(){
        //arrange
        DataTerceiraEra data = new DataTerceiraEra(23,02,2000);
        //act
        boolean retorno = data.ehBissexto();
        //assert
        assertTrue(retorno);
    }
}
