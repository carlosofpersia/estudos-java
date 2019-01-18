package br.com.certificacao.days;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

import static java.lang.Math.*;

public class DayThree {

	static Integer countI;
	double radio;

	DayThree (int x)
	{
		super();
	}

	void read(double radio) {
		this.radio = radio;
	}
	
	public static void main (String... args )
	{
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