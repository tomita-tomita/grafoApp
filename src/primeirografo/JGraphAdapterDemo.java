package primeirografo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import java.util.HashMap;
import java.util.Map;

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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomita
 */
public class JGraphAdapterDemo extends JApplet {
    private static final Color     DEFAULT_BG_COLOR = Color.decode( "#FAFBFF" );
    private static final Dimension DEFAULT_SIZE = new Dimension( 530, 320 );

    // 
    private JGraphModelAdapter m_jgAdapter;

    /**
     * @see java.applet.Applet#init().
     */
    public void init(  ) {
        // create a JGraphT graph
        ListenableGraph g = new ListenableDirectedGraph( DefaultEdge.class );

        // create a visualization using JGraph, via an adapter
        m_jgAdapter = new JGraphModelAdapter( g );
        
        JGraph jgraph = new JGraph( m_jgAdapter );        

        adjustDisplaySettings( jgraph );
        getContentPane().add( jgraph );
        resize( DEFAULT_SIZE );

        // add some sample data (graph manipulated via JGraphT)
        g.addVertex( "A" );
        g.addVertex( "B" );
        g.addVertex( "C" );
        g.addVertex( "D" );
        
        g.addEdge( "A", "B" );
        g.addEdge( "B", "C" );
        g.addEdge( "C", "A" );
        g.addEdge( "D", "C" );
        g.addEdge( "D", "A" );

        // position vertices nicely within JGraph component
        positionVertexAt( "A", 130, 40, jgraph );
        positionVertexAt( "B", 60, 200, jgraph );
        positionVertexAt( "C", 310, 230, jgraph );
        positionVertexAt( "D", 380, 70, jgraph );

        // that's all there is to it!...
    }


    private void adjustDisplaySettings( JGraph jg ) {
        jg.setPreferredSize( DEFAULT_SIZE );

        Color c = DEFAULT_BG_COLOR;
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


    private void positionVertexAt( Object vertex, int x, int y, JGraph jgraph ) {        
        DefaultGraphCell cell = m_jgAdapter.getVertexCell( vertex );             
        Map attr = cell.getAttributes();        
        GraphConstants.setGradientColor(attr, Color.red);
        Rectangle2D b = GraphConstants.getBounds( attr );
        
        GraphConstants.setBounds( attr, new Rectangle( x, y, (int)b.getWidth(), (int)b.getHeight()));
        
        Map cellAttr = new HashMap();
        cellAttr.put( cell, attr );        
        m_jgAdapter.edit(cellAttr, null, null, null);           
        jgraph.getModel().endUpdate();
    }
}
