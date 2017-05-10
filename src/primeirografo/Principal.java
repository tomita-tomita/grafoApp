package primeirografo;

import com.alee.laf.WebLookAndFeel;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    GrafoLista grafo;
    boolean arestasTemPeso;
    ArrayList<String> vesticesVisitados = new ArrayList<>();

    public Principal() {
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (Exception e) {
        }

        initComponents();
        ativaBotoes(false);
        campoHistorico.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        botaoCriarGrafo = new javax.swing.JButton();
        botaoVerticesAutomaticos = new javax.swing.JButton();
        botaoAdicionarVertice = new javax.swing.JButton();
        botaoAdicionarAresta = new javax.swing.JButton();
        botaoRemoverVertice = new javax.swing.JButton();
        botaoRemoverAresta = new javax.swing.JButton();
        botaoDsatur = new javax.swing.JButton();
        botaoWelshPowellGraph = new javax.swing.JButton();
        botaoJGraphTAdapter = new javax.swing.JButton();
        botaoImprimirGrafo = new javax.swing.JButton();
        botaoLimparHistorico = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jCheckBoxGrafoPossuiPeso = new javax.swing.JCheckBox();
        jCheckBoxGrafoDirecional = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoHistorico = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVertices = new javax.swing.JMenu();
        menuAdicionarVertice = new javax.swing.JMenuItem();
        jMenuRemoverVertice = new javax.swing.JMenuItem();
        jMenuVerificarVertice = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuGrafoTeste = new javax.swing.JMenuItem();
        jMenuArestas = new javax.swing.JMenu();
        jMenuAdicionarAresta = new javax.swing.JMenuItem();
        jMenuRemoverAresta = new javax.swing.JMenuItem();
        jMenuVerificarAresta = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuRetornarArestas = new javax.swing.JMenuItem();
        jMenuFuncoes = new javax.swing.JMenu();
        jMenuVerificarPlanaridade = new javax.swing.JMenuItem();
        jMenuBusca = new javax.swing.JMenu();
        jMenuBuscaEmLargura = new javax.swing.JMenuItem();
        jMenuBuscaEmProfundidade = new javax.swing.JMenuItem();
        jMenuDijkstra = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuWelshPowell = new javax.swing.JMenuItem();
        jMenuDsatur = new javax.swing.JMenuItem();
        jMenuJGraphT = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuImprimirGrafo = new javax.swing.JMenuItem();
        jMenuLimparHistorico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafos");
        setPreferredSize(new java.awt.Dimension(820, 491));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));
        jPanel1.setMinimumSize(new java.awt.Dimension(1, 1));
        jPanel1.setPreferredSize(new java.awt.Dimension(260, 300));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.GridLayout(11, 1));

        botaoCriarGrafo.setText("Criar Grafo");
        botaoCriarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarGrafoActionPerformed(evt);
            }
        });
        jPanel4.add(botaoCriarGrafo);

        botaoVerticesAutomaticos.setText("Vértices Automáticos (Testes)");
        botaoVerticesAutomaticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerticesAutomaticosActionPerformed(evt);
            }
        });
        jPanel4.add(botaoVerticesAutomaticos);

        botaoAdicionarVertice.setText("Adicionar Vértice");
        botaoAdicionarVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarVerticeActionPerformed(evt);
            }
        });
        jPanel4.add(botaoAdicionarVertice);

        botaoAdicionarAresta.setText("Adicionar Aresta");
        botaoAdicionarAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarArestaActionPerformed(evt);
            }
        });
        jPanel4.add(botaoAdicionarAresta);

        botaoRemoverVertice.setText("Remover Vértice");
        botaoRemoverVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverVerticeActionPerformed(evt);
            }
        });
        jPanel4.add(botaoRemoverVertice);

        botaoRemoverAresta.setText("Remover Aresta");
        botaoRemoverAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverArestaActionPerformed(evt);
            }
        });
        jPanel4.add(botaoRemoverAresta);

        botaoDsatur.setText("Dsatur");
        botaoDsatur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDsaturActionPerformed(evt);
            }
        });
        jPanel4.add(botaoDsatur);

        botaoWelshPowellGraph.setText("Welsh-Powell");
        botaoWelshPowellGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoWelshPowellGraphActionPerformed(evt);
            }
        });
        jPanel4.add(botaoWelshPowellGraph);

        botaoJGraphTAdapter.setText("Exibir Grafo - JGraphT");
        botaoJGraphTAdapter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoJGraphTAdapterActionPerformed(evt);
            }
        });
        jPanel4.add(botaoJGraphTAdapter);

        botaoImprimirGrafo.setText("Imprimir Grafo");
        botaoImprimirGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImprimirGrafoActionPerformed(evt);
            }
        });
        jPanel4.add(botaoImprimirGrafo);

        botaoLimparHistorico.setText("Limpar Historico");
        botaoLimparHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparHistoricoActionPerformed(evt);
            }
        });
        jPanel4.add(botaoLimparHistorico);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout());

        jCheckBoxGrafoPossuiPeso.setText("Grafo possui peso");
        jPanel5.add(jCheckBoxGrafoPossuiPeso);

        jCheckBoxGrafoDirecional.setText("Grafo Direcional");
        jPanel5.add(jCheckBoxGrafoDirecional);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico"));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 439));
        jPanel2.setLayout(new java.awt.BorderLayout());

        campoHistorico.setColumns(20);
        campoHistorico.setRows(5);
        jScrollPane1.setViewportView(campoHistorico);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 50));

        jLabel1.setText("Trabalho de Grafos (M2.1)");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 19, 227));
        jLabel2.setText("Alunos: Eduardo Vinícius Mölleken Tomita, Leonardo Lucas de Melo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jMenuVertices.setText("Vértices");

        menuAdicionarVertice.setText("Adicionar Vértice");
        menuAdicionarVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarVerticeActionPerformed(evt);
            }
        });
        jMenuVertices.add(menuAdicionarVertice);

        jMenuRemoverVertice.setText("Remover Vértice");
        jMenuRemoverVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRemoverVerticeActionPerformed(evt);
            }
        });
        jMenuVertices.add(jMenuRemoverVertice);

        jMenuVerificarVertice.setText("Verificar Vértice");
        jMenuVerificarVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerificarVerticeActionPerformed(evt);
            }
        });
        jMenuVertices.add(jMenuVerificarVertice);
        jMenuVertices.add(jSeparator1);

        jMenuGrafoTeste.setText("Vértices Automáticos (Teste)");
        jMenuGrafoTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGrafoTesteActionPerformed(evt);
            }
        });
        jMenuVertices.add(jMenuGrafoTeste);

        jMenuBar1.add(jMenuVertices);

        jMenuArestas.setText("Arestas");

        jMenuAdicionarAresta.setText("Adicionar Aresta");
        jMenuAdicionarAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAdicionarArestaActionPerformed(evt);
            }
        });
        jMenuArestas.add(jMenuAdicionarAresta);

        jMenuRemoverAresta.setText("Remover Aresta");
        jMenuRemoverAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRemoverArestaActionPerformed(evt);
            }
        });
        jMenuArestas.add(jMenuRemoverAresta);

        jMenuVerificarAresta.setText("Verificar Aresta");
        jMenuVerificarAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerificarArestaActionPerformed(evt);
            }
        });
        jMenuArestas.add(jMenuVerificarAresta);
        jMenuArestas.add(jSeparator2);

        jMenuRetornarArestas.setText("Retornar Arestas");
        jMenuRetornarArestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRetornarArestasActionPerformed(evt);
            }
        });
        jMenuArestas.add(jMenuRetornarArestas);

        jMenuBar1.add(jMenuArestas);

        jMenuFuncoes.setText("Funções");

        jMenuVerificarPlanaridade.setText("Verificar Planaridade");
        jMenuVerificarPlanaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerificarPlanaridadeActionPerformed(evt);
            }
        });
        jMenuFuncoes.add(jMenuVerificarPlanaridade);

        jMenuBusca.setText("Buscas");

        jMenuBuscaEmLargura.setText("Largura");
        jMenuBuscaEmLargura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBuscaEmLarguraActionPerformed(evt);
            }
        });
        jMenuBusca.add(jMenuBuscaEmLargura);

        jMenuBuscaEmProfundidade.setText("Profundidade");
        jMenuBuscaEmProfundidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBuscaEmProfundidadeActionPerformed(evt);
            }
        });
        jMenuBusca.add(jMenuBuscaEmProfundidade);

        jMenuFuncoes.add(jMenuBusca);

        jMenuDijkstra.setText("Dijkstra");
        jMenuDijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDijkstraActionPerformed(evt);
            }
        });
        jMenuFuncoes.add(jMenuDijkstra);

        jMenu5.setText("Coloração");

        jMenuWelshPowell.setText("Welsh-Powell");
        jMenuWelshPowell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuWelshPowellActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuWelshPowell);

        jMenuDsatur.setText("Dsatur");
        jMenuDsatur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDsaturActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuDsatur);

        jMenuFuncoes.add(jMenu5);

        jMenuJGraphT.setText("Exibir Grafo (JGraphT)");
        jMenuJGraphT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuJGraphTActionPerformed(evt);
            }
        });
        jMenuFuncoes.add(jMenuJGraphT);
        jMenuFuncoes.add(jSeparator3);

        jMenuImprimirGrafo.setText("Imprimir Grafo");
        jMenuImprimirGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuImprimirGrafoActionPerformed(evt);
            }
        });
        jMenuFuncoes.add(jMenuImprimirGrafo);

        jMenuLimparHistorico.setText("Limpar Histórico");
        jMenuLimparHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLimparHistoricoActionPerformed(evt);
            }
        });
        jMenuFuncoes.add(jMenuLimparHistorico);

        jMenuBar1.add(jMenuFuncoes);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ativaBotoes(boolean ativa) {
        //Botões Exibidos na Tela
        botaoAdicionarAresta.setEnabled(ativa);
        botaoAdicionarVertice.setEnabled(ativa);
        botaoImprimirGrafo.setEnabled(ativa);
        botaoRemoverAresta.setEnabled(ativa);
        botaoRemoverVertice.setEnabled(ativa);
        botaoDsatur.setEnabled(ativa);
        botaoWelshPowellGraph.setEnabled(ativa);
        botaoJGraphTAdapter.setEnabled(ativa);
        botaoVerticesAutomaticos.setEnabled(ativa);

        //Opções do Grafo
        jCheckBoxGrafoDirecional.setEnabled(!ativa);
        jCheckBoxGrafoPossuiPeso.setEnabled(!ativa);

        //Menus
        jMenuVertices.setEnabled(ativa);
        jMenuArestas.setEnabled(ativa);
        jMenuFuncoes.setEnabled(ativa);
    }

    private void exibirGrafo(String titulo) {
        JGraphAdapterDemo demo = new JGraphAdapterDemo();
        demo.init(grafo);
        JFrame frame = new JFrame();
        frame.getContentPane().add(demo);

        if (!titulo.equals("")) {
            frame.setTitle("JGraphT Adapter to JGraph Demo" + " - " + titulo);
        } else {
            frame.setTitle("JGraphT Adapter to JGraph Demo");
        }

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.show();
    }

    private String pergunta(String mensagem) {
        String resposta;

        resposta = JOptionPane.showInputDialog(mensagem);

        if (resposta == null) {
            resposta = "";
        }

        return resposta;
    }

    private void botaoRemoverVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverVerticeActionPerformed
        String rotulo = pergunta("Qual o rótulo do vértice?");

        if (rotulo.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        campoHistorico.setText(campoHistorico.getText() + "\n" + grafo.removeVertice(rotulo));
    }//GEN-LAST:event_botaoRemoverVerticeActionPerformed


    private void botaoCriarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarGrafoActionPerformed
        if (botaoCriarGrafo.getText().equals("Criar Grafo")) {
            grafo = new GrafoLista(jCheckBoxGrafoDirecional.isSelected(), jCheckBoxGrafoPossuiPeso.isSelected());
            arestasTemPeso = jCheckBoxGrafoPossuiPeso.isSelected();
            botaoCriarGrafo.setText("Remover Grafo");
            ativaBotoes(true);
        } else {
            grafo = null;
            botaoCriarGrafo.setText("Criar Grafo");
            ativaBotoes(false);
        }
    }//GEN-LAST:event_botaoCriarGrafoActionPerformed

    private void botaoAdicionarVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarVerticeActionPerformed
        String rotulo = pergunta("Qual o rótulo do vértice?");

        if (rotulo.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        Vertice novoVertice = new Vertice(rotulo);

        if (grafo.insereVertice(novoVertice)) {
            campoHistorico.setText(campoHistorico.getText() + "\nO vértice com o rótulo " + rotulo + " foi inserido com sucesso.");
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nO vértice com o rótulo " + rotulo + " já existe.");
        }
    }//GEN-LAST:event_botaoAdicionarVerticeActionPerformed

    private void botaoAdicionarArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarArestaActionPerformed
        int pesoAresta = 0;
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");
        String verticeDestino = pergunta("Qual o rótulo do vértice de destino?");

        if (verticeOrigem.equals("") || (verticeDestino.equals(""))) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        if (arestasTemPeso) {
            try {
                pesoAresta = Integer.parseInt(pergunta("Qual o peso desta aresta?"));
            } catch (Exception e) {
                campoHistorico.setText(campoHistorico.getText() + "\nPeso inválido");
                return;
            }
        }

        if (grafo.inserirAresta(verticeOrigem, verticeDestino, pesoAresta)) {
            campoHistorico.setText(campoHistorico.getText() + "\nA aresta foi inserida com sucesso.");
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nNão foi possível inserir a aresta.");
        }
    }//GEN-LAST:event_botaoAdicionarArestaActionPerformed

    private void botaoRemoverArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverArestaActionPerformed
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");
        String verticeDestino = pergunta("Qual o rótulo do vértice de destino?");

        if (verticeOrigem.equals("") || (verticeDestino.equals(""))) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        campoHistorico.setText(campoHistorico.getText() + "\n" + grafo.removeAresta(verticeOrigem, verticeDestino));
    }//GEN-LAST:event_botaoRemoverArestaActionPerformed

    private void botaoImprimirGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirGrafoActionPerformed
        campoHistorico.setText(campoHistorico.getText() + "\n" + grafo.imprimeGrafo());
    }//GEN-LAST:event_botaoImprimirGrafoActionPerformed

    private void botaoLimparHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparHistoricoActionPerformed
        campoHistorico.setText("");
    }//GEN-LAST:event_botaoLimparHistoricoActionPerformed

    private void botaoDsaturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDsaturActionPerformed
        Dsatur dsatur = new Dsatur(grafo);
        dsatur.ColorirVertices();
        exibirGrafo("Algoritmo Dsatur");
    }//GEN-LAST:event_botaoDsaturActionPerformed

    private void botaoWelshPowellGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoWelshPowellGraphActionPerformed
        WelshPowellGraph welsh = new WelshPowellGraph(grafo);
        welsh.colourVertices();
        exibirGrafo("Algoritmo Welsh-Powell");
    }//GEN-LAST:event_botaoWelshPowellGraphActionPerformed

    private void botaoJGraphTAdapterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoJGraphTAdapterActionPerformed
        exibirGrafo("");
    }//GEN-LAST:event_botaoJGraphTAdapterActionPerformed

    private void botaoVerticesAutomaticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerticesAutomaticosActionPerformed
        grafo.criarGrafoTeste();
    }//GEN-LAST:event_botaoVerticesAutomaticosActionPerformed

    private void menuAdicionarVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarVerticeActionPerformed
        String rotulo = pergunta("Qual o rótulo do vértice?");

        if (rotulo.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        Vertice novoVertice = new Vertice(rotulo);

        if (grafo.insereVertice(novoVertice)) {
            campoHistorico.setText(campoHistorico.getText() + "\nO vértice com o rótulo " + rotulo + " foi inserido com sucesso.");
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nO vértice com o rótulo " + rotulo + " já existe.");
        }
    }//GEN-LAST:event_menuAdicionarVerticeActionPerformed

    private void jMenuRemoverVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRemoverVerticeActionPerformed
        String rotulo = pergunta("Qual o rótulo do vértice?");

        if (rotulo.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        campoHistorico.setText(campoHistorico.getText() + "\n" + grafo.removeVertice(rotulo));
    }//GEN-LAST:event_jMenuRemoverVerticeActionPerformed

    private void jMenuVerificarVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerificarVerticeActionPerformed
        String rotulo = pergunta("Qual o rótulo do vértice?");

        if (rotulo.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        if (grafo.verificaVertice(rotulo)) {
            campoHistorico.setText(campoHistorico.getText() + "\nO Vértice foi encontrado.");
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nO Vértice não existe.");
        }
    }//GEN-LAST:event_jMenuVerificarVerticeActionPerformed

    private void jMenuGrafoTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGrafoTesteActionPerformed
        grafo.criarGrafoTeste();
    }//GEN-LAST:event_jMenuGrafoTesteActionPerformed

    private void jMenuAdicionarArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAdicionarArestaActionPerformed
        int pesoAresta = 0;
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");
        String verticeDestino = pergunta("Qual o rótulo do vértice de destino?");

        if (verticeOrigem.equals("") || (verticeDestino.equals(""))) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        if (arestasTemPeso) {
            try {
                pesoAresta = Integer.parseInt(pergunta("Qual o peso desta aresta?"));
            } catch (Exception e) {
                campoHistorico.setText(campoHistorico.getText() + "\nPeso inválido");
                return;
            }
        }

        if (grafo.inserirAresta(verticeOrigem, verticeDestino, pesoAresta)) {
            campoHistorico.setText(campoHistorico.getText() + "\nA aresta foi inserida com sucesso.");
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nNão foi possível inserir a aresta.");
        }
    }//GEN-LAST:event_jMenuAdicionarArestaActionPerformed

    private void jMenuRemoverArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRemoverArestaActionPerformed
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");
        String verticeDestino = pergunta("Qual o rótulo do vértice de destino?");

        if (verticeOrigem.equals("") || (verticeDestino.equals(""))) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        campoHistorico.setText(campoHistorico.getText() + "\n" + grafo.removeAresta(verticeOrigem, verticeDestino));
    }//GEN-LAST:event_jMenuRemoverArestaActionPerformed

    private void jMenuVerificarArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerificarArestaActionPerformed
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");
        String verticeDestino = pergunta("Qual o rótulo do vértice de destino?");

        if (verticeOrigem.equals("") || (verticeDestino.equals(""))) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        if (grafo.verificaAresta(verticeOrigem, verticeDestino)) {
            campoHistorico.setText(campoHistorico.getText() + "\nA aresta foi encontrada.");
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nA aresta não existe.");
        }
    }//GEN-LAST:event_jMenuVerificarArestaActionPerformed

    private void jMenuRetornarArestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRetornarArestasActionPerformed
        String rotulo = pergunta("Qual o rótulo do vértice?");

        if (rotulo.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        ArrayList<Aresta> arestas = grafo.retornarArestas(rotulo);

        if (arestas != null) {
            campoHistorico.setText(campoHistorico.getText() + "\nArestas para o Vértice " + rotulo + ": ");
            for (Aresta aresta : arestas) {
                campoHistorico.setText(campoHistorico.getText() + aresta.getVertice() + " | ");
            }
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nO vértice não possui arestas.");
        }
    }//GEN-LAST:event_jMenuRetornarArestasActionPerformed

    private void jMenuVerificarPlanaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerificarPlanaridadeActionPerformed
        if (grafo.listaVertice.size() <= 0) {
            campoHistorico.setText(campoHistorico.getText() + "\nNão existem vértices.");
        } else if (grafo.verificaPlanar()) {
            campoHistorico.setText(campoHistorico.getText() + "\nO grafo pode ser planar.");
        } else {
            campoHistorico.setText(campoHistorico.getText() + "\nO grafo não é planar.");
        }
    }//GEN-LAST:event_jMenuVerificarPlanaridadeActionPerformed

    private void jMenuBuscaEmLarguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBuscaEmLarguraActionPerformed
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");

        if (verticeOrigem.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        this.vesticesVisitados = grafo.bfs(verticeOrigem);
        campoHistorico.setText(campoHistorico.getText() + "\n");
        for (String vesticesVisitado : vesticesVisitados) {
            campoHistorico.setText(campoHistorico.getText() + vesticesVisitado + ", ");
        }
        grafo.resetVisitados();
    }//GEN-LAST:event_jMenuBuscaEmLarguraActionPerformed

    private void jMenuBuscaEmProfundidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBuscaEmProfundidadeActionPerformed
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");

        if (verticeOrigem.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        this.vesticesVisitados = grafo.dfs(verticeOrigem);
        campoHistorico.setText(campoHistorico.getText() + "\n");
        for (String vesticesVisitado : vesticesVisitados) {
            campoHistorico.setText(campoHistorico.getText() + vesticesVisitado + ", ");
        }
        grafo.resetVisitados();
    }//GEN-LAST:event_jMenuBuscaEmProfundidadeActionPerformed

    private void jMenuDijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDijkstraActionPerformed
        String verticeOrigem = pergunta("Qual o rótulo do vértice de origem?");
        String verticeDestino = pergunta("Qual o rótulo do vértice de destino?");

        if (verticeOrigem.equals("")) {
            campoHistorico.setText(campoHistorico.getText() + "\nResposta inválida");
            return;
        }

        campoHistorico.setText(grafo.dijkstra(verticeOrigem, verticeDestino));

        grafo.resetVisitados();
    }//GEN-LAST:event_jMenuDijkstraActionPerformed

    private void jMenuWelshPowellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuWelshPowellActionPerformed
        WelshPowellGraph welsh = new WelshPowellGraph(grafo);
        welsh.colourVertices();
        exibirGrafo("Algoritmo Welsh-Powell");
    }//GEN-LAST:event_jMenuWelshPowellActionPerformed

    private void jMenuDsaturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDsaturActionPerformed
        Dsatur dsatur = new Dsatur(grafo);
        dsatur.ColorirVertices();
        exibirGrafo("Algoritmo Dsatur");
    }//GEN-LAST:event_jMenuDsaturActionPerformed

    private void jMenuImprimirGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuImprimirGrafoActionPerformed
        campoHistorico.setText(campoHistorico.getText() + "\n" + grafo.imprimeGrafo());
    }//GEN-LAST:event_jMenuImprimirGrafoActionPerformed

    private void jMenuLimparHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLimparHistoricoActionPerformed
        campoHistorico.setText("");
    }//GEN-LAST:event_jMenuLimparHistoricoActionPerformed

    private void jMenuJGraphTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuJGraphTActionPerformed
        exibirGrafo("");
    }//GEN-LAST:event_jMenuJGraphTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionarAresta;
    private javax.swing.JButton botaoAdicionarVertice;
    private javax.swing.JButton botaoCriarGrafo;
    private javax.swing.JButton botaoDsatur;
    private javax.swing.JButton botaoImprimirGrafo;
    private javax.swing.JButton botaoJGraphTAdapter;
    private javax.swing.JButton botaoLimparHistorico;
    private javax.swing.JButton botaoRemoverAresta;
    private javax.swing.JButton botaoRemoverVertice;
    private javax.swing.JButton botaoVerticesAutomaticos;
    private javax.swing.JButton botaoWelshPowellGraph;
    private javax.swing.JTextArea campoHistorico;
    private javax.swing.JCheckBox jCheckBoxGrafoDirecional;
    private javax.swing.JCheckBox jCheckBoxGrafoPossuiPeso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuAdicionarAresta;
    private javax.swing.JMenu jMenuArestas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuBusca;
    private javax.swing.JMenuItem jMenuBuscaEmLargura;
    private javax.swing.JMenuItem jMenuBuscaEmProfundidade;
    private javax.swing.JMenuItem jMenuDijkstra;
    private javax.swing.JMenuItem jMenuDsatur;
    private javax.swing.JMenu jMenuFuncoes;
    private javax.swing.JMenuItem jMenuGrafoTeste;
    private javax.swing.JMenuItem jMenuImprimirGrafo;
    private javax.swing.JMenuItem jMenuJGraphT;
    private javax.swing.JMenuItem jMenuLimparHistorico;
    private javax.swing.JMenuItem jMenuRemoverAresta;
    private javax.swing.JMenuItem jMenuRemoverVertice;
    private javax.swing.JMenuItem jMenuRetornarArestas;
    private javax.swing.JMenuItem jMenuVerificarAresta;
    private javax.swing.JMenuItem jMenuVerificarPlanaridade;
    private javax.swing.JMenuItem jMenuVerificarVertice;
    private javax.swing.JMenu jMenuVertices;
    private javax.swing.JMenuItem jMenuWelshPowell;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem menuAdicionarVertice;
    // End of variables declaration//GEN-END:variables
}
