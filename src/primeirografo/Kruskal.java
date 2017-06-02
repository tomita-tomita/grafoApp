package primeirografo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Kruskal {

    private ArrayList<GrafoLista> floresta = new ArrayList<>();
    private GrafoLista grafo_kruskal;
    private ArrayList<Aresta> arestas_controle = new ArrayList<>();
    private ArrayList<Aresta> arestas_solucao = new ArrayList<>();

    public Kruskal(GrafoLista grafo) {
        arestas_controle = grafo.getArestasGrafo();
        inicializarFloresta(grafo);
    }

    public void iniciar() {
        Aresta menor_aresta;

        while (arestas_controle.size() > 0) {
            //Seleciona a menor aresta e a remove do conjunto Q
            menor_aresta = verificaMenorAresta();
            arestas_controle.remove(menor_aresta);

            //Verifica se U e F pertencem à arvores diferentes na floresta
            verificaGruposFloresta(menor_aresta);
        }
        grafo_kruskal = floresta.get(0);
        insereArestas();
        exibeGrafo();
    }

    private void inicializarFloresta(GrafoLista grafo) {
        for (Vertice vertice : grafo.getListaVertice()) {
            GrafoLista novo_grafo = new GrafoLista(true, true);
            try {
                novo_grafo.insereVertice(vertice.clone());
                novo_grafo.removeArestas();
                floresta.add(novo_grafo);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Kruskal.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }

    private Aresta verificaMenorAresta() {
        Aresta menor_aresta = new Aresta("", "", 999999999);

        for (Aresta aresta : arestas_controle) {
            if (aresta.getPeso() < menor_aresta.getPeso()) {
                menor_aresta = aresta;
            }
        }
        return menor_aresta;
    }

    private void verificaGruposFloresta(Aresta aresta) {
        int id_arvore_u = 0;
        int id_arvore_v = 0;

        for (GrafoLista grafo : floresta) {
            for (Vertice vertice : grafo.getListaVertice()) {
                if (vertice.getRotulo().equals(aresta.getOrigem())) {
                    id_arvore_u = floresta.indexOf(grafo);
                } else if (vertice.getRotulo().equals(aresta.getDestino())) {
                    id_arvore_v = floresta.indexOf(grafo);
                }
            }
        }

        if (id_arvore_u != id_arvore_v) {
            arestas_solucao.add(aresta);
            uneGruposFloresta(id_arvore_u, id_arvore_v);
        }
    }

    private void uneGruposFloresta(int id_arvore_u, int id_arvore_v) {
        ArrayList<Vertice> vertices = new ArrayList<>();
        
        vertices = floresta.get(id_arvore_u).getListaVertice();
        floresta.get(id_arvore_v).insereListaVertices(vertices);
        floresta.remove(id_arvore_u);
    }

    private void insereArestas() {
        for (Aresta aresta : arestas_solucao) {
            grafo_kruskal.getVertice(aresta.getOrigem()).insereAresta(aresta);
        }
    }

    private void exibeGrafo() {
        JGraphAdapter demo = new JGraphAdapter();
        demo.setGeraCoresAleatorias(true);
        demo.init(grafo_kruskal);
        JFrame frame = new JFrame();
        frame.getContentPane().add(demo);
        frame.setTitle("Visualizador de grafo - Kruskal");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.show();
    }

}
