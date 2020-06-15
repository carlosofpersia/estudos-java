package br.com.softplan.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void verificaSeTextoPlural() {
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		assertTrue(Utils.isPlural(numerosNotasFiscais));
	}

	@Test
	public void verificaSeTextoSingular() {
		List<Integer> numerosNotasFiscais = Arrays.asList(1);
		assertFalse(Utils.isPlural(numerosNotasFiscais));
	}

	@Test
	public void verificaSeTextoFuncionaComNull() {
		List<Integer> numerosNotasFiscais = null;
		assertFalse(Utils.isPlural(numerosNotasFiscais));
	}

	@Test
	public void verificaSeExisteNumerosNotasFiscais() {
		List<Integer> numerosNotasFiscais = Arrays.asList(1, 2, 3, 4, 5);
		assertTrue(Utils.hasNumerosNotasFiscais(numerosNotasFiscais));
	}

	@Test
	public void verificaSeNaoExisteNumerosNotasFiscais() {
		List<Integer> numerosNotasFiscais = Arrays.asList();
		assertFalse(Utils.hasNumerosNotasFiscais(numerosNotasFiscais));
	}

	@Test
	public void verificaSeNull() {
		List<Integer> numerosNotasFiscais = null;
		assertFalse(Utils.hasNumerosNotasFiscais(numerosNotasFiscais));
	}
}
