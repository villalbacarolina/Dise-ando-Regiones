package app.arista;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Arista;

public class AristaTest {

	@Test(expected = IllegalArgumentException.class)
	public void mismoOrigenyDestino_LanzaError() {
		int origen = 1;
		int destino = 1;
		int peso = 200;
		new Arista(origen, destino, peso);
	}

	@Test(expected = IllegalArgumentException.class)
	public void pesoNegativo_LanzaError() {
		int origen = 1;
		int destino = 1;
		int peso = -1;
		new Arista(origen, destino, peso);
	}

	@Test(expected = IllegalArgumentException.class)
	public void origenNegativo_LanzaError() {
		int origen = -1;
		int destino = 1;
		int peso = 100;
		new Arista(origen, destino, peso);

	}

	@Test(expected = IllegalArgumentException.class)
	public void destinoNegativo_LanzaError() {
		int origen = 1;
		int destino = -1;
		int peso = 100;
		new Arista(origen, destino, peso);
	}

	@Test
	public void actualizarPeso() {
		int origen = 1;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen, destino, peso);
		int nuevoPeso = 200;

		a.setPeso(nuevoPeso);

		assertEquals(a.getPeso(), nuevoPeso);
	}
	
	
	@Test
	public void obtenerClaveOrigenDestino() {
		int origen = 1;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen, destino, peso);

		String clave = "" + origen + "-" + destino;

		assertEquals(a.getClaveOrigenDestino(), clave);
	}
	
	@Test
	public void obtenerClaveDestinoOrigen() {
		int origen = 1;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen, destino, peso);

		String clave = "" + destino + "-" + origen;

		assertEquals(a.getClaveDestinoOrigen(), clave);
	}
	

	
}
