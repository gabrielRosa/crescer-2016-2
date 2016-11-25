/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Gabriel
 */
public class MeuCalendarioUtilTest {

    @Test
    public void testGetDiaPorExtensoDoNascimento02231997() {
        Date data = new Date("02/23/1997");
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Domingo";
        String result = instance.getDiaPorExtensoDoNascimento(data);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiaPorExtensoDoNascimento02241997() {
        Date data = new Date("02/24/1997");
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "Segunda-feira";
        String result = instance.getDiaPorExtensoDoNascimento(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTempoDecorrido1dia() {
        Date data = new Date("1/25/2016");
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "0 ano(s), 10 mes(es) e 2 dia(s)";
        String result = instance.getTempoDecorrido(data);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testGetTempoDecorrido1ano() {
        Date data = new Date("10/25/2015");
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        String expResult = "1 ano(s), 1 mes(es) e 2 dia(s)";
        String result = instance.getTempoDecorrido(data);
        assertEquals(expResult, result);
    }
    
}
