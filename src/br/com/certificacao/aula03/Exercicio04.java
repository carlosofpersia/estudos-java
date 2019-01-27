
/*
 * 
 * 3 - Certificação Java SE 7 Programmer I - Operadores::4 - Operadores lógicos
 * 
 */
package br.com.certificacao.aula03;

public class Exercicio04 {

	public Exercicio04() {
		
		System.out.println("4 - Operadores lógicos");
		// TODO Auto-generated constructor stub
	}

	public static boolean metodo (String msg) {

		System.out.println("shot circuit -> && || ");//satisfaz no primeiro se for true e não precisar ir nor outros.
		System.out.println(msg);
		return true;
	}

	public static void main (String[] args) {
		
		System.out.println("4 - Operadores lógicos");

		System.out.println(1 == 1 & 1 > 2 );//and, se usar duas vezes && ele não verifica a segunda pois já é true (short circuit)
		System.out.println(1 == 1 | 1 > 2 );//ou, se usar duas vezes || ele não verifica a segunda pois já é true (short circuit)
		System.out.println(1 == 1 ^ 1 > 2 );//ou exclusivo ^
		System.out.println( !(1 == 1 ) );//diferente

		System.out.println(1 == 1 & metodo("primeiro A") );
		System.out.println(1 == 1 && metodo("primeiro B") );
		System.out.println(1 != 1 & metodo("segundo A") );
		System.out.println(1 != 1 && metodo("segundo B") );//não passa pelo segundo, pois o primeiro já é falso
		System.out.println(1 == 1 | metodo("terceiro A") );
		System.out.println(1 == 1 || metodo("terceiro B") );
	}
}
