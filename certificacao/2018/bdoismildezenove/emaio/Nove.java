package br.com.certificacao.bdoismildezenove.emaio;

public class Nove {
	
	public static void main (String[] args) {
	
		int a = -10;
		int b = --a;
		System.out.println(b);//-11
		
		int c = -10;
		int d = ++a;
		System.out.println( c);//-9
		
		int row = 10;
		for( ; row > 0 ; ) {
		
			int col = row;
			while ( col >= 0 ) {
				System.out.println(col + " ");
				col -=2;
			}
			row = row / col;
		}
		
	}
}