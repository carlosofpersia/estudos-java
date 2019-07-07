package br.com.certificacao.aula06;

public class Exercicio03 {

	public Exercicio03() {
//		System.out.println("6 - Certificação Java SE 7 Programmer I - Métodos e encapsulamento");
//		System.out.println("3 - Crie métodos sobrecarregados");
		// TODO Auto-generated constructor stub
	}
	
	//Overload - sobrecarga
	public void metodo()
	{
		System.out.println("overload sem parametro");
	}

	//Overload - sobrecarga
	public void metodo(int a)
	{
		System.out.println("overload com int");
	}
	

	//Overload - sobrecarga
	public void metodo(double a)
	{
		System.out.println("overload com double");
	}
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo2(String a)
	{
		System.out.println("overload com String");
	}
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo2(Object o)
	{
		System.out.println("overload com Object");
	}
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo4(int a, double b)
	{
		System.out.println("metodo4 int double");
	}
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo4(double b, int a)
	{
		System.out.println("metodo4 double int");
	}
	
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo5(String a, Object b)
	{
		System.out.println("metodo5 String Object");
	}
	
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo5(Object b, String a)
	{
		System.out.println("metodo5 Object String");
	}
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo6(String b, String a)
	{
		System.out.println("metodo6 String String");
	}
	

	//Overload - sobrecarga, qual a referencia:
	public void metodo6(Object b, Object a)
	{
		System.out.println("metodo6 Object Object");
	}
	
	
	
	public static void main (String[] args) {
		
		/*
		 * Overload
metodo sobrecarregado:
mesmo nome, tipo ou quantidades de parametro
		 * */
		
		
		
		new Exercicio03().metodo6("Carlos", "Eduardo");
		new Exercicio03().metodo6(new Object(), new Object());
		new Exercicio03().metodo6(new Moto(), new Moto());
		new Exercicio03().metodo6(new Moto(), "Santos");
		
		//new Exercicio03().metodo5("Carlos", "Eduardo");//ambiguo
		
		new Exercicio03().metodo4(3, 4.5);
		new Exercicio03().metodo4(3.6, 5);
		//new Exercicio03().metodo4(1, 2);//ambiguo
		
		
		new Exercicio03().metodo2("Carlos");//ele chama o mais específico
		new Exercicio03().metodo2(( Object ) "Carlos");//forço para pegar o outro mais generico
		new Exercicio03().metodo2(new Object());
		
		new Exercicio03().metodo();
		new Exercicio03().metodo(5);
		new Exercicio03().metodo( (short) 6);
		
		new Exercicio03().metodo( 6.04);
		new Exercicio03().metodo( (float) 6.04);
		
		
		
		
		
		System.out.println("Exercicio03");
	}

}
