package app;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoTest {

	@Test(expected = IllegalArgumentException.class)
	public void numeroVerticesNegativoTest() {
		new Grafo(-1);
	}
	
	@Test
	public void numeroVerticesCeroTest() {
		new Grafo(0);
	}

	@Test
	public void numeroVerticesPositivoTest() {
		new Grafo(1);
	}
	
	@Test
	public void tamanioTest() {
		int numeroVertices = 1 ;
		Grafo g = new Grafo(numeroVertices);
		
		int tamanioObtenido = g.tamanio();
		
		assertEquals("El tamanio del grafo debería coincidir con el numero de vertices ingresado",tamanioObtenido, numeroVertices);
	}
	
	

}
