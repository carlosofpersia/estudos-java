
/*
 * 2 - Operadores aritméticos
 */
package br.com.certificacao.aula03;

public class Exercicio02 {

	public Exercicio02() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main (String[] args) 
	{
		
		/*
		 * char -> int -> long
		 * byte -> short -> int -> long
		 * float -> double
		 */
		
		int dois = 2;
		float dez = 10;

		float doze = dez + dois;
		
		System.out.println( doze );
		
		float oito = dez - dois;//retorna um float pq o float é o mais forte. se o retorno for int ele vai perder precisão e não funciona
		
		
		System.out.println( oito );
		
		float vinte = dez * dois;
		
		System.out.println( vinte );
		
		float cinco = dez / dois;
		
		System.out.println( cinco );

		int restoDaDivisaoDeCincoPorDois = 5 % 2; //MOD
		
		System.out.println( restoDaDivisaoDeCincoPorDois );
		
		int restoDaDivisaoDeQuatroPorDois = 4 % 2;
		
		System.out.println( restoDaDivisaoDeQuatroPorDois ); //MOD

		//int divisao1 = 5 / 0;
		//System.out.println( divisao1 ); //erro de execução
		
		double divisao1 = 5 / 0.0;
		System.out.println( divisao1 ); //0.0 pode, é um ponto flutuante o retorno é double
		
		double divisao2 = 5.0 / 0;
		System.out.println( divisao2 ); //0.0 pode, é um ponto flutuante o retorno é double
		
		double divisao3 = ( ( dois + 0.0 ) / 0);
		//double divisao3 = ( ( dois + 0 ) / 0);erro dividir int 0 por outro int da problema.
		System.out.println( divisao3 ); //0.0 pode, int + double funciona pq é ponto flutuante		

		
		double positivoInfinito = 5.0 / 0;
		double negativoInfinito = -5.0 / 0;
		
		System.out.println(positivoInfinito + negativoInfinito);//NaN - no are number
		
		
		
		//regra geral, minimo um int.
		//se for um int e um long o operador retornado é um long, se for int e int é int
	}

}
