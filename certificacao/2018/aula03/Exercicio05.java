package br.com.certificacao.aula03;

public class Exercicio05 {

	public Exercicio05() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main (String[] args)
	{

		//referencia
		int x = 15, y = 20, z = 30;
		x = ( y = z );
		
		
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		
		System.out.println("____________________________________________");
		
		
		int a = 10;
		a = a + ++a + a + ++a;
		System.out.println(a);

		System.out.println(a+=3);
		
		System.out.println("____________________________________________");
		
		byte b = 15;
		b += 3;
		//b = b + 3;byte não funciona assim, mas com o atalho funciona. pois é um tipo integer

		b += 200; //byte vai apenas de -127 a 127, estoura mas funciona, o valor que vem é errado. para numeros grandes, tomar cuidado
		System.out.println(b);

		
		System.out.println("____________________________________________");
		

		int i = 5;
		
		System.out.println(i--);//aparece 5, mas depois será 4
		System.out.println(i++);//aparece 4, mas depois será 5
		System.out.println(i);  //aparece 5
		System.out.println(++i);//aparece 6
		System.out.println(--i);//aparece 5
		System.out.println(i);  //aparece 5
		
		i += 5;//soma
		System.out.println(i);  //

		i -= 2;//menus
		System.out.println(i);  // 

		i *= 2;//multiplicacao
		System.out.println(i);  //

		i /= 2;//divisão
		System.out.println(i);  //		

		i %= 3;//mod
		System.out.println(i);  //
		
		
		
	}
}
