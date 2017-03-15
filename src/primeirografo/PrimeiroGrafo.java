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
        
        grafo.inserirAresta("A", "D");
        grafo.inserirAresta("B", "C");
        grafo.inserirAresta("C", "A");
        grafo.inserirAresta("D", "C");
        
        System.out.println(grafo.removeVertice("B"));

        System.out.println(grafo.removeAresta("C", "A"));   
        
        if(grafo.verificaAresta("C", "B")){
            System.out.println("Grafo já possui aresta "+v2.rotulo+"--->"+v1.rotulo);
        }else{
            System.out.println("Grafo não possui aresta "+v2.rotulo+"--->"+v1.rotulo);
        }

        
        //Validações necessárias:
        //Se a função insereVertice retornar false significa que o vertice já existe.        
        
        grafo.imprimeGrafo();
    }
    
}
