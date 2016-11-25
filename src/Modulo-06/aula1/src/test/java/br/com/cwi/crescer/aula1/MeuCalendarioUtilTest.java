/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class MeuCalendarioUtilTest {

    @Test
    public void testGetDiaPorExtensoDoNascimento() {
        Date data = new Date("02/23/1997");
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Domingo";
        String result = instance.getDiaPorExtensoDoNascimento(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTempoDecorrido() {
        Date data = new Date("11/24/2016");
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "0-0-1";
        String result = instance.getTempoDecorrido(data);
        assertEquals(expResult, result);
    }
    
}
