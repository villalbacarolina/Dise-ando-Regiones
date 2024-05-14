package app.bfs;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import app.BFS;
import app.Grafo;

public class BFS_Test {

	@Test(expected = IllegalArgumentException.class)
	public void nullNoConexo() {
		BFS.esConexo(null);
	}

	@Test
	public void esConexoGrafoVacio() {
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}

	@Test
	public void esConexoGrafo() {
		Grafo g = grafoConexo();
		assertTrue(BFS.esConexo(g));
	}

	@Test
	public void alcanzablesDesdeUnVertice() {
		Grafo g = grafoConexo();
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);

		Set<Integer> esperados = new HashSet<>();

		esperados.add(0);
		esperados.add(1);
		esperados.add(2);
		esperados.add(3);

		assertEquals(alcanzables, esperados);
	}

	@Test
	public void alcanzablesNoConexo() {
		Grafo g = grafoNOConexo();
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		Set<Integer> esperados = new HashSet<>();
		esperados.add(0);
		esperados.add(1);
		esperados.add(2);

		assertEquals(alcanzables, esperados);
	}

	@Test
	public void grafoNoConexo() {
		Grafo g = grafoNOConexo();

		assertFalse(BFS.esConexo(g));
	}

	private Grafo grafoConexo() {
		Grafo g = new Grafo(4);

		g.agregarArista(0, 1, 10);
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 3, 10);
		g.agregarArista(0, 2, 20);
		g.agregarArista(0, 3, 50);

		return g;
	}

	private Grafo grafoNOConexo() {
		Grafo g = new Grafo(4);

		g.agregarArista(0, 1, 10);
		g.agregarArista(1, 2, 10);

		return g;
	}

}
