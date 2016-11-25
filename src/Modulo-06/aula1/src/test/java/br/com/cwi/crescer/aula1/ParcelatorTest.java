package br.com.cwi.crescer.aula1;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

public class ParcelatorTest {

    @Test
    public void testGetTempoDecorridoCom1000Reais10Percento2Parcelas() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 06, 30);
        Date data = calendar.getTime();
        Parcelator parcelator = new Parcelator();
        assertEquals("30/6/2016 - R$550.0;30/7/2016 - R$550.0;", parcelator.parcelas(1000.00,10.00,2, data));
    }
    
    @Test
    public void testGetTempoDecorridoCom300Reais100Percento3Parcelas() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 06, 30);
        Date data = calendar.getTime();
        Parcelator parcelator = new Parcelator();
        assertEquals("30/6/2016 - R$200.0;30/7/2016 - R$200.0;30/8/2016 - R$200.0;", parcelator.parcelas(300.00,100.00,3, data));
    }

}
