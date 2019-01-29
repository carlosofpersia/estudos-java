package br.com.certificacao.adoismildezenove.ajaneiro;

public class VinteOito {
	Integer x;
	int y;
	Integer a;
	int b;
	
	VinteOito(int x, int y) {
		this.a = x = x;
		this.b = y = y;

		//this.x++;//java.lang.NullPointerException

		System.out.println("Contruct.Default");
		//javac br/com/certificacao/adoismildezenove/ajaneiro/VinteOito.java
	}

	protected static void main (String args) {
		System.out.println("main2.protected");
	}
	
	final private static void main (int args) {
		System.out.println("main3.final.private.static");
	}

	public static void main (String[] args) {

		//System.out.print();//error: não aplicavel sem nenhum parametro
		
		//VinteOito vinteOito = new VinteOito();//não pode ser aplicado, pois o default foi sobrescrito
		VinteOito vinteOito = new VinteOito(10, 20);
		System.out.println(vinteOito.x +" - "+ vinteOito.y);
		System.out.println(vinteOito.a +" - "+ vinteOito.b);
		System.out.println(vinteOito.a + vinteOito.b);
		System.out.println();
		main(5);
		System.out.println();
		main("Carlos");
		System.out.println();

		System.out.println("main1.public");
	}
}