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

    @Test
    public void testaEhBissextoAno3000(){
        //arrange
        DataTerceiraEra data = new DataTerceiraEra(23,02,3000);
        //act
        boolean retorno = data.ehBissexto();
        //assert
        assertFalse(retorno);
    }

    @Test
    public void testaEhBissextoAno1999(){
        //arrange
        DataTerceiraEra data = new DataTerceiraEra(23,02,1999);
        //act
        boolean retorno = data.ehBissexto();
        //assert
        assertFalse(retorno);
    }

    @Test
    public void testaEhBissextoAno1998(){
        //arrange
        DataTerceiraEra data = new DataTerceiraEra(23,02,1998);
        //act
        boolean retorno = data.ehBissexto();
        //assert
        assertFalse(retorno);
    }

    @Test
    public void testaEhBissexto2090(){
        assertFalse(new DataTerceiraEra(1,9,2090).ehBissexto());
    }
}
