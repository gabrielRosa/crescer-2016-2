import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{
    @Test
    public void alistarUmElfoVerde(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        exercito.alistar(elfoVerde);
        //assert
        assertEquals(elfoVerde, exercito.getExercito()[0]);
    }

    @Test
    public void alistarUmElfoNorturno(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        //act
        exercito.alistar(elfoNoturno);
        //assert
        assertEquals(elfoNoturno, exercito.getExercito()[0]);
    }

    @Test
    public void alistarUmElfoNorturnoEUmVerde(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        exercito.alistar(elfoNoturno);
        exercito.alistar(elfoVerde);
        //assert
        assertEquals(elfoNoturno, exercito.getExercito()[0]);
        assertEquals(elfoVerde, exercito.getExercito()[1]);
    }

    @Test
    public void alistarUmElfoNorturnoEUmVerdeEUmNormal(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        Elfo elfo = new Elfo("Elfo verde");
        //act
        exercito.alistar(elfoNoturno);
        exercito.alistar(elfoVerde);
        exercito.alistar(elfo);
        //assert
        assertEquals(elfoNoturno, exercito.getExercito()[0]);
        assertEquals(elfoVerde, exercito.getExercito()[1]);
        assertEquals(2, exercito.getExercito().length);
    }
    
    @Test
    public void buscarUmElfoVerdePeloNome(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        exercito.alistar(elfoVerde);
        //assert
        assertEquals(elfoVerde, exercito.buscar("Elfo verde"));
    }
    
    @Test
    public void buscarUmElfoVerdePeloNomeQueNaoExiste(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        exercito.alistar(elfoVerde);
        //assert
        assertEquals(null, exercito.buscar("Elfo Azul"));
    }
    
    @Test
    public void buscarComVariosEMesmoNome(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        Elfo elfo = new Elfo("Elfo verde");
        //act
        exercito.alistar(elfoNoturno);
        exercito.alistar(elfoVerde);
        exercito.alistar(elfo);
        //assert
        assertEquals(elfoNoturno, exercito.buscar("Elfo verde"));
    }
    
    @Test
    public void buscarComVariosEMesmoNomeENomeNaoExiste(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        Elfo elfo = new Elfo("Elfo verde");
        //act
        exercito.alistar(elfoNoturno);
        exercito.alistar(elfoVerde);
        exercito.alistar(elfo);
        //assert
        assertEquals(null, exercito.buscar("Elfo laranja"));
    }
}
