package primeirografo;

import java.util.ArrayList;

public class Vertice {

    ArrayList<Aresta> listaAresta = new ArrayList<>();
    String rotulo;

    Vertice(String rotulo) {
        this.rotulo = rotulo;
    }   
    
    public void insereAresta(Aresta aresta){
        this.listaAresta.add(aresta);
    }                
}
