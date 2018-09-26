package br.com.certificacao.aula07;

interface Aereo {
	//
}

interface Aquatico {
	//
}
interface Veiculo {
	//por padrão os métodos são abstratos e publicos.
	//não pode ter um método com corpo, porém verificar se no java 8 pode haver um  metodo "default" com corpo
}
//uma classe pode implementar diversar interfaces, sempre separando por , (vírgula)
class Carro implements Aereo, Aquatico, Veiculo {}


/**********************/

//herança
//uma interface pode herdar de uma ou várias interfaces
interface AI {

	//Constante. Por padrão deve ser public, static e final e por padrão maiuscula
	public static final int X = 10;

	//interface não pode ter metodos staticos, até o java 7, verificar no java 8.
	//esse só funciona no contexto da interface mesmo, verificar no java 8.
	public static void liga() {
		System.out.println("Interface AI.liga: X = " + X);
	}
}
interface BI extends AI {}
interface CI extends BI, AI {}
interface DI extends CI, BI, AI {}

class CarlossAi implements AI {
	
}

//uma interface nunca implementa outra interface, não faz sentido
//interface AI implements BI {} não pode compilar.

/**********************/

abstract class A {
	//class abstrata não precisa ter metodos
}

abstract class B {
	//class abstrata não precisa ter metodos, mas caso tenha o método deve ser abstrato
	//não tem corpo, só define interface do método.
	abstract void executa();

	//uma classe abstrata pode ter métodos normais e abstratos
	public void liga() {
		System.out.println("AbstractB.liga");
	}
}

class C extends B {

	@Override
	public void executa() {
		System.out.println("C.Executa");
	}
}

public class Exercicio6
{
	Exercicio6()
	{
		super();
		System.out.println("7 - Certificação Java SE 7 Programmer I - Relações entre classes");
		System.out.println("6 - Use classes abstratas e interface");
	}

	public static void main (String[] args)
	{
		//classes abstratas e interfaces não pode dar new, tem que ser extendidas, não compila.
		System.out.println(AI.X);
		System.out.println(CarlossAi.X);
		AI.liga();

		System.out.println("Exercicio6");
	}
}

//$~/Documents/Carloss/Desenvolvimento/estudos-java/src:
//javac br/com/certificacao/aula07/Exercicio2.java
//java -classpath . br.com.certificacao.aula07.Exercicio2
