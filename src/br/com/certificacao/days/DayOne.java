package br.com.certificacao.days;

import java.util.Arrays;
import java.util.List;

class A {
	protected int y = 15;
}

class B extends A {
	
}

public class DayOne {

	public static void main (String[] args ) {

		/********************************/
		
		List<String> list1 = Arrays.asList("B", "C");
		//list1.add("A");//java.lang.UnsupportedOperationException
		//System.out.println(list1.get(0));

		/********************************/

		Double d1 = 0.0/0.0;
		//System.out.println(Double.isNaN() + "");//não pode ser chamado do nada. -> non-static method isNaN() cannot be referenced from a static context
		System.out.println(Double.valueOf(0.0).isNaN() + "");
		System.out.println(d1.isInfinite());

		/********************************/

		Integer arr[] = {1,2,3,4};
		arr[1] = null;
		//for( int x : arr ) {
			//System.out.println(x);//1, NullPointerException
		//}

		/********************************/
	
		int y;
		//System.out.println(y);//erro de compilação devido a váriavel não iniciada;
		
		/********************************/
		
		Integer []array = new Integer[0];//Qtd de elementos, se for 0 fudeu!
		//System.out.println(array[0]);//java.lang.ArrayIndexOutOfBoundsException
	}
	
}