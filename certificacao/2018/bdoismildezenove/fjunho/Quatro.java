package br.com.certificacao.bdoismildezenove.fjunho;


public class Quatro {

	public static void main (String[] args) {


	int row = 10;
	for ( ;row > 0 ;) {
	
		int col = row;
		while (col >= 0) {
			System.out.print(col+" - ");
			col -= 2;
		}		
		row = row / col;//peguinha vai dividir por -2
		System.out.println();
		System.out.println(":::" +row+":::");
	}
		System.out.println("OK");
	}
}



































