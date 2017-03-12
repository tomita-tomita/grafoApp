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
    
    public boolean verificaVertice(Vertice vertice_verificar){
        boolean existe = false;
        for (Vertice vertice : listaVertice) {            
            if(vertice.rotulo == vertice_verificar.rotulo){                
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean verificaAresta(Vertice origem, Vertice destino){
        boolean exite = false;
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo == origem.rotulo) {
                for (int i = 0; i < vertice.listaAresta.size(); i++) {
                    if(vertice.listaAresta.get(i).destino.rotulo == destino.rotulo){
                        exite = true;
                    }
                }
            }
        }          
        return exite;
    }

    public String removeVertice(Vertice vertice_remove) {
        if(verificaVertice(vertice_remove)){
            for (int i = 0; i < this.listaVertice.size(); i++) {
                if(this.listaVertice.get(i).rotulo == vertice_remove.rotulo){
                    this.listaVertice.remove(i);
                    for (Vertice vertice : listaVertice) {            
                        for (int j = 0; j < vertice.listaAresta.size(); j++) {
                            if(vertice.listaAresta.get(j).getVertice().rotulo == vertice_remove.rotulo){
                                vertice.listaAresta.remove(j);
                            }
                        }
                    }                                     
                }
            }         
            return "Vertice "+vertice_remove.rotulo+" removido com sucesso";                
        }
        return "Não foi encontrado nenhum vertice "+vertice_remove.rotulo;                                                   
    }

    public String removeAresta(Vertice origem, Vertice destino) {
        if(verificaAresta(origem, destino)){
            for (Vertice vertice : listaVertice) {
                if (vertice.rotulo == origem.rotulo) {
                    for (int i = 0; i < vertice.listaAresta.size(); i++) {
                        if(vertice.listaAresta.get(i).destino.rotulo == destino.rotulo){
                            vertice.listaAresta.remove(i);
                        }
                    }
                }
            }
            return "Aresta "+origem.rotulo+"--->"+destino.rotulo+" removida com sucesso!";
        }
        return "Aresta "+origem.rotulo+"--->"+destino.rotulo+" não encontrada";
    }

    public void imprimeGrafo() {
        for (Vertice vertice : listaVertice) {
            System.out.print(vertice.rotulo + ": ");

            for (Aresta aresta : vertice.listaAresta) {
                System.out.print(aresta.destino.rotulo + " ");
            }
            System.out.println();
        }
    }

}
