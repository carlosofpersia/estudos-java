package br.com.certificacao.adoismildezenove.cmarco;


class Painting { 
	private String type;
	public String getType() { 
		return type;
	}
	public void setType(String type) { 
		this.type = type;
	}
}

class X {
	String str = "default";
	X (String s) {
		str = s;
	}
	void print() {
		System.out.println(str);
	}
}

public class Quatorze {
	
	int fvar;
	static int cvar;
	
	public static void main(Integer[] args) {
		System.out.println("EITA!!!");
	}
	
	static void doubling (Integer ref, int pv) { 
		ref =20;
		pv = 20;
	}

	
	
	static boolean bVar;
	public static void main(String[] args) {

		boolean bVar1 = true;
		int count =8; 
		do {
			System.out.println("Hello Java! " +count); 
				if (count >= 7) {
					bVar1 = false;
				}
		} while (bVar != bVar1 && count > 4);
		count -= 2;
	

	
		
	
	
	
	
	
	
	
	
	
	
		//java.lang.ArrayIndexOutOfBoundsException -> se não chamar um argumento
		//java.lang.NumberFormatException -> se chamar tipo errado
		Integer num = Integer.parseInt(args[1]);
		System.out.println(num);
		
		
		
		
	
		
		int ax = 10, az = 30;
		int aw = 1, ay = 1;
		try {
			aw = ax % 2; 
			//ay = az / aw;//java.lang.ArithmeticException
		} catch (ArithmeticException e1) { 
			System.out.println("Invalid Divisor");
		} catch (Exception e2) { 
			aw = 1;
			System.out.println("Divisor Changed");
		}
		//ay = az /aw; // Line 14 System.out.println("Succesful Division " + ay);


	
	
		System.out.println("beginfloats");
		float flt1 = 100F;
		float flt4 = (float) 1_11.00;
		float flt3 = 100;
		//double y1 = 203.22; float flt5 = y1;//um float não pode receber um tipo double, a não ser que seja cast (float flt5 = (float) y1);
		int y2 = 100; float flt2 = (float) y2; //ok
		System.out.println("endfloats");
		
	
		int a = 2,b = 1,c = 0;
		System.out.println(a + " - " + b +" = "+ c);
	
		String[] cartoons = {"tom","jerry","micky","tom"}; 
		int counter = 0;
		String cartoonsCount = "A";
		if ("tom".equals(cartoons[0])) { 
			counter++;
			cartoonsCount = "B";
		} else if ("tom".equals(cartoons[1])) { 
			counter++;
			cartoonsCount = "C";
		} else if ("tom".equals(cartoons[2])) { 
			counter++;
			cartoonsCount = "D";
		} else if ("tom".equals(cartoons[3])) { 
			counter++;
			cartoonsCount = "E";
		}
		System.out.println(counter + " - " + cartoonsCount);
	
	
	

		int result = (30 - 12 / ( 2 * 5 ) + 1); //30 - 1 + 1
		System.out.println("Expression Result = " + result);
	
		int[] xx = null;
		System.out.println(xx);
		for(int ii: xx) {
			//System.out.println(ii);
		}
		
		
	
		Painting obj1 = new Painting(); Painting obj2 = new Painting(); obj1.setType(null); obj2.setType("Fresco");
		System.out.println(obj1.getType() + " : " + obj2.getType());

	
		new X("Carloss").print();
	
		String color = "Tear";
		switch(color) {
			case "Red": System.out.println("Found Red"); 
			case "Blue": System.out.println("Found Blue"); 
				break;
			case "Tear": System.out.println("Found Tear"); 
				break;
			default: System.out.println("Found Default"); 
		}
	
		cvar = 400;
		Quatorze.cvar = 600;
		Quatorze quatorze = new Quatorze();
		quatorze.fvar = 200;
	
		Integer iObj = new Integer(10);
		int iVar = 10; 
		doubling(iObj++, iVar++);
		System.out.println(iObj+ ", "+iVar); 
	
	
	
	/*
		String[] colors = {"red", "blue","green","yellow","maroon","cyan"}; 
		int count = 0;
		for (String c : colors) {
			
			if (count >= 4) {
				break;
			} else { 
				continue;
			}
			//compilação falhará, pois não pode haver código depois de um break ou um continue
			
			if (c.length() >= 4) { 
				colors[count] = c.substring(0,3);
			}
			count++;			
		}
		System.out.println(colors[count]);
	*/
	

		
		
		
	}
}

