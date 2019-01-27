/**
 * 
 * 
 * https://help.github.com/articles/adding-a-remote/
 * 
 */
package br.com.certificacao.aula01;

/**
 * @author carloss
 *
 * Escopo Local
 * shadowing (é uma váriavel com escopo local com mesmo nome de váriavel de instancia ou static)
 */
public class Exercicio01 {

	static int id = 1;
    static int x = 15;
    static int i = 3;
	
	/**
	 * 
	 */
	public Exercicio01() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Introdução;
		System.out.println("ID: " + id);
		id = id + 1;
		System.out.println("ID: " + id);

		System.out.println("***************");
		//Exercicio 2 - shadowing;
        x = 200;//-------------------------------------shadowing
        System.out.println(x);

		System.out.println("***************");
		//Exercicio 3; Posso instanciar Variaveis de Classes (Static)
		for (new Exercicio01().i = 10; new Exercicio01().i < 100; new Exercicio01().i++) {
			System.out.println(i);
    	}
		System.out.println(i + " -> não sai do foreach variável local");

		System.out.println("***************");	   
		//Exercicio 1; Escopo Local entre blocos.
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }		
        int i = 15;
        System.out.println(i);
	}

}
