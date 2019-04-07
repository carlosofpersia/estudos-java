package br.com.certificacao.adoismildezenove.cmarco;

import java.io.*;


/*
//error: cyclic inheritance involving B_A
//class B_A extends C_A { int m(int a) { return 1; } }
class B_A extends C_A { int m(int a) { return 1; } }
class C_A extends A_A { int m(double b) { return 3; } }
class A_A extends B_A {
	int m(String c) { return 3; }
	public static void main(String[] args) {
		System.out.println(new C_A().m(3));
	}
}
*/

class Vehicle {
	protected void turnon() throws IOException {}
}
class Car extends Vehicle {
	public void turnon() throws FileNotFoundException {}
}

abstract class A1 {
	public abstract void m1();
	public void m2() { System.out.println("Green"); }
}

abstract class A2 extends A1 { 
	public abstract void m3();
	public void m1() { System.out.println("Cyan"); } 
	public void m2() { System.out.println("Blue"); }
}

class A {
	public void method(long l) {
	}
}
class B extends A {
	protected void method(int i) {
	}
}

public class VinteTres extends A2 {
	public void m1() { System.out.println("Yellow"); } 
	public void m2() { System.out.println("Pink"); } 
	public void m3() { System.out.println("Red"); } 
	public static void main(String[] args) {
		
		
		
		
		A2 tp = new VinteTres(); 
		tp.m1();
		tp.m2();
		tp.m3();
	}
}