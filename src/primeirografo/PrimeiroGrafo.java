package primeirografo;

public class PrimeiroGrafo {

    public static void main(String[] args) {
//        GrafoMatriz grafo = new GrafoMatriz(4);
//        grafo.insereAresta(0, 3);
//        grafo.insereAresta(1, 2);
//        grafo.insereAresta(2, 0);
//        grafo.insereAresta(3, 2);
//        grafo.imprimeGrafo();
        
        GrafoLista grafo = new GrafoLista();
        Vertice v0 = new Vertice("0");
        Vertice v1 = new Vertice("1");
        Vertice v2 = new Vertice("2");
        Vertice v3 = new Vertice("3");                
        
        grafo.insereVertice(v0);
        grafo.insereVertice(v1);
        grafo.insereVertice(v2);
        grafo.insereVertice(v3);      
        
        //grafo.insereAresta(v0, v3);
        //grafo.insereAresta(v1, v2);
        //grafo.insereAresta(v2, v0);
        //grafo.insereAresta(v3, v2);
        
        grafo.imprimeGrafo();
    }
    
}