package app.grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.Grafo;

public class EliminarVerticeTest {

	@Test(expected = IllegalArgumentException.class)
	public void eliminarVertice() {
		Grafo g = setup();

		g.eliminarVertice(3);

		g.obtenerVecinos(3);
	}

	@Test
	public void verticeEliminadoDeSusVecinos() {
		Grafo g = setup();
		List<Integer> vecinosEsperados = new ArrayList<>();
		vecinosEsperados.add(1);
		vecinosEsperados.add(0);
		g.eliminarVertice(3);

		List<Integer> vecinos = g.obtenerVecinos(2);

		assertEquals(vecinosEsperados, vecinos);

	}

	@Test
	public void menosVerticesDisponibles() {
		Grafo g = setup();
		int cantVerticesOriginal = 4;

		g.eliminarVertice(3);

		int cantVertices = g.verticesDisponibles();

		assertTrue(cantVerticesOriginal > cantVertices);

	}

	private Grafo setup() {
		Grafo g = new Grafo(4);

		g.agregarArista(0, 1, 10);
		g.agregarArista(1, 2, 10);
		g.agregarArista(2, 3, 10);
		g.agregarArista(0, 2, 20);
		g.agregarArista(0, 3, 50);

		return g;
	}

}
