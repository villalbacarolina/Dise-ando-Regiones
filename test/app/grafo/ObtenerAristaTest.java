package app.grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import app.Arista;
import app.Grafo;

public class ObtenerAristaTest {

	@Test
	public void obtenerAristasDeUnVertice() {
		Grafo g = setup();
		g.agregarArista(0, 1, 100);
		g.agregarArista(0, 2, 200);
		g.agregarArista(1, 2, 200);
		
		Set<Arista> aristas = g.obtenerAristasDe(0);
		List<Arista> lista_aristas = new ArrayList<>(aristas);

		assertEquals(lista_aristas.size(), 2);
	}
	
	@Test
	public void obtenerTodasLasAristas() {
		Grafo g = setup();
		g.agregarArista(0, 1, 100);
		g.agregarArista(0, 2, 200);
		g.agregarArista(1, 2, 200);
		
		List<Arista> aristas = g.obtenerAristas();
		
		assertEquals(aristas.size(), 3);
		
	}
	
	private Grafo setup() {
		int cantVertices = 3;
		Grafo g = new Grafo(cantVertices);
		return g;
	}

}
