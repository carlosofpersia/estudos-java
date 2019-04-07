package br.com.certificacao.bdoismildezenove.cmarco.atrinta;

import br.com.certificacao.bdoismildezenove.cmarco.btrinta.Btrinta;

import java.util.*;

public class Atrinta extends Btrinta {

	protected /* or public */ String show() {
		//nesse caso o metodo da classe pai é protected;
		//este metodo não pode ser sobrescrito com privado ou default
		//somente com protected ou menos restritivo public
		return "A.Name: " + name + ", " + "A.idade: " + age;
	}

	public static void main ( String [] args ) {

		Atrinta a = new Atrinta();

		a.name = "Eduardo";
		a.age = 35;
		System.out.println( a.show() );

		System.out.println( "*****************************" );

		System.out.println( "Atrinta - OK!" );
	}	
}