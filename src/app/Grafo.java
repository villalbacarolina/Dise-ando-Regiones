package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.NumberSearch;

public class Grafo {

	private Map<Integer, List<Integer>> _vecinos;
	private Map<String, Arista> _aristas;

	public Grafo(int vertices) {
		if (vertices < 0) {
			throw new IllegalArgumentException("La cantidad de vértices tiene que ser un número entero: " + vertices);
		}

		_vecinos = new HashMap<>();
		_aristas = new HashMap<>();
		for (int i = 0; i < vertices; i++) {
			_vecinos.put(i, new ArrayList<>());
		}

	}

	public void agregarArista(int origen, int destino, int peso) {
		assertVerticeValido(origen);
		assertVerticeValido(destino);

		_vecinos.get(origen).add(destino);
		_vecinos.get(destino).add(origen);

		Arista a = new Arista(origen, destino, peso);
//		Arista b = new Arista(destino, origen, peso);

		String claveDeAristaA = a.getClaveOrigenDestino();
		String claveDeAristaB = a.getClaveDestinoOrigen();

		_aristas.put(claveDeAristaA, a);
		_aristas.put(claveDeAristaB, a);
//		_aristas.put(claveDeAristaB, b);

	}

	public void eliminarArista(int origen, int destino) {
		assertVerticeValido(origen);
		assertVerticeValido(destino);

		_vecinos.get(origen).remove((Object) destino);
		_vecinos.get(destino).remove((Object) origen);

		String claveDeAristaA = "" + origen + "-" + destino;
		String claveDeAristaB = "" + destino + "-" + origen;

		_aristas.remove(claveDeAristaA);
		_aristas.remove(claveDeAristaB);

	}

	public List<Integer> obtenerVecinos(int vertice) {
		assertVerticeValido(vertice);
		return _vecinos.get(vertice);
	}

	public List<Arista> obtenerAristas() {
		Set<Arista> conjunto_aristas = new HashSet<>();

		for (Map.Entry<String, Arista> entry : _aristas.entrySet()) {
			conjunto_aristas.add(entry.getValue());
		}
		
		return new ArrayList<>(conjunto_aristas);
	}

	public Set<Arista> obtenerAristasDe(int origen) {
		Set<Arista> aristas = new HashSet<>();
		for (Map.Entry<String, Arista> entry : _aristas.entrySet()) {
			String clave = entry.getKey();
			if (!NumberSearch.containsIsolatedNumber(clave, origen)) {
				continue;
			}
			aristas.add(entry.getValue());
		}
		return aristas;
	}

	public int tamanio() {
		return this._vecinos.size();
	}

	public void actualizarPeso(int origen, int destino, int peso) {
		assertVerticeValido(origen);
		assertVerticeValido(destino);
		String clave = "" + origen + "-" + destino;
		Arista arista = _aristas.get(clave);
		if (arista != null) {
			arista.setPeso(peso);
		}

	}

	// VERIFICACIONES

	private void assertVerticeValido(int vertice) {
		if (_vecinos.get(vertice) == null) {
			throw new IllegalArgumentException("El vértice no existe: " + vertice);
		}
	}

	public void validarQueNoEsteVacio() {
		if (obtenerAristas().size() == 0)
			throw new IllegalArgumentException("El grafo no tiene ningún componente conexa.");
	}

	// PARA DEBUGGEAR

	public void mostrarAristas() {
		for (Map.Entry<String, Arista> entry : _aristas.entrySet()) {
			System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue().getPeso());
		}
	}

}
