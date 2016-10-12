import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaLittleMumuTest{
    @Test
    public void getOrdemDeAtaqueVerificaTamanhoDeAcordoCom30Porcento() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaLittleMumu e = new EstrategiaLittleMumu();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a"), new ElfoVerde("a"), new ElfoNoturno("b")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(3,ret.size());
    }
    
    @Test
    public void getOrdemDeAtaqueVerificaCom2Elementos() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaLittleMumu e = new EstrategiaLittleMumu();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(1,ret.size());
    }
    
    @Test
    public void getOrdemDeAtaqueVerificaElfoMorto() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaLittleMumu e = new EstrategiaLittleMumu();
        ElfoNoturno legolas = new ElfoNoturno("Legolas");
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(legolas,new ElfoVerde("a"), new ElfoVerde("a"), new ElfoNoturno("b")));
        //act
        for(int i=0; i<1000000;i++){
            legolas.atirarFlecha(new Dwarf());
        }
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(2,ret.size());
    }

    @Test
    public void getOrdemDeAtaqueVerificaOrdem() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaLittleMumu e = new EstrategiaLittleMumu();
        List<Elfo> elfo = new ArrayList<>(Arrays.asList(new ElfoNoturno("b"),new ElfoVerde("a"), new ElfoVerde("a"), new ElfoNoturno("b")));
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(elfo.get(1),ret.get(0));
    }
    
    @Test
    public void getOrdemDeAtaqueVerificaNull() throws ContingenteDesproporcionalException{
        //arrange
        EstrategiaLittleMumu e = new EstrategiaLittleMumu();
        List<Elfo> elfo = null;
        //act
        List<Elfo> ret = e.getOrdemDeAtaque(elfo);
        //assert
        assertEquals(null, ret);
    }
}
