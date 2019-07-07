
//6 - Manipulando dados usando a classe StringBuilder
package br.com.certificacao.aula02;

public class Exercicio06 {

	public Exercicio06() {

		
	}
	
	public static void main (String[] args)
	{

	
		//Mutável - pode mudar de valor;
		StringBuffer sb = new StringBuffer("String");
		// ou StringBuilder sb = new StringBuilder("String");
		sb.append("::");
		sb.append("Builder");
		System.out.println(sb.toString() ); //ou System.out.println(sb );
		
		StringBuffer sb2 = new StringBuffer(10);//tamanho máximo da string.
		// ou StringBuilder sb2 = new StringBuilder(10);//tamanho máximo da string.
		System.out.println(sb2.toString() );

		StringBuffer sb3 = new StringBuffer(sb);
		// ou StringBuilder sb3 = new StringBuilder(sb);
		sb3.append(" e string Buffer de novo ");
		sb3.append(" X ");
		sb3.append(sb);//string concatena um caracter com um objeto STringBuffer ou STringbuilder, ou com string
		sb3.append("---------------");
		sb3.append(new Exercicio03());
		System.out.println(sb3);//posso usar o objeto para String sem usar o toString...
		
		StringBuilder sb4 = new StringBuilder("Caelum - Inovação");
		sb4.insert(9, " Ensino e ");
		System.out.println(sb4);
		sb4.delete(6,  15);
		System.out.println(sb4);

		StringBuffer sb5 = new StringBuffer("   CARLOS  ");
		System.out.println(sb5.toString().trim());
		
		StringBuffer sb6 = new StringBuffer("CARLOS");
		
		
		System.out.println(sb6.equals(sb5));
		System.out.println(sb6.length());
		System.out.println(sb6.reverse());
		
		
		//trabalhando com posições da string
		System.out.println(sb6.charAt(2));
		System.out.println(sb6.indexOf("R"));

		StringBuffer sb7 = new StringBuffer("CARLOS EDUARDO DOS SANTOS");
		System.out.println(sb7.lastIndexOf("DOS"));
		System.out.println(sb7.substring(2, 5));
		
		System.out.println(sb7.subSequence(2, 5));
		
		//subSequence e substring possuem o mesmo comportamento;
		

		


		
		/*
		 * StringBuffer é de uma versão mais antiga do java.
		 * 
		 * StringBuilder não sincroniza o acesso aos métodos, o StringBuffer está liberado, todo mundo acessa de uma vez só.
		 * então se for concatenar ou usar strings em uma unica thread é melhor usar o StringBuilder
		 * 
		A diferença entre StringBuilder e StringBuffer é que a StringBuilder é melhor para uma 
		única Thread, para multiplas é melhor StringBuffer
		*/
		
		
		
		
	}

}
