package br.com.certificacao.adoismildezenove.bfevereiro.p3;

import br.com.certificacao.adoismildezenove.bfevereiro.p1.DoInterface;

public class DoClass implements DoInterface {
	
	int x1, x2;
	/*public*/ DoClass() {//erro 
		this.x1 = 0;
		this.x2 = 10;
	}
	
	public void m1 ( int p1 ) {
		x1 += p1;
		System.out.println(x1); //line 2
	}

	public void m2 ( int p1 ) {
		x2 += p1;
		System.out.println(x2);
	}
	
}

