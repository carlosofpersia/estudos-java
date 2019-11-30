package br.com.softplan.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.StringContains;
import org.junit.Test;

public class GeradorObservacaoBusinessTest {

	@Test
	public void verificaConstrutor() {
		GeradorObservacaoBusiness gerador = new GeradorObservacaoBusiness();
		assertTrue(gerador instanceof GeradorObservacaoBusiness);
	}

	@Test
	public void verificaSeRetornoTextoPlural() {
		GeradorObservacaoBusiness geraObservacao = new GeradorObservacaoBusiness();
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		String rsTexto = geraObservacao.geraObservacao(numerosNotasFiscais);
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

	@Test
	public void verificaSeRetornoTextoSingular() {
		GeradorObservacaoBusiness geraObservacao = new GeradorObservacaoBusiness();
		List<Integer> numerosNotasFiscais = Arrays.asList(283);
		String rsTexto = geraObservacao.geraObservacao(numerosNotasFiscais);
		assertThat(rsTexto, StringContains.containsString("fiscal"));
	}

	@Test
	public void verificaSeRetornoTextoPluralComValores() {
		GeradorObservacaoBusiness geraObservacao = new GeradorObservacaoBusiness();

		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "10.00");
		valores.put(2, "35.00");
		valores.put(3, "5.00");
		valores.put(4, "1500.00");
		valores.put(5, "0.30");

		String rsTexto = geraObservacao.geraObservacao(valores);
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

	@Test
	public void verificaSeRetornoTextoSingularComValores() {
		GeradorObservacaoBusiness geraObservacao = new GeradorObservacaoBusiness();

		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "7.00");

		String rsTexto = geraObservacao.geraObservacao(valores);
		assertThat(rsTexto, StringContains.containsString("fiscal"));
	}

	@Test
	public void verificaSeTextoPlural() {
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		assertTrue(GeradorObservacaoBusiness.isPlural(numerosNotasFiscais));
	}

	@Test
	public void verificaSeTextoSingular() {
		List<Integer> numerosNotasFiscais = Arrays.asList(1);
		assertFalse(GeradorObservacaoBusiness.isPlural(numerosNotasFiscais));
	}

	@Test
	public void verificaSeTextoFuncionaComNull() {
		List<Integer> numerosNotasFiscais = null;
		assertFalse(GeradorObservacaoBusiness.isPlural(numerosNotasFiscais));
	}

	@Test
	public void verificaSeExisteNumerosNotasFiscais() {
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		assertTrue(GeradorObservacaoBusiness.hasNumerosNotasFiscais(numerosNotasFiscais));
	}

	@Test
	public void verificaSeNaoExisteNumerosNotasFiscais() {
		List<Integer> numerosNotasFiscais = Arrays.asList();
		assertFalse(GeradorObservacaoBusiness.hasNumerosNotasFiscais(numerosNotasFiscais));
	}

	@Test
	public void verificaSeNull() {
		List<Integer> numerosNotasFiscais = null;
		assertFalse(GeradorObservacaoBusiness.hasNumerosNotasFiscais(numerosNotasFiscais));
	}

	@Test
	public void verificaRetornaCodigoList() {
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		assertThat((GeradorObservacaoBusiness.retornaCodigos(numerosNotasFiscais)).toString(),
				StringContains.containsString("3, 4"));
	}

	@Test
	public void verificaRetornaCodigoMap() {
		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "10.00");
		valores.put(2, "35.00");
		valores.put(3, "5.00");
		valores.put(4, "1500.00");
		valores.put(5, "0.30");

		assertThat((GeradorObservacaoBusiness.retornaCodigos(valores)).toString(),
				StringContains.containsString("cujo valor"));
	}
}
