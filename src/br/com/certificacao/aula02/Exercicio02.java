
//2 - Diferenciar entre variáveis de referências a objetos e tipos primitivos
package br.com.certificacao.aula02;


class ObjetoMeu {
	int valor;
}


public class Exercicio02 {

	Exercicio02()
	{
	
	}

	public static void main(String[] args)
	{

		ObjetoMeu o1 = new ObjetoMeu();//cria uma nova referencia para o mesmo objeto.
		o1.valor = 7;
		ObjetoMeu o2 = o1; //aqui não usa o contrutor de ObjetoMeu;
		o1.valor = o1.valor + 7;
		System.out.println(o1.valor);
		System.out.println(o2.valor);
		
		
		//tipos primitivos - copia valor
		int a = 10;
		int b = 10;
		a = a + 5;
		System.out.println(a);
		System.out.println(b);

	}

}
