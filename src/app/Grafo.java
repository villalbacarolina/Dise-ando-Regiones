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
	private int _cant_eliminados;
	private Map<String, Arista> _aristas;
	private int _nextID;

	public Grafo(int vertices) {
		if (vertices < 0) {
			throw new IllegalArgumentException("La cantidad de vértices tiene que ser un número entero: " + vertices);
		}

		_nextID = 0;
		_vecinos = new HashMap<>();
		_aristas = new HashMap<>();
		_cant_eliminados = 0;

		if (vertices == 0) {
//			_vecinos.put(0, new ArrayList<>());
			return;
		}

		for (int i = 0; i < vertices; i++) {
			_vecinos.put(i, new ArrayList<>());
			_nextID = i;
		}
		_nextID++;

	}

	public void eliminarVertice(int vertice) {
		assertVerticeValido(vertice);
		
		System.out.println("vertice: " + vertice);
		List<Integer> vecinos = new ArrayList<>(_vecinos.get(vertice));
		
		System.out.println("Vecinos: " + vecinos);
		
		vecinos.forEach(vecino -> eliminarArista(vertice, vecino) );
//		vecinos.forEach(vecino -> _vecinos.get(vecino).remove(vertice));
		// CLEAR
		_vecinos.get(vertice).clear();
		_cant_eliminados++;
	}

	public int agregarVertice() {
		int id = _nextID;
		
		_vecinos.put(_nextID, new ArrayList<>());
		_nextID++;
		
		System.out.println("ID para el vertice: "+id);
		
		return id;
	}

	public void agregarArista(int origen, int destino, int peso) {
		assertVerticeValido(origen);
		assertVerticeValido(destino);

		_vecinos.get(origen).add(destino);
		_vecinos.get(destino).add(origen);

		Arista a = new Arista(origen, destino, peso);

		String claveDeAristaA = a.getClaveOrigenDestino();
		String claveDeAristaB = a.getClaveDestinoOrigen();

		_aristas.put(claveDeAristaA, a);
		_aristas.put(claveDeAristaB, a);

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
//		assertVerticeValido(vertice);
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
	
	public int verticesDisponibles() {
		return tamanio() - _cant_eliminados;
	}

	public void actualizarPeso(int origen, int destino, int peso) {
			assertVerticeValido(origen);
			assertVerticeValido(destino);
			String clave = "" + origen + "-" + destino;

			Arista arista = _aristas.get(clave);

			if (arista != null) {
				arista.setPeso(peso);
				return;
			}

			agregarArista(origen, destino, peso);

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
