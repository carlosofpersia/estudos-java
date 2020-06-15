package br.com.resources;

/**
 * 
 * @author carloss
 * 
 * 
 */

public class Aula1 {

	public static void main(String[] args) {

		
		//Arrays:
		
		
		
		
		//forma literal;
		int[] refs = {1,2,3,4,5};

		
		/*
		 * 
		 * 
		
		//Código omitido
		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		lista.sort( (c1, c2) -> Integer, compare(c1.getNumero(), c2.getNumero()) );

		Comparator<Conta> comp = (Conta c1, Conta c2) -> {

	        String nomeC1 = c1.getTitular().getNome();
	        String.nomeC2 = c2.getTitular().getNome();
	        return nomeC1.compareTo(nomeC2);
		};

		lista.sort( comp );

		lista.forEach( (conta) -> System.out.println(conta + ", " + conta.getTitular().getNome());

		//Código omitido

		 * 
		 * 
		 */

		System.out.println("ok");
	}
}

class Conta {
	
}




/*
 * 
Olá! Bem-vindos ao curso de Java parte 6: Conhecendo o Java.util!

Meu nome é Nico Steppat e os acompanharei nas próximas aulas. Se você gostaria de entender o seguinte trecho de código:

Codigo da classe ...

Então você veio ao lugar certo!

Trabalharemos com estruturas de dados, e entenderemos o seu funcionamento. Veremos como trabalhar com os métodos das listas, como ordenar, e trabalhar com classes anônimas, classes wrapper, incluindo o método equals(), que havia falado anteriormente.

Temos várias funcionalidades importantes para o dia-a-dia do desenvolvedor, trabalharemos bastante neste pacote, e espero encontrar-los nos próximos vídeos!

Olá!

Neste curso, nosso objetivo é entendermos os pacotes java.util e java.io, e continuaremos a utilizar o java.lang.

Com relação ao java.lang, entenderemos melhor a nossa classe Object, pois temos os métodos hashCode() e equals(), isso será esclarecido ao falarmos sobre java.util.

Antes de entrarmos no java.util em si, retornaremos ao código que escrevemos para aprendermos um novo conceito.

Temos o projeto bytebank-herdado-conta, que finalizamos anteriormente, e conseguimos entendê-lo completamente, com uma exceção, vamos observar o código:

package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Cliente;

public class Teste {

        public static void main(String[] args) {

//Código omitido
Na declaração do método main, não sabemos exatamente qual é a função dos colchetes []. Antes de começarmos com o java.util, primeiro desvendaremos este mistério.

Renomearemos a classe Teste, clicando com o botão direto do mouse sobre ela, e selecionando "Refactor > Rename", a chamaremos de TesteObject. Em seguida, criaremos uma nova classe de teste, chamada Teste, com o seguinte conteúdo:

package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {

        }
}
Por que existem os colchetes []?

Imaginemos que queremos armazenar um conjunto de dados, por exemplo, as idades de cinco pessoas, para isso, utilizamos as variáveis:

package br.com.bytebank.banco.test;

public class Teste {

        public static void main(String[] args) {

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}
Para cinco idades, isto pode até funcionar, mas quando trabalhamos com um grande número de dados, por exemplo, cem idades, já se torna inviável. Precisamos de formas mais enxutas de armazenamento de dados, e para isso existem as estruturas de dados.

Conheceremos agora nossa primeira estrutura de dados, que se chama array:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}
Raramente os arrays serão utilizados da forma como faremos agora, ou seja, manualmente.

Arrays são colchetes ([]) associados a algum tipo de dados, no caso, queremos apresentar idade que, como vimos, são do tipo int. Assim, o array será do tipo int. Em seguida, precisaremos de um nome para a variável, que será idades:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades;

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}
Os colchetes ([]) também poderiam estar posicionados após o nome da variável, da seguinte forma int idades[], apesar de ser mais comum sua utilização da forma como colocamos no código acima.

Um array também é um objeto, assim sendo, precisamos criá-lo, pois temos uma referência que ainda não foi inicializada:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[];

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}
O compilador aponta um erro de compilação. Isso porque, ao criar o array, precisamos informar o seu tamanho. Quantas idades queremos guardar? 5, portando, o tamanho do nosso array é 5:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5];

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}
Assim que inserimos o tamanho do array o código volta a compilar.

Internamente, temos um processo que começa com uma pilha de execução, representada pelo método main. Nesta pilha, ou seja, no método, foi criada uma variável idades.

Esta variável é um array, que como vimos, é um objeto. Os objetos ficam armazenados na memória HEAP. Assim, idades é uma referência que aponta para um objeto na memória, capaz de guardar cinco idades.

Como podemos acessar uma das posições? Utilizamos a variável como referência e precisamos informar a posição que queremos acessar dentro de colchetes ([]). Por exemplo, se quisermos acessar a primeira posição, ela é representada pelo número 0:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5];

            idades[0]

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}
Nos será devolvido o valor que estiver armazenado na referida posição. Por enquanto, este valor é 0 já que, por padrão, ao criarmos um array ele é inicializado com 0 em todas as posições:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0]

            int idade1 = 29;
            int idade2 = 39;
            int idade3 = 19;
            int idade4 = 69;
            int idade5 = 59;

        }
}
O primeiro valor padrão do tipo int disponível é 0.

Acessando o array na posição 0, ele nos retorna o valor desta posição, que no nosso caso é a idade1. Podemos apagar os dados que havíamos preenchido anteriormente:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            int idade1 = idades[0];

            System.out.println(idade1);

        }
}
Ao executarmos, temos o seguinte resultado no console:

0
Ele nos imprimiu o valor presente na posição 0, que por coincidência, também é 0. Mas não queremos que seja 0, de acordo com nossos dados, ele deve ser 29. Para isso, inicializaremos o nosso array.

Utilizamos primeiro a referência do array, idades, seguida pelos colchetes ([]), que devem ser preenchidos com a posição que desejamos utilizar, no caso 0, e ao fim, informamos o valor que desejamos armazenar, no caso, 29:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;

            int idade1 = idades[0];

            System.out.println(idade1);

        }
}
Isso significa que estamos armazenando no primeiro espaço de memória que criamos, como falamos acima. O 29 está no índice zero, ou seja, na primeira posição.1

Agora, ao executarmos, temos o seguinte resultado no console:

29
Com isso, podemos inicializar as demais posições do array:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[0];

            System.out.println(idade1);

        }
}
Tentaremos acessar, por exemplo, a posição 4:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[4];

            System.out.println(idade1);

        }
}
Executaremos o programa, e temos o seguinte resultado no console:

69
Se o array tivesse, por exemplo, 50 posições, seria possível acessarmos a de número 49:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[50]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[49];

            System.out.println(idade1);

        }
}
Ao executarmos o programa, temos o seguinte resultado no console:

0
Isso porque não inicializamos essa posição, logo, nos é fornecido o valor padrão.

E o que acontece se tentarmos acessar uma posição que não existe? voltaremos a definir o array com 5 posições, e tentaremos novamente acessar a de número 49:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[49];

            System.out.println(idade1);

        }
}
Executaremos o programa, e temos o seguinte resultado no console:

Exception in thread "main" java.long.ArrayIndexOutOfBoundsException: 49
        at br.com.bytebank.banco.test.Teste.main(Teste.java:16)
Um erro ocorre. Este tipo de erro, inclusive, é bastante comum. É uma exceção unchecked, não somos obrigados a fazer nenhum tratamento.

Os arrays nos permitem ainda que perguntemos o seu tamanho. Criaremos um System.out.println(), utilizando a referência idades, e chamando o atributo length - notamos que não é um método pois não é acompanhado de parênteses:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            idades[0] = 29;
            idades[1] = 39;
            idades[2] = 49;
            idades[3] = 59;
            idades[4] = 69;

            int idade1 = idades[4];

            System.out.println(idade1);

            System.out.println(idades.length);

        }
}
Com a posição de volta para 4, na impressão, executaremos o programa e temos o seguinte resultado no console:

69
5
Ou seja, temos em primeiro lugar o valor armazenado na quarta posição, 69, e, em seguida, o tamanho do nosso array, que possui um total de 5 posições.

Veremos agora como podemos inicializar um array dentro de um laço. Primeiro, apagaremos todo o código referente a inicialização que acabamos de criar.

Definiremos a primeira posição como 0, portanto, i = 0. O limite do laço será o número de posições, assim, utilizaremos o atributo que acabamos de aprender idades.length. Por fim, incrementaremos com o i++:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            for(int i = 0; i < idades.length; i++) {

            }

        }
}
O próximo passo é a inicialização do array, dentro do laço.

Como i representa as posições, é esta variável que utilizaremos na inicialização, e que receberá i * i:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            for(int i = 0; i < idades.length; i++) {
                idades[i] = i * i;

            }

        }
}
Em seguida, teremos o mesmo laço, mas dentro desta segunda representação faremos a impressão dos valores:

package br.com.bytebank.banco.test;

public class Teste {

        //Array []
        public static void main(String[] args) {

            int[]idades = new int[5]; //inicializa o array com os valores padroes

            for(int i = 0; i < idades.length; i++) {
                idades[i] = i * i;
            }

            for(int i = 0; i < idades.length; i++) {
                System.out.println(idades[i]);
            }

        }
}
Executaremos, e temos o seguinte resultado no console:

0
1
4
9
16
Funcionou! Assim, conseguimos utilizar o array, também, com um laço.

Ainda não vimos o porquê da existência do String[] na assinatura do método main, mas chegaremos lá. Primeiro, precisamos entender o que são arrays de referências.

Até a próxima!

------------------------------------------

Ao acessar uma posição inválida recebemos a exceção ArrayIndexOutOfBoundException



1. Um array é sempre zero-based (o primeiro elemento se encontra na posição 0).
É correto, a primeira posição do array é sempre indicada pelo 0.

2. Arrays também são objetos.

3. Um array é sempre inicializado com os valores padrões.
É verdade, pois cada posição do array é inicializada com o valor padrão. Qual é esse valor padrão? O tipo do array define. Por exemplo, no array do tipo int o valor padrão é 0, no double o valor padrão é 0.0.

4. É uma estrutura de dados.
É correto. Array é uma estrutura de dados.

5. Um array realmente possui uma sintaxe estranha pois usa esses colchetes ([]). Então, se tiver com dúvida, relaxe e teste cada linha dentro de um método main. Não há problema em errar, pois estamos aprendendo...
Sabendo disso, qual é a forma correta de criar um array do tipo double
double[] precos = new double[5];
Correto, definimos o tamanho na hora de criar o array.
Além da sintaxe apresentada na alternativa, tem uma alternativa (menos utilizada):
double precos[] = new double[5];
Ambas as formas são corretas.



* Valor padrao de uma referencia de array e null




----------------------------------------------------------------------------------------------------------------------------


Nesta aula, daremos continuidade à construção do array que inicializamos na aula anterior.

Como arrays são objetos, para criarmos um novo, utilizamos a palavra new:

public class Teste {

        public static void main(String[] args) {
            int[] idades = new int[5];

        }
}
Precisamos definir qual tipo de dados são armazenados, no caso, utilizamos o int. Indicamos que se tratam de arrays por meio do uso de colchetes ([]), os utilizamos tanto ao declarar o tipo, quanto ao definir o tamanho do array. Todo array deve ter um tamanho fixo, pré-definido.

No nosso caso, definimos o tamanho como 5, isso significa que, na memória onde os objetos são armazenados é criado um espaço suficiente para que sejam guardados cinco números inteiros.

Automaticamente, o array é inicializado com o valor padrão do tipo definido, como aqui utilizamos o int, o valor padrão inicial é 0.

Em seguida, vimos como podemos acessar um array. No caso, fizemos um laço e criamos um mecanismo que nos permite acessar cada posição:

public class Teste {

        public static void main(String[] args) {
            int[] idades = new int[5];

        for(int i = 0; i < idades.length; i++) {
            idades[i] = i * i;
        }
    }
}
Utilizamos a referência idades, e os colchetes ([]), para indicarmos qual posição pretendemos acessar. Importante lembrar que para os arrays, as posições iniciam em 0, ou seja, a primeira posição é representada pelo número 0.

Mas não esclarecemos anteriormente, o real significado de String[] na assinatura do método main.

Temos que ter em mente que String é um tipo, uma classe, não um primitivo. Ou seja, o que fazemos ao declarar:

//Código omitido

public static void main(String[] args) {

//Código omitido
É declarar um array de referência.

Renomearemos a classe Teste, para TesteArrayDePrimitivos, e em seguida criaremos uma nova classe, um novo teste, chamado TestArrayReferencias, com um método main:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

        }

}
Por que um array de referências? para estarmos preparados caso surja a necessidade de armazenamos diversas contas. E se tivermos 10 contas? onde guardaríamos as 10 referências? Uma possibilidade seria guardá-las dentro de um array.

Primeiro, vamos trabalhar com a classe ContaCorrente, onde iremos armazenar 10 contas correntes, declararemos então o tipo:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                ContaCorrente

        }

}
Utilizaremos a mesma sintaxe do exemplo anterior, por isso, podemos desde já trazê-la e mantê-la em comentários sobre o tipo ContaCorrente:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente

        }

}
Para indicarmos que se trata de um array, incluiremos os colchetes ([]), após ContaCorrente:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[]

        }

}
Chamaremos a variável de contas. Utilizaremos o new para indicar que estamos criando um novo objeto, repetindo o tipo, e os colchetes ([]), além do número total de contas que pretendemos armazenar, no caso, 5:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];

        }

}
Criamos um objeto que pode guardar cinco referências de contas correntes. Quantas contas foram de fato criadas? nenhuma. Temos por enquanto somente o compartimento capaz de armazená-las.

Dentro deste array não há primitivos, mas podem viver referências, estas por sua vez, serão inicializadas com os valores padrões.

Como criamos uma ContaCorrente, qual é o seu valor padrão? No caso, é null. Por isso, não podemos dizer que foi criada alguma conta, pois o array não aponta para nenhum objeto.

Em seguida, criaremos uma ContaCorrente cc1, com seus respectivos dados de agência e número:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];

                ContaCorrente cc1 = new ContaCorrente(22, 11);

        }

}
A ideia é que, agora, criamos o nosso primeiro objeto. Temos uma referência cc1 que aponta para ele. Em seguida, nosso objetivo será armazená-lo na primeira posição em nosso array.

Como acessamos a primeira posição do array? primeiro, utilizamos o nome, em seguida fazemos a referência à posição entre colchetes ([]), para então atribuirmos o valor, cc1:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];

                ContaCorrente cc1 = new ContaCorrente(22, 11);

                contas[0] = cc1;

        }

}
Internamente, é criada uma cópia do valor cc1, que é armazenada na primeira posição e aponta para o objeto.

Criaremos em seguida mais um objeto, cc2:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);

        }

}
Temos mais uma referência em nosso código, apontando para este novo objeto. O próximo passo é armazenamos uma cópia desta cópia dentro do nosso array.

Para acessarmos a segunda posição, utilizamos o número 1, e atribuímos o valor cc2:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

        }

}
Testaremos nosso código, tentaremos acessar o número da segunda conta a partir do nosso array. Criaremos um System.out.println(), com o método getNumero():

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                System.out.println(cc2.getNumero());

        }

}
Mas não queremos acessar o objeto diretamente, queremos acessar a cópia que armazenamos. Como podemos fazer isso? Temos de fazer a referência ao array, utilizando a palavra contas, e incluir a posição que desejamos acessar, no caso a segunda posição, representada pelo número 1:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());
        }

}
Executaremos e temos o seguinte resultado no console:

22
Se tentarmos acessar a posição 0:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[0].getNumero());
        }

}
Temos o seguinte resultado:

11
Se tentarmos acessar a terceira posição:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[2].getNumero());
        }

}
Temos o seguinte resultado:

Exception in thread "main" java.long.NullPointerException
        at br.com.bytebank.banco.test.TestArrayReferencias.main(TestArrayReferencias.java:20)
Pois ela ainda não foi inicializada e, por padrão, tem o valor null.

Retornaremos para a impressão da segunda posição:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());
        }

}
Estamos acessando o contas[1] e, em contrapartida, nos será devolvido um valor, que é uma referência. Mas onde ela é armazenada? em uma variável, que por sua vez, tem que ter um tipo.

No nosso caso, o tipo da variável é ContaCorrente. Assim, nosso retorno é uma referência do tipo ContaCorrente:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());

                ContaCorrente ref = contas[1];
        }

}
Aqui, chamamos nossa referência de ref, ela tem o mesmo valor de cc2, ou seja, aponta para o objeto ContaCorrente.

Assim, podemos utilizar o ref.getNumero() para imprimirmos o número da conta. Executaremos:

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());

                ContaCorrente ref = contas[1];

                System.out.println(ref.getNumero());
        }

}
E obtivemos o seguinte resultado:

22
22
Indicando que nosso código funcionou.

Este último System.out.println() equivale a System.out.println(cc2.getNumero()):

package br.com.bytebank.banco.test;

public class TestArrayReferencias {

        public static void main(String[] args) {

                //int[] idades = new int[5];
                ContaCorrente[] contas = new ContaCorrente[5];
                ContaCorrente cc1 = new ContaCorrente(22, 11);
                contas[0] = cc1;

                ContaCorrente cc2 = new ContaCorrente(22, 22);
                contas[1] = cc2;

                //System.out.println(cc2.getNumero());

                System.out.println(contas[1].getNumero());

                ContaCorrente ref = contas[1];
                System.out.println(cc2.getNumero());
                System.out.println(ref.getNumero());
        }

}
Se executarmos, temos o seguinte resultado:

22
22
22
Portanto, quantas contas criamos afinal? Duas. Quantos objetos criamos? Três. Já referências, temos 9, destas, apenas 6 foram inicializadas.

Temos assim um array de referências.

Adiante, falaremos sobre array de referências polimórfico. Até lá!



Você está se preparando para a certificação Java e passou pelo código seguinte:

ContaPoupanca[] contas = new ContaPoupanca[10];
ContaPoupanca cp1 = new ContaPoupanca(11,22);
ContaPoupanca cp2 = new ContaPoupanca(33,44);

contas[0] = cp1;
contas[1] = cp1;
contas[4] = cp2;
contas[5] = cp2;

ContaPoupanca ref1 = contas[1];
ContaPoupanca ref2 = contas[4];
Quantas referências apontam para a ContaPoupanca com a agencia 33 e número 44?


Bingo! Vamos contar?

1) ContaPoupanca cp2 = new ContaPoupanca(33, 44);
2) contas[4] = cp2;
3) contas[5] = cp2;
4) ContaPoupanca ref2 = contas[4];




Continuando os estudos para certificação, você encontrou mais um trecho de código:

ContaPoupanca[] contas = new ContaPoupanca[10];
ContaPoupanca cp1 = new ContaPoupanca(11,22);
ContaPoupanca cp2 = new ContaPoupanca(33,44);

contas[0] = cp1;
contas[4] = cp2;

System.out.println(contas[1].getNumero());
Executando esse trecho dentro do método main do nosso projeto, qual é o resultado?

Obs: Se tiver com dúvidas teste o código, sem problemas!

Selecione uma alternativa


* NullPointerException


Correto, pois estamos acessando o segundo elemento do array (a posição 1) e essa posição ainda está null:

System.out.println(contas[1].getNumero());
Consequentemente recebemos uma NullPointerException.



* Mãos na massa: Trabalhando com arrays

Chegou a hora de você pôr em prática o que foi visto na aula. Para isso, execute os passos listados abaixo.

Arrays
1) No projeto bytebank-herdado-conta, no pacote br.com.bytebank.banco.test, renomeie a classe Teste para TesteObject. Após isso, também no mesmo pacote, crie uma nova classe TesteArrayDePrimitivos, já com o método main:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

    }

}
2) Para guardar idades, crie um array de inteiros, com cinco posições:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

    }

}
3) Em seguida, inicialize cada posição do array com uma idade:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        idades[0] = 29;
        idades[1] = 39;
        idades[2] = 49;
        idades[3] = 59;
        idades[4] = 69;

    }

}
4) Ao acessar alguma posição do array, ele retorna o valor guardado nessa posição. Então, guarde o valor da quarta posição do array em uma variável e imprima-a:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        idades[0] = 29;
        idades[1] = 39;
        idades[2] = 49;
        idades[3] = 59;
        idades[4] = 69;

        int idade4 = idades[3];

        System.out.println(idade4);

    }

}
5) Imprima o tamanho do array, acessando o seu atributo length:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        idades[0] = 29;
        idades[1] = 39;
        idades[2] = 49;
        idades[3] = 59;
        idades[4] = 69;

        int idade4 = idades[3];

        System.out.println(idade4);
        System.out.println(idades.length);

    }

}
6) Inicialize o array dentro de um laço, mas antes apague todo o código, deixando somente a inicialização do array:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

    }

}
7) Agora, inicialize o array dentro de um laço, por exemplo:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        for (int i = 0; i < idades.length; i++) {
            idades[i] = i * i;
        }

    }

}
8) Em seguida, faça um outro laço e imprima cada elemento do array:

public class TesteArrayDePrimitivos {

    public static void main(String[] args) {

        int[] idades = new int[5];

        for (int i = 0; i < idades.length; i++) {
            idades[i] = i * i;
        }

        for (int i = 0; i < idades.length; i++) {
            System.out.println(idades[i]);
        }

    }

}
Arrays de referência
9) No projeto bytebank-herdado-conta, no pacote br.com.bytebank.banco.test, crie a classe TesteArrayReferencias, já com o método main:

public class TesteArrayReferencias {

    public static void main(String[] args) {

    }

}
10) Para guardar contas, crie um array de ContaCorrente, com cinco posições:

public class TesteArrayReferencias {

    public static void main(String[] args) {

        ContaCorrente[] contas = new ContaCorrente[5];

    }

}
11) Instancie duas contas e guarde-as nas duas primeiras posições do array, por exemplo:

public class TesteArrayReferencias {

    public static void main(String[] args) {

        ContaCorrente[] contas = new ContaCorrente[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        ContaCorrente cc2 = new ContaCorrente(22, 22);

        contas[0] = cc1;
        contas[1] = cc2;

    }

}
12) Através do array, acesse a conta da primeira posição e imprima seu número:

public class TesteArrayReferencias {

    public static void main(String[] args) {

        ContaCorrente[] contas = new ContaCorrente[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        ContaCorrente cc2 = new ContaCorrente(22, 22);

        contas[0] = cc1;
        contas[1] = cc2;

        System.out.println(contas[0].getNumero());

    }

}




* Forma literal
PRÓXIMA ATIVIDADE

Até agora vimos a forma "classica" de criar um objeto array usando a palavra chave new, por exemplo:

int[] numeros = new int[6];
numeros[0] = 1;
numeros[1] = 2;
numeros[2] = 3;
numeros[3] = 4;
numeros[4] = 5;
No entanto também há uma forma literal. Literal, nesse contexto, significa usar valores diretamente, menos burocrático, mais direito. Veja a diferença:

int[] refs = {1,2,3,4,5};
Usamos as chaves {} para indicar que se trata de um array e os valores já ficam declarados dentro das chaves.


O que aprendemos?
PRÓXIMA ATIVIDADE

Nessa aula sobre Arrays aprendemos:

Um array é uma estrutura de dados e serve para guardar elementos (valores primitivos ou referências)
Arrays usam colchetes ([]) sintaticamente
Arrays têm um tamanho fixo!
Um array também é um objeto!
Arrays são zero-based (o primeiro elemento se encontra na posição 0)
Um array é sempre inicializado com os valores padrões.
Ao acessar uma posição inválida recebemos a exceção ArrayIndexOutOfBoundException
Arrays possuem um atributo length para saber o tamanho
A forma literal de criar uma Array, com o uso de chaves {}.
No próximo capítulo falaremos mais um pouco sobre arrays (do tipo Object) e veremos como funciona esse parâmetro do método main.



 * 
 *
 */

