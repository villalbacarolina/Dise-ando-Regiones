package app.bfs;

import org.junit.Before;
import org.junit.Test;

import app.BFS;
import app.Grafo;

public class BFSTest {
	
	private BFS bfs;
//    private Grafo grafo;

    @Before
    public void inicializar(){
    	bfs = new BFS();
//        grafo = new Grafo();
//        grafo.agregarArista(0,1,30);
//        grafo.agregarArista(0,2,40);
//        grafo.agregarArista(2,3,40);
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestGrafoEstaVacio(){
        Grafo grafoVacio = new Grafo(2);
        bfs.validarQueNoEsteVacio(grafoVacio);
    }

    @Test (expected = IllegalArgumentException.class)
    public void  TestGrafoEsNulo(){
    	Grafo grafoNulo = null;
    	bfs.validarQueNoSeaNulo(grafoNulo);
    }


}