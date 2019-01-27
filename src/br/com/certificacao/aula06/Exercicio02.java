package br.com.certificacao.aula06;

class Moto {
	
	
	public static final int PADRAO_TOTAL_MOTOS = 12;
	
	public static int totalDeMotos = PADRAO_TOTAL_MOTOS;
	
	public static int getTotalMotos()
	{
		return totalDeMotos;
	}
	
}

class Motocicleta extends Moto {
	
	
	public static final int PADRAO_TOTAL_MOTOS = 8;
	public static int totalDeMotos = PADRAO_TOTAL_MOTOS;
	public static int getTotalMotos()
	{
		return totalDeMotos;
	}
}

public class Exercicio02 {

	public Exercicio02()
	{
		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
		System.out.println("2 - Aplique a palavra chave static a métodos e campos");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args)
	{

		Moto.totalDeMotos = 23;
		System.out.println(Moto.getTotalMotos());
		System.out.println(Motocicleta.getTotalMotos());
		//o bind de objetos staticos são feitos por compilação, caso estejam os dois no mesmo lugar, não por polimorfismo
		
		System.out.println("Exercicio02");
	}

}
