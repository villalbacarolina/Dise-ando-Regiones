package utils;

public class InputUtils {
	
	public static Integer tryParseInt(String inputName, String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(inputName + " -> Tiene que ser un número Natural: " + value);
		}
	}
	
	public static Double tryParseDouble(String inputName, String value) {
		try {
			return Double.valueOf(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(inputName + " -> Tiene que ser un número: " + value);
		}
	}
}
