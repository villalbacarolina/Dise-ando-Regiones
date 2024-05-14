package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkDTOTest {

	@Test
	public void obtenerNombre() {
		String nombreEsperado = "Bs As";
		MarcaDTO mark = new MarcaDTO(nombreEsperado, 1);
		assertEquals(nombreEsperado, mark.nombre());
	}
	
	@Test
	public void obtenerID() {
		int idEsperado = 1;
		MarcaDTO mark = new MarcaDTO("Bs As", idEsperado);
		assertEquals(idEsperado, mark.id());
	}


}
