package app;

public class UnionFind {
	
	private int[] parents;

	public UnionFind(int[] parents) {
		if (parents == null) {
			throw new IllegalArgumentException("parents es null");
		}
		this.parents = parents;
	}
	
	public UnionFind(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("size debe ser positivo");
		}
		this.parents = new int[size];
		
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	public int raiz(int i) {
		verificarVertice(i);
		
		if (parents[i] != i) {
			parents[i] = raiz(parents[i]);
			return parents[i];
		}
		
		return i;
	}
	
	public boolean find(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		
		return raiz(i) == raiz(j);
	}

	public void union(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		
		int ri = raiz(i);
		int rj = raiz(j);
		
		parents[ri] = rj;
	}
	
	public int[] getParents() {
		return parents;
	}
	
	private void verificarVertice(int i) {
		if (i < 0) {
			throw new IllegalArgumentException("Los vertices no pueden ser negativos: "+ i);
		}
		
		if (i >= parents.length) {
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
		}
	}
}