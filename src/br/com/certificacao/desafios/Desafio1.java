package br.com.certificacao.desafios;

import java.time.*;
import java.time.temporal.*;


import java.util.Random;

import java.util.ArrayList;
import java.util.List;


public class Desafio1 {

static int y4 = 10;

	Desafio1 () {
		super();
		System.out.println("https://www.myexamcloud.com");
	}

	public static void main (String[] args) throws Exception {



//int y4;//compilação error = tem que ser inicializada
//System.out.println(y4 + Desafio1.y4);



String str1 = "Carlos";
StringBuilder sb = new StringBuilder ("-");
sb.append("Eduardo");
str1.concat(sb.toString());
System.out.println(str1);



System.out.println(Instant.now());


String y2 = "Y";
final String n = "N";
String in = "y";

switch( in.toUpperCase() ) {

    //case y2: System.out.println("Yes");
    case n: System.out.println("No");
    default: System.out.println("Y/N");

}


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(9);
        list.add(30);
        list.removeIf(e -> e % 2 != 0);
        System.out.println( list );


Random r = new Random();
System.out.println(r.nextInt(10));


                        Integer arr2[] = new Integer[0];
                        System.out.println(arr2[0]);


                        LocalDate date = LocalDate.parse("2014-12-30");
                        date = date.plusDays(2);
                        //date.plusHours(12);//compilação falhara
                        System.out.println(date.getYear() +"-"+ date.getMonth() +"-"+ date.getDayOfMonth() );


		Integer arr[] = {1,2,3,4};
		arr[1] = null;
		for(Integer a : arr ) {
			System.out.println(a);
		}

		Float number = Float.valueOf(args[0]);
		System.out.println(number);


		int x = 3;
		int y = ++x * 4 / x-- + --x;
		System.out.println("X + Y = " + (x+y));

		Object num = new Integer(2);
		String str = (String) num;
		System.out.println(str);

		System.out.println("OK");
	}
}
