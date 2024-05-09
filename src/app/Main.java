package app;

import utils.Vertice;

public class Main {

	public static void main(String[] args) {
		
		DisenandoRegiones d = new DisenandoRegiones();
//		
		d.agregarPeso(Vertice.BUENOS_AIRES, Vertice.CABA, 250);
		d.agregarPeso(Vertice.JUJUY, Vertice.SALTA, 550);
		d.agregarPeso(Vertice.SALTA, Vertice.FORMOSA, 10);
		d.agregarPeso(Vertice.SALTA, Vertice.SANTIAGO_DEL_ESTERO, 1000);
		
		d.generarRegionesTEST();
//		
//		d.obtenerVecinos(Vertice.SALTA);
//		
//		
//		
		
//		// TODO Auto-generated method stub
//		Grafo g = new Grafo(6);
//
//		g.agregarArista(0, 2, 10);
//		g.agregarArista(0, 3, 5);
//		g.agregarArista(2, 3, 2);
//		g.agregarArista(3, 1, 7);
//		g.agregarArista(3, 5, 1);
//		g.agregarArista(1, 5, 5);
//		g.agregarArista(2, 4, 5);
//		g.agregarArista(4, 5, 3);
//		
////		System.out.println(g.obtenerVecinos(0));
////		System.out.println(g.obtenerVecinos(1));
////		System.out.println(g.obtenerVecinos(2));
//		
//		System.out.println("------------");	
////		g.eliminarArista(1, 2);
////		g.mostrarAristas();
//		
//		List<Arista> aristas2 = g.obtenerAristas();
//		
//		for(Arista arista : aristas2) {
//			System.out.println(arista.getOrigen() + "-" + arista.getDestino() + ":" + arista.getPeso());
//		}
//		
////		System.out.println("------------");
////		System.out.println(g.obtenerVecinos(0));
////		System.out.println(g.obtenerVecinos(1));
////		System.out.println(g.obtenerVecinos(2));
//		System.out.println("------------");
//		Grafo agm = Kruskal.generar(g);
//		
////		agm.mostrarAristas();
//		
//		List<Arista> aristas = agm.obtenerAristas();
//		
//		for(Arista arista : aristas) {
//			System.out.println(arista.getOrigen() + "-" + arista.getDestino() + ":" + arista.getPeso());
//		}
//		
	}

}
