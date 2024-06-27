package src.datastructure.graph;

import java.util.ArrayList;

/**
 * Implementazione di grafi pesati utilizzando liste di adiacenza.
 * @param <D> tipo dell'oggetto di dati nei vertici del grafo
 */    
public class WeightedGraphAL<D> extends GraphAL<D> implements WeightedGraph<D> {

    /**
     * Costruisce un grafo pesato con implementazione utilizzando liste di adiacenza.
     */        
    public WeightedGraphAL(){
        super();
    }

    /**
     * Aggiunge un arco pesato al grafo.
     * @param e l'arco pesato da aggiungere
     * @throws IllegalArgumentException se l'arco non è un'istanza di WeightedEdge
     */
    @Override
    public void addEdge(Edge<D> e) {
        if (!(e instanceof WeightedEdge)) {
            throw new IllegalArgumentException("Only weighted edges are allowed in WeightedGraphAL");
        }
        super.addEdge(e);
    }
    
    /**
     * Restituisce gli archi uscenti dal vertice specificato, filtrando solo quelli pesati.
     * @param v il vertice di cui trovare gli archi uscenti
     * @return lista degli archi pesati uscenti dal vertice
     */
    @Override
    public ArrayList<Edge<D>> outEdges(Vertex<D> v) {
        VertexAL<D> vAL = (VertexAL<D>) v;
        ArrayList<Edge<D>> weightedEdges = new ArrayList<>();
        for (Edge<D> edge : vAL.adjac) {
            if (edge instanceof WeightedEdge) {
                weightedEdges.add(edge);
            }
        }
        return weightedEdges;
    }
    
    /**
     * Restituisce tutti gli archi del grafo, filtrando solo quelli pesati.
     * @return lista di tutti gli archi pesati del grafo
     */
    @Override
    public ArrayList<Edge<D>> edges() {
        ArrayList<Edge<D>> allWeightedEdges = new ArrayList<>();
        for (VertexAL<D> vertex : vertexes) {
            for (Edge<D> edge : vertex.adjac) {
                if (edge instanceof WeightedEdge) {
                    allWeightedEdges.add(edge);
                }
            }
        }
        return allWeightedEdges;
    }
}
