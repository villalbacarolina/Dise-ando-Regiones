package app;

public class DisenandoRegiones {
	
	public Grafo crearArgentina() {
		Grafo grafoArgentina = new Grafo(25);
		//para visualizar el grafico de aristas, ver /utils/aristas argentina.jpg
		grafoArgentina.agregarArista(1, 2, 0);
		grafoArgentina.agregarArista(2, 3, 0);
		grafoArgentina.agregarArista(2, 4, 0);
		grafoArgentina.agregarArista(2, 5, 0);
		grafoArgentina.agregarArista(2, 20, 0);
		grafoArgentina.agregarArista(3, 4, 0);
		grafoArgentina.agregarArista(3, 5, 0);
		grafoArgentina.agregarArista(3, 12, 0);
		grafoArgentina.agregarArista(4, 5, 0);
		grafoArgentina.agregarArista(5, 21, 0);
		grafoArgentina.agregarArista(5, 7, 0);
		grafoArgentina.agregarArista(5, 6, 0);
		grafoArgentina.agregarArista(6, 12, 0);
		grafoArgentina.agregarArista(6, 11, 0);
		grafoArgentina.agregarArista(6, 7, 0);
		grafoArgentina.agregarArista(6, 8, 0);
		grafoArgentina.agregarArista(7, 21, 0);
		grafoArgentina.agregarArista(7, 22, 0);
		grafoArgentina.agregarArista(7, 24, 0);
		grafoArgentina.agregarArista(7, 8, 0);
		grafoArgentina.agregarArista(8, 24, 0);
		grafoArgentina.agregarArista(8, 9, 0);
		grafoArgentina.agregarArista(8, 10, 0);
		grafoArgentina.agregarArista(8, 16, 0);
		grafoArgentina.agregarArista(10, 11, 0);
		grafoArgentina.agregarArista(10, 14, 0);
		grafoArgentina.agregarArista(10, 15, 0);
		grafoArgentina.agregarArista(10, 16, 0);
		grafoArgentina.agregarArista(11, 12, 0);
		grafoArgentina.agregarArista(11, 13, 0);
		grafoArgentina.agregarArista(11, 14, 0);
		grafoArgentina.agregarArista(12, 13, 0);
		grafoArgentina.agregarArista(13, 14, 0);
		grafoArgentina.agregarArista(14, 15, 0);
		grafoArgentina.agregarArista(15, 16, 0);
		grafoArgentina.agregarArista(16, 17, 0);
		grafoArgentina.agregarArista(17, 18, 0);
		grafoArgentina.agregarArista(18, 19, 0);
		grafoArgentina.agregarArista(20, 21, 0);
		grafoArgentina.agregarArista(21, 22, 0);
		grafoArgentina.agregarArista(22, 23, 0);
		grafoArgentina.agregarArista(22, 24, 0);
		return grafoArgentina;
	}

}
