package br.com.certificacao.aula07;

class A {
	
	long numeroGrande;
	
	A () {
		//super explicito
		System.out.println("Vazio");
	}
	
	A (String s) {
		System.out.println("String: " + s);
	}

	A (int i) {
		System.out.println("A.int: " + i);
	}
	
}

class B extends A {

	long numeroGrande;

	B (String s) {
		//mesmo que eu não escreva o padrão é super sem argumentos.
		//posso colocar ou não, ela é explicita; 
		//somente 1º linha (super|this)
		//super();
		System.out.println("B.String: " + s);
	}

	B(int i) {
		//cuidado que ele percebe loop nos contrutores, caso haja.
		//super|this deve ser somente a primeira instrução ou explicito
		this("B.String.Carloss"); 
		
		super.numeroGrande = 10;
		System.out.println(super.numeroGrande);

		this.numeroGrande = 15;
		System.out.println(numeroGrande);

		System.out.println("Fim construtor com o número: " + i);
	}
	
	public String getNumeroGrandeA() {
		System.out.println("A: " + super.numeroGrande);
		return "B";
	}
	
	public String getNumeroGrandeB() {
		System.out.println("B: " + this.numeroGrande);
		return "B";
	}
}
 
public class Exercicio5
{
	public static int i;
	
	Exercicio5()
	{
		super();
		System.out.println("7 - Certificação Java SE 7 Programmer I - Relações entre classes");
		System.out.println("5 - Use super e this para acessar objetos e contrutores");
	}

	public static void main (String[] args)
	{
		//
		B b = new B(7);
		((A) b).numeroGrande = 27;//forçar a váriavel pegar do pai.
		//((B) b).numeroGrande = 27;
		//b.numeroGrande = 27;
		System.out.println(b.getNumeroGrandeA());
		System.out.println(b.getNumeroGrandeB());
		
		//(this|super) não chamam objetos staticos.
		Exercicio5.i = 10;
		
		System.out.println(Exercicio5.i);
		
		

		System.out.println("Exercicio5");
	}
}

//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
//javac br/com/certificacao/aula07/Exercicio2.java
//java -classpath . br.com.certificacao.aula07.Exercicio2
