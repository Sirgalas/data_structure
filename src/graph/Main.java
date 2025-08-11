package graph;

import graph.graphs.Graphs;
import graph.graphs.impl.GraphsImpl;

public class Main {
    public static void main(String[] args) {
        Graphs graphs = new GraphsImpl<>();
        graphs.addVertex("A");
        graphs.addVertex("B");
        graphs.addVertex("C");
        graphs.addVertex("D");

        graphs.addEdge("A", "B");
        graphs.addEdge("A", "D");
        graphs.addEdge("B","C");
        graphs.addEdge("B", "D");
        graphs.addEdge("C", "D");
    }
}
