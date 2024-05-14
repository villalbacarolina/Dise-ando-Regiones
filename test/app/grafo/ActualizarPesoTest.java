package app.grafo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import app.Arista;
import app.Grafo;

public class ActualizarPesoTest {

	@Test(expected = IllegalArgumentException.class)
	public void actualizarPesoOrigenNoValido() {
		Grafo g = setup();
		g.actualizarPeso(4, 0, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void actualizarPesoDestinoNoValido() {
		Grafo g = setup();
		g.actualizarPeso(0, 4, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void actualizarPesoConPesoNoValido() {
		Grafo g = setup();
		g.actualizarPeso(0, 1, -1);
	}

	@Test
	public void actualizarPeso() {
		Grafo g = setup();
		Arista aristaEsperada = new Arista(0, 1, 100);

		g.actualizarPeso(0, 1, 100);

		Set<Arista> aristas = g.obtenerAristasDe(0);
		boolean res = false;
		for (Arista arista : aristas) {
			res |= arista.equals(aristaEsperada);
		}

		assertTrue(res);

	}

	private Grafo setup() {
		Grafo g = new Grafo(4);

		g.agregarArista(0, 1, 10);
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 3, 10);

		return g;
	}
}
