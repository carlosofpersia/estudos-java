package br.com.certificacao.aula09;

@FunctionalInterface
interface Matcher<T> {
	boolean test(T t);
}

class Pessoa extends Matcher {
	public boolean test(Pessoa p) {
		//...
	}
}

public class Exercicio4 {

	Exercicio4 () {
		super();
		System.out.println("9 - Certificação Java SE 8 Programmer I - Conteúdo além da prova");
		System.out.println("4 - Escreva uma expressão Lambda simples que consuma uma expressão Lambda Predicate");
	}

	public static void main (String[] args) {

		//Lambda Predicate

		//interface funcional, são interfaces que possuem apensas um método, onde se encaixam os lambdas
		
		//para usar os lambdas é necessário implementar uma interface funcional, ou usar uma que o java disponibiliza:
		//Predicate, Runnable...
		
		

		//Interface Predicate

		//java 8
		//Predicate é uma interface funcional do java 8, para trabalhar com lambda
		//Interfaces funcionais só tem um metodo, e a Predicate é um método do java 8 generico para isso.

		//(parametros) -> { codigo }
		
		(String s1, String s2) -> { codigo };  //(s1, s2) -> { codigo };
		s1 -> {codigo}
		Runnable r = () -> {codigo}

		Runnable r = () -> System.out.println("msg") //só uma linha de código não precisa de chaves;

		//várias linhas precisam de chaves;
		Runnable r2 = (/*parametros*/) -> {
			System.out.println("msg1"); 
			System.out.println("msg2"); 
		}
		
		Pessoa p = new Pessoa();
		Predicate<Pessoa> criterio = p /*parametros*/ -> return p.idade >= 18;
		//é o mesmo de:
		Predicate<Pessoa> criterio = p -> p.idade >= 18;
		//ou
		Predicate<Pessoa> criterio = (Pessoa p) -> {
			return p.idade >= 18;
		}
		//ou


		Pessoa p = (new Pessoa(), new Pessoa() /*com parametros*/) -> {
			System.out.println("msg1"); 
			System.out.println("msg2"); 			
		}
		
		//ou
		
Pessoa p = (/*sem parametros*/) -> {
			System.out.println("msg1"); 
			System.out.println("msg2");
			return new Pessoa();
		}
		
		
		
		System.out.println("Aula09.Exercicio4");
	}
}