import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest{
    @Test
    public void adiciona1ItemEPegarDescricao(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 1);
        //Act
        itens.adicionarItem(item);
        //Assert
        assertEquals(item.getDescricao(), itens.getItens().get(0).getDescricao());
    }

    @Test
    public void imprimirDescricaoTodas(){
        //arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 1);
        Item item2 = new Item("Espada2", 1);
        Item item3 = new Item("Espada3", 1);
        //act
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        //assert
        itens.getDescricoesItens();//duvida quanto a execucao do teste
    }

    @Test
    public void adiciona1ItemEPegarQuantidade2(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 2);
        //Act
        itens.adicionarItem(item);
        //Assert
        assertEquals(item.getQuantidade(), itens.getItens().get(0).getQuantidade());
    }

    @Test
    public void adiciona1ItemEPegarQuantidade20(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 20);
        //Act
        itens.adicionarItem(item);
        //Assert
        assertEquals(20, itens.getItens().get(0).getQuantidade());
    }

    @Test
    public void adiciona1ItemERemover1Item(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 2);
        //Act
        itens.adicionarItem(item);
        itens.removerItem(item);
        //Assert
        assertEquals(0, itens.getItens().size());
    }

    @Test
    public void adiciona1ItemERemover1ItemComMaiItensNoArray(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 2);
        Item item2 = new Item("Espada mitica", 1);
        //Act
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.removerItem(item);
        //Assert
        assertEquals(1, itens.getItens().size());
        assertEquals(item2.getDescricao(), itens.getItens().get(0).getDescricao());
    }
    //TODO novos teste serao implementados 
}
