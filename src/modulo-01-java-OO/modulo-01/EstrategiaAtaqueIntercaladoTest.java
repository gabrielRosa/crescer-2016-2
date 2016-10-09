import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest{
    @Test
    public void getOrdemDeAtaqueVerificaOrdemNoturnoEDepoisVerde() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaAtaqueIntercalado e = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a"), new ElfoVerde("a"), new ElfoNoturno("b")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(elfo.get(1), ret.get(0));
    }
}
