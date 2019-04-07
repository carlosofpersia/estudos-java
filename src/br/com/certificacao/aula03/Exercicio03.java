
/*
 * 3 - Operadores de comparação
 */
package br.com.certificacao.aula03;

public class Exercicio03 {

	public Exercicio03() {
		System.out.println("3 - Operadores de comparação");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) {
	
		/*
		 *
		 * comparação por ponto flutuante pode dar problema
		 * pode dar erro de precisão. ( 100.0 / 100.0 ) pode dar 0.99999999 e dar erro. aqui deu certo, mas tomar cuidado.
		 */
		System.out.println( 1 == ( 100.0 / 100.0 ) );
		System.out.println("-----------------------------------------------");
		
		
		int idade = 34;
		System.out.println(idade = 11);//operador = é somenta para atribuição, pegadinha. para comparação sempre 2 iguais.
		System.out.println("-----------------------------------------------");

		//System.out.println(true == "true");problema
		System.out.println(true == true);
		System.out.println(true != false);

		System.out.println("-----------------------------------------------");
		//ele não olha tipos primitivos númericos
		System.out.println( 1 == 1.0);//são iguais pois o valor é ambos o valor é 1. ignorou o tipo por ser o mesmo valor
		System.out.println( 1.0f == 1.0d);
		System.out.println( 1.0f == 1l);

		System.out.println("-----------------------------------------------");
		System.out.println( 1 == 1);
		System.out.println( 1 != 1);

		System.out.println("-----------------------------------------------");
		System.out.println( 2 >= 1);
		System.out.println( 2 <= 1);

		System.out.println("-----------------------------------------------");
		System.out.println( 2 > 1);
		System.out.println( 2 < 1);
		
		
		
		
		
		
		
	}
}
