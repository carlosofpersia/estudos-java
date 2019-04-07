package br.com.certificacao.bdoismildezenove.cmarco;

import java.util.*;

class Student { 
	int rollnumber; 
	String name;
	List cources = new ArrayList();
	Student(int i, String name, List cs) {
		rollnumber = i;
		this.name = name;
		cources = cs;
	}
	public String toString() {
		return rollnumber + " : " + name + " : " + cources;
	}
}

class Cake { 
	int model; 
	String flavor; 
	Cake() {
		model = 0;
		flavor = "Unknown";
	}
}

class Tours {
	public static void main (String[] args) {
		System.out.println("Happy Journey! " + args[1]);
	}
}

public class VinteNove {

	private char var;


	
	static void displayResult ( int [] num ) {
		try {
			System.err.println(num[1] / num[1] - num[2]);
		} catch ( ArithmeticException e ) {
			System.err.println("First exception");
		}
		System.out.println("First exception");
	}

	public static Cake bake1(Cake c) { 
		c.flavor = "Strawberry";
		c.model = 1200; 
		return c;
	}
	
	public static void bake2(Cake c) { 
		c.flavor = "Chocolate";
		c.model = 1230; 
		return;
	}

	static String args[] = {"lazy", "lion", "is", "always"};

	private int i;

	void disp() {
		while (i <= 5) {
			for (int i=1; i <=5;) { 
				System.out.print(i + " "); 
				i++;
			} i++;
			System.out.println();
		}
	}

	public static void main ( String [] args ) {
		
		String[] colors = {"red", "blue","green","yellow","maroon","cyan"}; 
		int count1 = 0;
		for (String c : colors) { 
			if (count1 >= 4) {
				break;
			} else { 
				continue;
			}
			if (c.length() >= 4) { 
				colors[count1] = c.substring(0,3);
			}
			count1++;
		}
		System.out.println(colors[count1]);
		

		System.out.println( "*****************************" );
		
		Tours.main(args);
	
		System.out.println( "*****************************" );
	
		String name = "Carlos Eduardo";
		System.out.println(name.substring(0,6));
		System.out.println(name.substring(7,10));
	
		System.out.println( "*****************************" );
		
		
		
		new VinteNove().disp();
	
		System.out.println( "*****************************" );

		//System.out.println(args[1] + " - " + args[2] + " - " +args[3] + " - Jumping!" );
		//variável local está mais forte aqui e da java.lang.ArrayIndexOutOfBoundsException
	
		System.out.println( "*****************************" );

		for (int ii = 0; ii < 3;ii++) { 
			int count = 0;
			for (int jj = 3; jj > 0; jj--) {
				if (ii == jj) {
					++count; break;
				}
			}
			System.out.print(count); continue;
		}

		
		
		System.out.println( "*****************************" );
		
		Object arr2[];
		int[] arr3;
		
		//int[][] array2d = new int[][2];inválido
		//int[][] array2d = new int[2][];válido
		
		int[][] array2d = {{0,1,2,3,4}, {5,6}};
/*
		int[] array1d = {0,1};
		int[][][] array3d = new int[2][2][2];
		array3d[0][0] = array1d;
		array3d[0][1] = array1d;
		array3d[1][0] = array1d;
		array3d[1][1] = array1d;
*/
	
	
		System.out.println( "*****************************" );

		Cake c = new Cake();		
		bake1(c);
		System.out.println(c.model + " " + c.flavor); 
		bake2(c);
		System.out.println(c.model + " " + c.flavor);

		
		System.out.println( "*****************************" );
	
		int [] array2D [] = { {1,2}, {3,4} };
		System.out.println(array2D[1][1]);
	
		System.out.println( "*****************************" );
	
		String d = "123";
		if (d.length() >2)
			d.concat("456");
		for(int x = 0; x <3; x++) 
			d += "x";
		System.out.println(d);
	
		System.out.println( "*****************************" );
		
		float m = 4;
		float n = 4;
		float o = m + n;
		double p = m + n;
		
		System.out.println(m +"="+ n +"="+ o +"="+ p);

		System.out.println( "*****************************" );
	
		int x = 10;	
		System.out.println( x>10 ? ">" : x<10 ? "<" : "=" );

		System.out.println( "*****************************" );

		int b = 3;
		if ( !(b > 3)) {
			System.out.println("square ");
		}
			
		{
			System.out.println("circle ");
		}
		System.out.println("..."); 
		

		System.out.println( "*****************************" );

		String message = "Hi everyone!";
		System.out.println("message = " + message.replace("e", "X")); 

		System.out.println( "*****************************" );

		float varA = (12_345.01 >= 123_45.00) ? 12_456 : 124_56.02f;
		System.out.println(varA);
		float varB = varA + 1024;
		System.out.println( varB );

		System.out.println( "*****************************" );

		List<String> cs = new ArrayList<>(); 
		cs.add("Java");
		cs.add("C");
		Student s = new Student(123,"Fred", cs); 
		System.out.println(s);

		System.out.println( "*****************************" );

		char var1 = 'a';
		char var2 = var1;
		var2 = 'e';

		VinteNove obj1 = new VinteNove();
		VinteNove obj2 = obj1;
		obj1.var = 'i';
		obj2.var = 'o';

		System.out.println( var1 + " = " + var2 );
		System.out.println( obj1.var + " = " + obj2.var );
		
		
	
		System.out.println( "*****************************" );
		
		try {
			int[] arr = {100, 100};
			displayResult(arr);
		} catch ( IllegalArgumentException e ) {
			System.out.println( "second exception" );
		} catch ( Exception e ) {
			System.out.println( "third exception" + e.getMessage() );
		}
		
		System.out.println( "VinteNove - OK!" );
	}
	
	
	
}