package utils;

public class MarcaDTO {
	String _nombre;
	Integer _id;

	public MarcaDTO(String nombre, int id) {
		_nombre = nombre;
		_id = id;
	}

	public String nombre() {
		return _nombre;
	}

	public int id() {
		return _id;
	}
}
