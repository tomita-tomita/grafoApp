package primeirografo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Dsatur {

    private final GrafoLista grafo;
    private ArrayList<Color> mapColor;
    private final Random generator;
    public static Color NOCOLOR = Color.red;

    public Dsatur(GrafoLista grafo) {
        this.generator = new Random();
        this.grafo = grafo;
    }

    public class DSATComparator implements Comparator<Vertice> {

        private GrafoLista g;

        public DSATComparator(GrafoLista g) {
            this.g = g;
        }

        @Override
        public int compare(Vertice o1, Vertice o2) {            
            int dsat1 = DSAT(o1);
            int dsat2 = DSAT(o2);
            return (-1) * (dsat1 - dsat2);

        }

        private int DSAT(Vertice o1) {            
            Collection<Vertice> vertices = null;
            try {
                vertices = g.getVizinhos(o1.getRotulo());
            } catch (Exception e) {                
                e.printStackTrace();
            }
            HashSet<Color> set = new HashSet<Color>();
            for (Vertice v : vertices) {
                if (!(v.getCor().equals(NOCOLOR))) {
                    set.add(v.getCor());
                }
            }
            int nb = set.size();
            if (set.isEmpty()) {
                return o1.getListaAresta().size();
            } else {
                return nb;
            }
        }

    }

    public void ColorirVertices() {
        try {
            grafo.resetCores();
            this.setNoColor();
            this.mapColor = this.genereTabColor(200);
            ArrayList<Vertice> all = new ArrayList<Vertice>(grafo.getListaVertice());
            Collections.sort(all, new DSATComparator(grafo));
            for (int i = 0; i < all.size(); i++) {
                //System.out.println(all.get(i).getListaAresta().size());
            }
            for (int i = 0; i < grafo.getListaVertice().size(); i++) {
                int j = -1;
                Vertice v;
                do {
                    j++;
                    v = all.get(j);
                } while (v.getCor() != NOCOLOR);
                Color colMin = this.findMinColor(v);
                v.setCor(colMin);
                Collections.sort(all, new DSATComparator(grafo));
            }
            //this.end();            
        } catch (Exception e) {            
            e.printStackTrace();
        }
    }

    private Color findMinColor(Vertice v) throws Exception {
        Collection<Vertice> voisin = grafo.getVizinhos(v.getRotulo());
        int min = Integer.MAX_VALUE;
        Color colMin = null;
        for (int i = 0; i < mapColor.size(); i++) {
            int cpt = 0;
            Color c = mapColor.get(i);
            for (Vertice u : voisin) {
                if (u.getCor().equals(c)) {
                    cpt++;
                }
            }
            if (cpt < min) {
                min = cpt;
                colMin = c;
            }
        }
        return colMin;
    }

    private ArrayList<Color> genereTabColor(int nb) {        
        ArrayList<Color> res = new ArrayList<Color>();
        for (int i = 0; i < nb; i++) {            
            int r = generator.nextInt(256);
            int gr = generator.nextInt(256);
            int b = generator.nextInt(256);            
            res.add(new Color(r, gr, b));

        }
        return res;
    }

    public void setNoColor() {
        for (Vertice v : grafo.getListaVertice()) {
            v.setCor(NOCOLOR);
        }
    }
   
    private int getNumberColors() {        
        Collection<Vertice> vertices = grafo.getListaVertice();
        HashSet<Color> liste = new HashSet<Color>();
        for (Vertice v : vertices) {
            liste.add(v.getCor());
        }
        return liste.size();
    }
}
