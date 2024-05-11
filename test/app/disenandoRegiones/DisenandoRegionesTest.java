package app.disenandoRegiones;

import static org.junit.Assert.*;

import org.junit.Test;

import app.DisenandoRegiones;
import app.Grafo;


public class DisenandoRegionesTest {

//	@Test(expected=IllegalArgumentException.class)
//	public void generarRegionesCantNegativaTest() {
//		DisenandoRegiones disReg = new DisenandoRegiones();
////		Grafo grafo = crearGrafoEstrella6Vertices();
//		disReg.generarRegiones(-1);
//	}
//	
//	@Test(expected=IllegalArgumentException.class)
//	public void generarRegionesCantExcesivaTest() {
//		DisenandoRegiones disReg = new DisenandoRegiones();
////		Grafo grafo = crearGrafoEstrella6Vertices();
//		disReg.generarRegiones(7);
//	}
//	
//	@Test(expected=IllegalArgumentException.class)
//	public void generarRegionesGrafoNullTest() {
//		DisenandoRegiones disReg = new DisenandoRegiones();
//		@SuppressWarnings("unused")
//		Grafo nuevo = disReg.generarRegiones(3, null);
//	}
//	
//	@Test
//	public void generarRegionesTest() {
//		DisenandoRegiones disReg = new DisenandoRegiones();
//		Grafo grafo = crearGrafoEstrella6Vertices();
//		Grafo nuevo = disReg.generarRegiones(3, grafo);
//		Grafo esperado = crearGrafoEstrella6VerticesDisconexo3Regiones();
//		
//		assertEquals(esperado.obtenerAristas().size(), nuevo.obtenerAristas().size());
//	}
//	
//	@Test
//	public void generarRegionesMismaCantTest() {
//		DisenandoRegiones disReg = new DisenandoRegiones();
//		Grafo grafo = crearGrafoEstrella6Vertices();
//		Grafo nuevo = disReg.generarRegiones(6, grafo);
//		
//		Grafo esperado = crearGrafo6VerticesDisconexo();
//		assertEquals(esperado.obtenerAristas(), nuevo.obtenerAristas());
//	}
//	
//	@Test(expected=IllegalArgumentException.class)
//	public void generarRegionesGrafoSinAristasTest() {
//		DisenandoRegiones disReg = new DisenandoRegiones();
//		Grafo grafo = crearGrafo6VerticesDisconexo();
//		@SuppressWarnings("unused")
//		Grafo nuevo = disReg.generarRegiones(6, grafo);
//	}
//	
//	
//	private Grafo crearGrafoEstrella6Vertices() {
//		Grafo grafo = new Grafo(6);
//		
//		grafo.agregarArista(0, 1, 10);
//		grafo.agregarArista(0, 2, 5);
//		grafo.agregarArista(0, 3, 8);
//		grafo.agregarArista(0, 4, 3);
//		grafo.agregarArista(0, 5, 1);
//		
//		return grafo;
//	}
//	
//	private Grafo crearGrafoEstrella6VerticesDisconexo3Regiones() {
//		Grafo grafo = new Grafo(6);
//		
//		grafo.agregarArista(0, 2, 5);
//		grafo.agregarArista(0, 4, 3);
//		grafo.agregarArista(0, 5, 1);
//		
//		return grafo;
//	}
//	
//	private Grafo crearGrafo6VerticesDisconexo() {
//		Grafo grafo = new Grafo(6);
//		return grafo;
//	}

}
