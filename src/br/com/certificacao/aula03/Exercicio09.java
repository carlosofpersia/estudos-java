package br.com.certificacao.aula03;

public class Exercicio09 {

	public Exercicio09() {
		// TODO Auto-generated constructor stub
		
		System.out.println("9 - Teste a igualdade entre Strings e outros objetos usando == e equals() - Parte 1");
	}
	
	public static void main (String [] args)
	{
		
		
		//usando new
		 String nome1 = new String ("Carlos");
		 String nome2 = new String ("Carlos");
		 System.out.println(nome1 == nome2);//uso de espaço na memória diferentes

		 
		 
		 //nesse caso ele jogou o tipo String Carlos na memória e apontou as duas váriaveis nome3 e nome4 para o mesmo pool
		 //somente da para fazer isso quando usamos os literais. se chamar new o java não consegue.
		 //literais
		 String nome3 = "Carlos";
		 String nome4 = "Carlos";
		 System.out.println(nome3 == nome4);//uso de == serve para o mesmo objeto, nesse caso passa pois está no mesmo pool de memória. ok		

		 
		 //literal + new
		 System.out.println(nome3 == nome1);//problema.
		 
		 
		 //Equals: verifica apenas o conteúdo, mesmo em posição de memória diferentes. ok
		 System.out.println(nome3.equals(nome1));
		 

	}

}
