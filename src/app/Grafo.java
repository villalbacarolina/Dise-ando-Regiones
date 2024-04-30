package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Arista b = new Arista(destino, origen, peso);
		
		String claveDeAristaA = a.getClaveOrigenDestino();
		String claveDeAristaB = b.getClaveOrigenDestino();
		
		_aristas.put(claveDeAristaA, a);
		_aristas.put(claveDeAristaB, b);
				
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
	
	public List<Arista> obtenerAristas(){
		List<Arista> aristas = new ArrayList<>();
		 for (Map.Entry<String, Arista> entry : _aristas.entrySet()) {
	            aristas.add(entry.getValue());
	        }
		 return aristas;
	}

	public int tamanio() {
		return this._vecinos.size();
	}

	
	
	// VERIFICACIONES
	
	private void assertVerticeValido(int vertice) {
		if (_vecinos.get(vertice) == null) {
			throw new IllegalArgumentException("El vértice no existe: " + vertice);
		}
	}
	
    public void validarQueNoEsteVacio(){
        if(obtenerAristas().size() == 0)
            throw new IllegalArgumentException("El grafo no tiene ningún componente conexa.");
    }

	
	// PARA DEBUGGEAR
	
	public void mostrarAristas() {
		 for (Map.Entry<String, Arista> entry : _aristas.entrySet()) {
	            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
	        }
	}
	
}
