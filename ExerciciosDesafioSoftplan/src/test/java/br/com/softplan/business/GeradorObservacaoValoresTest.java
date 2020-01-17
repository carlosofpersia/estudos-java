package br.com.softplan.business;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.StringContains;
import org.junit.Test;

public class GeradorObservacaoValoresTest {

	@Test
	public void verificaConstrutor() {
		GeradorObservacaoValores gerador = new GeradorObservacaoValores();
		assertTrue(gerador instanceof GeradorObservacaoValores);
	}

	@Test
	public void verificaSeRetornoTextoPluralComValores() {
		GeradorObservacaoValores geraObservacao = new GeradorObservacaoValores();

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
		GeradorObservacaoValores geraObservacao = new GeradorObservacaoValores();

		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "7.00");

		String rsTexto = geraObservacao.geraObservacao(valores);
		assertThat(rsTexto, StringContains.containsString("fiscal"));
	}

	@Test
	public void verificaRetornaCodigoMap() {
		GeradorObservacaoValores geradorObservacaoValores = new GeradorObservacaoValores();
		Map<Integer, String> valores = new HashMap<>();
		valores.put(1, "10.00");
		valores.put(2, "35.00");
		valores.put(3, "5.00");
		valores.put(4, "1500.00");
		valores.put(5, "0.30");
		assertThat((geradorObservacaoValores.retornaCodigos(valores)).toString(),
				StringContains.containsString("cujo valor"));
	}

}
