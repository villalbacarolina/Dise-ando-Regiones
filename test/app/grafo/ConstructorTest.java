package app.grafo;

import org.junit.Test;

import app.Grafo;

public class ConstructorTest {

	@Test(expected = IllegalArgumentException.class)
	public void numeroNegativo_LanzaError() {
		new Grafo(-1);
	}

	@Test
	public void numeroVerticesCero() {
		new Grafo(0);
	}

	@Test
	public void numeroVerticesPositivo() {
		new Grafo(1);
	}
}
