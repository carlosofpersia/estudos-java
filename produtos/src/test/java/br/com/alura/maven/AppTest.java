package br.com.alura.maven;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void verificaConstrutor() {
		App app = new App();
		assertTrue(app instanceof App);
	}

	@Test
	public void verificaMain() {
		App.main(null);
	}

}
