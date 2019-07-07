package br.com.certificacao.adoismildezenove.cmarco;

public class Doze {

		public static void main (String [] args) {

			
			Square square = new Square();
			square.foo("bar");
			square.foo();

			System.out.println("Doze - ok");
		}
}

class Shape { 

	public Shape() {
		System.out.println("Shape: constructor");
	}
	
	public void foo() {
		System.out.println("Shape: foo");
	}
}


class Square extends Shape { 
	public Square() {
		super();
	}
	
	public Square(String label) { 
		System.out.println("Square: constructor");
	}
	
	public void foo() { 
		super.foo();
	}
	
	public void foo(String label) {
		System.out.println("Square: foo");
	}
}