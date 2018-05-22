package br.com.certificacao.aula02;


class Calculadora {	
	public int soma (String nome, int... numeros) 
	{

		/*
		 * (int... numeros) -> varargs  
		 * somente um tipo, 
		 * deve ser o último parametro do método
		 * 
		 * um varargs é um array, mas o array não é um varargs
		 */

		int soma = 0;
		for (int i = 0; i < numeros.length; i++) {
			soma += numeros[i];
		}
		return soma;
	}
}

public class Exercicio05 {
	
	String nome;

	public Exercicio05() {

		setNome("Carloss");
		System.out.println(getNome());
	}

	public String getNome ()
	{
		return this.nome;
	}
	
	public void setNome (String nome)
	{
		this.nome = nome;
	}
	
	public static void main (String[] args) 
	{
		Calculadora calc = new Calculadora();
		System.out.println( calc.soma("nomeA", 2,5) );
		System.out.println( calc.soma("nomeB", 2,5, 7, 10, 10) );
		System.out.println( calc.soma("nomeC",  0,1,2,3 ) );
		System.out.println( calc.soma("nomeD" ) );
		System.out.println( calc.soma("nomeE",  2 ) );
		
		Exercicio05 e05 = new Exercicio05();
	}

}
