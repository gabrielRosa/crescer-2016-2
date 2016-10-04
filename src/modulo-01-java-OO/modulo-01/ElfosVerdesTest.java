import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest{
    @Test
    public void ganharItemEspadaDeAçoValiriano(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Elfo");
        //Act
        elfo.ganharItem(new Item("Espada de aço valiriano", 0));
        //Assert
        assertEquals("Espada de aço valiriano", elfo.getInventario().getItens().get(0).getDescricao());
    }

    @Test
    public void ganharItemArcoEFlechaDeVidro(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Elfo");
        //Act
        elfo.ganharItem(new Item("Arco e Flecha de Vidro", 0));
        //Assert
        assertEquals("Arco e Flecha de Vidro", elfo.getInventario().getItens().get(0).getDescricao());
    }

    @Test
    public void ganharItemArcoEFlechaDeVidroEEspadaDeAçoValiriano(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Elfo");
        //Act
        elfo.ganharItem(new Item("Arco e Flecha de Vidro", 0));
        elfo.ganharItem(new Item("Espada de aço valiriano", 0));
        //Assert
        assertEquals("Arco e Flecha de Vidro", elfo.getInventario().getItens().get(0).getDescricao());
        assertEquals("Espada de aço valiriano", elfo.getInventario().getItens().get(1).getDescricao());
    }

    @Test
    public void ganharItemDiferente(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Elfo");
        //Act
        elfo.ganharItem(new Item("Arco e Flecha Vidro", 0));
        //Assert
        assertEquals(0, elfo.getInventario().getItens().size());
    }

    @Test
    public void elfoAtiraUmaFlecha(){
        //arrange
        ElfoVerde legolas = new ElfoVerde("Elfo");
        //act
        legolas.atirarFlecha(new Dwarf());
        //assert
        assertEquals(2, legolas.getXp());
    }

    @Test
    public void elfoAtiraDuasFlecha(){
        //arrange
        ElfoVerde legolas = new ElfoVerde("Elfo");
        //act
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        //assert
        assertEquals(4, legolas.getXp());
    }

    @Test
    public void elfoAtira0Flecha(){
        //arrange
        ElfoVerde legolas = new ElfoVerde("Elfo");
        //act
        //assert
        assertEquals(0, legolas.getXp());
    }

}
