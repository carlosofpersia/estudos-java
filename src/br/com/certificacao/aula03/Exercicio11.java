package br.com.certificacao.aula03;




class Cliente {
	String nome;
	public Cliente (String nome)
	{
		this.nome = nome;//shadowing
	}
	
	
	/*
	 * mudar o método equals e não mudar a assinatura. ele sempre é public boolean e recebe Object(non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o )
	{
		Cliente outro = (Cliente) o;//Casting
		return this.nome.equals(outro.nome);
	}
}

public class Exercicio11 {

	public Exercicio11() {
		// TODO Auto-generated constructor stub
		
		System.out.println("11 - Teste a igualdade entre Strings e outros objetos usando == equals() - Parte 3");
	}

	public static void main ( String[] args )
	{
		Cliente c1 = new Cliente("Carlos");
		Cliente c2 = new Cliente("Brenna");
		Cliente c3 = new Cliente("Geovana");
		Cliente c4 = new Cliente("Carlos");

		System.out.println(c1 == c1);// == serve para verificarmos se está apontando para o mesmo objeto/referencia
		System.out.println(c1 == c2);
		System.out.println(c1 == c4);

		//usando a classe equals do Cliente
		System.out.println(c1.equals(c1));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c4));
		System.out.println(c1.equals((Object)c4));

	}
}
