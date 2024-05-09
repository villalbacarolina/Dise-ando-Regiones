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
		new Arista(origen,destino,peso);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void origenNegativo_LanzaError() {
		int origen = -1;
		int destino = 1;
		int peso = 100;
		new Arista(origen,destino,peso);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void destinoNegativo_LanzaError() {
		int origen = 1;
		int destino = -1;
		int peso = 100;
		new Arista(origen,destino,peso);
	}
	
	@Test
	public void aristasMismosValores() {
		int origen = 1;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen,destino,peso);
		Arista b = new Arista(origen,destino,peso);
		assertTrue(a.equals(b));
	}

	@Test
	public void distintosOrigenesEnConexion() {
		int origen = 1;
		int origen2 = 0;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen,destino,peso);
		Arista b = new Arista(destino,origen2,peso);
		
		assertFalse(a.esMismaConexion(b));
	}
	
	@Test
	public void distintosDestinosEnConexion() {
		int origen = 1;
		int destino2 = 0;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen,destino,peso);
		Arista b = new Arista(destino2,origen,peso);
		
		assertFalse(a.esMismaConexion(b));
	}
	
	@Test
	public void distintospesosEnConexion() {
		int origen = 1;
		int destino = 2;
		int peso = 100;
		int peso2 = 99;
		Arista a = new Arista(origen,destino,peso);
		Arista b = new Arista(destino,origen,peso2);
		
		assertFalse(a.esMismaConexion(b));
	}
	
	@Test
	public void mismaConexion() {
		int origen = 1;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen,destino,peso);
		Arista b = new Arista(destino,origen,peso);
		
		assertTrue(a.esMismaConexion(b));
	}
	
	@Test
	public void actualizarPeso() {
		int origen = 1;
		int destino = 2;
		int peso = 100;
		Arista a = new Arista(origen,destino,peso);
		int nuevoPeso = 200;
		
		a.setPeso(nuevoPeso);
		
		assertEquals(a.getPeso(), nuevoPeso);
	}
	
}
