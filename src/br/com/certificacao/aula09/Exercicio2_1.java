package br.com.certificacao.aula09;

public class Exercicio2_1 {

	Exercicio2_1() {
		super();
		System.out.println("9 - Certificação Java SE 8 Programmer I - Conteúdo além da prova");
		System.out.println("2 - Deenvolver código que usa classes wrappers como boolean, Double e Integer");
	}

	public static void main (String[] args) {

		//WRAPPERS

		//Wrapper to String = toString()
		//String to Primitivo = parseXxxx -> parseDouble
		//WRAPPER to PRIMITIVO = xxxValue -> intValue
		//Instanciar Wrapper = Double.valueOf(123.5);

		/*
			- Para cada uns dos primitivos existe um Wrapper -
			boolean = Boolean
			byte = Byte;
			short = Short;
			int = Integer;
			char = Character;
			long = Long;
			double = Double;
			float = Float;
		*/

		/*************************************************/

		//de primitivo para String, usar o toString().
		//esse toString é um método statico das classes wrappers
		//também pode receber uma base se necessário.
		String d50 = Double.toString(24.6);
		String d51 = Integer.toString(010, 8);



		/*************************************************/
		
		//para os Inteiros existem 2 tipos de acesso:
		Integer i40 = Integer.valueOf("23");
		//se não colocar a base, será decimal normal e nesse caso da pau
		Integer i41 = Integer.valueOf("5AF", 16);

		//Outra forma de usar o Wrapper.
		//pelo construtor normal:
		//Gerar um wrapper usar: valueOf
		Double d30 = new Double (12.7);
		Double d31 = new Double ("11.4");
		Double d32 = Double.valueOf(15.2);
		Double d33 = Double.valueOf("13.8");

		/*************************************************/

		//Converter STRING para PRIMITIVO usar parseXxxx()
		//todos os parse possuem um metodo statico: parseXXXX;
		//Gerar de String para Primitivo: parseXXXX
		//converter String para Primitivo
		
		double d20 = Double.parseDouble("123.6");
		int i20 = Integer.parseInt("123555");

		//converter as bases.
		int i21 = Integer.parseInt("10", 10);//mudar a base para decimal
		int i22 = Integer.parseInt("11", 16);//mudar a base para hexadecimal
		int i23 = Integer.parseInt("A", 16);//mudar a base para hexadecimal
		int i24 = Integer.parseInt("010", 8);//mudar a base para octal
		int i25 = Integer.parseInt("11", 2);//mudar a base para binario
 
		
		/*************************************************/

		//Converter WRAPPER para PRIMITIVO usar xxxValue()
		//Gerar de WRAPPER para PRIMITIVO: intValue
		//wrapper
		Long l = new Long("123");//wrapper
		//TipoPrimitivo + Value;
		long l1 = l.longValue();//conversão
		int i = l.intValue();
		double d = l.doubleValue();

		boolean b = (new Boolean("T")).booleanValue();
		char char1 = (new Character('a')).charValue();

		/*************************************************/

		//para ser true tem que ser escrito "true", qualquer coisa diferente dessa palavra será falso.
		Boolean b1 = new Boolean (true);
		Boolean b2 = new Boolean ("true");//verdadeiro
		Boolean b3 = new Boolean ("verdadeiro");//falso
		Boolean b4 = new Boolean ("true ");//true com espaço = falso

		/*************************************************/

		//somente este construtor em character
		Character c = new Character('a');

		/*************************************************/

		//2 construtores -> normal e string, mas floats válidos.
		Double d1 = new Double(22.5);
		Double d2 = new Double("10.2");
		//Double d3 = new Double("abc");//java.lang.NumberFormatException
		
		/*********************************************/
		
		
		
	
	
		System.out.println("Aula09.Exercicio2_1");
	}	
}