package estruturaGrafo;

public class Aresta implements Cloneable{    
    private String origem;
    private String destino;    
    int peso;

    public Aresta(String origem, String destino, int peso){            
        //Foi necessário inserir o campo origem para aplicar o algoritmo Kruskal
        this.origem = origem;
        this.destino = destino;            
        this.peso = peso;
    }  

    public Aresta(String destino){
        this.destino = destino;
        this.peso = 0;
    }   
        
    public String getVertice(){
        return this.destino;
    }

    public int getPeso() {
        return peso;
    }        

    public String getDestino() {
        return destino;
    } 

    public String getOrigem() {
        return origem;
    }        
    
    @Override
    public Aresta clone() throws CloneNotSupportedException {
        return (Aresta) super.clone();
    }
}