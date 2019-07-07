package br.com.certificacao.bdoismildezenove.dabril;

//import java.io.Error;//não existe
import java.io.*;
import java.util.*;

	class MarksOutOfBoundsException extends IndexOutOfBoundsException {
		
	}

	class Natural {
		private int i;
		void disp() {
			while(i<=5) {
				for(int i = 1; i<=5;) {
					System.out.print(i + ", "); i++;
				} i++;
				System.out.println();
			}
			
		}
	}

		class Tours {
			public static void main (String[] args) {
				System.out.print("Happy Journey!" + args[1]);
			}
		}
	
public class Cinco {

	private char var;
	
	private int x = 0;
	private int y = 0;

	public void printThis(int x, int y ) {
		x = x;
		y = y;
		System.out.println("x: " + this.x + "y: " + this.y );
	}

	public void printThat(int x, int y ) {
		this.x = x;
		this.y = y;
		System.out.println("x: " + this.x + "y: " + this.y );
	}	
	public void doList() throws Exception {
		throw new Error("Error");
	}

	public void doPrint() throws Exception {
		throw new RuntimeException("Exception");
	}
	
	static void dispResult(int[] num) {
		try {
			System.out.println(num[1] / num[1] - num[2]);
		} catch (ArithmeticException e ) {
			System.err.println("First Exception");
		}
		System.out.println("Done");
	}

	
	static String[] args = { "lazy", "lion", "is", "Always" };
	
	void verify(int marks) throws IndexOutOfBoundsException {
		if (marks > 100) {
			throw new MarksOutOfBoundsException();
		}
		if (marks > 50) { 
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	public static void main ( String [] args ) {

	
		System.out.println( "*****************************" );
	
		Tours.main(args);
	
		System.out.println( "*****************************" );

		int marks = Integer.parseInt(args[2]); 
		try {
			new Cinco().verify(marks);
		} catch(Exception e) { 
			System.out.println(e.getClass());
		}


	
		System.out.println( "*****************************" );
		
		Natural natural = new Natural();
		natural.disp();
	
		System.out.println( "*****************************" );
		
		//elephant - is - always - Jumping!
		System.out.println(
		args[1] + " - " + args[2] + " - " + args[3] + " - Jumping!"
		);
		
		System.out.println( "*****************************" );
		
		for (int ii = 0; ii < 3; ii++) {
			int count = 0;
			for (int jj = 3; jj > 0; jj--) {
				if (ii == jj) {
					System.out.print(ii + " - " + jj + " -> ");
					System.out.println( ii == jj );
					++count; 
					break;
				}
			}
			System.out.println(count + "*"); continue;
		}
		
		System.out.println( "*****************************" );
		
		Cinco c = new Cinco();
		c.printThis(1,2);
		c.printThat(3,4);
		
		System.out.println( "*****************************" );
		
		int[][] arr2D = { {0,1,2,3,4}, {5,6} };
		System.out.println(arr2D);
		
		int[] arr1D = {0,1};
		
		int[][][] arr3D = new int[2][2][2];
		arr3D[0][0] = arr1D;
		arr3D[0][1] = arr1D;
		arr3D[1][0] = arr1D;
		arr3D[1][1] = arr1D;
		System.out.println(arr3D);
		
		
		System.out.println( "*****************************" );
		
		String str1 = "Java";
		String[] str2 = {"J","a","v","a"}; 
		String str3 = "";
		for (String str : str2) { 
			str3 = str3+str;
		}
		boolean b1 = (str1 == str3); 
		boolean b2 = (str1.equals(str3)); 
		System.out.println(b1+", "+b2);

		
		System.out.println( "*****************************" );
		
		
		

		int x = 10;
		System.out.println(x>10?">":x<10?"<":"=");

	
		System.out.println( "*****************************" );
		
		Cinco cinco = new Cinco();
		try {
			cinco.doPrint();
			cinco.doList();
		} catch (Exception e2 ) {
			System.out.println("Caught: " + e2);
		}
	
		System.out.println( "*****************************" );
		
		char var1 = 'a';
		char var2 = var1;
		var2 = 'e';
		
		Cinco obj1 = new Cinco();
		Cinco obj2 = obj1;
		obj1.var = 'i';
		obj2.var = 'o';
		
		System.out.println( var1 +" - "+ var2 );
		System.out.println( obj1.var + " - " + obj2.var );
		
		

		
		System.out.println( "*****************************" );

		try {
			int[] arr = {100, 100};
			dispResult(arr);
		} catch (IllegalArgumentException e ) {
			System.out.println("Second Exception");
		} catch (Exception e ) {
			System.out.println("Third Exception");
		}
		
		System.out.println( "Cinco - OK!" );
	}
	
	
	
}