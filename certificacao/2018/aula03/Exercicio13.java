package br.com.certificacao.aula03;

public class Exercicio13 {

	public Exercicio13() {
		// TODO Auto-generated constructor stub
		
		System.out.println("13 - Utilize o switch");
	}
	
	public static void main (String[] args) {
		
		
		int opcao = 3;
		//switch inteiro ou string

		final int variavelFinal = 3; //somente aceita váriavel se ele for final. (constante)

		switch ( opcao ) {
			case 1:
				System.out.println("Opcao 1");			
				break;
	
			case 2:
				System.out.println("Opcao 2");	
				break;
				
			case variavelFinal:	
				System.out.println("Opcao 3");	
				break;
	
			case 4:
				System.out.println("Opcao 4");
				break;

			case 5://posso ter case vazio.
				System.out.println("Opcao 5");
				
				
			default:
				 //não importa a ordem, só funciona quando nenhum outros caras fazer o match.
				System.out.println("Opcao Errada");
				break;
		}
	}
}
