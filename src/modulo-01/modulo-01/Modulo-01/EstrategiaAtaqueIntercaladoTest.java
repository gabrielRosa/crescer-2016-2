import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest{

    @Test
    public void getOrdemDeAtaqueVerificaOrdemNoturnoEDepoisVerdeCom4() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaAtaqueIntercalado e = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a"), new ElfoVerde("a"), new ElfoNoturno("b")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(elfo.get(1), ret.get(1));
    }

    @Test
    public void getOrdemDeAtaqueVerificaOrdemNoturnoEDepoisVerdeCom3() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaAtaqueIntercalado e = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a"), new ElfoVerde("a")));
        //act
        try{
            List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        } catch(ContingenteDesproporcionalException ex){
            //assert
            assertTrue(true);
        }
    }

    @Test
    public void getOrdemDeAtaqueVerificaOrdemNoturnoEDepoisVerdeCom8() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaAtaqueIntercalado e = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a"), new ElfoVerde("a"), new ElfoNoturno("b"),new ElfoNoturno("b"),new ElfoVerde("a"), new ElfoVerde("a"), new ElfoNoturno("b")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(elfo.get(0), ret.get(0));
    }

    @Test
    public void getOrdemDeAtaqueNula() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaAtaqueIntercalado e = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfo = new ArrayList<>();
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(new ArrayList<>(), ret);
    }

    @Test
    public void getOrdemDeAtaqueVerificaOrdemSoNoturno() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaAtaqueIntercalado e = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b")));
        //act
        try{
            List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        } catch(ContingenteDesproporcionalException ex){
            //assert
            assertTrue(true);
        }
    }

}
