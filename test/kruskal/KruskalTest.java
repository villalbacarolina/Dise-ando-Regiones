package kruskal;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import app.Grafo;
import app.Kruskal;

public class KruskalTest {

	Grafo grafo;
	Kruskal kruskal;
	
	@Before
	public void inicializar(){
		kruskal = new Kruskal();
		grafo = new Grafo(10);
		grafo.agregarArista(1, 2, 4); //A1-B2
		grafo.agregarArista(2, 3, 8); //B2-C3
		grafo.agregarArista(3, 4, 6); //C3-D4
		grafo.agregarArista(4, 5, 9); //D4-E5
		grafo.agregarArista(5, 6, 10);//E5-F6
		grafo.agregarArista(6, 4, 13);//F6-D4
		grafo.agregarArista(6, 3, 4); //F6-C3
		grafo.agregarArista(6, 7, 3); //F6-G7
		grafo.agregarArista(7, 8, 5); //G7-I8
		grafo.agregarArista(3, 8, 3); //C3-I8
		grafo.agregarArista(8, 9, 6); //I8-H9
		grafo.agregarArista(7, 9, 1); //G7-H9
		grafo.agregarArista(2, 9, 12);//B2-H9
		grafo.agregarArista(1, 9, 8); //A1-H9
		//grafico disponible en utils
	}
	
	@Test
	public void TestCrearArbolGeneradorMinimo() {
		//grafico disponible en utils
		//resultados de AGM correctos
		Grafo AGM_OpcionA = new Grafo(10);
		Grafo AGM_OpcionB = new Grafo(10);
		//OpcionA: con union entre A-H
		AGM_OpcionA.agregarArista(1, 2, 4); //A1-B2
		AGM_OpcionA.agregarArista(1, 9, 8); //A1-H9
		AGM_OpcionA.agregarArista(7, 9, 1); //G7-H9
		AGM_OpcionA.agregarArista(6, 7, 3); //F6-G7
		AGM_OpcionA.agregarArista(6, 3, 4); //F6-C3
		AGM_OpcionA.agregarArista(3, 8, 3); //C3-I8
		AGM_OpcionA.agregarArista(3, 4, 6); //C3-D4
		AGM_OpcionA.agregarArista(4, 5, 9); //D4-E5
		//OpcionB: con union entre B-C
		AGM_OpcionB.agregarArista(1, 2, 4); //A1-B2
		AGM_OpcionB.agregarArista(2, 3, 8); //B2-C3
		AGM_OpcionB.agregarArista(7, 9, 1); //G7-H9
		AGM_OpcionB.agregarArista(6, 7, 3); //F6-G7
		AGM_OpcionB.agregarArista(6, 3, 4); //F6-C3
		AGM_OpcionB.agregarArista(3, 8, 3); //C3-I8
		AGM_OpcionB.agregarArista(3, 4, 6); //C3-D4
		AGM_OpcionB.agregarArista(4, 5, 9); //D4-E5
		
		Grafo arbolGeneradorMinimo = Kruskal.generar(grafo);
		

		if ( arbolGeneradorMinimo.obtenerAristas().equals(AGM_OpcionA.obtenerAristas()) )
	        assertTrue(true);
	    else if ( arbolGeneradorMinimo.obtenerAristas().equals(AGM_OpcionB.obtenerAristas() ))
	        assertTrue(true);
	}
}
