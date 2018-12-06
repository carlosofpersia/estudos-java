package br.com.certificacao.desafios.desafio_3;

import java.util.Arrays;
abstract class A {
        A() {
            System.out.println("A.A");
        }

        abstract void print();
}

public class Desafio3 extends A {

int x;
static int y;
static Integer z;
static boolean b = false;
    Desafio3() {
        System.out.println("Desafio3.Desafio3");
    }

        void print() {
            System.out.println("Desafio3.print");
        }



        public static void main (String[] args) {

/************************************/

int[] arrFill = new int[3];
Arrays.fill(arrFill, 2);
for( int fill : arrFill )
System.out.println(fill);


/************************************/


//System.out.println(z);ok, saída null
//System.out.println(z++);throws nullPointerException

/************************************/

System.out.println(Boolean.logicalXor(0<1, false));

/************************************/

Integer wrapperInteger = 8;//um inteiro tem 32 bites e 4 bytes
//wrapperInteger.BYTES;//4 bytes;
//wrapperInteger.SIZE;//32 bits (4x8);
System.out.println(wrapperInteger.BYTES + wrapperInteger.SIZE);//36
/************************************/

            System.out.println(new Desafio3().y *2);
            System.out.println("Nada");
/************************************/
//            args = {"1","2","3"};//ilegal
/************************************/
StringBuilder sb = new StringBuilder("1");//começa com capacidade de 16.
sb.ensureCapacity(20);
System.out.println(sb.capacity());
/************************************/
//int a = (int)args[0];//String não pode ser convertido para int
//System.out.println(a);
/************************************/
String s1 = "A";
String s2 = "a";

System.out.println(s1.compareToIgnoreCase(s2));
System.out.println(s1.compareTo(s2));
/************************************/
String str;
if( b=true) {
            str = new String(new StringBuilder("Carlos").append(" Eduardo"));
            str.concat(" Santos");
            System.out.println(str);
}
/************************************/
            System.out.println(new Desafio3().x);
            System.out.println(y);
/************************************/
            new Desafio3().print();
/************************************/

                int[] x = {1,2,3,4,5};
                nxt(x);
                for(int num: x) {
                    System.out.println(num + " ");
                }
/************************************/

        }

    static void nxt(Object o) {
        int[] y = (int[]) o;
        for (int i = 5, j = 0; i>0; --i, j++) {
            y[j]=i;
            System.out.println(i +"="+ j);
        }
    }

}