package src.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Implementazione di grafi utilizzando liste di adiacenza
 * @param <D> tipo dell'oggetto dato nei vertici del grafo
 */
public class GraphAL<D> implements Graph<D> {

    /** numero di vertici */
    public int n;
    
    /** numero di archi */
    public int m;
    
    /** lista dei vertici */
    public ArrayList<VertexAL<D>> vertexes;

    /**
     * Costruisce un grafo con implementazione tramite liste di adiacenza
     */
    public GraphAL() {
        n = 0;
        m = 0;
        vertexes = new ArrayList<VertexAL<D>>();
    }

    /**
     * Restituisce il numero di vertici nel grafo
     * @return il numero di vertici
     */
    public int vertexNum() {
        return n;
    }

    /**
     * Restituisce il numero di archi nel grafo
     * @return il numero di archi
     */
    public int edgeNum() {
        return m;
    }

    /**
     * Restituisce una lista di tutti i vertici nel grafo
     * @return una lista di vertici
     */
    public ArrayList<Vertex<D>> vertexes() {
        return new ArrayList<Vertex<D>>(vertexes);
    }

    /**
     * Restituisce una lista di tutti gli archi nel grafo
     * @return una lista di archi
     */
    public ArrayList<Edge<D>> edges() {
        ArrayList<Edge<D>> allEdges = new ArrayList<Edge<D>>();
        for (VertexAL<D> vertex : vertexes) {
            allEdges.addAll(vertex.adjac);
        }
        return allEdges;
    }

    /**
     * Restituisce il grado uscente di un dato vertice
     * @param v il vertice
     * @return il grado uscente del vertice
     */
    public int outDegree(Vertex<D> v) {
        VertexAL<D> vAL = (VertexAL<D>) v;
        return vAL.adjac.size();
    }

    /**
     * Restituisce una lista di archi uscenti da un dato vertice
     * @param v il vertice
     * @return una lista di archi uscenti
     */
    public ArrayList<Edge<D>> outEdges(Vertex<D> v) {
        VertexAL<D> vAL = (VertexAL<D>) v;
        return new ArrayList<Edge<D>>(vAL.adjac);
    }

    /**
     * Verifica se due vertici sono adiacenti
     * @param x il primo vertice
     * @param y il secondo vertice
     * @return l'arco se i vertici sono adiacenti, altrimenti null
     */
    public Edge<D> areAdjacent(Vertex<D> x, Vertex<D> y) {
        VertexAL<D> xAL = (VertexAL<D>) x;
        for (Edge<D> edge : xAL.adjac) {
            if (edge.dest.equals(y)) {
                return edge;
            }
        }
        return null;
    }

    /**
     * Aggiunge un vertice al grafo
     * @param data i dati del vertice
     * @return il nuovo vertice aggiunto
     */
    public Vertex<D> addVertex(D data) {
        VertexAL<D> newVertex = new VertexAL<D>(data, n);
        vertexes.add(newVertex);
        n++;
        return newVertex;
    }

    /**
     * Aggiunge un arco al grafo
     * @param e l'arco da aggiungere
     */
    public void addEdge(Edge<D> e) {
        LinkedList<Edge<D>> l = vertexes.get(((VertexAL<D>) e.source).index).adjac;
        l.add(e);
        LinkedList<Edge<D>> r = vertexes.get(((VertexAL<D>) e.dest).index).adjac;
        WeightedEdge<D> tmp = new WeightedEdge<D>(e.dest, e.source, ((WeightedEdge<D>) e).weight);
        r.add(tmp);
        this.m = this.m + 2;
    }

    /**
     * Rimuove un arco dal grafo
     * @param e l'arco da rimuovere
     */
    public void removeEdge(Edge<D> e) {
        VertexAL<D> source = (VertexAL<D>) e.source;
        VertexAL<D> dest = (VertexAL<D>) e.dest;
        
        // Rimuove l'arco dalla lista di adiacenza del sorgente
        if (source.adjac.remove(e)) {
            m--;
        }

        // Crea un arco inverso per cercare nella lista di adiacenza del destinazione
        Edge<D> reverseEdge = new WeightedEdge<D>(e.dest, e.source, ((WeightedEdge<D>) e).weight);

        // Rimuove l'arco inverso dalla lista di adiacenza del destinazione
        if (dest.adjac.remove(reverseEdge)) {
            m--;
        }
    }

    /**
     * Rimuove un vertice dal grafo
     * @param v il vertice da rimuovere
     */
    public void removeVertex(Vertex<D> v) {
        VertexAL<D> vAL = (VertexAL<D>) v;
        m = m - vAL.adjac.size();
        n = n - 1;
        if (vAL.index == n) {
            vertexes.remove(n);
        } else {
            VertexAL<D> vert = vertexes.remove(n);
            vert.index = vAL.index;
            vertexes.set(vert.index, vert);
        }
        Edge<D> e;
        for (int i = 0; i < vertexes.size(); i++) {
            Iterator<Edge<D>> it = (vertexes.get(i)).adjac.iterator();
            while (it.hasNext()) {
                e = it.next();
                if (e.dest == v) {
                    it.remove();
                    m = m - 1;
                }
            }
        }
    }

    /**
     * Restituisce l'indice di un vertice
     * @param v il vertice
     * @return l'indice del vertice v
     */
    public int index(VertexAL<D> v) {
        return v.index;
    }

    /**
     * Restituisce il vertice con un dato indice
     * @param i l'indice
     * @return il vertice con l'indice i
     */
    public VertexAL<D> vertex(int i) {
        if (i < 0 || i >= n) return null;
        return vertexes.get(i);
    }
}
