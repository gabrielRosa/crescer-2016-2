package br.com.cwi.crescer.aula1;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParcelatorTest {

    @Test
    public void testGetTempoDecorrido() {
        Parcelator parcelator = new Parcelator();
        assertEquals("30/06/2016 - R$ 550,00;31/07/2016 - R$ 550,00;", parcelator.parcelas(1000.00,10.00,2, new Date("06/30/2016")));
    }

}
