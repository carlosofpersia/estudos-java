package br.com.certificacao.adoismildezenove.cmarco;

import java.util.*;

class Patient {
	String name;
	Patient (String name) {
		this.name = name;
	}
}

class Student {
	String name = "";
	int age = 0;
	String major = "Undeclared";
	boolean fulltime = true;
	
	void display() {
		System.out.println("Name: " + name + " Major: " + major);
	}
	
	boolean isFulltime() {
		return fulltime;
	}
}
/*
class SampleClassA extends Dezenove{
	public long getHash() {
		//return long não é compatível com int
		return 44444444;
	}
}
class SampleClassB extends Dezenove {
	public long getHash() {
		//return long não é compatível com int
		return 99999999;
	}
}
*/

class Star {
	public void doStuff() {
		System.out.println("Twinkling Star");
	}
}

interface Universe {
	public void doStuff();
}

class Sun extends Star implements Universe {
	public void doStuff() {
		System.out.println("Twinkling Sun");
	}
}



public class Dezenove {
	
	static boolean isAvaliable = false;
		
	public static void main (String[] args) {
		
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("*********************");
		
		Dezenove dezenove = new Dezenove();
		System.out.println(isAvaliable + " ");
		isAvaliable = hasAvaliable(); //ou dezenove.hasAvaliable();
		System.out.println(isAvaliable + " ");
		
		
		System.out.println("*********************");
		
		Sun obj2 = new Sun();
		Star obj3 = obj2;
		((Sun)obj3).doStuff();
		((Star)obj2).doStuff();
		((Universe)obj2).doStuff();
		
		
		System.out.println("*********************");

		String[][] arra = new String[3][]; 
		arra[0] = new String[]{"rose", "lily"};
		arra[1] = new String[]{"apple", "berry","cherry","grapes"};
		arra[2] = new String[]{"beans", "carrot","potato"};
		for (int i = 0; i < arra.length; i++) {
			for (int j=0; j < arra[i].length; j++) { 
				arra[i][j] = arra[i][j].toUpperCase();
			}
		}
		for(String[] xarra : arra) {
			for(String yarrra : xarra) {
				System.out.println(yarrra);
			}
		}

		
		System.out.println("*********************");
		
		
		int ar1[] = {2,4,6,8};
		int ar2[] = {1,3,5,7,9};
		ar2 = ar1;
		System.out.print("Result: ");
		for(int e1: ar2) { 
			System.out.print(e1 + " - ");
		}

		
		
		System.out.println("*********************");
		
		
		Student bob = new Student();
		Student jian = new Student();
		
		bob.name = "Bob";
		bob.age = 19;
		jian = bob;
		jian.name = "Jian";
		
		System.out.println("Bob's Name: " + bob.name);
		
		
		System.out.println("*********************");
		
		
		int result = 30 - 12 / ( 2 * 5 ) + 1;
		System.out.println("Result = " + result);
		
		
		System.out.println("*********************");

		List<Patient> ps = new ArrayList<>();
		Patient p2 = new Patient ("Mike2");
		Patient p3 = new Patient ("Mike3");
		Patient p4 = new Patient ("Mike4");
		ps.add(p2);//0
		ps.add(p3);//1
		ps.add(p4);//2

		int f = ps.indexOf(p3);//se não existe é -1
		if(f >= 0) {
			System.out.println(f);
			System.out.println("Mike Found");
		}
		
		
		System.out.println("*********************");
		
		String[] table = {"aa", "bb", "cc"};
		for(String ss: table) {
			int ii = 0;
			while(ii < table.length) {
				System.out.println(ss + ", " + ii);
				ii++;
			}
			System.out.println("______________________________");
		}
		
		System.out.println("Dezenove OK");
	}

	public int getHash() {
		return 111111;
	}
	
	public static boolean hasAvaliable() {
		return !isAvaliable;
	}
	
}