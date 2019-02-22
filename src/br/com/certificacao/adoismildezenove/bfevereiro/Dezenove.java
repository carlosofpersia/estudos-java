package br.com.certificacao.adoismildezenove.bfevereiro;

public class Dezenove {
	
		private void init() {
			System.out.print("init ");
		}

		public void start() {
			init();
			System.out.print("start ");
		}
		
		public static void main (String [] args) {
			
			Dezenove dezenove = new Dezenove();
			dezenove.start();
			dezenove.init();
			
			
			
			
			System.out.println("Dezenove - OK");
		}
	
}