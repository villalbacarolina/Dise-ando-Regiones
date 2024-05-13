package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberSearchTest {

	@Test
	public void contieneElNumero() {
		String text = "1-10";
		int numbSearch = 1;
		
		assertTrue(NumberSearch.containsIsolatedNumber(text, numbSearch));
	}
	
	@Test
	public void noContieneElNumero() {
		String text = "1-10";
		int numbSearch = 2;
		
		assertFalse(NumberSearch.containsIsolatedNumber(text, numbSearch));
	}

}
