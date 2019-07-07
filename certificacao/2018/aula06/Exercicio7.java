package br.com.certificacao.aula06;

public class Exercicio7
{

		//java beans = cuidado ao usar GetSet a rodo, não é uma boa prática.
	//encapsulation or information hidden
	private String nome;

	Exercicio7()
	{
		super();
		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
		System.out.println("7 - Aplique princípios de encapsulamento a uma classe");
	}
	
	
	String getNome() {
		return nome;
	}

	void setNome(String nome) {
		if(nome == null ) nome = "";
		this.nome = nome;
	}
	
	

	public static void main (String[] args)
	{


		
		
		Exercicio7 exerc7 = new Exercicio7();
		exerc7.setNome("Carlos");
		System.out.println(exerc7.getNome());
		
		

		System.out.println("Exercicio07");
	}

}



		//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
		//javac br/com/certificacao/aula06/Exercicio7.java
		//java -classpath . br.com.certificacao.aula06.Exercicio7