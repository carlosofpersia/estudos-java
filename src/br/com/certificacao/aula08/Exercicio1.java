package br.com.certificacao.aula08;

public class Exercicio1 {

	Exercicio1() {
		super();
		System.out.println("8 - Certificação Java SE 7 Programmer I - Lidando com exceções");
		System.out.println("1 - Diferencie entre exceções do tipo checked, runtime e erros");
	}

	public static void main (String[] args) {

		/*

		Throwable - Topo da hierarquia de erros do java.
		
			* Error (OutOfMemoryError)
				- Situações extremas, o programa não se recupera
			
			* Exception (SQLException)
				- RuntimeException
					- fILHAS DE RuntimeException SÃO UNCHECKED
					- NullPointerException
					- IndexOutOfBoundsException
				- Todas as classes IRMÃS DE RuntimeException são CHECKED, O COMPILADOR OBRIGA A FAZER UM TRATAMENTO.

				OBS: Exception
				- Checked (Exception - Não é fácil evitar, are the exceptions that are checked at compile time.)
				- Unchecked (FILHOS DE Error, RuntimeException  - Erros mais simples de serem evitados, com tipos de checagem. )

		*/
	
		Exercicio1 e = new Exercicio1();

		System.out.println("Aula08.Exercicio1");
	}	
}