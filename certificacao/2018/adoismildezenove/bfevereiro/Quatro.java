package br.com.certificacao.adoismildezenove.bfevereiro;

import java.util.*;

//parei página 17 exercício 24 troy-1
public class Quatro extends A2 {


		static int j;
		
		static void doStuff() {
	
			System.out.println(j);
		}

		private Quatro() {
			super();
			System.out.println("contrutor");
		}

		private void a(String a) {
			System.out.println("protected.a: " + a);
		}	
		private void a() {
			System.out.println("private.a");
		}

	public void m1() { 
		System.out.println("Yellow"); 
	} 
	public void m2() {
		System.out.println("Pink"); 
	} 
	public void m3() { 
		System.out.println("Red"); 
	} 
	
	static String[][] arr =new String[3][]; 

	
	
	
	private static void doPrint() {
		//insert code here	
		System.out.println(arr.length);
		 for (int i = 0;i < arr.length; i++ ) { 
			int j = arr[i].length - 1;
			System.out.println(arr[i][j] + " = " + i );
		 }
		System.out.println(); 
		for (int i = 0;i < arr.length-1;i++) { 
			int j = arr[i].length - 1; 
			System.out.println( arr[i][j] + " = " + i );
			i++;
		}
		System.out.println();

	}


		
	public static void main (String[] args) {

	
StringBuilder s1 = new StringBuilder("Hello Java!"); 
String s2 = s1.toString();
List<String> lst = new ArrayList<String>();
lst.add(s2); 
System.out.println(s1.getClass());
System.out.println(s2.getClass());
System.out.println(lst.getClass());


	
	
		String[] class1 = {"A","B","C"};
		String[] class2 = {"L","M","N","O"}; 
		String[] class3 = {"I","J"};
		arr[0] = class1; 
		arr[1] = class2; 
		arr[2] = class3; 
		Quatro.doPrint();

	
	
	
	
	
		AnotherSample as = new AnotherSample();
		Sample s = new Sample();
		System.out.println(s);
		System.out.println(as);
		s = as;
		System.out.println(s);
		System.out.println(as);	
	
A2 tp = new Quatro(); 
tp.m1();
tp.m2();
tp.m3();

	
		Quatro q = new Quatro();
		q.a("Carloss");
		q.a();
		
		
		System.out.println("Quatro.java - OK");
	}
}



abstract class A1 {
	public abstract void m1();
	public void m2() { 
		System.out.println("Green"); 
	}
}
abstract class A2 extends A1 { 
	
	public void m1() { 
		System.out.println("Cyan"); 
	} 
	public void m2() {
		System.out.println("Blue"); 
	}
	public abstract void m3();
}

class Sample {
	
}

class AnotherSample extends Sample {
	
}


