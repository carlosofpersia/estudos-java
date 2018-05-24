
//4 - O ciclo de vida de um objeto
package br.com.certificacao.aula02;

//import br.com.certificacao.aula02.Exercicio03;//opcional

public class Exercicio04 {

	public Exercicio04() {


		//ciclo de vida de um objeto
	}
	
	public static void main (String args[] )
	{
		
		Exercicio03 carro1; //não criou um objeto (0)
		
		//para criar um objeto é necessário chamar o construtor (pergunta de certificação);
		Exercicio03 c1 = new Exercicio03(); //chamou o construtor com 'new' é objeto.
		c1.modelo = "Ferrari";
		c1.ano = 2018;

		System.out.println(c1.modelo +"::"+ c1.ano);
		//não está mais acessivel (inacessiveis);
		
		c1 = new Exercicio03();//está acessivel
		System.out.println(c1.modelo +"::"+ c1.ano);
		
		//2 carros foram criados;
		

		c1 = null;

		
		if( 15 > 10) {
			//dentro dos blocos são acessiveis, fora será inacessivel;
			Exercicio03 e2 = new Exercicio03();
			e2.ano = 2015;
		}
		
		//agora 3 objetos são inacessiveis
		
		//GarbageColector: pode jogar a qualquer instante jogar fora os objetos quando eles se tornam inacessiveis
		//GarbageColector: por padrão não se sabe quando vai rodar. mas só joga fora os objetos inacessiveis
		
		
		//quantos objetos foram garbage coletados? NÂO SEI.
		

	}

}
