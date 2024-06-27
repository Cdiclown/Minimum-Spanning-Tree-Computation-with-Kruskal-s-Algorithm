package src.datastructure.graph;

/**
 * Weighted edge implementation
 * @param <D> type of the data object in the graph vertexes
 */
public class WeightedEdge<D> extends Edge<D> {

    /** weight of the edge */
    public double weight;

    /**
     * Constructs a weighted edge
     * @param source source vertex
     * @param dest destination vertex
     * @param weight weight of the edge
     */
    public WeightedEdge(Vertex<D> source, Vertex<D> dest, double weight) {
        super(source, dest);
        this.weight = weight;
    }
}
