package br.com.certificacao.days;

interface I {
	void print();
}

public class DayFour implements I {

	
	double d = f++;
	static float f = 12.0f;

	public void print() {
		
	}
	
	public static void main (String[] args) {

//		int []a= {1,2,3};
//		for(int x = 0; ++x < 4;x++)
//			System.out.println(x + " - " + a[x]);
	
	
		String s1 = "B";//maior
		String s2 = "A";
		System.out.println(s1.compareToIgnoreCase(s2)); //1
		s1 = "A";//menor
		s2 = "B";
		System.out.println(s1.compareToIgnoreCase(s2)); //-1
		s1 = "A";//iguais
		s2 = "A";
		System.out.println(s1.compareToIgnoreCase(s2)); //0


		/**********************/
	
		int i = 1;
		if(i++ == 1)
			if(i++ > 2){
				System.out.print(i + " - 1"); 
			}
		else if(i++ > 3)
			System.out.print(i + " - 2");
		else
			System.out.println(i + " - 3");
	
		/**********************/
	
	
		byte b[] = {65,97};//"Aa"
		String str = new String(b);
		System.out.println(str);
		System.out.println(str.length());//se for str.length da erro pois é o length da String

		/**********************/
	
		int []x = {1,2,3,4,5};
		nxt(x);
		for(int num : x)
			System.out.print(num+" ");//5 4 3 2 1 -> arrays são objetos e portanto são passados por referencia.
		
	
		/**********************/
	
		DayFour dayFour = new DayFour();
		long l = 12;
		dayFour.d--;
		dayFour.d -= 0.3d;
		System.out.print((dayFour.f == dayFour.d) + " * ");
		System.out.print(dayFour.d == l);
	}

	static void nxt(Object o){
	   int []y = (int[])o;
	   for(int i=5,j=0;i>0;--i,j++){
		   y[j]=i;
		}
	}

}