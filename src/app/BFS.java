package app;

import java.util.ArrayList;

public class BFS {

    private static boolean[] marcados;
    private ArrayList<Integer> L;

    public BFS(){}


    public void validarQueNoSeaNulo(Grafo g){
        if(g==null)
            throw new IllegalArgumentException("El grafo no existe.");
    }
    public void validarQueNoEsteVacio(Grafo g){
        validarQueNoSeaNulo(g);
        if(g.obtenerAristas().size() == 0)
            throw new IllegalArgumentException("El grafo no tiene ningún componente conexa.");
    }

}