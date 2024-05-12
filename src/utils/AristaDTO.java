package utils;

public class AristaDTO {
	int _origen;
	int _destino;
	int _peso;

	public AristaDTO(int origen, int destino, int peso) {
		_origen = origen;
		_destino = destino;
		_peso = peso;
	}

	public int get_origen() {
		return _origen;
	}

	public int get_destino() {
		return _destino;
	}

	public int get_peso() {
		return _peso;
	}

}
