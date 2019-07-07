package br.com.certificacao.aula03;

public class Exercicio06 {

	public Exercicio06() {
		
		System.out.println("operador ternário");
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args) {
		
		System.out.println("testaOperadorDeReferencia");
		
		
		
		String nome = "Carlos";
		int tamanho = nome.length();
		
		System.out.println(nome);
		System.out.println(tamanho);
		
		String nomeCompleto = nome + " Eduardo";//concatenacao
		System.out.println(nomeCompleto);
		
		
		System.out.println("-------------------------------------");
		
		
		
		
		System.out.println("operador ternário");
		
		int i = 5;

		int resultado = (i == 5) ? 100 : 0;
		System.out.println(resultado);
		
		
		System.out.println(resultado);
		
		
		//se usar dentro do sysout ele resolve, fora da erro:
		System.out.println((i == 5) ? "100" : 0);

		//int resultado2 = (i == 5) ? "100" : 0;// da pau de incompatibilização de tipos
		//System.out.println(resultado2);
		
		
		
		double resultado3 = (i == 5) ? 100 : 0d;
		System.out.println(resultado3);
		
	}
}
