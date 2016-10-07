import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNoturnosPorUltimoTest{
    @Test
    public void getOrdemDeAtaqueVerificaOrdemNoturnoEDepoisVerde(){
        //arrange
        EstrategiaNoturnosPorUltimo e = new EstrategiaNoturnosPorUltimo();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(elfo.get(1), ret.get(0));
    }

    @Test
    public void getOrdemDeAtaqueVerificaOrdemVerdeEDepoisNoturno(){
        //arrange
        EstrategiaNoturnosPorUltimo e = new EstrategiaNoturnosPorUltimo();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoVerde("a"),new ElfoNoturno("b")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(elfo.get(0), ret.get(0));
    }
}
