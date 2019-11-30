package br.com.softplan.resources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.softplan.business.GeradorObservacaoBusiness;

public class GeradorObservacaoResource {

	public static void main(String[] args) {

		GeradorObservacaoBusiness gerador = new GeradorObservacaoBusiness();

		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
		String resultado = gerador.geraObservacao(numeros);
		System.out.println(resultado);
		
		gerador = new GeradorObservacaoBusiness();
		numeros = Arrays.asList(283);
		resultado = gerador.geraObservacao(numeros);
		System.out.println(resultado);

		gerador = new GeradorObservacaoBusiness();
		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "10.00");
		valores.put(2, "35.00");
		valores.put(3, "5.00");
		valores.put(4, "1500.00");
		valores.put(5, "0.30");
		resultado = gerador.geraObservacao(valores);
		System.out.println(resultado);

		
		valores = new HashMap<>();
		valores.put(1, "7.00");
		gerador = new GeradorObservacaoBusiness();
		resultado = gerador.geraObservacao(valores);
		System.out.println(resultado);

	}
}
