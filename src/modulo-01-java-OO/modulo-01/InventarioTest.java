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
    public void ordenarItens12Itens(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 10);
        Item item2 = new Item("Espada mitica", 1100);
        Item item3 = new Item("Escudo mitica", 0);
        Item item4 = new Item("Espada", 2);
        Item item5 = new Item("Espada mitica", 1);
        Item item6 = new Item("Escudo mitica", 109);
        Item item7 = new Item("Espada", 10);
        Item item8 = new Item("Espada mitica", 1100);
        Item item9 = new Item("Escudo mitica", 0);
        Item item10 = new Item("Espada", 2);
        Item item11 = new Item("Espada mitica", 1);
        Item item12 = new Item("Escudo mitica", 109);
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        itens.adicionarItem(item4);
        itens.adicionarItem(item5);
        itens.adicionarItem(item6);
        itens.adicionarItem(item7);
        itens.adicionarItem(item8);
        itens.adicionarItem(item9);
        itens.adicionarItem(item10);
        itens.adicionarItem(item11);
        itens.adicionarItem(item12);
        String valorFinal ="";
        //act
        itens.ordenarItens();
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("0 0 1 1 2 2 10 10 109 109 1100 1100 ", valorFinal);
    }

    @Test
    public void ordenarItens24Itens(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 10);
        Item item2 = new Item("Espada mitica", 1100);
        Item item3 = new Item("Escudo mitica", 0);
        Item item4 = new Item("Espada", 2);
        Item item5 = new Item("Espada mitica", 1);
        Item item6 = new Item("Escudo mitica", 109);
        Item item7 = new Item("Espada", 10);
        Item item8 = new Item("Espada mitica", 1100);
        Item item9 = new Item("Escudo mitica", 0);
        Item item10 = new Item("Espada", 2);
        Item item11 = new Item("Espada mitica", 1);
        Item item12 = new Item("Escudo mitica", 109);
        Item item13 = new Item("Espada", 10);
        Item item14 = new Item("Espada mitica", 1100);
        Item item15 = new Item("Escudo mitica", 0);
        Item item16 = new Item("Espada", 2);
        Item item17 = new Item("Espada mitica", 1);
        Item item18 = new Item("Escudo mitica", 109);
        Item item19 = new Item("Espada", 10);
        Item item20 = new Item("Espada mitica", 10000);
        Item item21 = new Item("Escudo mitica", -1);
        Item item22 = new Item("Espada", 2);
        Item item23 = new Item("Espada mitica", 1);
        Item item24 = new Item("Escudo mitica", 109);
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        itens.adicionarItem(item4);
        itens.adicionarItem(item5);
        itens.adicionarItem(item6);
        itens.adicionarItem(item7);
        itens.adicionarItem(item8);
        itens.adicionarItem(item9);
        itens.adicionarItem(item10);
        itens.adicionarItem(item11);
        itens.adicionarItem(item12);
        itens.adicionarItem(item13);
        itens.adicionarItem(item14);
        itens.adicionarItem(item15);
        itens.adicionarItem(item16);
        itens.adicionarItem(item17);
        itens.adicionarItem(item18);
        itens.adicionarItem(item19);
        itens.adicionarItem(item20);
        itens.adicionarItem(item21);
        itens.adicionarItem(item22);
        itens.adicionarItem(item23);
        itens.adicionarItem(item24);
        String valorFinal ="";
        //act
        itens.ordenarItens();
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("-1 0 0 0 1 1 1 1 2 2 2 2 10 10 10 10 109 109 109 109 1100 1100 1100 10000 ", valorFinal);
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

    @Test
    public void ordenarItens0ItensComParametroAscendente(){
        //Arrange
        Inventario itens = new Inventario();
        String valorFinal ="";
        //act
        itens.ordenarItens(TipoOrdenacao.ASCENDENTE);
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("", valorFinal);
    }

    @Test
    public void ordenarItens0ItensComParametroDescendente(){
        //Arrange
        Inventario itens = new Inventario();
        String valorFinal ="";
        //act
        itens.ordenarItens(TipoOrdenacao.DESCENDENTE);
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("", valorFinal);
    }

    @Test
    public void ordenarItens24ItensComParametroDescendente(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 10);
        Item item2 = new Item("Espada mitica", 1100);
        Item item3 = new Item("Escudo mitica", 0);
        Item item4 = new Item("Espada", 2);
        Item item5 = new Item("Espada mitica", 1);
        Item item6 = new Item("Escudo mitica", 109);
        Item item7 = new Item("Espada", 10);
        Item item8 = new Item("Espada mitica", 1100);
        Item item9 = new Item("Escudo mitica", 0);
        Item item10 = new Item("Espada", 2);
        Item item11 = new Item("Espada mitica", 1);
        Item item12 = new Item("Escudo mitica", 109);
        Item item13 = new Item("Espada", 10);
        Item item14 = new Item("Espada mitica", 1100);
        Item item15 = new Item("Escudo mitica", 0);
        Item item16 = new Item("Espada", 2);
        Item item17 = new Item("Espada mitica", 1);
        Item item18 = new Item("Escudo mitica", 109);
        Item item19 = new Item("Espada", 10);
        Item item20 = new Item("Espada mitica", 10000);
        Item item21 = new Item("Escudo mitica", -1);
        Item item22 = new Item("Espada", 2);
        Item item23 = new Item("Espada mitica", 1);
        Item item24 = new Item("Escudo mitica", 109);
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        itens.adicionarItem(item4);
        itens.adicionarItem(item5);
        itens.adicionarItem(item6);
        itens.adicionarItem(item7);
        itens.adicionarItem(item8);
        itens.adicionarItem(item9);
        itens.adicionarItem(item10);
        itens.adicionarItem(item11);
        itens.adicionarItem(item12);
        itens.adicionarItem(item13);
        itens.adicionarItem(item14);
        itens.adicionarItem(item15);
        itens.adicionarItem(item16);
        itens.adicionarItem(item17);
        itens.adicionarItem(item18);
        itens.adicionarItem(item19);
        itens.adicionarItem(item20);
        itens.adicionarItem(item21);
        itens.adicionarItem(item22);
        itens.adicionarItem(item23);
        itens.adicionarItem(item24);
        String valorFinal ="";
        //act
        itens.ordenarItens(TipoOrdenacao.DESCENDENTE);
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("10000 1100 1100 1100 109 109 109 109 10 10 10 10 2 2 2 2 1 1 1 1 0 0 0 -1 ", valorFinal);
    }

    @Test
    public void ordenarItens6ItensComParametroDescendente(){
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
        itens.ordenarItens(TipoOrdenacao.DESCENDENTE);
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("1100 109 10 2 1 0 ", valorFinal);
    }

    @Test
    public void ordenarItens6ItensComParametroAscendente(){
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
        itens.ordenarItens(TipoOrdenacao.ASCENDENTE);
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("0 1 2 10 109 1100 ", valorFinal);
    }

    @Test
    public void ordenarItens24ItensComParametroAscendente(){
        //Arrange
        Inventario itens = new Inventario();
        Item item = new Item("Espada", 10);
        Item item2 = new Item("Espada mitica", 1100);
        Item item3 = new Item("Escudo mitica", 0);
        Item item4 = new Item("Espada", 2);
        Item item5 = new Item("Espada mitica", 1);
        Item item6 = new Item("Escudo mitica", 109);
        Item item7 = new Item("Espada", 10);
        Item item8 = new Item("Espada mitica", 1100);
        Item item9 = new Item("Escudo mitica", 0);
        Item item10 = new Item("Espada", 2);
        Item item11 = new Item("Espada mitica", 1);
        Item item12 = new Item("Escudo mitica", 109);
        Item item13 = new Item("Espada", 10);
        Item item14 = new Item("Espada mitica", 1100);
        Item item15 = new Item("Escudo mitica", 0);
        Item item16 = new Item("Espada", 2);
        Item item17 = new Item("Espada mitica", 1);
        Item item18 = new Item("Escudo mitica", 109);
        Item item19 = new Item("Espada", 10);
        Item item20 = new Item("Espada mitica", 10000);
        Item item21 = new Item("Escudo mitica", -1);
        Item item22 = new Item("Espada", 2);
        Item item23 = new Item("Espada mitica", 1);
        Item item24 = new Item("Escudo mitica", 109);
        itens.adicionarItem(item);
        itens.adicionarItem(item2);
        itens.adicionarItem(item3);
        itens.adicionarItem(item4);
        itens.adicionarItem(item5);
        itens.adicionarItem(item6);
        itens.adicionarItem(item7);
        itens.adicionarItem(item8);
        itens.adicionarItem(item9);
        itens.adicionarItem(item10);
        itens.adicionarItem(item11);
        itens.adicionarItem(item12);
        itens.adicionarItem(item13);
        itens.adicionarItem(item14);
        itens.adicionarItem(item15);
        itens.adicionarItem(item16);
        itens.adicionarItem(item17);
        itens.adicionarItem(item18);
        itens.adicionarItem(item19);
        itens.adicionarItem(item20);
        itens.adicionarItem(item21);
        itens.adicionarItem(item22);
        itens.adicionarItem(item23);
        itens.adicionarItem(item24);
        String valorFinal ="";
        //act
        itens.ordenarItens(TipoOrdenacao.ASCENDENTE);
        for(int i =0; i<itens.getItens().size();i++){
            valorFinal+= itens.getItens().get(i).getQuantidade()+" ";
        }
        //assert
        assertEquals("-1 0 0 0 1 1 1 1 2 2 2 2 10 10 10 10 109 109 109 109 1100 1100 1100 10000 ", valorFinal);
    }
}
