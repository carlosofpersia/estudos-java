package br.com.certificacao.aula08;

public class Exercicio2 {

	Exercicio2() {
		super();
		System.out.println("8 - Certificação Java SE 7 Programmer I - Lidando com exceções");
		System.out.println("2 - Descreva o que são exceções e para que são utilizadas em Java");
	}

	public void fazAlgo(int[] idades) {

		//imagina uma quantidade alta de excessões...

		//if( idades != null && idades.length >= 2 ) {
			System.out.println("Idade: " + idades[1]);
		//}
	}

	public static void main (String[] args) {

		Exercicio2 exerc = new Exercicio2();

		/*
		
Exception in thread "main" java.lang.NullPointerException
Saída do Problema:
        at br.com.certificacao.aula08.Exercicio2.fazAlgo(Exercicio2.java:16)
Origem do Problema:
        at br.com.certificacao.aula08.Exercicio2.main(Exercicio2.java:24)
		
		*/

		exerc.fazAlgo(null);
		exerc.fazAlgo(new int[5]);
		exerc.fazAlgo(new int[0]);

		System.out.println("Aula08.Exercicio2");

	}
}