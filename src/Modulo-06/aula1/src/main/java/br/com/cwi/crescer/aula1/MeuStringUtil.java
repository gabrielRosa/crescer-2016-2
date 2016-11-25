package br.com.cwi.crescer.aula1;

import java.lang.reflect.Method;

public class MeuStringUtil {

    public boolean isVazia(String string) {
        return string.isEmpty();
    }

    public byte getVogais(String frase) {
        byte cont = 0;
        final char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < frase.length(); i++) {
            for (int j = 0; j < vogais.length; j++) {
                if (frase.charAt(i) == vogais[j]) {
                    cont++;
                    break;
                }
            }
        }
        return cont;
    }

    public String contraria(String frase) {
        return new StringBuilder().append(frase).reverse().toString();
    }
    
    public boolean isPalindromo(String string){
        String contraria = this.contraria(string);
        return contraria.equals(string);
    }
    
    public static void main(String [] args){
        Method[] metodos =  MeuStringUtil.class.getMethods();
        for(Method m: metodos){
            System.out.println(m.getName());
        }
    }
}
