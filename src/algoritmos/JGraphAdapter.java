package algoritmos;

import estruturaGrafo.Aresta;
import estruturaGrafo.Vertice;
import estruturaGrafo.GrafoLista;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;

import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 *
 * @author tomita
 */
public class JGraphAdapter extends JApplet {

    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
    private boolean geraCoresAleatorias;   

    private JGraphModelAdapter m_jgAdapter;
    private Random gerador = new Random();

    public void init(GrafoLista grafo) {
        ListenableGraph g = new ListenableDirectedGraph(DefaultEdge.class);
        Color[] cores = new Color[grafo.getListaVertice().size()];
        for (int i = 0; i < cores.length; i++) {
            int r = gerador.nextInt(256);
            int gr = gerador.nextInt(256);
            int b = gerador.nextInt(256);
            cores[i] = new Color(r, gr, b);
        }

        m_jgAdapter = new JGraphModelAdapter(g);

        JGraph jgraph = new JGraph(m_jgAdapter);

        adjustDisplaySettings(jgraph);
        getContentPane().add(jgraph);
        resize(DEFAULT_SIZE);

        for (Vertice vertice : grafo.getListaVertice()) {
            g.addVertex(vertice.getRotulo());
        }

        for (Vertice vertice : grafo.getListaVertice()) {
            for (Aresta aresta : vertice.getListaAresta()) {
                g.addEdge(vertice.getRotulo(), aresta.getDestino());
            }
        }

        for (Vertice vertice : grafo.getListaVertice()) {
            positionVertexAt(vertice.getRotulo(), gerador.nextInt(380), gerador.nextInt(230), jgraph, grafo, cores);
        }
    }

    private void adjustDisplaySettings(JGraph jg) {
        jg.setPreferredSize(DEFAULT_SIZE);

        Color c = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter("bgcolor");
        } catch (Exception e) {
        }

        if (colorStr != null) {
            c = Color.decode(colorStr);
        }

        jg.setBackground(c);
    }

    private void positionVertexAt(Object vertex, int x, int y, JGraph jgraph, GrafoLista grafo, Color[] cores) {
        DefaultGraphCell cell = m_jgAdapter.getVertexCell(vertex);
        Map attr = cell.getAttributes();
        for (Vertice vertice : grafo.getListaVertice()) {
            if (vertice.getRotulo().equals(vertex)) {
                //GraphConstants.setBackground(attr, cores[grafo.getListaVertice().indexOf(vertice)]);
                if (geraCoresAleatorias) {
                    GraphConstants.setBackground(attr, cores[grafo.getVertice(vertice.getRotulo()).getIndiceCor()]);
                } else {
                    GraphConstants.setBackground(attr, grafo.getVertice(vertice.getRotulo()).getCor());
                }
            }
        }

        Rectangle2D b = GraphConstants.getBounds(attr);

        GraphConstants.setBounds(attr, new Rectangle(x, y, (int) b.getWidth(), (int) b.getHeight()));

        Map cellAttr = new HashMap();
        cellAttr.put(cell, attr);
        m_jgAdapter.edit(cellAttr, null, null, null);
        jgraph.getModel().endUpdate();
    }

    public void setGeraCoresAleatorias(boolean geraCoresAleatorias) {
        this.geraCoresAleatorias = geraCoresAleatorias;
    }
}
