package br.com.certificacao.aula03;

public class Exercicio08 {

	public Exercicio08() {
		
		System.out.println("8 - Use parenteses para sobrescrever a precedência de operadores");
		
		// TODO Auto-generated constructor stub
	}
	
	public static void main ( String[] args) {
		
		
		//Precedencia dos parenteses
		
		
		int a = 15 * 4 + 1;
		System.out.println(a);
		
		
		
		int b = 15 * ( 4 + 1 );
		System.out.println(b);


		System.out.println(15 + 0 + " é cento e cinquenta");
		System.out.println(15 + (0 + " é cento e cinquenta" ) );
		
		
		System.out.println("carlos".length());
		
		System.out.println("carlos" + " eduardo".length());
		System.out.println(("carlos" + " eduardo").length());
		
		
	}

}
