package app.unionfind;

import static org.junit.Assert.*;

import org.junit.Test;

import app.UnionFind;

public class UnionFindTest {
	
	@Test (expected=IllegalArgumentException.class)
	public void constructorConSizeNegativoTest(){
		@SuppressWarnings("unused")
		UnionFind uf = new UnionFind(-5);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void constructorConVerticesNullTest(){
		@SuppressWarnings("unused")
		UnionFind uf = new UnionFind(null);
	}
	
	@Test
	public void raizTest() {
		int[] vertices = {0, 2, 3, 3, 4, 3, 6, 7, 7, 7};
		UnionFind uf = new UnionFind(vertices);
		assertEquals(3, uf.raiz(1));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void raizVerticeNegativoTest() {
		UnionFind uf = new UnionFind(5);
		uf.raiz(-1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void raizVerticeExcedidoTest() {
		UnionFind uf = new UnionFind(5);
		uf.raiz(5);
	}
	
	@Test
	public void unionTest() {
		UnionFind uf = new UnionFind(10);
		uf.union(1, 0);
		
		int[] prueba = {0, 0, 2, 3, 4, 5, 6, 7, 8, 9};
		assertArrayEquals(prueba, uf.getParents());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void unionPrimerVerticeNegativoTest() {
		UnionFind uf = new UnionFind(10);
		uf.union(-1, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void unionSegundoVerticeNegativoTest() {
		UnionFind uf = new UnionFind(10);
		uf.union(1, -1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void unionPrimerVerticeExcedidoTest() {
		UnionFind uf = new UnionFind(10);
		uf.union(10, 0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void unionSegundoVerticeExcedidoTest() {
		UnionFind uf = new UnionFind(10);
		uf.union(1, 10);
	}
	
	@Test
	public void connectedTest() {
		int[] vertices = {0, 2, 3, 3, 4, 3, 6, 7, 7, 7};
		UnionFind uf = new UnionFind(vertices);
		assertTrue(uf.find(2, 5));
	}
	
	@Test
	public void notConnectedTest() {
		int[] vertices = {0, 2, 3, 3, 4, 3, 6, 7, 7, 7};
		UnionFind uf = new UnionFind(vertices);
		assertFalse(uf.find(8, 5));
	}
}