package app.grafo;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Grafo;

public class TamanioTest {

	@Test
	public void tamanio() {
		int numeroVertices = 1;
		Grafo g = new Grafo(numeroVertices);

		int tamanioObtenido = g.tamanio();

		assertEquals("El tamanio del grafo debería coincidir con el numero de vertices ingresado", tamanioObtenido,
				numeroVertices);
	}

}
