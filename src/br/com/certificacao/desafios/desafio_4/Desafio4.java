package br.com.certificacao.desafios.desafio_4;

import java.util.*;

public class  Desafio4 {

    public Integer aMethod( Integer a ) {
        a = a + 2;
        return a;
    }

    public static void main (String[] args) {




List<String> lista =Arrays.asList("a", "b", "c", "d");
for (String l : lista) {
    System.out.println(l);
}
//lambda
lista.forEach(l -> System.out.println(l));





Desafio4 desafio = new Desafio4();

Integer a = 10;
desafio.aMethod(a);
System.out.println(a);
System.out.println("----------------");


/*
        Integer i = 10;
        for(;i>0;) {
        System.out.println(i);
        }
        */


int i = Integer.parseInt("10");
i++;
System.out.println(i);

Integer j = Integer.valueOf(i);
System.out.println(j);

double k = j.doubleValue();
System.out.println(k);



        if(true) {
            System.out.println("ok.b1");
        }

        boolean b1 = false;
        if(b1= true) {
            System.out.println("ok.b1");
        }

        Boolean b = false;
        if(b = true) {
            System.out.println("ok.b");
        }
    }

}