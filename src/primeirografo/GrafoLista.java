package primeirografo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GrafoLista {

    ArrayList<Vertice> listaVertice = new ArrayList<>();   
    ArrayList<String> vesticesVisitados = new ArrayList<>();
    /*BSF*/    
    private Stack<Vertice> filaVertices;    
   
    /*DSF*/    
    private Stack<Vertice> pilhaVertices;  
    
    private final boolean direcional;
    private final boolean arestasTemPeso;

    public GrafoLista(boolean direcional, boolean arestasTemPeso) {
        this.pilhaVertices = new Stack<>();
        this.filaVertices = new Stack<>();
        this.direcional = direcional;
        this.arestasTemPeso = arestasTemPeso;
    }

    public boolean insereVertice(Vertice novoVertice) {
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo.equals(novoVertice.rotulo)) {
                return false;
            }
        }

        this.listaVertice.add(novoVertice);
        return true;
    }

    public boolean inserirAresta(String rotulo_origem, String rotulo_destino, int pesoAresta) {
        boolean possivel = false;
        if ((verificaVertice(rotulo_origem)) && (verificaVertice(rotulo_destino)) && (!rotulo_origem.equals(rotulo_destino))) {
            for (Vertice vertice : listaVertice) {
                if (vertice.getRotulo().equals(rotulo_origem)) {
                    if (arestasTemPeso) {
                        possivel = vertice.insereAresta(new Aresta(rotulo_destino, pesoAresta));
                    } else {
                        possivel = vertice.insereAresta(new Aresta(rotulo_destino));
                    }
                }
                if (!direcional) {
                    if (vertice.getRotulo().equals(rotulo_destino)) {
                        if (arestasTemPeso) {
                            possivel = vertice.insereAresta(new Aresta(rotulo_origem, pesoAresta));
                        } else {
                            possivel = vertice.insereAresta(new Aresta(rotulo_origem));
                        }
                    }
                }
            }
        }

        return possivel;
    }

    public boolean verificaVertice(String vertice_verificar) {
        boolean existe = false;
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo.equals(vertice_verificar)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean verificaAresta(String origem, String destino) {
        boolean exite = false;
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo.equals(origem)) {
                for (int i = 0; i < vertice.listaAresta.size(); i++) {
                    if (vertice.listaAresta.get(i).destino.equals(destino)) {
                        exite = true;
                    }
                }
            }
        }
        return exite;
    }

    public String removeVertice(String vertice_remove) {
        if (verificaVertice(vertice_remove)) {
            for (int i = 0; i < this.listaVertice.size(); i++) {
                if (this.listaVertice.get(i).rotulo.equals(vertice_remove)) {
                    this.listaVertice.remove(i);
                    for (Vertice vertice : listaVertice) {
                        for (int j = 0; j < vertice.listaAresta.size(); j++) {
                            if (vertice.listaAresta.get(j).getVertice().equals(vertice_remove)) {
                                vertice.listaAresta.remove(j);
                            }
                        }
                    }
                }
            }
            return "Vertice " + vertice_remove + " removido com sucesso";
        }
        return "Não foi encontrado nenhum vertice " + vertice_remove;
    }

    public String removeAresta(String origem, String destino) {
        if (verificaAresta(origem, destino)) {
            for (Vertice vertice : listaVertice) {
                if (vertice.rotulo.equals(origem)) {
                    for (int i = 0; i < vertice.listaAresta.size(); i++) {
                        if (vertice.listaAresta.get(i).destino.equals(destino)) {
                            vertice.listaAresta.remove(i);
                        }
                    }
                }
            }
            return "Aresta " + origem + "--->" + destino + " removida com sucesso!";
        }
        return "Aresta " + origem + "--->" + destino + " não encontrada";
    }

    public String imprimeGrafo() {
        String grafo = "";

        for (Vertice vertice : listaVertice) {
            grafo = grafo + vertice.rotulo + ": ";

            for (Aresta aresta : vertice.listaAresta) {
                if (arestasTemPeso) {
                    grafo = grafo + aresta.destino + "(" + aresta.getPeso() + ") ";
                } else {
                    grafo = grafo + aresta.destino + " ";
                }
            }
            grafo = grafo + "\n";
        }

        return grafo;
    }

    public int getQuantidadeArestas() {
        int qtdArestas = 0;

        for (Vertice vertice : listaVertice) {
            qtdArestas = qtdArestas + vertice.getListaAresta().size();
        }

        if (!direcional) {
            qtdArestas = qtdArestas / 2;
        }

        return qtdArestas;
    }

    public boolean possuiTresCiclos() {
        boolean possivel = false;
        for (int i = 0; i < listaVertice.size(); i++) {
            for (int j = 0; j < listaVertice.size(); j++) {
                if (verificaAresta(listaVertice.get(i).getRotulo(), listaVertice.get(j).getRotulo())) {
                    for (int k = 0; k < listaVertice.size(); k++) {
                        if (verificaAresta(listaVertice.get(j).getRotulo(), listaVertice.get(k).getRotulo())) {
                            if ((verificaAresta(listaVertice.get(k).rotulo, listaVertice.get(i).getRotulo())) && (i != j) && (i != k) && (j != k)) {
                                System.out.println(listaVertice.get(i).rotulo);
                                possivel = true;
                            }
                        }
                    }
                }
            }
        }
        return possivel;
    }

    public boolean verificaPlanar() {
        int qtd_vertice, qtd_arestas;

        if (listaVertice.size() <= 2) {
            return true;
        }

        qtd_vertice = listaVertice.size();
        qtd_arestas = getQuantidadeArestas();

        if (possuiTresCiclos()) {
            return (qtd_arestas <= (3 * qtd_vertice - 6));
        } else {
            return (qtd_arestas <= (2 * qtd_vertice - 4));
        }
    }

    public ArrayList<Aresta> retornarArestas(String rotulo_vertice) {
        for (Vertice vertice : listaVertice) {
            if (vertice.getRotulo().equals(rotulo_vertice)) {
                return vertice.getListaAresta();
            }
        }
        return null;
    }
    
    public Vertice getVertice(String rotulo){
        for (Vertice vertice : listaVertice) {
            if (vertice.getRotulo().equals(rotulo)) {
                return vertice;
            }
        }        
        return null;
    }
    
    public ArrayList<String> bfs(String vertice){
        Vertice verticeAtual = getVertice(vertice);
        verticeAtual.visitado = true;         
        this.filaVertices.add(verticeAtual);
        while (!this.filaVertices.isEmpty()) {            
            this.vesticesVisitados.add(this.filaVertices.firstElement().getRotulo());
            this.filaVertices.remove(0);
            for (Aresta aresta : verticeAtual.listaAresta) {                
                if(!getVertice(aresta.getVertice()).getVisitado()){
                    getVertice(aresta.getVertice()).visitado = true;
                    this.filaVertices.add(getVertice(aresta.getVertice()));   
                }  
            }     
        }        
        for (Vertice verticeAll : listaVertice) {
            if(!verticeAll.getVisitado()){
                bfs(verticeAll.getRotulo());
            }
        }             
        return this.vesticesVisitados;
    }        
    
    public void criarGrafoTeste(){
        Vertice a = new Vertice("A");
        Vertice b = new Vertice("B");
        Vertice c = new Vertice("C");
        Vertice d = new Vertice("D");
        Vertice e = new Vertice("E");
        Vertice f = new Vertice("F");
        Vertice g = new Vertice("G");
        insereVertice(a);
        insereVertice(b);
        insereVertice(c);
        insereVertice(d);
        insereVertice(e);
        insereVertice(f);
        insereVertice(g);
        inserirAresta("A", "B", 1);        
        inserirAresta("A", "C", 2);        
        inserirAresta("A", "D", 3);        
        inserirAresta("B", "D", 4);        
        inserirAresta("C", "E", 5);        
        inserirAresta("C", "F", 6);        
        inserirAresta("E", "F", 7);        
        inserirAresta("E", "F", 8);        
    }
    
    public void resetVisitados (){
        for (Vertice vertice : listaVertice) {
            vertice.visitado = false;         
        }
        this.vesticesVisitados.clear();
    }
    
    public ArrayList<String> dfs(String rotulo_origem){
        Vertice verticeAtual = getVertice(rotulo_origem);        
        verticeAtual.visitado = true;       
        this.vesticesVisitados.add(verticeAtual.getRotulo());
        this.pilhaVertices.add(verticeAtual);
        for (Aresta aresta : verticeAtual.listaAresta) {            
            if(!getVertice(aresta.getVertice()).getVisitado()){
                dfs(aresta.getVertice());
            }
        }
        this.pilhaVertices.remove(verticeAtual);        
        if(!this.pilhaVertices.isEmpty()){
            for (Vertice vertice : listaVertice) {
                if(!vertice.getVisitado()){
                    dfs(vertice.getRotulo());
                }
            }            
        }else{           
           return this.vesticesVisitados;           
        }        
        return null;
    }
    
    public String dijkstra(String rotulo_origem, String rotulo_destino){
        //O rótulo destino pode ser vazio, verificar as diferenças do que 
        //deve ser retornado.
        return "";
    }
}
