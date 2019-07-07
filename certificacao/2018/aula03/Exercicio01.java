
/**
 * 3 - Certificação Java SE 7 Programmer I - Operadores
 * 1 - Use operadores Java
 * 
 * https://help.github.com/articles/adding-a-remote/
 */
package br.com.certificacao.aula03;

import java.util.ArrayList;
import java.util.List;

public class Exercicio01 {

	public Exercicio01() {
		//Construtor não possui retorno.
	}
	
	
	public static void main (String[] args)
	{
		
		System.out.println("3 - Certificação Java SE 7 Programmer I - Operadores");
		System.out.println("1 - Use operadores Java");

		ArrayList<String> lista = new ArrayList<String>();
		/*
		 * Operador de atribuição com referência está copiando a referência.
		 * - abrangente para o + abrangente = OK (ArrayList para List)
		 */ 
		List<String> lista2 = lista;//list é mais abrangente por isso pode usar um ArrayList (ArrayList é um tipo de List )

		ArrayList<String> lista3 = new ArrayList<>(); //a partir do java 7 ele ja sabe o tipo da atribuição. 
		
		/* 
		 * Operadores de atribuição '='
		 * long aceita valores mais especifico e menos abrangente
		 * pedi uma váriavel long e estou atribuindo um int.
		 * 
		 * char -> int -> long
		 * byte -> short -> int -> long
		 * float -> double
		 *  
		 *  
		 *  
		 * 
		 */
		long idade = 27;//anos
		
		int    a = 10;
		long   b = 20;
		short  c = 3; 
		byte   d = 4;
		double e = 30.0;
		float  f = 40.3f;
		double g  = 40.3f;

		f = a;
		f = b;
		f = c; 
		f = d;
		g = a;
		g = b;
		g = c;
		g = d;

		char h = 65;
		//char h = -2; não deixa
		//a = b; //int não aceita long
		
	}
}
