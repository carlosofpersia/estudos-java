package br.com.certificacao.bdoismildezenove.dabril;

import java.util.*;

class DbConfig {
	String user;
	String password;
}

class A {
	public String doStuff(String msg) {
		return msg;
	}
}
class B extends A {
	public String doStuff(String msg) {
		return msg.replace('a', 'e');
	}
}
class C extends B {
	public String doStuff(String msg) {
		return msg.substring(2);
	}
}

class Exam {
	void method() {
		
	}
}

class Student { 
	public String name = ""; 
	public int age = 0;
	public String major = "Undeclared"; 
	public boolean fulltime = true; 
	public void display() {
		System.out.println("Name: " + name + " Major: " + major); 
	} 
	public boolean isFullTime() {
		return fulltime;
	}
}

public class Dois extends Exam {

	final void method() {
		
	}

	DbConfig configureDb(String name, String password) {
		return new DbConfig();
	}

	public static void main ( String [] args ) {

	
	try {
		String[] arr = new String[4];
		arr[1] = "Unix";
		arr[2] = "Linux";
		arr[3] = "Solaris";
		
		for( String var : arr ) {
			System.out.print(var + " ");
		}
		
	} catch (Exception e ) {
		System.out.println(e.getClass());
	}
	System.out.println();
	
	
		System.out.println( "*****************************" );
	
		String str1 = "Java";
		char str2[] = {'J', 'a', 'v', 'a'};
		String str3 = null;
		for( char c: str2) {
			str3 = str3 + c;
		}
		
		System.out.println(str1);//Java
		System.out.println(str2);//Java
		System.out.println(str3);//nullJava
		if(str1.equals(str3)) 
			System.out.println("Successful");
		else 
			System.out.println("Unsuccessful");

		System.out.println( "*****************************" );
	
		StringBuilder sb = new StringBuilder();
		sb.append("Carlos Eduardo");
		System.out.println( sb );
		sb.delete(0, sb.length());
		System.out.println( "Limpou a sb: " + sb );
	
		System.out.println( "*****************************" );
	
		int ax = -10;
		int bx = 17;
		int cx = ++ax;
		int dx = bx--;
		cx++;
		dx--;
		System.out.println(ax+"="+bx+"="+cx+"="+dx);
	
		System.out.println( "*****************************" );
	
		Student bob = new Student();
		bob.name = "Bob";
		bob.age = 18;
		//bob.year = 1982;
	
		System.out.println( "*****************************" );
		
		List<A> strs = new ArrayList<A>();
		strs.add(new A());
		strs.add(new B());
		strs.add(new C());
		for( A t: strs ) {
			System.out.println(t.doStuff("Java"));
		}
		
		
		System.out.println( "*****************************" );
		
		List<String> list1 = new ArrayList<>();
		list1.add("SE");
		list1.add("EE");
		list1.add("ME");
		list1.add("SE");
		list1.add("EE");
		list1.remove("SE");
		System.out.println(list1);
		
		List<Integer> list = new ArrayList<>();
		list.add(27);
		list.add(21);
		list.add(13);
		list.add(30);
		list.add(11);
		list.add(27);
		list.add(27);
		list.add(2);
		
		list.removeIf(e -> e % 2 == 0);
		list.removeIf(e -> e == 27);
		System.out.println(list);//[21, 13, 11]
		
		System.out.println( "*****************************" );
		
		for ( int ii = 0; ii < 4; ii++ ) {
			System.out.print("ii = " + ii +" - ");
			ii = ii + 1;
			System.out.println("ii = " + ii);
		}

		
		System.out.println( "*****************************" );

		Dois d = new Dois();
		DbConfig dbConf = d.configureDb("manager", "manager");
		
		//Integer number = Integer.valueOf("808.1"); //java.lang.NumberFormatException

		System.out.println( "Dois - OK!" );
	}
	
	
	
}