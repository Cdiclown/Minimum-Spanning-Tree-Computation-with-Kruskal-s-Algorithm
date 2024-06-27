package src.datastructure.unionfind;

/**
 * Struttura dati Union-Find con ottimizzazioni di path compression e union by rank.
 * Questa struttura dati gestisce insiemi disgiunti e supporta operazioni efficienti di unione e ricerca.
 */
public class QuickUnionRank {
    private final int[] parent;
    private final int[] rank;

    /**
     * Costruisce una nuova struttura Union-Find con n elementi inizialmente separati.
     *
     * @param n il numero di elementi iniziali
     */
    public QuickUnionRank(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Ogni elemento inizia come il proprio rappresentante
            rank[i] = 0;    // Inizialmente, ogni albero ha altezza zero
        }
    }

    /**
     * Trova il rappresentante (root) dell'insieme che contiene l'elemento p,
     * applicando la path compression per rendere la struttura più piatta.
     *
     * @param p l'elemento di cui trovare il rappresentante
     * @return il rappresentante (root) dell'insieme che contiene p
     */
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);  // Path compression
        }
        return parent[p];
    }

    /**
     * Unisce due insiemi che contengono gli elementi p e q, applicando union by rank
     * per mantenere l'albero più basso possibile.
     *
     * @param p un elemento da unire
     * @param q l'altro elemento da unire
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // Union by rank
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
    }

    /**
     * Verifica se due elementi p e q sono nello stesso insieme.
     *
     * @param p un elemento
     * @param q l'altro elemento
     * @return true se p e q sono nello stesso insieme, false altrimenti
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
