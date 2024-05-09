package app;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo g = new Grafo(6);

		g.agregarArista(0, 2, 10);
		g.agregarArista(0, 3, 5);
		g.agregarArista(2, 3, 2);
		g.agregarArista(3, 1, 7);
		g.agregarArista(3, 5, 1);
		g.agregarArista(1, 5, 5);
		g.agregarArista(2, 4, 5);
		g.agregarArista(4, 5, 3);
		
//		System.out.println(g.obtenerVecinos(0));
//		System.out.println(g.obtenerVecinos(1));
//		System.out.println(g.obtenerVecinos(2));
		
		System.out.println("------------");	
//		g.eliminarArista(1, 2);
		g.mostrarAristas();
		
//		System.out.println("------------");
//		System.out.println(g.obtenerVecinos(0));
//		System.out.println(g.obtenerVecinos(1));
//		System.out.println(g.obtenerVecinos(2));
		System.out.println("------------");
		Grafo agm = Kruskal.generar(g);
		
		agm.mostrarAristas();
		
		
	}

}
