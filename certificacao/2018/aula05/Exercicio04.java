package br.com.certificacao.aula05;

import java.util.ArrayList;
import java.util.Iterator;

public class Exercicio04 {

	public Exercicio04() {
		System.out.println("5 - Certificação Java SE 7 Programmer I - Laços");
		System.out.println("4 - Compare os tipos de laços");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args)
	{
		
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Carlos");
		nomes.add("Eduardo");
		nomes.add("Santos");

		for (String nome : nomes) {
			//aqui eu só posso usar da esquerda para direita, somente leitura.
			System.out.println("Foreach: " + nome);
		}

		Iterator<String> it = nomes.iterator();
		while( it.hasNext() ) {
			String nome = it.next();
			System.out.println("Iterator: " + nome);
		}

		//String[] arr = new String[] { "a", "b", "c", "d", "e" };
		String[] arr = { "a", "b", "c", "d", "e" };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + " [arr]  " + arr[i]);
		}

		int j = 20;
		while (j < 10) { //uso o while quando eu só tenho uma condição de parada, não sei muita coisa
			System.out.println("While:" + j);
			j++;
		}
		//
		do {              /*Executa pelo menos uma vez*/
			System.out.println("Do...while" + j);
			j++;
		} while(j < 10);
		
		
		System.out.println("Exercicio04");
	}

}
