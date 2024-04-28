package app;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 100);
		g.agregarArista(1, 2, 200);
		
		System.out.println(g.obtenerVecinos(0));
		System.out.println(g.obtenerVecinos(1));
		System.out.println(g.obtenerVecinos(2));
		
		System.out.println("------------");	
		g.eliminarArista(1, 2);
		g.mostrarAristas();
		
		System.out.println("------------");
		System.out.println(g.obtenerVecinos(0));
		System.out.println(g.obtenerVecinos(1));
		System.out.println(g.obtenerVecinos(2));
	}

}
