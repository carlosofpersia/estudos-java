package br.com.certificacao.adoismildezenove.bfevereiro;

import java.util.*;

interface Contract {}
class Super implements Contract {}
class Sub extends Super {}

public class Vinte {
		
		public static void main (String [] args) {

			List<Contract> objs = new ArrayList<>();
			//List objs = new ArrayList();

			Contract c1 = new Super();
			Contract c2 = new Sub();
			Super s1 = new Sub();

			objs.add ( c1 );
			objs.add ( c2 );
			objs.add ( s1 );

			for ( Object itm: objs ) {

				System.out.println( itm.getClass().getName() );
			}
			
			
			System.out.println("Vinte - OK");
		}
	
}