package primeirografo;

import java.util.ArrayList;

public class Vertice {

    ArrayList<Aresta> listaAresta = new ArrayList<>();
    String rotulo;

    Vertice(String rotulo) {
        this.rotulo = rotulo;
    }   
    
    public boolean insereAresta(Aresta nova_aresta){
        
        for (Aresta aresta : listaAresta) {
            if (aresta.getVertice().equals(nova_aresta.getVertice())){
                return false;
            }
        }
        
        this.listaAresta.add(nova_aresta);        
        return true;
    } 

    public ArrayList<Aresta> getListaAresta() {
        return listaAresta;
    }

    public String getRotulo() {
        return rotulo;
    }        
}
