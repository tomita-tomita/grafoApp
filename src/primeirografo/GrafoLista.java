package primeirografo;

import java.util.ArrayList;

public class GrafoLista {

    ArrayList<Vertice> listaVertice = new ArrayList<>();

    public boolean insereVertice(Vertice novoVertice) {
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo.equals(novoVertice.rotulo)){
                return false;
            }
        }
        
        this.listaVertice.add(novoVertice);
        return true;
    }
    
    public void inserirAresta(String rotulo_origem, String rotulo_destino){
        //Não deve deixar gravar duas vezes o mesmo vértice (criar validação)
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo.equals(rotulo_origem)){
                vertice.insereAresta(new Aresta(rotulo_destino));
            }
            if (vertice.rotulo.equals(rotulo_destino)){
                vertice.insereAresta(new Aresta(rotulo_origem));
            }            
        }        
    }
    
    public boolean verificaVertice(String vertice_verificar){
        boolean existe = false;
        for (Vertice vertice : listaVertice) {            
            if(vertice.rotulo.equals(vertice_verificar)){                
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean verificaAresta(String origem, String destino){
        boolean exite = false;
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo.equals(origem)) {
                for (int i = 0; i < vertice.listaAresta.size(); i++) {                    
                    if(vertice.listaAresta.get(i).destino.equals(destino)){
                        exite = true;
                    }
                }
            }
        }          
        return exite;
    }

    public String removeVertice(String vertice_remove) {
        if(verificaVertice(vertice_remove)){
            for (int i = 0; i < this.listaVertice.size(); i++) {
                if(this.listaVertice.get(i).rotulo.equals(vertice_remove)){
                    this.listaVertice.remove(i);
                    for (Vertice vertice : listaVertice) {            
                        for (int j = 0; j < vertice.listaAresta.size(); j++) {
                            if(vertice.listaAresta.get(j).getVertice().equals(vertice_remove)){
                                vertice.listaAresta.remove(j);
                            }
                        }
                    }                                     
                }
            }         
            return "Vertice "+vertice_remove+" removido com sucesso";                
        }
        return "Não foi encontrado nenhum vertice "+vertice_remove;                                                   
    }

    public String removeAresta(String origem, String destino) {
        if(verificaAresta(origem, destino)){
            for (Vertice vertice : listaVertice) {
                if (vertice.rotulo.equals(origem)) {
                    for (int i = 0; i < vertice.listaAresta.size(); i++) {
                        if(vertice.listaAresta.get(i).destino.equals(destino)){
                            vertice.listaAresta.remove(i);
                        }
                    }
                }
            }
            return "Aresta "+origem+"--->"+destino+" removida com sucesso!";
        }
        return "Aresta "+origem+"--->"+destino+" não encontrada";
    }

    public void imprimeGrafo() {
        for (Vertice vertice : listaVertice) {
            System.out.print(vertice.rotulo + ": ");

            for (Aresta aresta : vertice.listaAresta) {
                System.out.print(aresta.destino + " ");
            }
            System.out.println();
        }
    }
    
//    public boolean verificaPlanar(){
//        boolean possivel = false;
//        for (int i = 0; i < listaVertice.size(); i++) {            
//            for (int j = i+1; j < listaVertice.size(); j++) {
//                for (int k = 0; k < listaVertice.get(j).listaAresta.size(); k++) {
//                    if (listaVertice.get(j).listaAresta.get(k).destino == listaVertice.get(i).rotulo) {
//                        System.out.println(listaVertice.get(i).rotulo);
//                        possivel = true;
//                    }
//                }
//            }
//        }
//        return possivel;
//    }

}
