package br.com.certificacao.aula08;

import java.util.*;

class BlocoEstatico {
	static {
		//bloco estatico
		//quando chamar a classa em qualquer momento, esse bloco será carragado
		//lançara a excessão e jogara um error por ser estático
		//sempre que instanciar a classe BlocoEstatico que tem esse (static) que esta com NullPointerException vai dar erro tb por ser estatico.
		String s = null;
		s.length();

		System.out.println("BlocoEstatico.static");
	}
}

class NovaConta {
	double saldo = 100;
	public void saca(double valor) {
		if(saldo < valor) {
			//usado quando o valor não bate com o que esperavamos.
			throw new IllegalArgumentException();
		}
		saldo -= valor;
	}
}

class Tarefa {
	boolean rodando = false;
	void start() {
		if( rodando ) {
			//estado em que não era para ser chamado esse metodo novamente. 
			throw new IllegalStateException();
		}
		rodando = true;
	}
	void stop() {
		rodando = false;
	}
}

public class Exercicio5 {

	Exercicio5() {
		super();
		System.out.println("8 - Certificação Java SE 7 Programmer I - Lidando com exceções");
		System.out.println("5 - Reconheça classes de exceções comuns e suas catagorias");

	}
	
	void metodoLooping() {
		metodoLooping();
	}

	
	public static void main (String[] args) {

		//********************************************************
		//Exception in thread "main" java.lang.OutOfMemoryError
		//erro de estouro de memoria
		boolean sempre = true;
		ArrayList<String> strings = new ArrayList<String>();
		String inicial = "carloss";
		while(sempre) {
			inicial += "carloss";
			strings.add(inicial);
		}
		//java.lang.OutOfMemoryError

		//********************************************************
		//para teste tenho que remover manualmente a classe .class "C:\Users\f545974\Documents\Carloss\Desenvolvimento\estudos-java\src\br\com\certificacao\aula08\Tarefa.class"
		//erro se da quando o interpretador não encontra a classe compilada .class.
		new Tarefa();//java.lang.NoClassDefFoundError
		
	
		//********************************************************
		(new Exercicio5()).metodoLooping();//java.lang.StackOverflowError
	
	
		//********************************************************
		BlocoEstatico bea = new BlocoEstatico();//
		/*
Exception in thread "main" java.lang.ExceptionInInitializerError
        at br.com.certificacao.aula08.Exercicio5.main(Exercicio5.java:54)
Caused by: java.lang.NullPointerException
        at br.com.certificacao.aula08.BlocoEstatico.<clinit>(Exercicio5.java:11)
        ... 1 more
		*/

	
	
		//********************************************************
		Tarefa t = new Tarefa();
		t.start();
		t.start();//java.lang.IllegalStateException

		//********************************************************
		(new NovaConta()).saca(300);//java.lang.IllegalArgumentException
	
	
		//********************************************************
		String numero1 = "1a";
		int um = Integer.parseInt(numero1);//java.lang.NumberFormatException
		


		//********************************************************
		Object o = "guilherme";
		Date data = (Date) o;//java.lang.ClassCastException

		
		//********************************************************
		String s = null;
		s.length();//java.lang.NullPointerException

		
		//********************************************************
		int[] i = new int[15];//15 posições, ou seja, de '0...14'
		i[14] = 7;
		i[15] = 13;//java.lang.ArrayIndexOutOfBoundsException

		//********************************************************
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Carloss");//posição 0
		lista.add("Eduardoo");//posição 1
		lista.get(1);
		lista.get(2);//java.lang.IndexOutOfBoundsException


		//********************************************************		
		System.out.println("Aula08.Exercicio5");
	}
}