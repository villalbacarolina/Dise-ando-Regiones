package utils;

public class NumberSearch {

	public static boolean containsIsolatedNumber(String input, int number) {
		String numberStr = Integer.toString(number);
		String pattern = ".*\\b" + numberStr + "\\b.*";
		return input.matches(pattern);
	}

}
