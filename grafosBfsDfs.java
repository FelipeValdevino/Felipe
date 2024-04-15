Codigo atualizado em BFS

package atividade;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solucao{
private static final int BRANCO = -1;
private static final int CINZA = 0;
private static final int PRETO = 1;

public int[] cor;
public int[] distancia;
public Integer[] ante;
public Queue<Integer> fila;

public boolean[][] grafo;

public Solucao(boolean[][] grafo2) {
    this.grafo = grafo2;
    int tamanho = grafo.length;
    cor = new int[tamanho];
    distancia = new int[tamanho];
    ante = new Integer[tamanho];
    fila = new ArrayDeque<>();
}

public void BFS(int s){
   
    for (int i = 0; i < grafo.length; i++) {
        cor[i] = BRANCO;
        distancia[i] = -1;
        ante[i] = null;
    }

    cor[s] = CINZA;
    distancia[s] = 0;
    fila.add(s);

    // Execução do BFS
    while (!fila.isEmpty()) {
        int u = fila.poll();
        for (int v = 0; v < grafo.length; v++) {
            if (grafo[u][v] && cor[v] == BRANCO) {
                cor[v] = CINZA;
                distancia[v] = distancia[u] + 1;
                ante[v] = u;
                fila.add(v);
            }
        }
        cor[u] = PRETO;
    }
}
}

Codigo em DFS

package atividade;

import java.util.LinkedList;

public class Solucao {
}
private static final int BRANCO = -1;
private static final int CINZA = 0;
private static final int PRETO = 1;

public int[] ante;
public int[] i;
public int[] f;
public int[] cor;
public int tempo;

private LinkedList<LinkedList<Integer>> grafo;

public Solucao(LinkedList<LinkedList<Integer>> grafo) {
    this.grafo = grafo;
    int n = grafo.size();
    ante = new int[n];
    i = new int[n];
    f = new int[n];
    cor = new int[n];
    tempo = -1;

    for (int u = 0; u < n; u++) {
        cor[u] = BRANCO;
        ante[u] = -1;
    }
}

public void dfs_start(int s) {
    cor[s] = BRANCO;
    tempo = -1;
    dfs_visit(s); // Chamada inicial para DFS a partir do vértice s
}
private void dfs_visit(int u) {
    cor[u] = CINZA;
    tempo++;
    i[u] = tempo;

    for (int v : grafo.get(u)) {
        if (cor[v] == BRANCO) {
            ante[v] = u;
            dfs_visit(v);
        }
    }

    cor[u] = PRETO;
    tempo++;
    f[u] = tempo;
}
}