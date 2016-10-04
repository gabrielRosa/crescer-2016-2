import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest{

    @Test
    public void elfoAtiraZeroFlecha(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        //Assert
        assertEquals(42, legolas.getFlecha().getQuantidade());
        assertEquals(0, legolas.getXp());
    }

    @Test
    public void elfoAtiraUmaFlecha(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        legolas.atirarFlecha(new Dwarf());
        //Assert
        assertEquals(41, legolas.getFlecha().getQuantidade());
        assertEquals(3, legolas.getXp());
    }

    @Test
    public void elfoAtiraDuasFlecha(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        //Assert
        assertEquals(40, legolas.getFlecha().getQuantidade());
        assertEquals(6, legolas.getXp());
    }

    @Test
    public void elfoAtiraTresFlecha(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        //Assert
        assertEquals(39, legolas.getFlecha().getQuantidade());
        assertEquals(9, legolas.getXp());
    }

    @Test
    public void elfoAtiraZeroFlechaComVida100(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        //Assert
        assertEquals(42, legolas.getFlecha().getQuantidade());
        assertEquals(0, legolas.getXp());
        assertEquals(100, legolas.getVida(),0);
    }

    @Test
    public void elfoAtiraUmaFlechaComVida95(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        legolas.atirarFlecha(new Dwarf());
        //Assert
        assertEquals(41, legolas.getFlecha().getQuantidade());
        assertEquals(3, legolas.getXp());
        assertEquals(95, legolas.getVida(),0);
    }

    @Test
    public void elfoAtiraDuasFlechaComVida90(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        //Assert
        assertEquals(40, legolas.getFlecha().getQuantidade());
        assertEquals(6, legolas.getXp());
        assertEquals(90.25, legolas.getVida(),0);
    }

    @Test
    public void elfoAtiraTresFlechaComVida85(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo");
        //Act
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        legolas.atirarFlecha(new Dwarf());
        //Assert
        assertEquals(39, legolas.getFlecha().getQuantidade());
        assertEquals(9, legolas.getXp());
        assertEquals(85.7375, legolas.getVida(), 0);

    }

    @Test
    public void elfoAtiraTresFlechaComVida(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo",100000);
        //Act
        for(int i=0; i<1000000;i++){
            legolas.atirarFlecha(new Dwarf());
        }
        //Assert
        assertEquals(Status.MORTO, legolas.getStatus());

    }
    
    @Test
    public void elfoAtiraFlechaSemFlecha(){
        //Arrange
        ElfoNoturno legolas = new ElfoNoturno("Elfo",90);
        //Act
        for(int i=0; i<1000000;i++){
            legolas.atirarFlecha(new Dwarf());
        }
        //Assert
        assertEquals(Status.MORTO, legolas.getStatus());

    }
}
