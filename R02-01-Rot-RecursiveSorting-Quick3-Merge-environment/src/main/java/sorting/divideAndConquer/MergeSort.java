package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		} else {

			int meio = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, rightIndex);
			sort(array, meio + 1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
		}

	}

	/*
	 * public void merge(int[] array, int leftIndex, int middle, int rightIndex) {
	 * int[] aux = new int[array.length];
	 * 
	 * for (int i = leftIndex; i <= rightIndex; i++) {
	 * aux[i] = array[i];
	 * }
	 * 
	 * int i = leftIndex;
	 * int j = (leftIndex + rightIndex) / 2;
	 * int k = leftIndex;
	 * 
	 * while (i <= j && j <= rightIndex) {
	 * 
	 * if (aux[i] <= aux[j]) {
	 * array[k] = aux[i];
	 * i++;
	 * } else {
	 * array[k] = aux[j];
	 * j++;
	 * }
	 * k++;
	 * 
	 * }
	 * // Caso um dos arrays acabem primeiro, append
	 * while (i <= j) {
	 * array[k] = aux[i];
	 * i++;
	 * k++;
	 * }
	 * }
	 */

}
