package br.com.certificacao.aula04;

public class Exercicio01
{

	public Exercicio01()
	{

		System.out.println("4 - Certificação Java SE 7 Programmer I - Criando e usando Arrays");
		
		System.out.println("1 - Declare, instancie, inicialize e use um array uni-dimensional");

	}
		
	public static void main (String[] args) {
		
		
		
//		int[] idades;
//		double pesos[];
//		long []numeros;
//		long[]tamanhos;
		
		
//		int[] idades = new int[-1];//compila embora exception negative arraysize exception
//		int[] idades = new int[10];//20 posições o os valores defaults serão 0 por ser int.
		
		int[] idades = new int[] {0,2,4,6,8};      //valores a serem incluidos no array na inicialização
		System.out.println(idades[2]);
		System.out.println(idades[3]);
		
		
		Cliente[] clientes = new Cliente[] { new Cliente(), null, new Cliente()};
		System.out.println(clientes[2].getNome());

		//várias formas de criar array;
		

		int[] idades2 = {0,2,4,6,8};      //short insert valores na inicialização //somente na mesma linha iniciativa.
		System.out.println(idades2[4]);
		
		int[] idades3;
		idades3 = new int[] {0,2,4,6,8};
		System.out.println(idades3[3]);
		
		idades3[3] = 100;
		System.out.println(idades3[3]);
		
		//System.out.println(idades3[100]);//ele compila mas ao executar da uma ArrayIndexOutOfBoundsException
		//erro de execução
		
		System.out.println(idades3.length);//5 posições
		
		for ( int i = 0; i < idades3.length; i++ ) {
			System.out.println(i +" - "+ idades3[i]);
		}
		
		for ( int idades3_ : idades3 ) { //domente para leitura e ele não possui os indices e não da para alterar lá dentro.
			System.out.println( "Foreach:" + idades3_);
		}
		
		
		
		System.out.println("br.com.certificacao.aula04");
		
		
	}

}


class Cliente
{
	String nome;

	public Cliente()
	{
		System.out.println( "Instancia Cliente" );
	}

	public String getNome()
	{
		return "Carlos";
	}
}
