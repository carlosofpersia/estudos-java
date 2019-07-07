package br.com.certificacao.bdoismildezenove.cmarco;

import java.util.*;

class DBConfiguration {
	String user;
	String password;
}
/*
class Overloading { 
	int x(double d) {
		System.out.println("one"); 
		return 0;
	}
	String x(double d) { 
		System.out.println("two"); 
		return null;
	}
	double x(double d) { 
		System.out.println("three"); 
		return 0.0;
	}
}
*/

public class VinteSeis {

	/*
	static void breakBad() {
		//error: break outside switch or loop -> break;
		if( true ) {
			break;
		}
		
	}
	*/

	static void m ( int i ) {
		i += 7;
	}

	DBConfiguration configuration () {
		return new DBConfiguration();
	}

	/* static */ class Alpha {
		public String doStuff( String msg ) {
			return msg;
		}
	}
	
	/* static */ class Beta extends Alpha {
		public String doStuff( String msg ) {
			return msg.replace('a', 'e');
		}
	}
	
	/* static */ class Gamma extends Beta {
		public String doStuff ( String msg ) {
			return msg.substring(2);
		}
	}
	
	public static void main ( String [] args ) {

		//is already defined in class Overloading
		//new Overloading().x(4.0);
	
			System.out.println( "*****************************" );

	
		int row = 10;
		for( ; row > 0 ; ) {
			int col = row;
			while(col >= 0) {
				System.out.println(col+"");
				col-=2;
			}
			row = row / col;
		}
	
	
		String product = "Pen";
		product.toLowerCase();
		product.concat("BOX".toLowerCase());
		System.out.println(product);
		//System.out.println(product.substring(4,6));//java.lang.StringIndexOutOfBoundsException
	
		System.out.println( "*****************************" );
	
	/*
		int arr[] = {1,2,3};
		for(int var: arr) {
			int i = 1;
			while(i <= var);//devido o ; será loop infinito.
				System.out.println(i++);
				
		}
	*/
		System.out.println( "*****************************" );

		int a = -10;
		int b= 17;
		int c = ++a;
		int d = b--;
		c++;
		d--;
		System.out.println(c + ", " + d);
		

		//

		System.out.println( "*****************************" );
/*
		List<Alpha> strs = new ArrayList<Alpha>();
		strs.add( new Alpha() ); //non-static variable this cannot be referenced from a static context
		strs.add( new Beta()  ); //non-static variable this cannot be referenced from a static context
		strs.add( new Gamma() ); //non-static variable this cannot be referenced from a static context
		for( Alpha t: strs ) {
			System.out.println( t.doStuff( "Java" ) );
		}
*/
		System.out.println( "*****************************" );

		System.out.println( "Result: " + 2 + 3 + 5 );
		System.out.println( "Result: " + 2 + 3 * 5 );

		System.out.println( "*****************************" );

		 for ( int ii = 0; ii < 4; ii++ ) {
			System.out.println( "ii = "+ ii );
			ii = ii + 1;
		 }

		System.out.println( "*****************************" );
	
		VinteSeis vs = new VinteSeis();
		DBConfiguration conf = vs.configuration();

		//Integer number = Integer.valueOf( "808.1"); //java.lang.NumberFormatException

		System.out.println( "*****************************" );

		int j = 12;
		m(j);
		System.out.println( j );

		System.out.println( "*****************************" );

		int var1 = -5;
		int var2 = var1--; 
		int var3 = 0;
		if (var2 < 0) { 
			var3 = var2++;
		} else {
			var3 = --var2;
		}
		System.out.println( var3 );

		System.out.println( "*****************************" );

		System.out.println( "VinteSeis - OK!" );
	}
}