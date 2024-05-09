package app;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		DisenandoRegiones d = new DisenandoRegiones();
		
		d.agregarPeso(1, 2, 250);
		d.agregarPeso(1, 3, 550);
		d.agregarPeso(2, 1, 750);
		
		d.obtenerVecinos(1);
		
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
