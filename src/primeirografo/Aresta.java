package primeirografo;

public class Aresta {    
        String destino;   
        int peso;
        
        Aresta(String destino, int peso){            
            this.destino = destino;            
            this.peso = peso;
        }  
        
        Aresta(String destino){
            this.destino = destino;
            this.peso = 0;
        }
        
    public String getVertice(){
        return this.destino;
    }

    public int getPeso() {
        return peso;
    }        
}
