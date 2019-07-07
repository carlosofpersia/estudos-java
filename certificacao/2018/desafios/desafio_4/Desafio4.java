package br.com.certificacao.desafios.desafio_4;

import java.util.*;
import java.util.function.Predicate;

public class  Desafio4 {

    public Integer aMethod( Integer a ) {
        a = a + 2;
        return a;
    }

	public void bMethod( int a ) {
		a = a++;
	}
	private void cMethod(int a) {
		/*
		Predicate<Integer> d = a -> a > 0; // A //problema com variavel local e parametro lambda
		if(d.test(a)){ // B
			System.out.println(a);
		}
		*/
	}
	
    public static void main (String[] args) {
	
		List<String> sts = Arrays.asList("B", "C");
        //sts.add("A");//UnsupportedOperationException 
        System.out.print(sts);
	
	
	new Desafio4().cMethod(1);

	/******************************/

	System.out.println(true ^ true);//XOR -> dois iguais retorno é falso
	boolean b3 = true ^ false;//XOR -> dois diferentes retorno é true
	System.out.println(b3);

	/******************************/

List<String> lista =Arrays.asList("a", "b", "c", "d");//cria um array fixo, só posso alterar o existente.
lista.set(2, "x");
System.out.println(lista.get(2));
/*sem lambda*/
for (String l : lista) {
    System.out.println(l);
}
//lambda
lista.forEach(l -> System.out.println(l));//Consumer<T>

System.exit(0);

Desafio4 desafio = new Desafio4();

Integer a = 10;
desafio.aMethod(a);
System.out.println(a);
System.out.println("----------------");


/*
        Integer i = 10;
        for(;i>0;) {
        System.out.println(i);
        }
        */

//String para primitivo
int i = Integer.parseInt("10");
i++;
System.out.println(i);

//String ou Primitivo ou Wrapper para Wrapper
Integer j = Integer.valueOf(i);
System.out.println(j);

//Wrapper para primitivo
double k = j.doubleValue();
System.out.println(k);



        if(true) {
            System.out.println("ok.b1");
        }

        boolean b1 = false;
        if(b1= true) {
            System.out.println("ok.b2");
        }

        Boolean b = false;
        if(b = true) {
            System.out.println("ok.b3");
        }
    }

}