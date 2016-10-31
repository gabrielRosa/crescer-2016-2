import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest{
    @Test
    public void aumentarUnidades1000(){
        //arrange
        Item item = new Item("Escudo", 100);
        //act
        item.aumentarUnidades(1000);
        //assert
        assertEquals(1100, item.getQuantidade());
    }
}
