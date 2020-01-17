package br.com.softplan.strategy;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import br.com.softplan.business.GeradorObservacaoNumeros;
import br.com.softplan.business.GeradorObservacaoValores;

public class GeradorObservacaoStrategyTest {

	@Test
	public void verificaConstrutor() {
		GeradorObservacaoStrategy gerador = new GeradorObservacaoStrategy();
		assertTrue(gerador instanceof GeradorObservacaoStrategy);
	}

	@Test
	public void verificaSePluralNumero() {

		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		GeradorObservacaoStrategy geraObservacao = new GeradorObservacaoStrategy();
		String rsTexto = geraObservacao.geraObservacao(numerosNotasFiscais);
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

	@Test
	public void verificaSePluralNumerosGetInstance() {

		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);

		GeradorObservacaoStrategy geraObservacao = new GeradorObservacaoStrategy();
		GeradorObservacaoNumeros goNumeros = (GeradorObservacaoNumeros) geraObservacao.getInstance(numerosNotasFiscais);
		String rsTexto = goNumeros.geraObservacao();
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

	@Test
	public void verificaSePluralValores() {

		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "10.00");
		valores.put(2, "35.00");
		valores.put(3, "5.00");
		valores.put(4, "1500.00");
		valores.put(5, "0.30");

		GeradorObservacaoStrategy geraObservacao = new GeradorObservacaoStrategy();
		String rsTexto = geraObservacao.geraObservacao(valores);
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

	@Test
	public void verificaSePluralValoresGetInstance() {

		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "10.00");
		valores.put(2, "35.00");
		valores.put(3, "5.00");
		valores.put(4, "1500.00");
		valores.put(5, "0.30");

		GeradorObservacaoStrategy geraObservacao = new GeradorObservacaoStrategy();
		GeradorObservacaoValores goValores = (GeradorObservacaoValores) geraObservacao.getInstance(valores);
		String rsTexto = goValores.geraObservacao();
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

}
