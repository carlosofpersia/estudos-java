package br.com.certificacao.aula09;

public class Exercicio2_2 {

	Exercicio2_2 () {
		super();
		System.out.println("9 - Certificação Java SE 8 Programmer I - Conteúdo além da prova");
		System.out.println("2 - Deenvolver código que usa classes wrappers como boolean, Double e Integer. Continuação..");
		System.out.println("Acessar cálculos com Wrappers.");
	}

	public static void main (String[] args) {

		Integer intWrapperJava5 = Integer.valueOf(17);
		intWrapperJava5++;//box and unbox faz-se por baixo dos panos.
		System.out.println( intWrapperJava5 );

		/****************************************************/

		//Forma antiga e ruim, pois fazia manualmente todo o processo.
		Integer intWrapper = Integer.valueOf(10);
		int intPrimitivo = intWrapper.intValue();//converte wrapper para primitivo.
		intPrimitivo++;
		intWrapper = Integer.valueOf(intPrimitivo);

		/****************************************************/

		System.out.println("Aula09.Exercicio2_2");
	}	
}