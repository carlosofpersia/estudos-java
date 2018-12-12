package br.com.certificacao.desafios.desafio_4;

public class  Desafio4 {

    public static void main (String[] args) {

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