package br.com.certificacao.aula05;

public class Exercicio01 {

	public Exercicio01() {
		System.out.println("5 - Certificação Java SE 7 Programmer I - Laços");
		
		System.out.println("1 - Crie e use laços do tipo while");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args)
	{

		//while
		//cria e inicializa a váriavel;
		//verifica a condição
		//executa o loop
		//executa o incremento

		int i = 1;

		

//		while ( i < 10 ) { //primeiro ele veririca a condição se for false nem passa.
//			System.out.println(i);
//			i++;//cuidado com loop eterno
//		}
		
		while( i < 10 )
			System.out.println(i++);
		//i++;//cuidado que fora do bloco ele não acessa o while;

//		while(true) //compilador percebe e da erro 	Unreachable code
//			System.out.println(i++);

//		final boolean verdadeiro = true;//da erro Unreachable code.
//		while(verdadeiro)
//			System.out.println(i);//esse codigo looparia se não fosse Unreachable code.

		boolean verdadeiro = true;//se tirar o final funciona, pq pode ser que seja false em algum momento;
		while(verdadeiro) {
			System.out.println(i++);//
			if( i == 20 ) {
				verdadeiro = false;
			}
		}
			

		System.out.println("Exercicio01");
	}

}
