package primeirografo;

import java.util.ArrayList;

public class GrafoLista {

    ArrayList<Vertice> listaVertice = new ArrayList<>();

    public boolean insereVertice(Vertice novoVertice) {
        for (Vertice vertice : listaVertice) {
            if (vertice.rotulo.equals(novoVertice.rotulo)) {
                return false;
            }
        }

        this.listaVertice.add(novoVertice);
        return true;
    }

    public boolean inserirAresta(String rotulo_origem, String rotulo_destino) {
        boolean possivel = false;

        if ((verificaVertice(rotulo_origem)) && (verificaVertice(rotulo_origem)) && (!rotulo_origem.equals(rotulo_destino))) {
            for (Vertice vertice : listaVertice) {
                if (vertice.rotulo.equals(rotulo_origem)) {
                    possivel = vertice.insereAresta(new Aresta(rotulo_destino));
                }
                if (vertice.rotulo.equals(rotulo_destino)) {
                    possivel = vertice.insereAresta(new Aresta(rotulo_origem));
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
                grafo = grafo + aresta.destino + " ";
            }
            grafo = grafo + "\n ";
        }

        return grafo;
    }

    public int getQuantidadeArestas() {
        int qtdArestas = 0;

        for (Vertice vertice : listaVertice) {
            qtdArestas = qtdArestas + vertice.getListaAresta().size();
        }

        //Mudar futuramente quando for aceito grafos direcionais
        qtdArestas = qtdArestas / 2;

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
}
