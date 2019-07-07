/**
 * 1º declaração é o pacote.
 *               Caso não seja declarado será considerado um default package 
 *               default package não podem ser importadas para uso em por outros pacotes.
 *               
 * Rodar programa no terminal:
 * carlossantos@carlossantos-Note:~/eclipse-workspace/luzicity-java/src$ javac br/com/certificacao/aula01/Exercicio02.java 
 * carlossantos@carlossantos-Note:~/eclipse-workspace/luzicity-java/src$ java br.com.certificacao.aula01.Exercicio02 argumento1 argumento2
 * 
 * 
 * passar propriedade para o programa pelo terminal (-Dnomepropriedade = valor)
 * java -Dsistema=producao br.com.certificacao.aula01.Exercicio02 argumento1 argumento2
 * 
 * CLASSPATH (CLASSPATH|-classpath|-cp) define onde o java vai procurar os pacotes. (diretório atual);
 * 
 * 
 *
 *               
 */
package br.com.certificacao.aula01;

/**
 * 2º declaração são os imports (opcional)
 */
import java.util.ArrayList;
import java.util.Date;
import java.io.*;


//comentário de linha

/*
comentário de
multiplas linhas
*/


/**
 * 
 * @author carloss
 * 
 * 3º declaração em diante são os tipos (Class, Interface, Enuns...).
 *               Só pode um tipo publico por arquivo. 
 *               e deve conter o mesmo nome da classe, 
 *               por padrão os tipos são do tipo default.
 *
 * Estrutura de uma classe (arquivo) JAVA
 * 
 *  Dentro de uma classe, podemos ter variáveis, métodos e construtores
 * 
 */
public class Exercicio02 {

    String nome;
    String sobrenome;
    int j = -100;
    int Teste = 305;
	
	/**
	 * construtores
	 * 
	 * Uma classe pode possuir zero ou vários construtores
	 * construtor não tem retorno e possui o mesmo nome da classe
	 */
	public Exercicio02( String nome, String sobrenome, int i ) {
		// TODO Auto-generated constructor stub
        this.nome = nome;
        this.sobrenome = sobrenome;
        
        //um construtor pode ter um return vazio:
        if (i > 20)
            return;
        j = i;
        
	}
	
    public String getNomeCompleto() {
        return this.nome + this.sobrenome;
    }
	
	/**
	 * 
	 * método normal, não é construtor
	 * método normal traz um tipo do retorno (void, String ...)
	 * 
     *  JavaDoc, repare que a primeira linha do comentário tem 2 asteriscos
	 * 
	 * 
	 */
	public void Exercicio02() {
		// TODO Auto-generated constructor stub
		
        System.out.println(Teste);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        new Exercicio02("Carlos", "Eduardo", 10);
        new Exercicio02("Carlos", "Eduardo", 10).Exercicio02();
		
		ArrayList<String> lista = new ArrayList<String>();

		System.out.println("Argumentos: " + args.length);
		
        for (String arg : args) {
            if (new B().existe(arg))
                lista.add(arg);
        }		
	}
}

interface A {

	//somente constantes ou assinatura de métodos.
    public static final int TAMANHO_SENHA = 8; //constante

    public abstract void autentica(String login, String senha); //assinatura do método
}


/**
 * Podem ser definidos em qualquer ordem;
 * Se existir alguma classe/interface pública, o nome do arquivo deve ser o mesmo dessa classe/interface;
 * Só pode existir uma classe/interface pública por arquivo;
 * Se não houver nenhuma classe/interface pública, o arquivo pode ter qualquer nome.
 * 
 *
 */
class /* comentário no meio da linha */ B {
    public boolean existe(String nome) {
        File f = new File(nome);
        return f.exists();
    }

}
