package app.grafo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import app.Grafo;

public class AgregarVerticeTest {

	@Test
	public void obtenerIdDelVerticeAgregado() {
		Grafo g = setup();
		int idEsperado = 4;
		
		int resp = g.agregarVertice();
		
		assertTrue(idEsperado == resp);
	}
	
	@Test
	public void aumentaLaCantidadDeVertices() {
		Grafo g = setup();
		int tamanioEsperado = 5;
		
		g.agregarVertice();
		
		assertTrue(tamanioEsperado == g.tamanio());
	}
	
	@Test
	public void elVerticeNoTieneVecinos() {
		Grafo g = setup();
		int id = g.agregarVertice();
		
		List<Integer> resp = g.obtenerVecinos(id);
		
		assertTrue(resp.size() == 0);
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
