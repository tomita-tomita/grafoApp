package primeirografo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WelshPowellGraph {

    private final GrafoLista grafo;

    public WelshPowellGraph(GrafoLista grafo) {
        this.grafo = grafo;
    }

    class VertexComparator implements Comparator<Vertice> {

        @Override
        public int compare(Vertice a, Vertice b) {
            return a.getListaAresta().size() < b.getListaAresta().size() ? 1 : a.getListaAresta().size() == b.getListaAresta().size() ? 0 : -1;
        }

    }   
    
    //Implementação do algoritmo Welsh-Powell
    public void colourVertices() {
        Collections.sort(grafo.getListaVertice(), new VertexComparator());
        Map<String, String> vertex_color_index = new HashMap<>();
        for (int i = 0; i < grafo.getListaVertice().size(); i++) {
            if (!(vertex_color_index.containsKey(grafo.getListaVertice().get(i).getRotulo()))) {                            
                
                grafo.getListaVertice().get(i).setIndiceCor(i);
                vertex_color_index.put(grafo.getListaVertice().get(i).getRotulo(), "Colour " + i);
                
                for (int j = i + 1; j < grafo.getListaVertice().size(); j++) {
                    if (!(grafo.getListaVertice().get(i).verificaVizinho(grafo.getListaVertice().get(j).getRotulo())) && !(vertex_color_index.containsKey(grafo.getListaVertice().get(j).getRotulo()))) {
                        
                        grafo.getListaVertice().get(j).setIndiceCor(i);
                        vertex_color_index.put(grafo.getListaVertice().get(j).getRotulo(), "Colour " + i);
                        
                    } 
                }
            }
        }
        System.out.println(vertex_color_index);
    }

}