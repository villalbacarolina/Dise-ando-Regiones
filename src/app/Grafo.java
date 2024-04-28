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
    
    public int tamanio() {
    	return this._vecinos.size();
    }
	
}
