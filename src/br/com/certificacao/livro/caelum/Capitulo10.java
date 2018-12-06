package br.com.certificacao.livro.caelum;

public class Capitulo10 {
	
	
	public static void main(String[] args) {
		
		//Wrappers

		Double d1 = new Double(22.5);
		Double d2 = new Double("22.5");
		//Double d3 = new Double("abc"); //throws NumberFormatException		
		Character c = new Character('d');

		/**************************************/
		//Convertendo de wrappers para primitivos: xxxValue();
		Long l = new Long("123");
		byte b = l.byteValue();
		double d = l.doubleValue();
		int i = l.intValue();
		short s = l.shortValue();

		//------------------------
		boolean b = new Boolean("true").booleanValue();
		char c = new Character('z').charValue();		

		/**************************************/

		//Convertendo de String para wrappers ou primitivos

		//Convertendo String para primitivos: parseXXX()
		
		double d = Double.parseDouble("23.4");
		long l = Long.parseLong("23");
		int i = Integer.parseInt("444");

		//wrappers de números inteiros, usa a base a ser usada para a conversão.
		short i1 = Short.parseShort("11",10); // 11 Decimal
		int i2 = Integer.parseInt("11",16); // 17 HexaDecimal
		byte i3 = Byte.parseByte("11",8); // 9 Octal
		int i4 = Integer.parseInt("11",2); // 3 Binary
		int i5 = Integer.parseInt("A",16); // 10 HexaDecimal
		int i6 = Integer.parseInt("FF",16); // 255 HexaDecimal

		//------------------------
		//Convertendo String diretamente para um wrapper: valueOf()

		Double d = Double.valueOf("23.4");
		Long l = Long.valueOf("23");
		Integer i1 = Integer.valueOf("444");
		Integer i2 = Integer.valueOf("5AF", 16);

		/**************************************/

		//Convertendo de primitivos ou wrappers para String
		Integer i = Integer.valueOf(256);
		String number = i.toString();

		//------------------------
		String d = Double.toString(23.5);
		String s = Short.toString((short)23);
		String i = Integer.toString(23);
		String l = Long.toString(20, 16);//primitivo + a base desejada (16 -> hexadecimal)

		//------------------------
		String binaryString = Integer.toBinaryString(8); //1000, binary
		String hexString = Long.toHexString(11); // B, Hexadecimal
		String octalString = Integer.toOctalString(22); // 26 Octal
		
		/**************************************/

		//autoboxing.

		/* Antes:
		Integer intWrapper = Integer.valueOf(1);
		int intPrimitive = intWrapper.intValue();
		intPrimitive++;
		intWrapper = Integer.valueOf(intPrimitive);
		*/

		Integer intWrapper = Integer.valueOf("1");
		intWrapper++; //will unbox, increment, then box again.
		
		//----------------------------------------------

		/*	
		Valores baixos é possível que o resultado seja true, mesmo usando 2 objetos diferentes.
		Todos Boolean e Byte ;
		Short e Integer de -128 até 127;
		Caracter ASCII, como letras, números etc.
		*/
		Integer i1 = 123;
		Integer i2 = 123;
		System.out.println(i1 == i2); //true
		System.out.println(i1.equals(i2)); //true

			/**/
		
		Integer i1 = 1234;
		Integer i2 = 1234;
		System.out.println(i1 == i2); //false
		System.out.println(i1.equals(i2)); //true
		
		//----------------------------------------------
		
		//NULLPOINTEREXCEPTION EM OPERAÇÕES ENVOLVENDO WRAPPERS
		Integer a = null;
		int b = 44;
		System.out.println(a + b); //throws NULLPOINTEREXCEPTION
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		System.out.println("OK");
	}
}