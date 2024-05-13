package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputUtilsTest {

	@Test(expected = IllegalArgumentException.class)
	public void parseIntFalla() {
		InputUtils.tryParseInt("test", "soyUnString");
	}

	@Test(expected = IllegalArgumentException.class)
	public void parseDoubleFalla() {
		InputUtils.tryParseDouble("test", "soyUnString");
	}

	@Test
	public void parseInt() {
		int res = InputUtils.tryParseInt("testOK", "1");
		assertEquals(res, 1);
	}

	@Test
	public void parseDouble() {
		Double res = InputUtils.tryParseDouble("testOK", "1.2");
		assertTrue(res == 1.2);
	}
}
