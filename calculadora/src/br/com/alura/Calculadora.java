package br.com.alura;

public class Calculadora {

	/*
	 * 
	 * alvo target -> build, ou seja, arquivos .class
	 * 
	 * Separar codigo fonte *.java do build *.class
	 * 
	 * javac -sourcepath src -d target src/Calculadora.java
	 * 
	 * javac -sourcepath src/main -d target/classes -cp lib/xstream-1.4.8.jar
	 * src/main/Calculadora.java
	 * 
	 * 
	 * 
	 * 
	 * 
	 * separar fonte do target:
	 * javac -sourcepath src -d target src/br/com/alura/Calculadora.java
	 * 
	 * java -classpath . br/com/alura/Calculadora
	 * 
	 */

	public static void main(String[] args) {

		System.out.println("6 + 6 resulta em: " + (6 + 6));
	}
}
