
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome(){
        //Arrange
        String nomeEsperado = "Bruce Wayne";
        //Act
        Elfo bruceWayne = new Elfo(nomeEsperado);
        //Assert
        assertEquals(nomeEsperado,bruceWayne.getNome());
    }

    @Test
    public void elfoNasceComArco(){
    }

    @Test
    public void elfoNasceCom42Flechas(){
        //act
        Elfo elfoDoTeste = new Elfo("Elrond");
        //assert
        assertEquals("Flecha", elfoDoTeste.getFlecha().getDescricao());

    }

    @Test
    public void elfoAtiraUmaFlecha(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        legolas.atirarFlecha(new Dwarf());
        //assert
        assertEquals(41, legolas.getFlecha().getQuantidade());
        assertEquals(1, legolas.getXp());
    }

    @Test
    public void elfoAtiraDuasFlecha(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        //assert
        assertEquals(40, legolas.getFlecha().getQuantidade());
        assertEquals(2, legolas.getXp());
    }

    @Test
    public void elfoAtira42Flecha(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        for(int i=0;i<42;i++){
            legolas.atirarFlecha(new Dwarf());
        }
        //assert
        assertEquals(0, legolas.getFlecha().getQuantidade());
        assertEquals(42, legolas.getXp());
    }

    @Test
    public void elfoAtiraFlechaUmDwarf(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        Dwarf dwarf = new Dwarf();
        //act
        legolas.atirarFlecha(dwarf);
        //assert
        assertEquals(100, dwarf.getVida());
    }

    @Test 
    public void testDoToString(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        String ret = legolas.toString();
        //assert
        assertEquals("Elfo possui 42 flechas e 0 nível de experiência.", ret);
    }

    @Test 
    public void testDoToStringComAtirarFlecha(){
        //arrange
        Elfo legolas = new Elfo("Elfo");
        //act
        legolas.atirarFlecha(new Dwarf());
        String ret = legolas.toString();
        //assert
        assertEquals("Elfo possui 41 flechas e 1 nível de experiência.", ret);
    }

    @Test 
    public void testNovoConstrutorNomeE100Flechas(){
        //arrange
        Elfo legolas = new Elfo("Elfo",100);
        //act
        int flechas = legolas.getFlecha().getQuantidade();
        //assert
        assertEquals(100, flechas);
    }

    @Test 
    public void testNovoConstrutorNomeE0Flechas(){
        //arrange
        Elfo legolas = new Elfo("Elfo",0);
        //act
        int flechas = legolas.getFlecha().getQuantidade();
        //assert
        assertEquals(0, flechas);
    }

    @Test 
    public void testNovoConstrutorNomeEFlechasTesteDoNome(){
        //arrange
        Elfo legolas = new Elfo("Elfo",0);
        //act
        //assert
        assertEquals("Elfo", legolas.getNome());
    }

}
