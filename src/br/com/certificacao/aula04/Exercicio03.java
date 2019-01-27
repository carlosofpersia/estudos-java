package br.com.certificacao.aula04;

public class Exercicio03 {

	public Exercicio03() {
		System.out.println("3 - Declare, instancie, inicialize e use um array multi-dimensional");
	}

	
	public static void main (String[] args)
	{
		
		
		//
		
		int [][] tabela; //2 dimensões;
		
		int [][] cubo[]; //3 dimensões;
		
		int [][] hipercubo[][]; //4 dimensões;

		tabela = new int[10][5];
		cubo = new int[10][][];

		int [][] teste = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(teste[0][2]);
		System.out.println(teste[1][1]);
		System.out.println(teste[2][0]);

		int [][] estranho = new int[2][];//quando defino o primeiro eu tenho que instanciar o tamanho do 2 quando eu o instancio
		estranho[0] = new int[20];
		estranho[1] = new int[10];
		for( int i = 0; i < estranho.length; i++ ) {
			System.out.println("Tamanho: " + estranho[i].length);
		}
		
		
		System.out.println("Exercicio03");
	}
}
