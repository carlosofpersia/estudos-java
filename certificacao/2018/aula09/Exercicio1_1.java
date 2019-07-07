package br.com.certificacao.aula09;

public class Exercicio1_1 {

	Exercicio1_1() {
		super();
		System.out.println("9 - Certificação Java SE 8 Programmer I - Conteúdo além da prova");
		System.out.println("1 - Trabalhando com saída no console");
	}

	public String toString() {
		return "Um objeto do tipo Exercicio ";
	}

	public static void main (String[] args) {

		//o virgula conta como caracter
		System.out.format("[%0,9.2f]%n", 45.1);//000045,10
	
	
		//System.out.print -> imprime sem quebra de linhas;
		//System.out.print("foo\n "); -> imprime com quebra de linhas;
		//System.out.println -> imprime com quebra de linhas;

		//impressão formatada -> format e printf
		//percent-indice-flags-tamanho-precisao-tipo -> percente+indice são obrigatórios, o restante opcionais.
		
		//colocar sem o cifrão, é o mínimo de posições que usará: "[   34]", ou seja 5 posições usadas.
		System.out.format("[%+5d]%n", 1);
		System.out.format("[%5d]%n", 12);//colocar o mais na frente apresentará o sinal de positivo, o de menos não precisa ser colocado é explicito.
		System.out.format("[%5d]%n", 113);
		System.out.format("[%5d]%n", -1114);
		System.out.format("[%+5d]%n", 11115);
		System.out.format("[%5d]%n", -111116);//esse número conta o mínimo de posições hehe
		
		//se o número for negativo e colocar parenteses, o número ficara entre parenteses, positivos não acontece nada.
		System.out.format("[%(7d]%n", -10);
		
		//para alinhar para direita, pois o padrão é para direita, botar o - depois do percente
		System.out.format("[%-(7d]%n", -10);

		//preencher com 0 os espaços que sobram (somente para números normais mesmo):
		System.out.format("[%07d]%n", 10);
		System.out.format("[%07d]%n", -1);
		
		//para números muito grandes, posso botar uma virgula para separar os milhares:
		System.out.format("[%,f] %n", 5395765.49);
		//ajustar as casas decimais.
		System.out.format("[%,.2f] %n", 5395765.49);
 
		//para usar posição, começar com o 1 e não com o zero como nos casos de array.
		System.out.format("%n*%3$s, ou seja, %3$s %1$s %2$s.%n*%n", "Eduardo", "Santos", "Carlos");//colocar a posição no lugar certo basta usar percente-posição-cifrão-tipo.
		
		System.out.format("%s é %d! Esse bilhete é %b%n", "Carloss", 10, true);//%s: string, %d: inteiros
		System.out.format("%b|%b %n", false, true);//%b: boolean
		System.out.format("%f %n", 45.7);//%f: ponto flutuante
		


		//se usar tipo errado da pau.
		//System.out.format("%d %n", "a");//java.util.IllegalFormatConversionException
		//System.out.format("%s %n", 45.7);//java.util.UnknownFormatConversionException		

		//System.out.printf("foo ");

		System.out.println("-------------------------");
		System.out.print("foo\n ");

		char[] letras = {'a', 'b'};//array de char imprime o conteudo independente do que esteja dentro, qualquer outro método usado usaram o toString.
		System.out.print(letras);
		System.out.println("-------------------- ");
		System.out.print(new char[10]);

		System.out.println("-------------------- ");
		System.out.print(new int[10]);//array de char. 

		//usam o toString;
		Boolean boo = new Boolean(true);
		System.out.println(boo);
		System.out.print(1);
		System.out.print(",");
		System.out.print('a');
		System.out.print(new Exercicio1_1());
		
		System.out.println(2);

		System.out.println("Aula09.Exercicio1_1");
	}	
}