package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DisenandoRegiones {

	private Grafo _grafoArgentina;

	public DisenandoRegiones() {
		crearArgentina();
	}

	public void agregarPeso(int origen, int destino, int peso) {
		_grafoArgentina.actualizarPeso(origen, destino, peso);
	}
	
	public void obtenerVecinos(int origen) {
		Set<Arista> conjunto_aristas = _grafoArgentina.obtenerAristasDe(origen);
		List<Arista> lista_aristas = new ArrayList<>(conjunto_aristas);
		
		//por ahora lo usamos para pintar los vecinos..
		//hay que retornar los valores de las aristas como un DTO o una tupla
		for(Arista arista: lista_aristas) {
			System.out.println(arista.getOrigen() + "-" + arista.getDestino() + "-" + arista.getPeso());
		}
	}

	public void crearArgentina() {
		_grafoArgentina = new Grafo(24);
		// para visualizar el grafico de aristas, ver /utils/aristas argentina.jpg
		_grafoArgentina.agregarArista(0, 1, 0);
		_grafoArgentina.agregarArista(1, 2, 0);
		_grafoArgentina.agregarArista(1, 3, 0);
		_grafoArgentina.agregarArista(1, 4, 0);
		_grafoArgentina.agregarArista(1, 19, 0);
		_grafoArgentina.agregarArista(1, 20, 0);
		_grafoArgentina.agregarArista(2, 3, 0);
		_grafoArgentina.agregarArista(2, 4, 0);
		_grafoArgentina.agregarArista(2, 11, 0);
		_grafoArgentina.agregarArista(3, 4, 0);
		_grafoArgentina.agregarArista(4, 20, 0);
		_grafoArgentina.agregarArista(4, 6, 0);
		_grafoArgentina.agregarArista(4, 5, 0);
		_grafoArgentina.agregarArista(5, 11, 0);
		_grafoArgentina.agregarArista(5, 10, 0);
		_grafoArgentina.agregarArista(5, 6, 0);
		_grafoArgentina.agregarArista(5, 7, 0);
		_grafoArgentina.agregarArista(6, 20, 0);
		_grafoArgentina.agregarArista(6, 21, 0);
		_grafoArgentina.agregarArista(6, 23, 0);
		_grafoArgentina.agregarArista(6, 7, 0);
		_grafoArgentina.agregarArista(7, 23, 0);
		_grafoArgentina.agregarArista(7, 8, 0);
		_grafoArgentina.agregarArista(7, 9, 0);
		_grafoArgentina.agregarArista(7, 15, 0);
		_grafoArgentina.agregarArista(9, 10, 0);
		_grafoArgentina.agregarArista(9, 13, 0);
		_grafoArgentina.agregarArista(9, 14, 0);
		_grafoArgentina.agregarArista(9, 15, 0);
		_grafoArgentina.agregarArista(10, 11, 0);
		_grafoArgentina.agregarArista(10, 12, 0);
		_grafoArgentina.agregarArista(10, 13, 0);
		_grafoArgentina.agregarArista(11, 12, 0);
		_grafoArgentina.agregarArista(12, 13, 0);
		_grafoArgentina.agregarArista(13, 14, 0);
		_grafoArgentina.agregarArista(14, 15, 0);
		_grafoArgentina.agregarArista(15, 16, 0);
		_grafoArgentina.agregarArista(16, 17, 0);
		_grafoArgentina.agregarArista(17, 18, 0);
		_grafoArgentina.agregarArista(19, 20, 0);
		_grafoArgentina.agregarArista(20, 21, 0);
		_grafoArgentina.agregarArista(21, 22, 0);
		_grafoArgentina.agregarArista(21, 23, 0);
	}

}
