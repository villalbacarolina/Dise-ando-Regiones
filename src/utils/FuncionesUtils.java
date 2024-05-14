package utils;

public class FuncionesUtils {

	public static Integer intentarParsearInteger(String inputName, String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(inputName + " -> Tiene que ser un número Natural: " + value);
		}
	}

	public static Double intentarParsearDouble(String inputName, String value) {
		try {
			return Double.valueOf(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(inputName + " -> Tiene que ser un número: " + value);
		}
	}

	public static boolean stringContieneNumero(String input, int number) {
		String numberStr = Integer.toString(number);
		String pattern = ".*\\b" + numberStr + "\\b.*";
		return input.matches(pattern);
	}
}
