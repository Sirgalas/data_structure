package graph.graphs;

import java.util.List;

public interface Graphs<T> {

    public void addVertex(T vertex);
    public void addEdge(T vertexOne, T vertexTwo);
    public List<T> getDependencies(T vertex);
    public void search(T startVertex);
}
