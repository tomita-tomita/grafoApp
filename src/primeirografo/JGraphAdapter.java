package primeirografo;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;

import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import sun.font.GraphicComponent;

public class JGraphAdapter extends JFrame{    
    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension( 530, 320 );
    private final GrafoLista grafo;
    private JGraphModelAdapter m_jgAdapter;        
    private mxGraph graph;
    private mxGraphComponent graphComponent;

    public JGraphAdapter(GrafoLista grafo) throws HeadlessException {
        this.grafo = grafo;        
    }        
        
    public void init(){
        setSize(800,600);
        graph = new mxGraph();
        graphComponent = new mxGraphComponent(graph);
        graphComponent.setPreferredSize(new Dimension(400, 400));
        getContentPane().add(graphComponent);
        graph.getModel().beginUpdate();
        graph.insertVertex(null, null, "A", 30, 80, 100, 50);
        graph.getModel().endUpdate();
        
       ListenableGraph g = new ListenableDirectedGraph( DefaultWeightedEdge.class );
       m_jgAdapter = new JGraphModelAdapter( g );
       JGraph jgraph = new JGraph( m_jgAdapter );
       int pos_x =60, pos_y=40;                
       adjustDisplaySettings(jgraph);
       getContentPane().add( jgraph );
       resize( DEFAULT_SIZE );
       
       //Insere vértices no aplicativo
        for (Vertice vertice : this.grafo.listaVertice) {
            g.addVertex(vertice.getRotulo());                                               
            positionVertexAt(vertice.getRotulo(), pos_x, pos_y);
            
            pos_x = pos_x + 70;
            pos_y = pos_y + 30;
        } 
        
        //Insere as arestas no aplicativo
        for (Vertice vertice : this.grafo.listaVertice) {                        
            
            for (Aresta aresta : vertice.getListaAresta()) {
                g.addEdge(vertice.getRotulo(), aresta.destino);
            }               
        }                
    }
    
     private void adjustDisplaySettings( JGraph jg ) {
        jg.setPreferredSize( DEFAULT_SIZE );

        Color  c        = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter( "bgcolor" );
        }
         catch( Exception e ) {}

        if( colorStr != null ) {
            c = Color.decode( colorStr );
        }

        jg.setBackground( c );
    }


    private void positionVertexAt( Object vertex, int x, int y ) {
        DefaultGraphCell cell = m_jgAdapter.getVertexCell( vertex );
        Map              attr = cell.getAttributes(  );
        Rectangle2D        b    = GraphConstants.getBounds( attr );        
        GraphConstants.setBounds( attr, new Rectangle( x, y, (int)b.getWidth(), (int)b.getHeight()) );

        Map cellAttr = new HashMap(  );
        cellAttr.put( cell, attr );
        
        //m_jgAdapter.edit( cellAttr, null, null, null, null );
        m_jgAdapter.edit(cellAttr, null, null, null); //Alterou?
    }
}
