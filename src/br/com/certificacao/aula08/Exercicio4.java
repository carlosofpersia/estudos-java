package br.com.certificacao.aula08;


class AcessoAoArquivo {
	
	//da pau aqui pq FileInputStream precisa da IOException do tipo "CHECKED";
	java.io.InputStream is = new java.io.FileInputStream("a.txt");
	
	AcessoAoArquivo () throws java.io.FileNotFoundException {

		//para não dar pau, preciso colocar o throws no contrutor para resolver o problema de FileInputStream
	}
}


class SaldoInsuficienteException extends Exception {

	SaldoInsuficienteException(String msg) {
		super(msg);
		System.out.println("SaldoInsuficienteException.construtor -> " + msg);
	}
}

class ContaDoBem {

	double saldo = 100;

	/*
	throws java.io.IOException
	Diz que eu posso ter uma IOException ou não, mas não trata.
	*/
	void saca( double quantidade ) throws SaldoInsuficienteException /* java.io.IOException*/ {
		if( this.saldo < quantidade ) {
			/*
			----------------------------------------------
			IllegalArgumentException 
			Extende de RuntimeException, que é UNCHECKED, ou seja, 
			não precisa colocar try catch.
			*/
			//throw new IllegalArgumentException( "Saldo Insuficiente: " + quantidade );
			
			/*
			----------------------------------------------
			IOException, essa é CHECKED, ou seja, 
			Obrigatório colocar try catch.
			*/
			//throw new java.io.IOException( "Saldo Insuficiente: " + quantidade );
			
			/*
			----------------------------------------------
			*/
			throw new SaldoInsuficienteException( "Saldo Insuficiente: " + quantidade );
		}
		saldo -= quantidade;
	}
}

public class Exercicio4 {

	Exercicio4() {
		super();
		System.out.println("8 - Certificação Java SE 7 Programmer I - Lidando com exceções");
		System.out.println("4 - Invoque um método que joga uma exceção");
	}
 
	public static void saqueBanco() {
		String s = null;
		
		try {

			s.length();
			(new ContaDoBem()).saca(500);
			/*
		} catch (java.io.IOException e) {
			System.out.println("Tratei o java.io.IOException da ContaDoBem.saca" + e.getMessage());
			*/
		} catch( NullPointerException e ) {
			System.out.println("NullPointerException.saqueBanco: " + e.getMessage());
		} catch( RuntimeException e ) {
			//devo respeitar a ordem das exceções
			//pega pela hierarquia, primeiro as filhas... se colocar a pai primeiro não compila
			//NullPointerException extend de RuntimeException
			System.out.println("NullPointerException.saqueBanco: " + e.getMessage());
		} catch ( SaldoInsuficienteException e ) {
			System.out.println("SaldoInsuficienteException.saqueBanco: " + e.getMessage());
		}
	}
 
	public static void metodo1() {
		String s = null;
		System.out.println("Primeiro Antes");
		try {
			metodo2();
			System.out.println("Primeiro Depois");
		} catch(NullPointerException e) {
			System.out.println("Primeiro Tratado");
		}
		System.out.println("Primeiro Fim");
	}

	public static void metodo2() {
		String s = null;
		System.out.println("Segundo Antes");
		s.length();
		System.out.println("Segundo Depois");
	}
	
	public static void main (String[] args) {

		saqueBanco();
		metodo1();

		System.out.println("Aula08.Exercicio4");
	}
}