/*página 396*/
package br.com.certificacao.livro.caelum;

import java.time.LocalDate;
import java.util.Locale;

public class Capitulo09 {

	private String nome;

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}	

	public String toString() {
		return "* Print de um objeto chama um public String toString *";
	}
	
	public static void main (String[] args) {


		String s1 = "1Z0-808";
		StringBuilder sb1 = new StringBuilder("1Z0");
		s1.replaceAll("-", "");
		System.out.println(s1.equals(sb1.toString()));
		System.out.println(sb1);
		System.out.println(s1);
		
		
	

		StringBuilder sb = new StringBuilder();//define capacity para 12
		sb.append("Carlos");
		System.out.println(sb);//define 
		System.out.println(sb.length());
		System.out.println(sb.capacity());
			for(int xy = 0; xy<10; System.out.print(xy)) {
				xy++;//12345678910
				//xy++;//246810
			}
		System.out.println();
		
	
	
		/*
		 * Encapsulamento
		 * Deixar os métodos públicos e atributos privados.
		 */
		Capitulo09 capitulo09 = new Capitulo09();
		capitulo09.setNome("Carloss");
		System.out.println(capitulo09.getNome());
		
		
		

		/*
		 * System.out (PrintStrem)
		 */
	
		/*
		 * System.out.(println|print)
		 * várias sobrecargas, inclusive de um Objeto, este chamará o toString
		 * Caso especial do Char, que será tratado com toString, todos os outros arrays serão tratados como Objetos
	     */
		System.out.println(new Capitulo09());//* Print de um objeto chama um public String toString *
		char[] arrChar = { 'a', 'b', 'c', 65, 66 };//abcAB
		System.out.println(arrChar);
		//for (char c : arrChar) { System.out.print(c+"\n"); }
		System.out.println(); //new line
		int[] i = {1, 2, 3, 4};//[I@15db9742
		System.out.println(i);
		
		System.out.println("\n");

		/*
		 * System.out.(printf|format)
		 */
		System.out.printf("Hello %s, have a nice day! %d %n", "Mario", 100);
		System.out.printf("%2$s %1$s%n", "World","Hello"); // Hello World
		System.out.printf("[%10s]%n", "foo"); //[ foo]
		System.out.printf("[%-10s]%n", "foo"); //[ foo]
		System.out.printf("[%010d]%n", 22); //somente com numeros, se usar String lançará "FormatFlagsConversionMismatchException"
		System.out.printf("[%+10d]%n", 22);
		
		System.out.printf("C");

		Locale br = new Locale("pt","BR");
		System.out.printf(br,"[%,.2f] %n", 123456.789); // 123.456,789000000

		System.out.println("\n");
		
		System.out.printf("%s\n",12); //ok
		System.out.printf("%d\n",new Integer(321)); //ok
		System.out.printf("%d\n",(short)(byte)(double) 127); //ok

		System.out.println("\n");

		System.out.printf(">%-(8.2f<%n",12.45);//ok
		System.out.printf(br, ">%0,8.2f<%n",12.45);//ok
		System.out.format(">%0(8.2f<%n",12.45);
		System.out.format(">%1$08.2f<%n",12.45);
		System.out.printf(">%0,(8.2f<%n",12.45);
				
		System.out.println("\n");		

		System.out.println(new char[]{'a','b','c'}); // toString
		System.out.println(new byte[]{'a','b','c'}); // Objeto
		System.out.println("abc"); // toString
		System.out.println(new String[]{"abc"}); // Objeto
		
		System.out.println("\n");
		
		
		
		
	}
}