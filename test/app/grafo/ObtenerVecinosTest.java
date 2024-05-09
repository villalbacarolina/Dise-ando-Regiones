package app.grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.Grafo;

public class ObtenerVecinosTest {

	@Test(expected = IllegalArgumentException.class)
	public void verticeNoExiste_LanzaError() {
		int cantVertices = 2;
		int verticeOrigen = 0;
		int verticeDestino = 1;
		int verticeNoExiste = 2;
		int peso = 200;
		Grafo g = new Grafo(cantVertices);
		g.agregarArista(verticeOrigen, verticeDestino, peso);
	
		g.obtenerVecinos(verticeNoExiste);		
	}
	
	@Test
	public void obtenerVecinos() {
		int cantVertices = 2;
		int verticeOrigen = 0;
		int verticeDestino = 1;
		int peso = 200;
		Grafo g = new Grafo(cantVertices);
		g.agregarArista(verticeOrigen, verticeDestino, peso);
		List<Integer> vecinosEsperados = new ArrayList<>();
		vecinosEsperados.add(1);		
		
		List<Integer> vecinosObtenidos = g.obtenerVecinos(verticeOrigen);
		
		assertEquals(vecinosObtenidos, vecinosEsperados);
	}
	
}
