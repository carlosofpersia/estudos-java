package br.com.certificacao.aula06;

import java.util.Random;

class Param {

	String getNumero(int a) throws RuntimeException {
		Random rand = new Random();
		if( rand.nextBoolean()) {
			System.out.println("verdadeiro");
			return "Verdadeiro";
		}
		System.out.println("getNumero.falso: ");
		throw new RuntimeException("Jogando a Exception resolve o problema!");
	}
}

public class Exercicio01 {
	
	String nome = "Carlos";//atividade da aula 06 exercicio 06 -> mesmo pacote

	public Exercicio01() {
		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
		System.out.println("1 - Crie métodos com argumentos e valores de retorno");
	}
	
	public static void main (String[] args) {
		
		
		
		Param param = new Param();
		param.getNumero(2);
		
		
		
		
		System.out.println("Exercicio01");
	}

}
