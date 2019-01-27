package br.com.certificacao.days;

import java.util.*;
import java.util.Arrays;

public class DayTwo {

	int sum;
	int x;

	final static int calcJ = 32;//se não for static não funciona em medoto static
	//final int calcJ = 32;

	public static void main (String[] args ) {

		int a = 10, b = 0;	
		int intC = a+b;
		//intC = a/b;//java.lang.ArithmeticException
		System.out.println(intC);
	
		char charC = 'A';//65
		System.out.println((char)calc(charC));//'a'
		System.out.println(calc(charC));//97
		
	
		/*******************************/
	
		int[] ints = {1,2,4,5,3};
		System.out.println(Arrays.binarySearch(ints, 3));
		//https://www.geeksforgeeks.org/arrays-binarysearch-java-examples-set-1/
	

	/*******************************/
	
		int x = 11;
		System.out.println(x+"");
		update(x);
		System.out.println(x);

	/*******************************/
	
		String str1 = "JAVA";
		String str2 = new String("JAVA");
		String str3 = "JAVA";
		System.out.println(str2.length());

		System.out.println(str1.hashCode() == str2.hashCode());//true
		System.out.println(str1 == str2);//false
		System.out.println(str1 == str3);//false
		System.out.println(str1.equals(str2));//true
	
	/*******************************/
	
	
ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(3);
        list.trimToSize();//não tem parametro
        System.out.println(list.size());
	
	/*******************************/
	
	
		//int x, y;//falha pois variável local precisa inicializar
		//DayTwo dt = new DayTwo();
		
		//dt.sum += x;
		//System.out.println(dt.sum);
	}
	
	
	
	static int calc (int i) {
		return (i+calcJ);
	}
	
	public static void update(int x) {
		if(++x > 10 )
			x = 10;
		else
			x++;
			
	}
}