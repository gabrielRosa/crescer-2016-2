package br.com.cwi.crescer.aula1;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeuStringUtilTest {

    @Test
    public void testeIsVaziaElaEstaVazia() {
        String string = "";
        MeuStringUtil instance = new MeuStringUtil();
        boolean result = instance.isVazia(string);
        assertEquals(true, result);
    }

    @Test
    public void testeIsVaziaElaNaoEstaVazia() {
        String string = "abc";
        MeuStringUtil instance = new MeuStringUtil();
        boolean result = instance.isVazia(string);
        assertEquals(false, result);
    }

    @Test
    public void testGetVogaisTemUmaVogal() {
        String frase = "abc";
        MeuStringUtil instance = new MeuStringUtil();
        byte result = instance.getVogais(frase);
        assertEquals(1, result);
    }

    @Test
    public void testGetVogaisNaoTemVogal() {
        String frase = "bc";
        MeuStringUtil instance = new MeuStringUtil();
        byte result = instance.getVogais(frase);
        assertEquals(0, result);
    }

    @Test
    public void testContrariaComPalavraOvo() {
        String frase = "ovo";
        MeuStringUtil instance = new MeuStringUtil();
        String result = instance.contraria(frase);
        assertEquals("ovo", result);
    }

    @Test
    public void testContrariaComPalavraCwi() {
        String frase = "cwi";
        MeuStringUtil instance = new MeuStringUtil();
        String result = instance.contraria(frase);
        assertEquals("iwc", result);
    }

    @Test
    public void testIsPalindromoComPavaraOvo() {
        String string = "ovo";
        MeuStringUtil instance = new MeuStringUtil();
        boolean result = instance.isPalindromo(string);
        assertEquals(true, result);
    }

    @Test
    public void testIsPalindromoComPavaraDell() {
        String string = "dell";
        MeuStringUtil instance = new MeuStringUtil();
        boolean result = instance.isPalindromo(string);
        assertEquals(false, result);
    }
}
