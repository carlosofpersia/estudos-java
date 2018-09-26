package br.com.certificacao.aula06;

class Prova {
	int tempo;
}

public class Exercicio8
{
	Exercicio8()
	{
		super();
		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
		System.out.println("8 - Efeito que ocorre com ref a obj e a tp primitivos passados a outros métodos");
	}
	
	static void teste( Prova prova ) {
		
		prova.tempo = 210;
	}

	static void teste2( Prova prova ) {
		prova = new Prova();
		prova.tempo = 520;
	}
	
	static int teste(int i ) {
		i = 5;
		return i;
	}

	public static void main (String[] args)
	{
		
		Prova prova = new Prova();
		prova.tempo = 100;
		teste(prova);
		System.out.println(prova.tempo);
		
		
		teste2(prova);//garbage colection arrasta...
		System.out.println(prova.tempo);
		
		
		
		/* 
		 * PILHA       Memória
		 * teste:17    i = 2 // é o mesmo valor, mas são 2 números 2. este saí para o garbage collection.
		 * main:23     i = 2
		*/

		int i = 2;
		
		teste(i);//depois que chamado pode ser garbage colectadas.
		System.out.println(i);
		i = teste(i);
		System.out.println(i);
		
		
		
		System.out.println("Exercicio8");
	}

}





		//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
		//javac br/com/certificacao/aula06/Exercicio7.java
		//java -classpath . br.com.certificacao.aula06.Exercicio7

