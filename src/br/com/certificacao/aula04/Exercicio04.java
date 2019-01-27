package br.com.certificacao.aula04;

import java.util.ArrayList;

public class Exercicio04 {

	public Exercicio04() {
		System.out.println("4 - Declare e use uma ArrayList");
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args)
	{

//generics define o arrayListe e diz que é do tipo String;
//ArrayList<String /*generics*/> lista = new ArrayList<String/*não é obrigado aqui*/>();
ArrayList<String> lista = new ArrayList<>();

lista.add("JAVA");//add um nome na lista;
lista.add("PHP");
lista.add("C#");
lista.add("Node");
lista.add("JAVA");//no arrayList posso ter nomes repetidos
lista.add("PHP");

System.out.println(lista.contains("JAVA"));//verifica se existe um nome;
System.out.println(lista.contains("javascript"));

boolean removido = lista.remove("JAVA");//só remove a primeira posição que encontro.
System.out.println(removido);
System.out.println(lista.contains("JAVA"));

System.out.println(lista.size());

Object[] objetos = lista.toArray();//força para array apenas
for(Object o : objetos ) {
	System.out.println(o);
}

//para forçar o ArrayList, deve ser colocado um parametros com o tamanho do array.
String[] ListaToArray = lista.toArray( new String[ lista.size() ] );
String[] ListaToArray2 = lista.toArray( new String[ 0 ] );//faz o mesmo que o lista.size(), dinamicamente


ArrayList<String> paises = new ArrayList<>();
paises.add("Brasil");//adiciona no fim do array
paises.add("Coreia");//adiciona no fim do array
paises.add("Japao");//adiciona no fim do array


paises.add(0, "Argentina");//add com sobrecarga na posição 2 em paises.
paises.add(2, "China");//add com sobrecarga na posição 2 em paises.

paises.remove(3);//add e remove tem sobrecarga, posso jogar o index do array ou o valor;

System.out.println(" *** País: " + paises.get(1) + " *** ");
paises.set(1, "Africa");//o add adiciona e o set altera o valor na posição definida.
System.out.println(" *** País: " + paises.get(1) + " *** ");

ArrayList<String> tudo = new ArrayList<>();
tudo.addAll(lista);
tudo.addAll(paises);

System.out.println("Tamanhos de Tudo: " + tudo.size());
for(String t : tudo) {
	System.out.println("Nomes: " + t);
}

//posição do array pelo valor: indexOf
System.out.println(tudo.indexOf("PHP"));
System.out.println(tudo.lastIndexOf("PHP"));
System.out.println(tudo.lastIndexOf("Javascript"));//quando não encontra -1


		
		System.out.println("Exercicio04");
	}

}
