package br.com.certificacao.aula03;

public class Exercicio10 {

	public Exercicio10() {
		System.out.println("10 - Teste a igualdade entre Strings e outros objetos usando == equals() - Parte 2");
		// TODO Auto-generated constructor stub
	}

	
	public static void main (String[] args)
	{
		//literais
		String ab = "a" + "b";
		System.out.println(ab == "ab");//literais apontam para a mesma referencia no pool.
		
		
		String x = "x";
		String xy = x + "y";//nesse caso está usando uma referencia para concatenar, os objetos agora são diferentes. nova váriavele..
		System.out.println(xy == "xy ");
		
		
		
		//Strings são imutaveis
		String texto = "um texto qualquer";
		String txt = texto.substring(3, 8);
		
		System.out.println(txt == "texto" );
		
		
		System.out.println(texto.toString() == texto );//nenhum novo objeto foi criado.
		System.out.println(texto.toLowerCase() == texto );//nenhum novo objeto foi criado.
		
		
		//quantos objetos foram criados?
		
		
		String h = new String ("hello ");// 2 objetos cridos, new + literal
		String h1 = "hello "; // 0 objetos criados, já existe no pool (literal), faz uma referencia
		String w = "world ";//1 objeto criado literal.
		
		System.out.println("hello "); //0
		System.out.println(h1 + "world");//1
		System.out.println("Hello " == h1);//1, H maiusculo, case sensitive muda o pool de memória
		
		
		
		
		
		
	}
	
}
