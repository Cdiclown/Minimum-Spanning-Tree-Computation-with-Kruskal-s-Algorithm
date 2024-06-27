package src.datastructure.graph;

import java.util.LinkedList;

/**
 * Implementation of a vertex in an adjacent list graph
 * @param <D> type of the data object in the graph vertexes
 */    
public class VertexAL<D> extends Vertex<D> {

    /** index of the vertex */
    public int index;

    /** adjacency list */
    public LinkedList<Edge<D>> adjac;

    /**
     * Constructs a vertex for an adjacent list graph
     * @param data data object contained in the vertex
     * @param index index of the vertex
     */
    public VertexAL(D data, int index) {
        super(data);
        this.index = index;
        adjac = new LinkedList<Edge<D>>();
    }
}
