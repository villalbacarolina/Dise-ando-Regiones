package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	
    private Map<Integer, List<Integer>> _vecinos;
    
    public Grafo(int vertices) {
    	if(vertices < 0) {
    		throw new IllegalArgumentException("La cantidad de vértices tiene que ser un número entero: " + vertices);
    	}
    	    	

    	_vecinos = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            _vecinos.put(i, new ArrayList<>());
        }
    }
    
    public void agregarArista(int origen, int destino, double peso) {
    	assertNoBucle(origen, destino);
    	assertVerticeValido(origen);
    	assertVerticeValido(destino);
    	
        _vecinos.get(origen).add(destino);
        _vecinos.get(destino).add(origen);
    }
    
    public List<Integer> obtenerVecinos(int vertice) {
    	assertVerticeValido(vertice);
    	
        return _vecinos.get(vertice);
    }
    
    public int tamanio() {
    	return this._vecinos.size();
    }
      
    private void assertVerticeValido(int vertice) {
    	if(vertice < 0) {
    		throw new IllegalArgumentException("El vértice tiene que ser un número entero: " + vertice);
    	}
    	
    	if(_vecinos.get(vertice) == null) {
    		throw new IllegalArgumentException("El vértice no existe: " + vertice);
    	}
    }
    
    private void assertNoBucle(int origen, int destino) {
    	if( origen == destino) {
    		throw new IllegalArgumentException("No se permiten bucles -> origen-destino: " + origen);
    	}
    }
	
}
