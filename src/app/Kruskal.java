package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

	public static Grafo generar(Grafo grafo) {
		grafo.validarQueNoEsteVacio();

		if (!BFS.esConexo(grafo)) {
			throw new RuntimeException("El grafo no es conexo");
		}

		List<Arista> aristasGrafo = grafo.obtenerAristas();
		List<Arista> aristasGrafoPesoAscendente = Kruskal.ordenarAristas(aristasGrafo);

		Grafo arbolMinimo = new Grafo(grafo.tamanio());
		UnionFind unionFind = new UnionFind(grafo.tamanio());

		for (Arista arista : aristasGrafoPesoAscendente) {
			int origen = arista.getOrigen();
			int destino = arista.getDestino();

			// si vertice a no esta en el mismo componente conexa que b
			// (en otras palabras, tiene el mismo padre/no forma circuito con b)
			if (!unionFind.find(origen, destino)) {
				// guardamos arista entre a y b
				arbolMinimo.agregarArista(origen, destino, arista.getPeso());
				// como se creo' una arista ahora a y b pertenecen al mismo componente conexa
				// por lo q unionFind anota q tienen el mismo padre
				// y podra' decir si ellos u otros vertices q los usen pertenecen al mismo
				// componente conexa
				unionFind.union(origen, destino);

				if (arbolMinimo.obtenerAristas().size() == grafo.tamanio() - 1)
					break;
			}
		}
		return arbolMinimo;
	}

	public static ArrayList<Arista> ordenarAristas(List<Arista> aristasAOrdenar) {
		ArrayList<Arista> aristasOrdenadas = new ArrayList<>(aristasAOrdenar);
		Collections.sort(aristasOrdenadas, (a1, a2) -> Integer.compare(a1.getPeso(), a2.getPeso()));
		return aristasOrdenadas;
	}
}
