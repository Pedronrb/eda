package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de
 * forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados.
 * E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		// Reseta contadores se estiver começando uma nova ordenação
		if (leftIndex == 0 && rightIndex == array.length - 1) {
			MERGESORT_APPLICATIONS = 0;
			INSERTIONSORT_APPLICATIONS = 0;
		}

		if (leftIndex < rightIndex) {
			if (rightIndex - leftIndex <= SIZE_LIMIT) {
				insertionSort(array, leftIndex, rightIndex);
				INSERTIONSORT_APPLICATIONS++;
			} else {
				int middle = leftIndex + (rightIndex - leftIndex) / 2;
				sort(array, leftIndex, middle);
				sort(array, middle + 1, rightIndex);
				merge(array, leftIndex, middle, rightIndex);
				MERGESORT_APPLICATIONS++;
			}
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			T key = array[i];
			int j = i - 1;
			while (j >= leftIndex && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Comparable[rightIndex - leftIndex + 1];
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[i - leftIndex] = array[i];
		}

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (aux[i - leftIndex].compareTo(aux[j - leftIndex]) <= 0) {
				array[k] = aux[i - leftIndex];
				i++;
			} else {
				array[k] = aux[j - leftIndex];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = aux[i - leftIndex];
			i++;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = aux[j - leftIndex];
			j++;
			k++;
		}
	}

	public static int getMergeSortApplications() {
		return MERGESORT_APPLICATIONS;
	}

	public static int getInsertionSortApplications() {
		return INSERTIONSORT_APPLICATIONS;
	}
}
