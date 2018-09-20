package br.com.certificacao.aula06;


class Livro {
	
	//Sobrecarga de construtores...
	Livro () {
		//this(123);//cuidado com loop infinito.
		System.out.println("construtor Sem Argumentos");
	}

	Livro (String... s) {
		
		for( String ss : s ) {
			System.out.println(ss);
		}
		
		System.out.println("construtor com varargs");
	}

	Livro (int i) {
		//tomar cuidado com loop infinito 
		//this();//cuidado com loop infinito.

		/*
		* Só posso chamar um construtor dentro de outro 
		* deve ser a primeira instrução do construtor
		* apesar de ser a primeira instrução, ela pode receber algum valor static, metodo membro não compila
		*/

		this( valor(), "Carlos", "Eduardo", "Santos" );

		System.out.println("construtor com int");
	}		
	
	static String valor() {
		return "xpto";
	}
}

public class Exercicio5 {

	
	Exercicio5()
	{
//		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
//		System.out.println("5 - Crie e sobrecarregue construtores");
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args)
	{

		Livro l0 = new Livro();
		//Livro l1 = new Livro("Carlos");
		//Livro l2 = new Livro("Carlos", "Eduardo", "Santos");
		Livro l3 = new Livro("Carlos".length());
		
		System.out.println("Exercicio05");
	}

}
