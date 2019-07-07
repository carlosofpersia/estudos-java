package br.com.certificacao.bdoismildezenove.cmarco;

import java.util.*;

abstract class Wow {
	private int wow;
	//abstract public int wow; //abstract somente para classes e metodos (proibido para variaveis de instancias)
	public Wow(int wow) {
		this.wow = wow;
	}
	public void wow() {}
	private void wowza() {}
}

abstract class X {
	public abstract void methodX();
}

interface Y {
	public void methodY();
}

class A {
	public void mA() {
		System.out.println( "Am1" );
	}
}

class B extends A {
	public void mA() {
		System.out.println( "Am2" );
	}
	public void mB() {
		System.out.println( "Bm" );
	}
}



public class VinteOito extends X implements Y {

	static double dvalue; //0.0 pois o default do double é 0.0
	static VinteOito ref;//null pois o default do objeto é null
	
	private boolean flag;

	public void displaySeries() {
		int num = 2;
		while (flag) {
			if (num % 7 == 0)
				flag = false;
			System.out.print(num);
			num+=2;
		}
	}
	
	//public void methodZ() {}
	public void methodX() {}
	public void methodY() {}
	
	public static void main ( String[] args ) {
		
		System.out.println( "*****************************" );

		int[] arr = {1,2,3,4,5};
		System.arraycopy (arr, 2, arr, 1,2);
		/*
		 * pegar a partir da posição 2
		 * então 3,4,5
		 * trocar pelos valores 1,2
		 * ficara: 1,3,4,4,5
			0=>1
			1=>2
			2=>3 => 1
			3=>4 => 2
			4=>5
		 */
		System.out.print(arr[0]);
		System.out.print(arr[1]);
		System.out.print(arr[2]);
		System.out.print(arr[3]);
		System.out.print(arr[4]);
		
		
		
		System.out.println( "*****************************" );
		
		new VinteOito().displaySeries();

		System.out.println( "*****************************" );
		
		String s = "A";
		switch(s) {
			case "a" : System.out.println("Simple a");
			default : System.out.println("Default");
			case "A" : System.out.println("Capital A");
		}
		
		System.out.println( "*****************************" );
		
		int[] lst = {1,2,3,4,5,4,3,2,1};
		int sum = 0;
		for( int frnt = 0, rear = lst.length -1; 
		         frnt < 5 && rear >= 5; 
				 frnt++, rear-- 
			 ) {
//0+1+1 = 2
//2+2+2 = 6
//6+3+3 = 12
//12+4+4 = 20 *
			sum = sum + lst[frnt] + lst[rear];
		}
		System.out.println( sum );
		
		System.out.println( "*****************************" );

		A aRef = new B();
		B bRef = (B) aRef;
		bRef.mB();
		aRef.mA();
		
		
		System.out.println( "*****************************" );

		int numbers[];
		numbers = 	new int[2];
		numbers[0] = 10;
		numbers[1] = 20;
		
		numbers = 	new int[4];
		numbers[2] = 30;
		numbers[3] = 40;

		for( int number : numbers ) {
			System.out.print(" " + number);//0 0 30 40 
		}
		
		System.out.println();
		
		//int numero;//só aqui não funciona pq nao inicializou antes de usar;
		//numero = 10;//se inicialiar antes de usar, vai funcionar
		//System.out.println(numero);//não funciona caso não estiver inicializado

		
		System.out.println( "*****************************" );

		System.out.println(ref); System.out.println(dvalue);
		
		System.out.println( "VinteOito - OK!" );
	}
}