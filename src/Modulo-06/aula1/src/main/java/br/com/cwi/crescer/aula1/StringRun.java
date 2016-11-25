package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringRun {

    public static void main(String[] args) throws ParseException {
        if ("A".equals(new String("A"))) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
        Scanner s = new Scanner(System.in);
        String input = s.next();
//        System.out.println(getVogais(input));
//        System.out.println(contraria(input));
//        System.out.println(concatenaEstados());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
        System.out.println(dateFormat.format(calendar.getTime()));
        
        //dateFormat = new SimpleDateFormat("MM-yyyy");
        //Date d = dateFormat.fo
        
        //System.out.println(dateFormat.format(new Date()));
    }





    private static String concatenaEstados() {
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        final StringBuffer s = new StringBuffer();
        final List<Estados> lista = new LinkedList<>();

        lista.addAll(Arrays.asList(Estados.values()));

        Collections.sort(lista, (Estados e1, Estados e2) -> e1.toString().compareTo(e2.toString()));

        lista.forEach((e) -> {
            s.append(e.getNome());
            s.append("; ");
        });

        s.replace(s.length() - 2, s.length(), ".");

        return s.toString();
    }
}
