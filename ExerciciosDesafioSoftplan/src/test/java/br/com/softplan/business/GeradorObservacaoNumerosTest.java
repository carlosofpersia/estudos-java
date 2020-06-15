package br.com.softplan.business;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.StringContains;
import org.junit.Test;

public class GeradorObservacaoNumerosTest {

	@Test
	public void verificaConstrutor() {
		GeradorObservacaoNumeros gerador = new GeradorObservacaoNumeros();
		assertTrue(gerador instanceof GeradorObservacaoNumeros);
	}

	@Test
	public void verificaSeRetornoTextoPlural() {
		GeradorObservacaoNumeros geraObservacao = new GeradorObservacaoNumeros();
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		String rsTexto = geraObservacao.geraObservacao(numerosNotasFiscais);
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

	@Test
	public void verificaSeRetornoTextoPluralConstruct() {
		List<Integer> numerosNotasFiscais = Arrays.asList(6, 7, 8, 9, 10);
		GeradorObservacaoNumeros geraObservacao = new GeradorObservacaoNumeros(numerosNotasFiscais);
		String rsTexto = geraObservacao.geraObservacao();
		assertThat(rsTexto, StringContains.containsString("fiscais"));
	}

	@Test
	public void verificaSeRetornoTextoSingular() {
		GeradorObservacaoNumeros geraObservacao = new GeradorObservacaoNumeros();
		List<Integer> numerosNotasFiscais = Arrays.asList(283);
		String rsTexto = geraObservacao.geraObservacao(numerosNotasFiscais);
		assertThat(rsTexto, StringContains.containsString("fiscal"));
	}

	@Test
	public void verificaRetornaCodigoList() {
		GeradorObservacaoNumeros geradorObservacaoNumeros = new GeradorObservacaoNumeros();
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		assertThat((geradorObservacaoNumeros.retornaCodigos(numerosNotasFiscais)).toString(),
				StringContains.containsString("3, 4"));
	}
}
