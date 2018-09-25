package br.com.certificacao.aula07;

import java.util.*;

//só sobrescrevo se existir visibilidade, senão houver visibilidade, será chamado normalmente, para saber se esta sobrescrevendo, usa @Override que dirá se não estiver sobrescrevendo
abstract class Conta2 {
	int id;
	
	void liga() {
		System.out.println("Conta.liga");
	}
	
	abstract void todosTem();
}

class ContaJuridica extends Conta2 {
	String cnpj;	

	//@Override
	void fecha() {
		System.out.println("ContaJuridica.fecha");
	}
	
	@Override
	void todosTem() {
		System.out.println("ContaJuridica.todosTem");
	}
}

class ContaFisica extends Conta2 {
	String cpf;	
	
	@Override
	void todosTem() {
		System.out.println("ContaFisica.todosTem");
	}
}

public class Exercicio3
{
	Exercicio3()
	{
		super();
		System.out.println("7 - Certificação Java SE 7 Programmer I - Relações entre classes");
		System.out.println("3 - Diferencie tipo de uma referência e tipo de um objeto");
	}

	public static void main (String[] args)
	{
		Conta2 c = new ContaJuridica();
		c.id = 15;
		//c.cnpj = "0001"; //Nâo roda pois nem toda Conta possui cnpj, somente as Juridicas.
		c.liga();
		//c.fecha();//Nâo roda pois nem toda Conta possui cnpj, somente as Juridicas.
		//garantir que vai rodar todos os códigos, somente em tempo de compilação.
		c.todosTem();
		
		(new ContaJuridica()).cnpj = "0001";//ok
		//ContaJuridica d = c;//Não compila

		(new ContaFisica()).todosTem();//ok

		List lista = new ArrayList();

		System.out.println("Exercicio3");
	}
}

//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
//javac br/com/certificacao/aula07/Exercicio2.java
//java -classpath . br.com.certificacao.aula07.Exercicio2
