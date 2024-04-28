package app.grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import app.Grafo;

public class ObtenerVecinosTest {

	@Test(expected = IllegalArgumentException.class)
	public void verticeNoExiste_LanzaError() {
		int cantVertices = 2;
		int verticeOrigen = 0;
		int verticeDestino = 1;
		int verticeNoExiste = 2;
		double peso = 200;
		Grafo g = new Grafo(cantVertices);
		g.agregarArista(verticeOrigen, verticeDestino, peso);
	
		g.obtenerVecinos(verticeNoExiste);		
	}
	
	@Test
	public void obtenerVecinos() {
		int cantVertices = 2;
		int verticeOrigen = 0;
		int verticeDestino = 1;
		double peso = 200;
		Grafo g = new Grafo(cantVertices);
		g.agregarArista(verticeOrigen, verticeDestino, peso);
		ArrayList<Integer> vecinosEsperados = new ArrayList<>();
		vecinosEsperados.add(verticeDestino);		
		
		assertEquals(g.obtenerVecinos(verticeOrigen), vecinosEsperados);
	}
	
}
