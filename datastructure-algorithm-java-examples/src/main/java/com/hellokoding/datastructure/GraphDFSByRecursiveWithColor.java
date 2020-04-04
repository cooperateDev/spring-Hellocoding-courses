package com.hellokoding.datastructure;

public class GraphDFSByRecursiveWithColor {
    static final int WHITE = 0, GRAY = 1, BLACK = 2;

    static void dfsByRecursiveWithColor(GraphUndirectedByAdjacencyList g, int v, int[] color) {
        color[v] = GRAY;
        System.out.printf("%d ", v);

        for (Integer w : g.adjacencyList.get(v)) {
            if (color[w] == WHITE) {
                dfsByRecursiveWithColor(g, w, color);
            }
        }
        color[v] = BLACK;
    }

    static void traversal(GraphUndirectedByAdjacencyList g) {
        int[] color = new int[g.V];

        for (int i = 0; i < g.V; i++) {
            if (color[i] == WHITE) {
                dfsByRecursiveWithColor(g, i, color);
            }
        }
    }

    public static void main(String[] args) {
        GraphUndirectedByAdjacencyList g = new GraphUndirectedByAdjacencyList(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        traversal(g);
    }
}
