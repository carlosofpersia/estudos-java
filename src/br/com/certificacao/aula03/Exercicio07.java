package br.com.certificacao.aula03;

public class Exercicio07 {

	public Exercicio07() {
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args) {
		
		
		System.out.println("Casting JAVA");
		
		
		double d = 15.3;
		//int i = d;//pode perder precisão. da esquerda para direita ok.
		
		int i = (int) d;//solução usar Casting
		System.out.println(i);

		long l = 1515151515151515l;
		int i2 = (int) l;//se não couber pode estourar, inclusive virar um número negativo, esse é o risco do casting
		System.out.println(i2);

	}
}
