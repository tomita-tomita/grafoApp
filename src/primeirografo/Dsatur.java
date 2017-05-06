package primeirografo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dsatur {

    private final GrafoLista grafo;

    public Dsatur(GrafoLista grafo) {
        this.grafo = grafo;
    }

    public void ColorirVertices() {
        Collections.sort(grafo.getListaVertice(), new Dsatur.VertexComparator());
        Map<String, String> vertex_color_index = new HashMap<>();
        int cor = 0;
        int grau = 0;

        grafo.resetCores();

        for (int i = 0; i < grafo.getListaVertice().size(); i++) {
            if (i == 0) {
                grafo.getListaVertice().get(i).setCor(cor);
                grau = grafo.getListaVertice().get(i).getListaAresta().size();                
            } else if (!(vertex_color_index.containsKey(grafo.getListaVertice().get(i).getRotulo()))) {                
                if (grafo.getListaVertice().get(i).getListaAresta().size() == grau) {
                    
                    grafo.getListaVertice().get(i).setCor(cor);
                    vertex_color_index.put(grafo.getListaVertice().get(i).getRotulo(), "Colour " + cor);
                    
                } else {
                    cor++;
                    grau = grafo.getListaVertice().get(i).getListaAresta().size();
                    grafo.getListaVertice().get(i).setCor(cor);
                    vertex_color_index.put(grafo.getListaVertice().get(i).getRotulo(), "Colour " + cor);
                }
            }
        }
        System.out.println(vertex_color_index);

    }

    class VertexComparator implements Comparator<Vertice> {

        @Override
        public int compare(Vertice a, Vertice b) {
            return a.getListaAresta().size() < b.getListaAresta().size() ? 1 : a.getListaAresta().size() == b.getListaAresta().size() ? 0 : -1;
        }

    }
}
