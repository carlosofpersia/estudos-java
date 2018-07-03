package br.com.certificacao.aula05;

public class Exercicio03 {

	public Exercicio03() {
		System.out.println("5 - Certificação Java SE 7 Programmer I - Laços");
		System.out.println("3 - Crie e use laços do tipo do-while");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args)
	{
	
		//Do - while
		
		int i = 20;
		while ( i < 10 ) {            //só executa se passar da condição.
			System.out.println("while.i" + i);
			i++;
		}
		
		/**********************************************************/
		int j = 20;
		do {                 //no Do-while será executado pelo menos uma vez.
			System.out.println("Dowhile.j" + j);
			j++;
		} while (j < 10);

		/**********************************************************/
		int x = 0;
		do
			System.out.println("Dowhile.x" + x++);
			//x++;//mais de uma expressão não compila se tiver sem chaves
		while (x < 10);//obrigado a ter ; depois da palavra while
	}

}
