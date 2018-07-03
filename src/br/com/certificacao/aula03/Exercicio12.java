package br.com.certificacao.aula03;

import javax.management.RuntimeErrorException;

class UnreacheableCode {
	public int metodo (int x) {
		if( x > 200 ) {
			return 20;
		} else if ( x > 100 && x <= 200 ) {
			return 10;
		}
		throw new RuntimeException();
	}
}


public class Exercicio12 {

	public Exercicio12() {
		
		System.out.println("12 - Utilize o if e if-else");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) 
	{
		
		UnreacheableCode code = new UnreacheableCode();
		System.out.println(code.metodo(201));
		System.out.println(code.metodo(150));
		

		System.out.println("___________________________________");
		
		int v = 100;
		if (v > 200) 
			if (v <400)
				if(v > 300)
					System.out.println("a");
				else 
					System.out.println("b");
			else 
				System.out.println("c");
		else 
			System.out.println("d");
		

		
		System.out.println("___________________________________");
		
		
		boolean autentico = true;

		if ( autentico ) {
			System.out.println("ok");
		} else {
			System.out.println("não autorizado!");
		}
		
		
		if (1 < 2) {
			System.out.println("ok");
		}
		
		System.out.println("___________________________________");
		
		//somente uma instrução
		boolean valor = true;
		if( valor == false)
			System.out.println("ifOK");
		else
			System.out.println("elseOK");

		System.out.println("___________________________________");
		
		
		if( valor ) { 
			System.out.println("true");
		} else if( valor == false && 6 > 1 ) {
			System.out.println("false else if A");//elseif não existe no java.
		} else if(valor == false && 1 < 2) {
			System.out.println("false else if B");
		} else  {
			System.out.println("so else");
		}
		

		System.out.println("___________________________________");
		
		if( valor ) {
			System.out.println("ifOK");
		} else 
			System.out.println("else");
			System.out.println("tente novamente");//cuidado com a identação quando não existir chaves nas condicionais.
		
			
		System.out.println("___________________________________");
		
		int a = 0, b = 3;
		if( a == b) {
			System.out.println("iguais");//se fosse a = b não funcionaria pois é atribuição, a nao ser que esteja atribuindo algum boolean.
		}
		
		if( valor = false) {
			System.out.println("false");//verificar o valor da atribuição quando boolean e o resultado.
		}
		

	}

}
