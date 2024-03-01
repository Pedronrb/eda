package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (verification(array, leftIndex, rightIndex)) {
			this.SelectionSort(array, leftIndex, rightIndex);
		}
	}

	private void SelectionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			int posMenor = i;
			for (int j = i + 1; j <= rightIndex; j++) {
				if (array[j].compareTo(array[posMenor]) < 0) {
					posMenor = j;
				}
			}
			Util.swap(array, i, posMenor);
			/*
			 * if (posMenor != i) {
			 * aux = array[i];
			 * array[i] = array[posMenor];
			 * array[posMenor] = aux;
			 * }
			 */
		}
	}

	private boolean verification(T[] array, int leftIndex, int rightIndex) {
		boolean status = true;
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			status = false;
		}
		return status;
	}
}
