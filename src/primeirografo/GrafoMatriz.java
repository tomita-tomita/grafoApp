/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeirografo;

/**
 *
 * @author 3602699
 */
public class GrafoMatriz {
    int tam;
    int mat[][];

    public GrafoMatriz(int tam) {
        this.tam = tam;
        this.mat = new int[tam][tam];
    }
    
    public void inicializaGrafo(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.mat[i][j] = 0;
            }
        }        
    }
    
    public void insereAresta(int vertice1, int vertice2){
        this.mat[vertice1][vertice2] = 1;
    }
    
    public void imprimeGrafo(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }        
        System.out.println();        
    }
    
}
