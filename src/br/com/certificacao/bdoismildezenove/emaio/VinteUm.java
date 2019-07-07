package br.com.certificacao.bdoismildezenove.emaio;

import java.util.ArrayList;
import java.util.List;


class A {
	public void mX() {
		System.out.println("Xm1");
	}
}

class B extends A {
	public void mX() {
		System.out.println("Xm2");
	}
	
	public void mY() {
		System.out.println("Ym");
	}
}


abstract class X {
	
	
	public abstract void methodX();
}

interface Y {
	public void methodY();
}


abstract class M extends X implements Y {


}

abstract class N extends X implements Y {
	public void methodN() {}
}

interface Contract {}
class Super implements Contract {}
class Sub extends Super {}

public class VinteUm {
	
	
	
	
	public static void main (String[] args) {


		List<Contract> objs = new ArrayList<>();
		
		Contract c1 = new Super();
		Contract c2 = new Sub();
		Super s1 = new Sub();
		
		objs.add(c1);
		objs.add(c2);
		objs.add(s1);
		
		for (Object itm: objs) {
			System.out.println(itm.getClass().getName());
		}
	
	
	
	/*----------------------------------------*/
	
	
	String s = "A";
	switch(s) {
	
		case "a": System.out.println("Simple A");
		default: System.out.println("Default");
		case "A": System.out.println("Capital A");
	}
	
	/*----------------------------------------*/
	
	
		A xRef = new B();
		B yRef = (B) xRef;

			yRef.mY();
			xRef.mX();
	
		System.out.println("OK");
	}
}



































