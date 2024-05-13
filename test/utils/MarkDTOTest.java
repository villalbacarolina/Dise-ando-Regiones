package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkDTOTest {

	@Test
	public void obtenerNombre() {
		String nombreEsperado = "Bs As";
		MarkDTO mark = new MarkDTO(nombreEsperado, 1);
		assertEquals(nombreEsperado, mark.name());
	}
	
	@Test
	public void obtenerID() {
		int idEsperado = 1;
		MarkDTO mark = new MarkDTO("Bs As", idEsperado);
		assertEquals(idEsperado, mark.id());
	}


}
