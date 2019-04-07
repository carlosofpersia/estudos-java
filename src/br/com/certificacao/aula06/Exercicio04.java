package br.com.certificacao.aula06;

class A {

	int i = 15;
	String nome;
//	int tamanhoNome = tamanhoNome();
	String sobrenome = "Santos";
	int tamanhoSobrenome = tamanhoSobrenome();

	//posso alterar o tipo de acesso, se alterar o tipo de retorno se torna um método comum
	//deve ser identico ao nome da classe.
	//se o inicializador ficar antes da chamda será nullPointerException
	//deve respeitar a ordem de chamadas.
	//String sobrenome = "Santos";
	
	//Sobrecarga de construtores
	A() {
	}

	//Sobrecarga de construtores (parametros diferentes)
	A(String nome) {
//		imprimeNome();
		this.nome = nome;

		//chamar um método no construtor deve-se tomar muito cuidado, mais ainda se for sobrescrito nas classes filhas.
		imprimeNome();
		System.out.println("Tamanho Sobrenome: " + tamanhoSobrenome);
	}
	
	//cuidado que se colocar private ele pegara apenas da classe original
	private void imprimeNome()
	{
		System.out.println("Tamanho nome: " + nome.length());
	}
	


	//cuidado para não dar loop infinito no construtor.
//	A() {
//		new A();
//	}
	
	int tamanhoSobrenome()
	{
		return sobrenome.length();
	}
	
//	constutor padrão. pode ou não estar implementado.
//	A() {
//		super();
//	}

//	não vai funcionar pq as váriaveis membros são instanciadas antes do construtor.
//	int tamanhoNome() {
//		return nome.length();
//	}

}

class B extends A {
	B(String s) {
		super(s);
	}

	void imprimeNome() {
		System.out.println("Tamanho nome Classe B: " + nome.length());
	}
}

public class Exercicio04 {

	//Se a classe é pública o construtor padrão é público, mas posso alterá-lo.
	public /*não precisa colocar públic o compilador já entende*/ Exercicio04()
	{
//		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
//		System.out.println("4 - Diferença entre o construtor padrão e construtores definidos pelo usuário");
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args)
	{

		A a = new A();
		A b = new A("Carlos Eduardo");
		System.out.println(b.i);
		
		B c = new B("Brenna Lídia");
		
		System.out.println("Exercicio04");
	}

}
