package app;

public class Arista {
	private int _origen;
	private int _destino;
	private int _peso;

	public Arista(int origen, int destino, int peso) {
		assertNoBucle(origen, destino);
		assertVerticeValido(origen);
		assertVerticeValido(destino);
		assertPesoValido(peso);
		_origen = origen;
		_destino = destino;
		_peso = peso;
	}

	public int getOrigen() {
		return _origen;
	}

	public int getDestino() {
		return _destino;
	}

	public int getPeso() {
		return _peso;
	}

	public String getClaveOrigenDestino() {
		return "" + _origen + "-" + _destino;
	}

	public String getClaveDestinoOrigen() {
		return "" + _destino + "-" + _origen;
	}

	public void setPeso(int peso) {
		assertPesoValido(peso);
		_peso = peso;
	}

	private void assertPesoValido(int peso) {
		if (peso < 0) {
			throw new IllegalArgumentException("El peso tiene que ser un número Natural: " + peso);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Arista arista = (Arista) obj;
		if (_origen != arista._origen || _destino != arista._destino || _peso != arista._peso) {
			return false;
		}

		return true;
	}

	private void assertVerticeValido(int vertice) {
		if (vertice < 0) {
			throw new IllegalArgumentException("El vértice tiene que ser un número Natural: " + vertice);
		}
	}

	private void assertNoBucle(int origen, int destino) {
		if (origen == destino) {
			throw new IllegalArgumentException("No se permiten bucles -> origen-destino: " + origen);
		}
	}
}
