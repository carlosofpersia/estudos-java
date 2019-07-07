package br.com.certificacao.bdoismildezenove.cmarco.btrinta;

import java.util.*;

public class Btrinta {

	protected String name;
	protected int age;
	
	protected String show() {
		return "B.Name: " + name + ", " + "B.idade: " + age;
	}

	public static void main ( String [] args ) {

		System.out.println( "*****************************" );

		Btrinta b = new Btrinta();
		b.name = "Carlos";
		b.age = 27;

		System.out.println( b.show() );

		System.out.println( "Btrinta - OK!" );
	}
	
	
	
}