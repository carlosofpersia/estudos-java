
//7 - Criando e Manipulando Strings
package br.com.certificacao.aula02;

import org.hibernate.boot.model.source.spi.SubclassEntitySource;

public class Exercicio07 {

	public Exercicio07() {
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args) {
		
		
		String texto = "Pretendo fazer a prova de certificação de JAVA";
		System.out.println(texto.indexOf("Pretendo")); //indexOf encontra a primeira posição da palavra desejada.
		System.out.println(texto.indexOf("prova"));
		System.out.println(texto.indexOf("Pretendia"));//palavra que não existe retorna -1
		System.out.println(texto.indexOf("a"));//primeira posição da primeira letra a

		System.out.println(texto.indexOf("e", 7));//primeira posição da letra e depois da posicao 7
		System.out.println(texto.lastIndexOf("a"));//última posição da letra a
		
		
		System.out.println("**********************************************");
		System.out.println(texto.startsWith("Pretendo"));
		System.out.println(texto.startsWith("Pretendia"));
		System.out.println(texto.endsWith("C#"));
		System.out.println(texto.endsWith("JAVA"));
		System.out.println("**********************************************");
		
		
		System.out.println("Doido".compareTo("Abacate"));
		System.out.println("Doido".compareTo("Doido"));
		System.out.println("Doido".compareTo("Hipopotamo"));

		System.out.println("Doido".compareTo("doido"));
		System.out.println("Doido".compareToIgnoreCase("doido"));
		
		
		System.out.println("**********************************************");

		System.out.println("JAVA".equals("java"));
		System.out.println("JAVA".equalsIgnoreCase("java"));
		
		
		System.out.println("**********************************************");
		
		
		String parseado = "  Quero tirar a certificação oficial  ".toUpperCase().trim();
		System.out.println(parseado);
		System.out.println(parseado.substring(6, 11));//retirar um pedaço da string
		
		
		//A string é imutavel
		String s = "carlos";
		s.toUpperCase();//imutável
		System.out.println(s);
		s = s.toUpperCase();//referencio novamente, daí funciona, ou seja, uma nova string.
		System.out.println(s);
		
		System.out.println(s.charAt(0));//C de Carlos
		System.out.println(s.charAt(3));//L de Los
		System.out.println("Tamanho da String: " + s.length());//
		
		System.out.println("".isEmpty());
		System.out.println("carlos".isEmpty());
		System.out.println("       ".isEmpty());

		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.isEmpty());
		
		
		String nomeCompleto1 = "Carlos Eduardo dos Santos".substring(7, 14);
		System.out.println(nomeCompleto1.concat(" Sincero e Belo!"));
		
		System.out.println("   abcde    ".trim());
		
		
		String nomeCompleto2 = "Antonio Donizildo";
		System.out.println(nomeCompleto2.replace("o", "-X-"));
		System.out.println(nomeCompleto2.replace("Antonio", "Maria"));//A string não é alterada apenas apresentada.

		//System.out.println(s.charAt(200));//se não encontrar a String -> java.lang.StringIndexOutOfBoundsException
		
		
		
		String nomeDireto = "JAVA";
		
		String nomeIndireto = new String("JAVA");
		
		System.out.println(nomeDireto +"::"+ nomeIndireto);
		
		
		char[] nome1 = new char[] { 'J', 'A', 'V', 'A' };
		String nome2 = new String(nome1);

		System.out.println(nome1[0] +"::" + nome2);
		
		
		StringBuilder nome3 = new StringBuilder("JAVA");
		String nome4 = new String(nome3);
		
		System.out.println(nome3 +"::"+ nome4);
		
		
		String nome5 = null;
		
		String nome6 = nome4 + "::" + nome5;
		System.out.println(nome6);
		
		
		
		System.out.println("Certificacao " + 1500);
		System.out.println(1500 + " Certificacao ");		
		
		//concatenação, sempre da esquerda para direita
		System.out.println(1 + 500 + " Certificacao ");//soma os numeros depois concatena a string ( 1 + 500 = 501 )
		System.out.println(15 + 00 + " Certificacao ");//soma os numeros depois concatena a string ( 15 + 0 = 15 ) ou
		System.out.println(15 + (0 + ( 0 + " Certificacao " ) ) ) ; //para resover o problema de somar os inteiros da esquerda para direita basta usar parentes
		
		//não posso usar método com valor null, vai rolar java.lang.NullPointerException
		//System.out.println(nome5.toString());
		
		
		
		
	}
	
}
