package br.com.certificacao.aula07;



class X {

	int x;
	public void y() {
		System.out.println("Y em um obj: " + x);
	}
	
	//o bind de um método statico é feito em compilação.
	public static void metodo() {
		System.out.println("Metodo Statico em X");
	}
}

class Y extends X {

//especialização da classe
//toda classe java herda de obj. 

/*
	public static void metodo() {
		System.out.println("Metodo Statico em Y");
	}	
*/
}

class Gato {
	
	String corDosOlhos;
	
	public String toString()
	{
		return "[Gato " + corDosOlhos + "]";
	}
}

public class Exercicio1
{
	Exercicio1()
	{
		super();
		System.out.println("7 - Certificação Java SE 7 Programmer I - Relações entre classes");
		System.out.println("1 - Implementando Herança");
	}

	public static void main (String[] args)
	{

		Y y = new Y();
		y.x = 15;
		y.y();
		
		X.metodo();
		Y.metodo();

		System.out.println("Exercicio1");
		
		X x = new Y();
		x.metodo();

		Gato g = new Gato();
		g.corDosOlhos = "mel";
		System.out.println("Teste concatenando o " + g.toString());
		
		System.out.println("Exercicio1");

	}
}




//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
//javac br/com/certificacao/aula06/Exercicio7.java
//java -classpath . br.com.certificacao.aula06.Exercicio7
