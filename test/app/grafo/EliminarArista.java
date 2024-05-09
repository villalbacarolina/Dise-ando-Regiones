package app.grafo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.Arista;
import app.Grafo;

public class EliminarArista {

	@Test
	public void EliminaDeVecinos() {
		int cantVertices = 3;
		int verticeOrigen = 0;
		int verticeDestino = 1;
		int peso = 200;
		int vertice2Origen = 1;
		int vertice2Destino = 2;
		int peso2 = 500;
		Grafo g = new Grafo(cantVertices);
		g.agregarArista(verticeOrigen, verticeDestino, peso);
		g.agregarArista(vertice2Origen, vertice2Destino, peso2);
		List<Integer> vecinosEsperados = new ArrayList<>();
		vecinosEsperados.add(0);
		
		
	g.eliminarArista(vertice2Origen, vertice2Destino);
		
		List<Integer> vecinosObtenidos = g.obtenerVecinos(vertice2Origen);
		
		assertEquals(vecinosObtenidos, vecinosEsperados);
		
	}
	
	@Test
	public void EliminaDeAristas() {
		int cantVertices = 3;
		int verticeOrigen = 0;
		int verticeDestino = 1;
		int peso = 200;
		Grafo g = new Grafo(cantVertices);
		g.agregarArista(verticeOrigen, verticeDestino, peso);

		List<Arista> aristasEsperadas = new ArrayList<>();
		
		g.eliminarArista(verticeOrigen, verticeDestino);
		
		List<Arista> aristasObtenidas = g.obtenerAristas();
		
		assertEquals(aristasObtenidas, aristasEsperadas);
		
	}

}
