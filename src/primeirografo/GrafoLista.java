package primeirografo;

import java.util.ArrayList;

public class GrafoLista {

    ArrayList<Vertice> listaVertice = new ArrayList<>();

    public void insereVertice(Vertice vertice) {
        this.listaVertice.add(vertice);
    }
    
    public void inserirAresta(Vertice origem, Vertice destino){
        origem.insereAresta(new Aresta(destino));
        destino.insereAresta(new Aresta(origem));
    }

    public String removeVertice(Vertice vertice) {
        return "";
    }

    public String removeAresta(Vertice origem, Vertice destino) {
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo == origem.rotulo) {
                for (Aresta aresta : vertice.listaAresta) {
                    if (destino.rotulo == aresta.destino.rotulo) {
                        //Excluir

                    }
                }
            }
        }                
        return "";
    }

    public void imprimeGrafo() {
        for (Vertice vertice : listaVertice) {
            System.out.print(vertice.rotulo + " ");

            for (Aresta aresta : vertice.listaAresta) {
                System.out.print(aresta.destino.rotulo);
            }
            System.out.println();
        }
    }

}
