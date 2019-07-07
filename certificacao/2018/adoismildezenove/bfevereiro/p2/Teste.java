package br.com.certificacao.adoismildezenove.bfevereiro.p2;

import br.com.certificacao.adoismildezenove.bfevereiro.p1.*;
import br.com.certificacao.adoismildezenove.bfevereiro.p3.*;

public class Teste {

	public static void main (String[] args ) {
	
/* 

 * Problema ao usar um contrutor de outro pacote que não é public, ou seja, não da para instanciar.
 * br\com\certificacao\adoismildezenove\bfevereiro\p2\Teste.java:10: error: DoClass() is not public in DoClass; cannot be accessed from outside package
 * DoInterface doi = new DoClass(); //line 3;
 * 1 error
*/
		DoInterface doi = new DoClass(); //line 3;
		doi.m1(100);
		doi.m1(200);
	}
}