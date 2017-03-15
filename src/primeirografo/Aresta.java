package primeirografo;

public class Aresta {    
        String destino;        
        
        Aresta(String destino){            
            this.destino = destino;            
        }  
        
    public String getVertice(){
        return this.destino;
    }
}
