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
        Vertice v0 = new Vertice("A");
        Vertice v1 = new Vertice("B");
        Vertice v2 = new Vertice("C");
        Vertice v3 = new Vertice("D");                
        
        grafo.insereVertice(v0);
        grafo.insereVertice(v1);
        grafo.insereVertice(v2);
        grafo.insereVertice(v3);      
        
        grafo.inserirAresta(v0, v3);
        grafo.inserirAresta(v1, v2);
        grafo.inserirAresta(v2, v0);
        grafo.inserirAresta(v3, v2);
        
        System.out.println(grafo.removeVertice(v1));

        System.out.println(grafo.removeAresta(v2, v0));   
        
        if(grafo.verificaAresta(v2, v1)){
            System.out.println("Grafo já possui aresta "+v2.rotulo+"--->"+v1.rotulo);
        }else{
            System.out.println("Grafo não possui aresta "+v2.rotulo+"--->"+v1.rotulo);
        }

        
        
        grafo.imprimeGrafo();
    }
    
}