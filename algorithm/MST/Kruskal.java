package src.algorithm.MST;

import src.datastructure.graph.*;
import src.datastructure.unionfind.QuickUnionRank;
import src.algorithm.sorting.Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementazione dell'algoritmo di Kruskal per il calcolo dell'Albero di Copertura Minimo (MST) di un grafo pesato.
 *
 * @param <D> tipo dei dati memorizzati nei nodi del grafo
 */
public class Kruskal<D> implements MST<D> {

    /**
     * Grafo pesato che rappresenta l'MST.
     */
    private WeightedGraph<D> mst;

    /**
     * Peso totale dell'MST.
     */
    private double totalWeight;

    /**
     * Costruttore di Kruskal che inizializza un nuovo MST vuoto.
     */
    public Kruskal() {
        mst = new WeightedGraphAL<>();
        totalWeight = 0.0;
    }

    /**
     * Calcola l'Albero di Copertura Minimo (MST) del grafo pesato specificato.
     *
     * @param graph il grafo pesato di input
     */
    @Override
    public void compute(WeightedGraph<D> graph) {
        List<WeightedEdge<D>> weightedEdges = new ArrayList<>();

        // Estrae gli archi pesati dal grafo di input
        for (Edge<D> edge : graph.edges()) {
            if (edge instanceof WeightedEdge) {
                weightedEdges.add((WeightedEdge<D>) edge);
            }
        }

        // Converti la lista di archi pesati in un array
        @SuppressWarnings("unchecked")
        WeightedEdge<D>[] edgeArray = weightedEdges.toArray(new WeightedEdge[0]);

        // Ordina gli archi per peso utilizzando mergesort
        Sorting.mergesort(edgeArray);

        // Inizializza la struttura Union-Find con path compression e union by rank
        QuickUnionRank uf = new QuickUnionRank(graph.vertexNum());

        // Aggiunge tutti i vertici al grafo MST
        for (Vertex<D> vertex : graph.vertexes()) {
            mst.addVertex(vertex.data);
        }

        // Esegui l'algoritmo di Kruskal
        for (WeightedEdge<D> edge : edgeArray) {
            int u = graph.vertexes().indexOf(edge.source);
            int v = graph.vertexes().indexOf(edge.dest);

            // Verifica se gli estremi dell'arco sono connessi
            if (!uf.connected(u, v)) {
                uf.union(u, v);
                mst.addEdge(new WeightedEdge<>(edge.source, edge.dest, edge.weight));
                totalWeight += edge.weight;
            }
        }
    }

    /**
     * Restituisce l'Albero di Copertura Minimo (MST) del grafo pesato.
     *
     * @return l'Albero di Copertura Minimo (MST) del grafo pesato
     */
    @Override
    public WeightedGraph<D> spanningTree() {
        return mst;
    }

    /**
     * Restituisce il peso totale dell'Albero di Copertura Minimo (MST) del grafo pesato.
     *
     * @return il peso totale dell'Albero di Copertura Minimo (MST) del grafo pesato
     */
    @Override
    public double totalWeight() {
        return totalWeight;
    }
}

