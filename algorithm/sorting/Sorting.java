package src.algorithm.sorting;

import src.datastructure.graph.WeightedEdge;
import java.util.Arrays;

   /**
     * 
     * Ho scelto Il merge sort per l'algoritmo di Kruskal per le seguenti ragioni:
     * 
     * 1. Complessità Temporale: Merge sort ha una complessità temporale di O(n log n)), che è ottimale per l'ordinamento di liste.
     *    Questo è importante perché l'ordinamento degli archi è il passo più costoso dell'algoritmo di Kruskal.
     * 
     * 2. Stabilità: Merge sort è un algoritmo stabile, il che significa che mantiene l'ordine relativo degli elementi con lo stesso valore.
     *    Questo può essere utile se gli archi hanno attributi secondari oltre al peso che potrebbero essere rilevanti.
     * 
     * 3. Efficienza
     * 
     * 4. deguatezza per Strutture Dati: Merge sort funziona bene con strutture dati basate su liste, che sono comunemente utilizzate per rappresentare grafi.
     *

/**
 * Questa classe contiene vari algoritmi di ordinamento.
 */
public class Sorting {

    /**
     * Unisce due sotto-array in un array ordinato.
     *
     * @param <T>   la classe degli oggetti nell'array che devono implementare Comparable
     * @param A     l'array di destinazione in cui unire i sotto-array
     * @param L     il sotto-array sinistro
     * @param R     il sotto-array destro
     * @param left  la dimensione del sotto-array sinistro
     * @param right la dimensione del sotto-array destro
     */
    private static <T extends Comparable<T>> void merge(T[] A, T[] L, T[] R, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (L[i].compareTo(R[j]) <= 0) {
                A[k++] = L[i++];
            } else {
                A[k++] = R[j++];
            }
        }
        while (i < left) {
            A[k++] = L[i++];
        }
        while (j < right) {
            A[k++] = R[j++];
        }
    }

    /**
     * Ordina l'array specificato utilizzando il mergesort.
     *
     * @param <T> la classe degli oggetti nell'array che devono implementare Comparable
     * @param A   l'array da ordinare
     */
    public static <T extends Comparable<T>> void mergesort(T[] A) {
        int n = A.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        T[] L = Arrays.copyOfRange(A, 0, mid);
        T[] R = Arrays.copyOfRange(A, mid, n);

        mergesort(L);
        mergesort(R);

        merge(A, L, R, mid, n - mid);
    }

    /**
     * Unisce due sotto-array di WeightedEdge in un array ordinato per peso.
     *
     * @param <D>  la classe degli oggetti nei vertici del grafo
     * @param A    l'array di destinazione in cui unire i sotto-array
     * @param L    il sotto-array sinistro
     * @param R    il sotto-array destro
     * @param left la dimensione del sotto-array sinistro
     * @param right la dimensione del sotto-array destro
     */
    private static <D> void merge(WeightedEdge<D>[] A, WeightedEdge<D>[] L, WeightedEdge<D>[] R, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (L[i].weight <= R[j].weight) {
                A[k++] = L[i++];
            } else {
                A[k++] = R[j++];
            }
        }
        while (i < left) {
            A[k++] = L[i++];
        }
        while (j < right) {
            A[k++] = R[j++];
        }
    }

    /**
     * Ordina l'array di WeightedEdge specificato utilizzando il mergesort.
     *
     * @param <D> la classe degli oggetti nei vertici del grafo
     * @param A   l'array di WeightedEdge da ordinare
     */
    public static <D> void mergesort(WeightedEdge<D>[] A) {
        int n = A.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        WeightedEdge<D>[] L = Arrays.copyOfRange(A, 0, mid);
        WeightedEdge<D>[] R = Arrays.copyOfRange(A, mid, n);

        mergesort(L);
        mergesort(R);

        merge(A, L, R, mid, n - mid);
    }
}
