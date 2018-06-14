package br.com.certificacao.aula04;

public class Exercicio02
{
	public Exercicio02()
	{
		System.out.println("Arrays Exercicios 2");
	}
	
	public static void main (String[] args) {
		
		
		Cliente[] clientes = new Cliente[10];
		//System.out.println(clientes[0].nome);//é null pq não foi colocado nenhum valor

		for ( int i = 0; i < clientes.length; i++ ) {

			clientes[i] = new Cliente();
			clientes[i].nome = "Carlos" + i;
		}

		for ( Cliente c : clientes ) {
			System.out.println(c.nome);
		}

		//dentro de um array pode acessar um subtipo do tipo do array
		Cliente clientes2[] = new Cliente[5];
		clientes2[0] = new Cliente();
		clientes2[1] = new ClienteEspecial();
		
		Cliente carlos = new Cliente();
		carlos.nome = "Eduardo";

		clientes[0] = carlos;
		
		System.out.println(carlos.nome);
		System.out.println(clientes[0].nome);

		carlos.nome = "Santos";//o array é de referencia, é um ponteiro, todas as duas váriaveis apontam para o mesmo ponteiro.

		System.out.println(carlos.nome);
		System.out.println(clientes[0].nome);

		int[] valores = new int[10];
		/*
		//não posso pegar um array int e acessa-lo em um array long
		long numeros[] = (long[]) valores;//	Cannot cast from int[] to long[]
		*/
		String[] nomes = {"Antonio", "Donizildo"};
		
		Object[] objetos;
		
		objetos = nomes;//String é um object, ele pode ser acessado pois é compátivel
		
		for (Object o : objetos ) {
			System.out.println(o);
		}
		
		
		
		
		
		
		
		System.out.println("Exercicio02");
	}

}

class ClienteEspecial extends Cliente {}