package app.grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.Grafo;

public class AgregarAristaTest {

	@Test(expected = IllegalArgumentException.class)
	public void verticeOrigenNoExiste_LanzaError() {
		int cantVertices = 2;
		int verticeOrigenNoExiste = 2;
		int verticeDestino = 1;
		double peso = 200;
		Grafo g = new Grafo(cantVertices);

		g.agregarArista(verticeOrigenNoExiste, verticeDestino, peso);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeDestinoNoExiste_LanzaError() {
		int cantVertices = 2;
		int verticeOrigenNoExiste = 1;
		int verticeDestino = 2;
		double peso = 200;
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
		Grafo g = new Grafo(cantVertices);

		List<Integer> vecinosObetenidos = new ArrayList<Integer>();
		vecinosObetenidos.add(verticeDestino);

		g.agregarArista(verticeOrigen, verticeDestino, 450);

		assertEquals("Los vecinos no coinciden", g.obtenerVecinos(verticeOrigen), vecinosObetenidos);
	}

}
