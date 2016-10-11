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
        try{
            exercito.alistar(elfoVerde);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(elfoVerde, exercito.getContingente()[0]);
    }

    @Test
    public void alistarUmElfoNorturno(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        //act
        try{
            exercito.alistar(elfoNoturno);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(elfoNoturno, exercito.getContingente()[0]);
    }

    @Test
    public void alistarUmElfoNorturnoEUmVerde(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        try{
            exercito.alistar(elfoNoturno);
            exercito.alistar(elfoVerde);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(elfoNoturno, exercito.getContingente()[0]);
        assertEquals(elfoVerde, exercito.getContingente()[1]);
    }

    @Test
    public void alistarUmElfoNorturnoEUmVerdeEUmNormal(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde");
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        Elfo elfo = new Elfo("Elfo verde");
        //act
        try{
            exercito.alistar(elfoNoturno);
            exercito.alistar(elfoVerde);
            exercito.alistar(elfo);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(elfoNoturno, exercito.getContingente()[0]);
        assertEquals(elfoVerde, exercito.getContingente()[1]);
        assertEquals(2, exercito.getContingente().length);
    }

    @Test
    public void buscarUmElfoVerdePeloNome(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        try{
            exercito.alistar(elfoVerde);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(elfoVerde, exercito.buscar("Elfo verde"));
    }

    @Test
    public void buscarUmElfoVerdePeloNomeQueNaoExiste(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        try{
            exercito.alistar(elfoVerde);
        }catch(Exception e){
            e.toString();
        }
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
        try{
            exercito.alistar(elfoNoturno);
            exercito.alistar(elfoVerde);
            exercito.alistar(elfo);
        }catch(Exception e){
            e.toString();
        }
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
        try{
            exercito.alistar(elfoNoturno);
            exercito.alistar(elfoVerde);
            exercito.alistar(elfo);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(null, exercito.buscar("Elfo laranja"));
    }

    @Test
    public void buscarUmElfoVerdeComVida(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfo verde");
        //act
        try{
            exercito.alistar(elfoVerde);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(elfoVerde, exercito.buscar(Status.VIVO).get(0));
    }

    @Test
    public void buscarUmElfoNorturnoMorto(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde", 200);
        //act
        try{
            exercito.alistar(elfoNoturno);
            for(int i=0;i<200;i++){
                elfoNoturno.atirarFlecha(new Dwarf());
            }
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertEquals(elfoNoturno, exercito.buscar(Status.MORTO).get(0));
    }

    @Test
    public void buscarUmElfoNorturnoMortoPoremEleEstaVivo(){
        //arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo verde", 200);
        //act
        try{
            exercito.alistar(elfoNoturno);
        }catch(Exception e){
            e.toString();
        }
        //assert
        assertTrue(exercito.buscar(Status.MORTO).isEmpty());
    }

}
