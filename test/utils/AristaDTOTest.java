package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class AristaDTOTest {

	@Test
	public void obtenerOrigen() {
		AristaDTO dto = new AristaDTO(1, 2, 10);

		assertEquals(dto.get_origen(), 1);
	}

	@Test
	public void obtenerDestino() {
		AristaDTO dto = new AristaDTO(1, 2, 10);

		assertEquals(dto.get_destino(), 2);
	}

	@Test
	public void obtenerPeso() {
		AristaDTO dto = new AristaDTO(1, 2, 10);

		assertEquals(dto.get_peso(), 10);
	}

}
