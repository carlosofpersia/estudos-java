package br.com.softplan.resources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.softplan.business.GeradorObservacaoNumeros;
import br.com.softplan.business.GeradorObservacaoValores;
import br.com.softplan.strategy.GeradorObservacaoStrategy;

public class Exercicio1 {

	public static void main(String[] args) {

		String message = "";
		
		//Exemplo de uso 1
		GeradorObservacaoNumeros geradorNumeros = new GeradorObservacaoNumeros();
		List<Integer> arrNumeros = Arrays.asList(1, 2, 3, 4, 5);
		message = geradorNumeros.geraObservacao(arrNumeros);
		System.out.println(message);

		//Exemplo de uso 2
		geradorNumeros = new GeradorObservacaoNumeros();
		List<Integer> arrNumeroUnico = Arrays.asList(283);
		message = geradorNumeros.geraObservacao(arrNumeroUnico);
		System.out.println(message);

		//Exemplo de uso 3
		GeradorObservacaoValores geradorValores = new GeradorObservacaoValores();
		Map<Integer, String> arrValores = new HashMap<>();
		arrValores.put(1, "10.00");
		arrValores.put(2, "35.00");
		arrValores.put(3, "5.00");
		arrValores.put(4, "1500.00");
		arrValores.put(5, "0.30");
		message = geradorValores.geraObservacao(arrValores);
		System.out.println(message);

		//Exemplo de uso 4
		geradorValores = new GeradorObservacaoValores();
		Map<Integer, String> arrValor = new HashMap<>();
		arrValor.put(1, "7.00");
		message = geradorValores.geraObservacao(arrValor);
		System.out.println(message);

		//Exemplo de uso 5
		GeradorObservacaoValores geradorValoresConstruct = new GeradorObservacaoValores(arrValores);
		message = geradorValoresConstruct.geraObservacao();
		System.out.println(message);

		//Exemplo de uso 6
		GeradorObservacaoStrategy goStrategy = new GeradorObservacaoStrategy();
		Map<Integer, String> arrValoresStrategy = new HashMap<>();
		arrValoresStrategy.put(1, "535.00");
		arrValoresStrategy.put(2, "557.00");
		message = goStrategy.geraObservacao(arrValoresStrategy);
		System.out.println(message);

		//Exemplo de uso 7
		arrNumeros.set(3, 6);
		message = goStrategy.geraObservacao(arrNumeros);
		System.out.println(message);
		
		//Exemplo de uso 8
		arrNumeros.set(3, 7);
		GeradorObservacaoNumeros num = (GeradorObservacaoNumeros) goStrategy.getInstance(arrNumeros);
		message = num.geraObservacao();
		System.out.println(message);

		//Exemplo de uso 9
		arrValoresStrategy.put(3, "589.00");
		GeradorObservacaoValores val = (GeradorObservacaoValores) goStrategy.getInstance(arrValoresStrategy);
		message = val.geraObservacao();
		System.out.println(message);

	}
}