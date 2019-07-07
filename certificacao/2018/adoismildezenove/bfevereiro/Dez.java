package br.com.certificacao.adoismildezenove.bfevereiro;


public class Dez {
	public static void main(String[] args) { 
		
		
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