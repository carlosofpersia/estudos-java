package br.com.certificacao.aula06;

import br.com.certificacao.aula05.Exercicio01;

public class Exercicio6 extends Exercicio01
{

	Exercicio6()
	{
		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
		System.out.println("6 - Aplique modificadores de acesso");
		// TODO Auto-generated constructor stub
	}

	public void imprimeNome()
	{
		System.out.println("Nome = " + this.nome);

		/*
		 * quando for protected, cuidado para acessar esse elemento chamando casting de outra classe pq pode dar pau
		 * "this.nome" não é o mesmo "((Exercicio01) this).nome"
         */
		//System.out.println("Nome2 = " + ((Exercicio01) this).nome);
	}

	public static void main (String[] args)
	{

		Exercicio6 e06 = new Exercicio6();
		e06.imprimeNome();
		/*
		 * public
		 * protected //mesmo pacote
		 * private
		 * default //modificador padrão
		 */

		//
		
		System.out.println("Exercicio06");
	}

}
