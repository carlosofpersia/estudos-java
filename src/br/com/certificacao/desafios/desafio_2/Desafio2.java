package br.com.certificacao.desafios.desafio_2;

import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.io.*;

/*
ordem: privado, default, protected, public
*/

class A {
  protected void metodo() {
        System.out.println("ClassA.metodo.base");
    }
}

class B extends A {

public void metodo () {
    System.out.println("ClassB.metodo.b");
}
void metodo (String a) {
    System.out.println("ClassB.metodo.subclass" + a);
}

        B(String s) {
            super();//não tem super aqui!
        }
}
/*
class C extends B {
C(String s) {
    super();
    System.out.println(s);
}
C () {
    this("Kent");
}
}
*/


//novidade java 8
interface D {
    public static int getSpeed() {
        System.out.println("wow!");
        return 10;
    }

public default String getMovimento() {
        return "move";
    }

/*
problema devido a palavra ser reservada!
    public default String toString() {
        return "move";
    }
    */
}

public class Desafio2 /*extends A */{

static int _52 = 4;
             static Double x;

            final void metodo() throws NullPointerException {
                System.out.println("Desafio2.metodo.int"); //só ve o de cima se for protegido ou público, quando for default não ve metodo protegido.
            }

//final Desafio2(){}//proibido.
/*
 * um error sera lançado
    public void main (String[] args) {
        System.out.println("Static");
    }
*/

	final /*ok*/ public static void main ( String[] args ) {



List<Integer> list = new ArrayList<Integer>();
list.add(3);
list.add(6);
list.add(10);
list.add(3);
System.out.println(list.set(1,12));

/*
//================================
System.out.println(Integer.decode("1"));
System.out.println(new Integer("2"));
System.out.println(Integer.valueOf("3"));
//================================
((B)new A()).metodo("C");//java.lang.ClassCastException
//================================
List<Integer> list = new ArrayList<Integer>();
list.add(3);
list.add(6);
list.add(10);
list.add(3);
list.trimToSize(3);
System.out.println(list.size());
//================================
while (y++ < x) {
//================================
//new int[]{1,2,3,4};arrays anonimos
//================================
int i = _52;//mesmo que Desafio2._52;
System.out.println(_52);
System.out.println(i);
System.out.println(_52/i);
//================================
((Desafio2)d).metodo();
//================================
System.out.println(D.getSpeed());
//================================
System.out.println(Math.abs(-24));
//================================
C c = new C();
//================================
String s = "carloss-eduardoo";
StringBuilder builder = new StringBuilder("carloss");
s.replaceAll("-", "*");
builder.append("-eduardoo");
System.out.println(s.toString());
System.out.println(builder);
System.out.println(s.equals(builder.toString()));

//================================
LocalTime time = LocalTime.of(11, 22);
time.format(DateTimeFormatter.ISO_LOCAL_DATE);
System.out.println(time);
//================================
int x = 1_10_2;
String bonitão_e_ric$o = "carloss";
System.out.println(bonitão_e_ric$o);
//================================
Apresenta e da o loop
for(;;) {
    System.out.println("OK");
}
//================================
int i = 0;
for(;i<2;i++) {
        System.out.println("10");
}
//================================
char c = 67;//caracter 'C'
System.out.println(c);
//================================
A ab = new Desafio2();
ab.metodo(5);
//================================
System.out.println(x.doubleValue());
//================================
try {
String st = null;
System.out.println(st.length());
} catch (NullPointerException e ) {
    System.out.println("Error");
}
System.out.println(st);
//================================

Character ch = new Character('3');
System.out.println(Character.getNumericValue(ch) + 33);//36
//================================
int x = 1;
int y = 2;
int z = 3;
switch(s) {
    case x: {System.out.println("A");}
    default: {System.out.println("Default ");}
    case y: {System.out.println("Default ");}; break;
    case z: {System.out.println("C");}
}
//================================
List<String> list1 = new ArrayList<>();
list1.add("Carloss");
list1.add("Eduardoo");
list1.add("Santoss");
System.out.println(list1.get(0).indexOf("l"));
System.out.println(list1.get(1).indexOf("u"));
//================================
List<String> list = new ArrayList<>();

list.add("B");
list.add("C");
list.add("A");
System.out.println(":: " + list.indexOf("C"));
Collections.reverse(list);
System.out.println( ":: " + list.indexOf("D"));
Collections.sort(list);
System.out.println(":: " + list.indexOf("A"));

*/


}