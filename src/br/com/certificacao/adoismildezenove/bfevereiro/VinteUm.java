package br.com.certificacao.adoismildezenove.bfevereiro;

import java.util.*;

public class VinteUm {
		
		public static void main (String [] args) {
		
			Runnable run = () -> { System.out.println("Run"); };

			StringBuilder sb = new StringBuilder();
			sb.append("world");
			sb.insert(0, "Hello ");
			System.out.println(sb);
		
			ArrayList<Integer> list = new ArrayList<>(1);
			list.add(1001);
			list.add(1002);
			//System.out.println(list.size());
			System.out.println(list.get(list.size()-1));
		
			int [] x = {6,7,8};
			for(int i : x) {
				System.out.print(i + "");
				i++;
			}

			System.out.println();

			VinteUm speakIt = new Tell();
			Tell tell = new Tell();

			//speakIt.tellIt();
			//(Truth)speakIt.tellIt();
			((Truth)speakIt).tellIt();
			tell.tellIt();
			//(Truth)tell.tellIt();
			((Truth)tell).tellIt();
			
			System.out.println("VinteUm - OK");
		}
	
	/* sem o metodo ele da pau quando chama direto
	public void tellIt() {
		System.out.println("Left on!");
	}
	*/
}

class Tell extends VinteUm implements Truth {
	
	public void tellIt() {
		System.out.println("Right on!");
	}
}

interface Truth {
	public void tellIt();
}

interface Runnable {
	public void run();
}