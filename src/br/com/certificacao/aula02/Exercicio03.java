
//3 - Lendo ou escrevendo campos de objetos

package br.com.certificacao.aula02;

public class Exercicio03 {
	
	String modelo;
	int ano;

	public Exercicio03() {
		
		
		ano = 2014; //ou this.ano = 2014. opcional quando não existe outra variavel com mesmo nome.
		//this.ano = 2014;
	}
	
	void reseta ()
	{
		ano = 2014;//this. é opcional pois não existe nenhuma outra váriavel chamada ano.
		//this.ano = 2014; 
	}
	
	public String getDadosDeImpressao()
	{
		return modelo +"::"+ ano;
	}
	
	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
	
	
	public static void main (String args[])
	{
		
		Exercicio03 e = new Exercicio03();
		e.modelo = "Palio";
		e.setModelo("Siena");
		
		System.out.println(e.getDadosDeImpressao());
		System.out.println(e.ano);
		System.out.println(e.modelo.length());//tamanho da string
	}

}
