package br.com.certificacao.aula08;

public class Exercicio3 {

	Exercicio3() {
		super();
		System.out.println("8 - Certificação Java SE 7 Programmer I - Lidando com exceções");
		System.out.println("3 - Crie um bloco try-catch e determine como exceções alteram o fluxo normal de um programa");
	}

	
	
	public static void main (String[] args) {

		String nome = null;
	
		try {

			nome.toLowerCase();
			System.out.println("Linha Seguinte a Excessão.");

		//} catch ( java.io.IOException ex ) {
			//Checked - java.io.IOException
			//não é filha de RuntimeException
			//se acontecer algo que tenha a ver com a excessão ou erro.
			//só pode ser usada se tiver funcionalidade referente a essa excessão
			/*Throwable*/ /*Exception*/ /*NullPointerException*/
			//System.out.println( "NullPointerException: " + ex.getMessage() );
			
		} catch ( NullPointerException ex ) {
			//
			//Throwable(Tudo), Exception(Checked), RuntimeException(Unchecked), NullPointerException (Unchecked)
			System.out.println( "NullPointerException: " + ex.getMessage() );
		
		}
		System.out.println("Aula08.Exercicio3");

	}
}