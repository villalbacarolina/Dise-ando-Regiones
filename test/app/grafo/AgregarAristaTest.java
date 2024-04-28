package app.grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.Arista;
import app.Grafo;

public class AgregarAristaTest {

	@Test(expected = IllegalArgumentException.class)
	public void verticeOrigenNoExiste_LanzaError() {
		int cantVertices = 2;
		int verticeOrigenNoExiste = 2;
		int verticeDestino = 1;
		int peso = 200;
		Grafo g = new Grafo(cantVertices);

		g.agregarArista(verticeOrigenNoExiste, verticeDestino, peso);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeDestinoNoExiste_LanzaError() {
		int cantVertices = 2;
		int verticeOrigenNoExiste = 1;
		int verticeDestino = 2;
		int peso = 200;
		Grafo g = new Grafo(cantVertices);

		g.agregarArista(verticeOrigenNoExiste, verticeDestino, peso);
	}

	@Test(expected = IllegalArgumentException.class)
	public void mismoOrigenYDestino_LanzaError() {
		int cantVertices = 5;
		int verticeOrigen = 0;
		int verticeDestino = 0;
		Grafo g = new Grafo(cantVertices);

		g.agregarArista(verticeOrigen, verticeDestino, 450);
	}

	@Test
	public void distintosVertices() {
		int cantVertices = 5;
		int verticeOrigen = 0;
		int verticeDestino = 4;
		int peso = 200;
		Grafo g = new Grafo(cantVertices);
		List<Integer> vecinosEsperados = new ArrayList<Integer>();
		vecinosEsperados.add(4);

		g.agregarArista(verticeOrigen, verticeDestino, peso);
		
		List<Integer> vecinosObtenidos = g.obtenerVecinos(verticeOrigen);
		
		assertEquals("Los vecinos no coinciden", vecinosObtenidos, vecinosEsperados);
	}

}
