package br.com.alura.maven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProdutoTest {

	@Test
	public void verificaConstrutor() {
		Produto bala = new Produto("juquinha", 0.10);
		assertTrue(bala instanceof Produto);

	}

	@Test
	public void verificaPrecoComImposto() {
		Produto bala = new Produto("juquinha", 0.10);
		assertEquals(0.11, bala.getPrecoComImposto(), 0.0001);
	}
	

	@Test
	public void verificaNome() {
		Produto bala = new Produto("juquinha", 0.10);
		assertEquals("juquinha", bala.getNome());
	}

	@Test
	public void verificaPreco() {
		Produto bala = new Produto("juquinha", 0.17);
		assertTrue(0.17 == bala.getPreco());
	}


}
