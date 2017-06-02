package primeirografo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Prim {

    private ArrayList<Aresta> arestas_solucao = new ArrayList<>();
    private ArrayList<Vertice> vertices_controle = new ArrayList<>();
    private GrafoLista grafo_prim;

    public Prim(GrafoLista grafo) {        
        inicializarGrafoPrim(grafo.clonarListaVertice(), grafo.getGrafoDirecional(), grafo.getArestasTemPeso());
        this.vertices_controle = grafo.clonarListaVertice();
    }

    public void iniciar() {

        Aresta menor_aresta;
        //Vertice vertice = vertices_controle.get(0);
        vertices_controle.remove(0);

        //Enquanto não estiver vazio
        while (vertices_controle.size() > 0) {
            //Encontra a menor aresta e a insere na lista de arestas de solução
            menor_aresta = verificarMenorAresta();
            arestas_solucao.add(menor_aresta);

            //Remove o vértice do conjunto de controle.
            vertices_controle.remove(procurarVerticeControle(menor_aresta.getOrigem()));
        }

        insereArestas();
        exibeGrafo();
    }

    private void inicializarGrafoPrim(ArrayList<Vertice> vertices, boolean grafo_direcional, boolean arestas_tem_peso) {
        grafo_prim = new GrafoLista(grafo_direcional, arestas_tem_peso);

        for (Vertice vertice : vertices) {
            try {
                Vertice novo_vertice = vertice.clone();
                novo_vertice.removeArestas();
                grafo_prim.insereVertice(novo_vertice);                
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Prim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }

    private Aresta verificarMenorAresta() {
        Aresta menor_aresta = new Aresta("", "", 999999999);

        while (menor_aresta.getOrigem().equals("")) {
            for (Vertice vertice : vertices_controle) {
                for (Aresta aresta : vertice.getListaAresta()) {

                    //Caso a aresta seja menor e o vertice destino não esteja no controle
                    if ((aresta.getPeso() < menor_aresta.getPeso()) && (!verificaArestaControle(aresta.getDestino()))) {
                        menor_aresta = aresta;
                    }
                }
            }
        }
        return menor_aresta;
    }

    private boolean verificaArestaControle(String rotulo_vertice) {
        //Verifica se o vértice existe na lista de vertices de controle
        for (Vertice vertice : vertices_controle) {
            if (vertice.getRotulo().equals(rotulo_vertice)) {
                return true;
            }
        }
        return false;
    }

    private int procurarVerticeControle(String rotulo_vertice) {
        for (Vertice vertice : vertices_controle) {
            if (vertice.getRotulo().equals(rotulo_vertice)) {
                return vertices_controle.indexOf(vertice);
            }
        }
        return 0;
    }

    private void insereArestas() {
        for (Aresta aresta : arestas_solucao) {
            grafo_prim.getVertice(aresta.getOrigem()).insereAresta(aresta);
        }
    }

    private void exibeGrafo() {
        JGraphAdapter demo = new JGraphAdapter();
        demo.setGeraCoresAleatorias(true);
        demo.init(grafo_prim);
        JFrame frame = new JFrame();
        frame.getContentPane().add(demo);
        frame.setTitle("Visualizador de grafo - Prim");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.show();
    }

}
