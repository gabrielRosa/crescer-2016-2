package br.com.cwi.crescer.aula1;

import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MeuCalendarioUtil {

    public String getDiaPorExtensoDoNascimento(Date data) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEE");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] nomeDia = symbols.getWeekdays();
        return nomeDia[calendar.get(Calendar.DAY_OF_WEEK)];
    }

    public String getTempoDecorrido(Date data) {
        Calendar calendar1 = Calendar.getInstance();
        
        long tempoDecorrido = new Date().getTime() - data.getTime();
        
        calendar1.setTime(new Date(tempoDecorrido));
        
        StringBuffer sb = new StringBuffer();
        sb.append(calendar1.get(Calendar.YEAR)-1970);
        sb.append(" ano(s), ");
        sb.append(calendar1.get(Calendar.MONTH));
        sb.append(" mes(es) e ");
        sb.append(calendar1.get(Calendar.DAY_OF_MONTH));
        sb.append(" dia(s)");
        
        return sb.toString();
    }
    
        public static void main(String [] args){
        Method[] metodos =  MeuStringUtil.class.getMethods();
        for(Method m: metodos){
            System.out.println(m.getName());
        }
    }
}
