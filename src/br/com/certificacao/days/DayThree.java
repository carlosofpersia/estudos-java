package br.com.certificacao.days;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static java.lang.Math.*;

public class DayThree {



	int car = 12;
	//int los = car++;//não pode, somente se fosse static
	int los = ++car;

	static Integer countI;
	double radio;
	static int countII;
	static int countIII = 0;

	
	DayThree() {
		countIII++;
	}
	
	DayThree (int x)
	{
		super();
	}

	void read(double radio) {
		this.radio = radio;
	}
	
	public static void main (String... args )
	{

	
		int[] xxxx = new int[4];
		Arrays.fill(xxxx,4);
		System.out.println(xxxx[0]);
		System.out.println(xxxx[1]);
		System.out.println(xxxx[2]);
		System.out.println(xxxx[3]);
		System.out.println(xxxx[4]);
	
	
	
		DayThree dt = new DayThree();
		System.out.println(dt.los);

		
		
		
		
		//int params = (int) args[0];//incompatible types: String cannot be converted to int
		//System.out.println(params);

		
		
		
		
			//System.out.println(((new StringBuilder("8").)ensureCapacity(20)).capacity());

		
		byte bl[] = {65,97};
		String strS = new String(bl);
		System.out.println(strS);
		
		
		
		Integer iI = 355;
		System.out.println(iI.SIZE);
		System.out.println(iI.BYTES);
		
		System.out.println(countIII );
		System.out.println(new DayThree().countIII );
		
		System.out.println(countII++);
		System.out.println(countI++);
		
		System.out.println(-10 % 3 == - 1);
		System.out.println(-10 % -3 == -1);
		System.out.println(-10 % (3) == -1);
		System.out.println(-10 % (-3) == -1);
		
		
		int i = 0;
		for( ; ++i < 10; ) {
			int j = 0;
			System.out.println(j++ +" - "+ i);
		}

		List<Integer> list3 = new ArrayList<>();
		list3.add(10);
		list3.add(10);
		System.out.println(Integer.max(list3.get(0), 1));

	//-----------------//------------
		int[] ints2 = {2,-1,4,5,3};		
		//long il = 2;
		//System.out.println(ints2[il]);incompatible types: possible lossy conversion from long to int
		
		Arrays.sort(ints2);
		System.out.println(Arrays.binarySearch(ints2, -1));
	
//-----------------//------------	
		int iii = 4;
		int jjj = 1;
		System.out.println(Integer.valueOf(args[0]));
		System.out.println(Integer.parseInt(args[0]));
		if(iii > Integer.valueOf(args[0]) && jjj < Integer.parseInt(args[0]) ) {
			System.out.println("OK");
		}
		
//-----------------//------------
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> rem2 = new ArrayList<Integer>();

		rem2.add(0);
		rem2.add(3);
		list2.add(2);
		list2.add(3);
		list2.add(1);
		list2.add(5);
		list2.add(4);
		list2.add(0);
		list2.subList(0,2);
		System.out.println(list2);
		list2.removeAll(rem2);
		System.out.println(list2);


		//-----------------//------------
		
           boolean f = true;
		   
           if(f = false) {
               System.out.println("iffalse" + f);
           } else if (f) {
			System.out.println("elseiftrue" + f);   
		   } else {
			   System.out.println("nada consta: " + f +" !");
		   }
			   
		   

		   
           

		
		
		Integer num = Integer.parseInt(args[1]);
		System.out.println("Number is: " + num);
		
		
		int y=0;
		//for (int x = 0; (x<2), (y<2), x++) {
			//System.out.println(x +"-"+ y);
		//}
		
		StringBuilder sb = new StringBuilder("cCcC");
		//sb.insert(0, "cCcC");
		System.out.println(sb.lastIndexOf("c"));
		sb.insert(sb.lastIndexOf("c"), true);
		
		System.out.println(sb);

		ArrayList<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("C");
		list.add("E");
		list.add("D");
		System.out.println(list.get(1));
		list.add(1, "B");
		System.out.println(list.get(1));
		System.out.println(list.get(4));
		list.set(4, "F");
		System.out.println(list.get(4));
		System.out.println(list);
		
		list.subList(0,2);
		
	
		//System.out.println(countI+1);//java.lang.NullPointerException
		
		//long l = 0xc;
		//int [] intA = new int[l];//error: incompatible types: possible lossy conversion from long to int
		//System.out.println(intA);
		
		boolean b = true;
		System.out.println((10!=10) ^ (b = false) );
		
		System.out.println(sqrt(9));
		
		LocalTime birthday10 = LocalTime.of(11, 22);
		birthday10.format(DateTimeFormatter.ISO_LOCAL_TIME);
		System.out.println(birthday10);
		
		
		
		DayThree dayT = new DayThree(10);
		dayT.read(10);
		System.out.println(dayT.radio);
	
		System.out.println("ok");
	}
}