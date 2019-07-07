package br.com.certificacao.bdoismildezenove.dabril;

import java.util.*;


abstract class A {
	public abstract void methodX();
}

interface B {
	public void methodY();
}

abstract class C extends A implements B {
	public void methodZ() {}
}

abstract class D extends A implements B {

}

class X {
	public void mX() {
		System.out.println("XM1");
	}
}

class Y extends X {
	public void mX() {
		System.out.println("XM2");
	}
	public void mY() {
		System.out.println("XM.");
	}
}

abstract class Wow {
	private int wow;
	public Wow (int wow) {
		this.wow = wow;
	}
	public void wow() {}
	private void wowza() {}
}

class Alpha {
	
	public String[] main = new String[2];
	
	Alpha(String[] main) {
		for(int ii = 0; ii < main.length; ii++) {
			this.main[ii] = main[ii] + 5;
		}
	}
	
	public void main() {
		System.out.println(main[0] + main[1]);
	}
}

public class Quatro {

	private boolean flag;
	public void displaySeries() {
		int num = 2;
		while(flag) {
			if(num % 7 == 0) 
				flag = false;
			System.out.print(num+" ");
			num+=2;
		}
	}

	public static void main ( String [] args ) {

	
	int[] array = {1,2,3,4,5};
	System.arraycopy(array, 2, array, 1, 2);
	System.out.print(array[1]);
	System.out.print(array[4]);
	System.out.println();
	System.out.println( "*****************************" );
	
	Alpha main = new Alpha(args);
	main.main();
	
	System.out.println( "*****************************" );
		
		new Quatro().displaySeries();
		
	
		System.out.println( "*****************************" );
		
		String[] table = {"aa", "bb", "cc"};
		for(String ss: table) {
			int ii = 0;
			while( ii < table.length ) {
				System.out.println(ii);
				ii++;
				break;
			}
		}
	
		System.out.println( "*****************************" );
		
		X xRef = new Y();
		Y yRef = (Y) xRef;
		yRef.mY();
		xRef.mX();
	
		System.out.println( "*****************************" );
	
		int numbers[];
		numbers = new int[2];
		numbers[0] = 10;
		numbers[1] = 20;
		
		numbers = new int[4];
		numbers[2] = 30;
		numbers[3] = 40;
		
		for ( int number : numbers ) {
			System.out.println( number );
		}
		
		System.out.println( "*****************************" );
		
		
		try {
			int[] xx = null;
			for( int x : xx ) {
				System.out.println( x );//java.lang.NullPointerException
			}
		} catch ( Exception e ) {
			System.out.println( "Exception: " + e.getMessage());
		}
		

		System.out.println( "Quatro - OK!" );
	}
	
	
	
}