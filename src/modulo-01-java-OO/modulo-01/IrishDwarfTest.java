import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest{
    @Test
    public void irishDwarfComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfComSorteCom2Itens() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 5));
        dwarf.adicionarItem(new Item("Ouro", 5));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(15005, dwarf.getInventario().getItens().get(1).getQuantidade());
    }

    @Test
    public void irishDwarfQuantidadeNegativaComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", -5));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfQuantidadeNulaComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 0));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(0, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfQuantidade3ComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.adicionarItem(new Item("Pint de Guinness", 3));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(6003, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfQuantidade3SemSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2001));
        dwarf.adicionarItem(new Item("Pint de Guinness", 3));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(3, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
}
