
/**
 *
 * 1 - Declarar e inicializar variáveis
 * https://help.github.com/articles/adding-a-remote/
 * 
 */

package br.com.certificacao.aula02;


class Motor {
	//referencia não inicializada;
}

class Carro {
	int ano;
	char primeiraLetra; //char no java é um valor numerico, se não inicializado o default é 0;
	boolean usado; 
	Motor motor;
	String marca;
	
	//valores padrões são 0, false ou null;
	
	//byte = -128 a 127
}


interface E {
	public static final int TAMANHO = 15;
	public abstract void autentica ( String login, String senha );
	
}

public class Exercicio01
{
	
	
	//toda palavra reservada do java em minusculo
	//false, true, null...
	
	
	
	
	public static void main ( String[] args )
	{
		
		boolean bonitão79878$_$$ = true;
		boolean $ok1 = true;
		boolean _ok2 = true;
		//boolean _ok3 = false;
		
		
		float f = 13.1f;
		double v = 10.2d;


		char c = 66;//tabela unicode deve ser equivalente....
		System.out.println(c);
		
		//posso colocar _ entre 2 digitos;
		long x2 = 12__234_234_143_124l;
		System.out.println(x2);
		

		long l = 12l;
		int idade = 15;
		idade = 16;
		System.out.println(idade);

		int[] valores1 = new int[10];
		System.out.println(valores1[0]);
		
		String[] valores2 = new String[10];
		System.out.println(valores2[0]);
		
	
		
		//se colocar 0 na frente do int será definido base octal, o octal 10 é referente ao decimal 8
		int i = 010;
		System.out.println("Octal: " + i);

		//se colocar 0x na frente do int será definido base hexadecimal, o hexadecimal 0xA é referente ao decimal 8
		int h = 0xF; //15
		System.out.println("Hexadecimal: " + h);
		
		//se colocar 0b1 na frente do int será definido base binaria, 0 e 1...
		int b = 0b0010;
		System.out.println("Binario: " + b);
		
		Carro carro = new Carro();
		
		System.out.println(carro.ano);
		System.out.println(carro.primeiraLetra);
		System.out.println(carro.primeiraLetra == carro.ano);
		System.out.println(carro.usado);
		System.out.println(carro.motor);
		System.out.println(carro.marca);
	}
	
}