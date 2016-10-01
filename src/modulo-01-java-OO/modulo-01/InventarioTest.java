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
    public void adicionar2ItensNoInventario(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 1);
        Item item2 = new Item("Espada quebrada", 10);
        //act
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        //assert
        assertTrue(itens.getItens().contains(item));
        assertTrue(itens.getItens().contains(item2));
    }

    @Test
    public void imprimirDescricaoTodas(){
        //arrange
        Inventario itens = new Inventario();
        Item item = new Item("Adaga", 1);
        Item item2 = new Item("Escudo", 1);
        Item item3 = new Item("Bracelete", 1);
        //act
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        //assert
        assertEquals("Adaga,Escudo,Bracelete", itens.getDescricoesItens());
    }

    @Test
    public void imprimirDescricaoNada(){
        //arrange //act
        Inventario itens = new Inventario();
        //assert
        assertEquals("", itens.getDescricoesItens());
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

    @Test
    public void itemMaisPopularCom2Itens(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 2);
        Item item2 = new Item("Espada mitica", 1);
        //Act
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        //assert
        assertEquals(item, itens.itemMaisPopular());
    }

    @Test
    public void itemMaisPopularCom3Itens(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 2);
        Item item2 = new Item("Espada mitica", 1);
        Item item3 = new Item("Escudo mitica", 10);
        //Act
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        //assert
        assertEquals(item3, itens.itemMaisPopular());
    }

    @Test
    public void ordenarItens6Itens(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 10);
        Item item2 = new Item("Espada mitica", 1100);
        Item item3 = new Item("Escudo mitica", 0);
        Item item4 = new Item("Espada", 2);
        Item item5 = new Item("Espada mitica", 1);
        Item item6 = new Item("Escudo mitica", 109);
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        itens.adicionarItem(item4);
        itens.adicionarItem(item5);
        itens.adicionarItem(item6);
        String valorFinal ="";
        //act
        itens.ordenarItens();
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("0 1 2 10 109 1100 ", valorFinal);
    }

    @Test
    public void ordenarItens0Itens(){
        //Arrange
        Inventario itens = new Inventario();
        String valorFinal ="";
        //act
        itens.ordenarItens();
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("", valorFinal);
    }
}
