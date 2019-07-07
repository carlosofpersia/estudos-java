package br.com.certificacao.adoismildezenove.bfevereiro;

class Caller {
	
		protected void init() {
			System.out.println("init ");
		}

		public void start() {
			init();
			System.out.println("start ");
		}
}

public class Dezenove {

		public static void main (String [] args) {

			Caller call = new Caller();
			call.start();
			call.init();

			System.out.println("Dezenove - OK");
		}	
}