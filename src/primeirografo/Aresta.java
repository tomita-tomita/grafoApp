package primeirografo;

public class Aresta {    
        Vertice destino;        
        
        Aresta(Vertice destino){            
            this.destino = destino;            
        }  
        
    public Vertice getVertice(){
        return this.destino;
    }
}
