package graph.graphs.impl;

import graph.graphs.Graphs;

import java.util.*;

public class GraphsImpl<T> implements Graphs<T> {

    private final Map<T, List<T>> graph = new HashMap<>();

    public void addVertex(T vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T vertexOne, T vertexTwo) {
        if (!graph.containsKey(vertexOne) || !graph.containsKey(vertexTwo)) {
            throw new IllegalArgumentException("Vertex not found");
        }
        graph.get(vertexOne).add(vertexTwo);
        graph.get(vertexTwo).add(vertexOne);
    }

    public List<T> getDependencies(T vertex) {
        return graph.getOrDefault(vertex,Collections.emptyList());
    }

    public void search(T startVertex) {
        Set<T> visited = new HashSet<>();
        searchHelper(startVertex,visited);
    }

    private void searchHelper(T vertex, Set<T> visited) {
        if(!visited.contains(vertex)) {
            visited.add(vertex);
            System.out.println(vertex);
            for (T vertexD : getDependencies(vertex)) {
                searchHelper(vertexD,visited);
            }
        }
    }
}
