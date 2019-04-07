package br.com.certificacao.aula07;

//todo método de interface por padrão é público e abstrato.

class A  {
	public void metodo () {
		System.out.println("Imprime A");
		//this.metodo2(); ou apenas chamando o metodo2(); vai dar loop pq esta chamando o objeto em tempo de execução que é a classe B no nosso exemplo.
	}
	
	//tomar cuidado com o loop na herança
	/*public void metodo2() {
		System.out.println("Metodo 2 do pai");
	}*/
}

class B extends A {
	public void metodo ()
	{
		System.out.println("Imprime B");
		super.metodo();
	}
	
	public void metodo2()
	{
		System.out.println("Imprime C");
		metodo();
		super.metodo();
	}
}

class Veiculo {
	
	public void liga() throws java.io.IOException
	{
		System.out.println("Liga Veículo!");
	}
	
}

class Helicoptero extends Veiculo {
	
	/*
	 * para reescrita o nome do método deve ser extamente o mesmo
	 * deve ser de uma classe herdada, filha, neta ...
	 * mesma quantidade, ordem e tipos de parametros.
	 * tomar cuidado com a visibilidade, esta deve ser a mesma ou mais aberta.
	 * as Exception devem ser iguais ou menor da referenciada, não pode colocar outras exptions: java.io.IOException é pai de java.io.FileNotFoundException
	 * o método da mãe não pode ser final.
	 * o retorno do método é igual ou mais específico.
	 */ 
	public void liga() throws java.io.FileNotFoundException /* throws java.sql.SQLException, isso eu não posso pois o método pai não está lançando esta Exception. */
	{
		
		System.out.println("Liga Helicoptero!");
	}
}

//posso pegar o metodo que já existe na objeto concreto e torna-lo abstrato em um segundo momento novamente.
abstract class Droid extends Veiculo {
	public abstract void liga();
}

class HexaDroid extends Droid {
	public void liga() {
		System.out.println("Liga HexaDroid!");
	}
}

class FabricaDeVeiculo {
	Veiculo fabrica() {
		return new Veiculo();
	}
}

class FabricaDeHexaDroid extends FabricaDeVeiculo {
	
	//quando estou reescrevendo o tipo deve ser compatível HexaDroid é filho de Veiculo por isso que pode.
	HexaDroid fabrica() {
		return new HexaDroid();
	}
}

public class Exercicio2
{
	
	/*
	 * Reescrita -> Alterar o comportamento do método, herdar uma classe e reescrever o comportamento da classe pai.
	 */
	Exercicio2()
	{
		super();
		System.out.println("7 - Certificação Java SE 7 Programmer I - Relações entre classes");
		System.out.println("2 - Desenvolva código que mostra o uso de polimorfismo");
	}

	static void metodo( Veiculo v ) throws java.io.IOException {
		v.liga();
	}
	
	public static void main (String[] args) throws java.io.IOException
	{
		//
		B a = new B();
		a.metodo();
		a.metodo2();
		
		
		Veiculo h1 = new Helicoptero();
		h1.liga();
		
		HexaDroid h2 = new FabricaDeHexaDroid().fabrica();
		h2.liga();
	
		metodo(new HexaDroid());
		metodo(new Veiculo());
		metodo(new Helicoptero());
	
		System.out.println("Exercicio2");
	}
}


//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
//javac br/com/certificacao/aula07/Exercicio2.java
//java -classpath . br.com.certificacao.aula07.Exercicio2
