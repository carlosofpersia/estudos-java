package br.com.certificacao.aula05;

public class Exercicio05 {

	public Exercicio05() {
		
		System.out.println("5 - Certificação Java SE 7 Programmer I - Laços");
		System.out.println("5 - Use break e continue");
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main (String[] args) {
		

		
		
		//um label de statemente + um comentário hehe
		http://luzicity.com.br
		for (int m = 0; m < 4; m++) {
			System.out.println("Estou antes o Switch, laço: " + m);
			labelEduardo: //posso dar 2 labels para o mesmo statement
			labelCarlos: switch (m) {
			case 0:
			case 1:
				System.out.println("Caso " + m);
				for (int n = 0; n < 3; n++) {
					System.out.println(n);
					if(n == 1) {
						break labelEduardo;//se fosse break no label http o laço pararia geral.
					}
				}
				//break;//somente para laço do switch
			case 2: 
				System.out.println("Legal " + m);
				continue http;
			case 3:
				System.out.println("Cheguei no 3");
				break;
			default:
				System.out.println("Estranho...");
				break;
			}
			System.out.println("Estou após o Switch, laço: " + m);
		}

		System.out.println("-----------------------------------");
		
		
		//quebrar o laço correto dentro de vários for's, é necessário rotular o laço
		//posso usar label em qualquer Statments (while, for, switch)
		
		int externo = 4; //diferente do nome dos laços, posso usar em váriavel normal.
		externo: for (int x = 0; x < 10; x++) {
			tabuada: System.out.println("Tabuada do " + x);
			interno: for (int y = 0; y < 10; y++) {
				if(x * y == 25 ) break externo;
				System.out.println( x + " * " + y + " = " + (x*y) );
			}
		}

//se tiver outro for com o mesmo nome for, não tem problema em outro contexto é claro.

		System.out.println("-------------------------------------------");
		
		
		int j;
		for ( j = 1; j < 10 ; j++ ) {
			if(j == 8 ) break;
			if(j == 5 ) continue;
			System.out.println(j);
		}
		System.out.println( "Fora do laço FOR, onde j = " + j );
		
		 int i = 0;
		 externo: while(i < 10) { //posso repetir o nome do label, fora do escopo dos blocos (externos:)
			 i++;
			 if(i == 7) {
				 break;//para o laço;
				 //continue;//passa para o próximo laço;
			 } else {
				 System.out.println("i = " + i);
			 }
		 }
		 System.out.println("Fora do laço WHILE, onde i = " + i);
		
		
		System.out.println("Exercicio05");
	}

}
