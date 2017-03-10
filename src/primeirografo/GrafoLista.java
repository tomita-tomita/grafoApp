package primeirografo;

import java.util.ArrayList;
import java.util.List;

class Aresta{
        Vertice origem;
        Vertice destino;        
        
        Aresta(Vertice origem, Vertice destino){
            this.origem = origem;
            this.destino = destino;            
        }
    }    
        
     class Vertice{
        int id;            
        
        Vertice(int id){
            this.id = id;            
        }
    }

public class GrafoLista {        
    ArrayList<Aresta> listaAresta = new ArrayList<>();    
    ArrayList<Vertice> listaVertice = new ArrayList<>();    
        
     
     public void insereVertice(Vertice vertice){
         this.listaVertice.add(vertice);
     }
     
    public void insereAresta(Aresta aresta){
        this.listaAresta.add(aresta);
    }
    
    public void imprimeGrafo(){
        for (Vertice vertice : listaVertice) {
            System.out.print(vertice.id + " ");            
            
            for (Aresta aresta : listaAresta) {
                if (vertice.id == aresta.origem.id) {
                    System.out.print(aresta.destino.id);
                }
            }
            System.out.println();
        }
    }
    
}
