package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class FuncionesUtilsTest {

	@Test(expected = IllegalArgumentException.class)
	public void parseIntFalla() {
		FuncionesUtils.intentarParsearInteger("test", "soyUnString");
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseDoubleFalla() {
		FuncionesUtils.intentarParsearDouble("test", "soyUnString");
	}

	@Test
	public void parseInt() {
		int res = FuncionesUtils.intentarParsearInteger("testOK", "1");
		assertEquals(res, 1);
	}

	@Test
	public void parseDouble() {
		Double res = FuncionesUtils.intentarParsearDouble("testOK", "1.2");
		assertTrue(res == 1.2);
	}

	@Test
	public void contieneElNumero() {
		String text = "1-10";
		int numbSearch = 1;

		assertTrue(FuncionesUtils.stringContieneNumero(text, numbSearch));
	}

	@Test
	public void noContieneElNumero() {
		String text = "1-10";
		int numbSearch = 2;

		assertFalse(FuncionesUtils.stringContieneNumero(text, numbSearch));
	}
}
