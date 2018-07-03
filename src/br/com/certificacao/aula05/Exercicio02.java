package br.com.certificacao.aula05;

import java.util.ArrayList;

public class Exercicio02 {

	public Exercicio02() {
		System.out.println("5 - Certificação Java SE 7 Programmer I - Laços");
		System.out.println("2 - Crie e use laços do tipo for, incluindo o enhanced for");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) {

		for (int i = 1; i < 10; i++) {
			System.out.println(i);
		}
		
		/* todos os parametros são opcionais, ficara infinito. equivalente ao while true*/
		//porém nessa versão do java fica false;
		
		//posso criar e extender várias váriaveis no for
		//só posso definir um tipo na criação e inicialização dentro do for:
		//for (int i = 0, j= 10, k = 30; i < 10 ; i++, j-- ) {}
		//mas posso criar 2 tipos fora e inicializar dentro do for:
		int x;
		double y;
		for (x = 0, y= 10; x < 20 ; x++, y--/*posso fazer qualquer expressão*/, System.out.println("...Loop...") ) {
			System.out.println(x +" - "+ y);
			;
			;
			;
			;
			;
		}
		
		
		int[] numeros = {1,2,3,4,5,6};
		for (int m = 0; m < numeros.length; m++) {
			int numero = numeros[m];
			System.out.println("For:" + numero);
		}
		
		for (int n : numeros) {
			System.out.println("Foreach:" + n);
		}
		
		
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Carlos");
		nomes.add("Eduardo");
		for (String nome : nomes) {
			System.out.println(nome);
			//na prática não é bom remover elementos dentro do loop foreach
		}
		System.out.println(nomes);
		
		
		
		System.out.println("Exercicio02");
	}

}
