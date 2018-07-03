package br.com.certificacao.aula04;

import java.util.ArrayList;
import java.util.Iterator;

public class Exercicio05 {

	public Exercicio05() {
		
		System.out.println("5 - Declare e use um ArrayList - Iterator e o Enhanced for");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) {
		
		ArrayList<String> lista = new ArrayList<>();
		
		lista.add("Carlos");
		lista.add("Brenna");
		lista.add("Geovana");
		lista.add("Enzo");

		Iterator<String> it = lista.iterator();//para percorrer um ArrayList
		while ( it.hasNext() ) {
			String atual = it.next();//pega posição atual;
			System.out.println(atual);
			//it.remove();//alterou a lista;
		}
		
		System.out.println(lista.size());
		
		for( String nome: lista ) {
			System.out.println("Nome: " + nome);
		}
		
		//sempre que usar o ArrayList ou outras coleções, verificar se o Equals() está implementado
		// se estiver mal implementado ou de forma errada algumas funções das coleções não vao funcionar direito.
		
		
		
		Cliente cliEduardo = new Cliente ();
		cliEduardo.nome = "Eduardo";
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(cliEduardo);
		
		System.out.println(cliEduardo.nome);
		System.out.println(clientes.get(0).nome);
		
		
		cliEduardo.nome = "Santos";//pega o nome do objeto referenciado.
		
		System.out.println(cliEduardo.nome);
		System.out.println(clientes.get(0).nome);
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Exercicio05");
	}

}
