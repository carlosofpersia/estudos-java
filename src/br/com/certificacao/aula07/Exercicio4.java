package br.com.certificacao.aula07;


//não herdo duas class, mas implemento duas interfaces.
interface Automatico {}

class Veiculo {};
/*final  */class Moto extends Veiculo {};//se Moto for final não podera casting da interface Automatica (essa mesmo não sendo implementada em moto funciona, mas com a palavra reservada final não funciona)
class Carro extends Veiculo {};
class CarroAutomatico extends Carro implements Automatico {};

public class Exercicio4
{
	Exercicio4()
	{
		super();
		System.out.println("7 - Certificação Java SE 7 Programmer I - Relações entre classes");
		System.out.println("4 - Quando o cast é necesário");
	}

	public static void main (String[] args)
	{

		CarroAutomatico ca = new CarroAutomatico();
		//Automatico a = ca;OK
		Carro c2 = ca;
		Automatico a = (Automatico) c2;

		boolean tipoAutomatico = c2 instanceof Automatico;/*palavra reservada em java é tudo minusculo*/
		System.out.println("tipoAutomatico: " + tipoAutomatico);
		//if (!c2 instanceof Automatico ) ) {}//cuidado para usar o !c2 pois é precedente de instanceof e da pau em c2. "if(!(c2 instanceof Automatico))"
		if( (c2 instanceof Automatico ) ) {
			System.out.println("eh automatico");
		}

		Moto m2 = new Moto();
		//Moto não implementa a classe automatica, mas Moto pode casting em uma interface que não implementa.
		//mas se a classe for final, daí não podera implementar a interface.
		//compila, mas não executa, pq não foi realmente implementada.
  		//Automatico a2 = (Automatico) m2;

		
		
		/***************************************/
		String carloss = "Carloss";
		//o casting é obrigatório quando estou no mais generico para o mais especifico.
		//quando é obvio o casting é opcional;
		String nome = (String) carloss;
		Object nome2 = (String) carloss;
		Object nome3 = (Object) nome2;
		
		
		
		
		//compila pois todo carro é um veiculo.
		Veiculo v = new Carro();
		
		//Não pode pois nem todo veiculo é uma moto.
		//Moto m = v;
		//casting é responsábilidade do desenvolvedor.
		//assumo o risco que o veiculo é uma moto, mas da um "java.lang.ClassCastException" pq tentei ser espertinho mas fora do contexto castiavel hehe
		//nesse caso se eu tenho um veiculo, pode ser que ele seja uma moto.
		//Moto m = (Moto) v;
		
		
		//nesse caso o carro nunca é uma moto, pois moto não herda de carro, não é casting.
		//Carro c = new Carro();
		//Moto m2 = (Moto) c;
		
		
		
		
		Object[] obj = new Object[100];
		String s = "certificacao";
		obj[0] = s;
		//Casting, faz-se quando o objeto é válido, String herda de Object então o casting Compila.
		String recuperada = (String) obj[0];//fazendo o compilador saber que o objeto esperado é uma String. faz-se o Casting.

		
		
		
		//
		System.out.println("Exercicio4");
	}
}

//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
//javac br/com/certificacao/aula07/Exercicio2.java
//java -classpath . br.com.certificacao.aula07.Exercicio2
