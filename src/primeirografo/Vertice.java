package primeirografo;

import java.util.ArrayList;

public class Vertice implements Comparable<Vertice>{

    ArrayList<Aresta> listaAresta = new ArrayList<>();
    String rotulo;
    String rotulo_pai;
    Boolean visitado;
    int distancia;

    Vertice(String rotulo) {
        this.visitado = false;
        this.rotulo = rotulo;
    }   
    
    public boolean insereAresta(Aresta nova_aresta){
        
        for (Aresta aresta : listaAresta) {
            if (aresta.getVertice().equals(nova_aresta.getVertice())){
                return false;
            }
        }
        
        this.listaAresta.add(nova_aresta);        
        return true;
    } 

    public ArrayList<Aresta> getListaAresta() {
        return listaAresta;
    }

    public String getRotulo() {
        return rotulo;
    }        
    
    public Boolean getVisitado(){
        return this.visitado;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }        

    public String getRotulo_pai() {
        return rotulo_pai;
    }

    public void setRotulo_pai(String rotulo_pai) {
        this.rotulo_pai = rotulo_pai;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }

    @Override
    public int compareTo(Vertice t) {
        if(this.getDistancia() < t.getDistancia()) return -1;
          else if(this.getDistancia() == t.getDistancia()) return 0;
          
          return 1;
    }
        
}
