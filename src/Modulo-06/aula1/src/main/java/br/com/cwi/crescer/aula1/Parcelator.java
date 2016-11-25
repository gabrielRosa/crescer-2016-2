package br.com.cwi.crescer.aula1;

import java.util.Calendar;
import java.util.Date;


public class Parcelator {
    
    public String parcelas(double valor, double juros, int numeroParcelas, Date dataPrimeiroVencimento){
        double porcentagem = valor/10;
        double valorFinal = (valor + porcentagem*(juros/10))/numeroParcelas;
        
        StringBuffer stringBuffer = new StringBuffer();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataPrimeiroVencimento);
             
        for(int i=0; i<=numeroParcelas;i++){
            stringBuffer.append(calendar.get(Calendar.DAY_OF_MONTH));
            stringBuffer.append("/");
            stringBuffer.append(calendar.get(Calendar.MONTH));
            stringBuffer.append("/");
            stringBuffer.append(calendar.get(Calendar.YEAR));
            stringBuffer.append(" - ");
            stringBuffer.append("R$");
            stringBuffer.append(valorFinal);
            stringBuffer.append(";");
            
            calendar.add(Calendar.MONTH, 1);
        }
        return stringBuffer.toString();
    }
}
