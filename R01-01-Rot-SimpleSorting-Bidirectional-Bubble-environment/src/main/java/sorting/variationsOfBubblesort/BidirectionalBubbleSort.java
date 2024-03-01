package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (verification(array, leftIndex, rightIndex)) {
			this.BidirectionalBubbleSort(array, leftIndex, rightIndex);
		}
	}

	private void BidirectionalBubbleSort(T[] array, int leftIndex, int rightIndex) {
		boolean swapped = true;

		while (swapped) {
			swapped = false;

			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					Util.swap(array, i, i + 1);
					swapped = true;
				}
			}
			for (int j = rightIndex; j > leftIndex; j--) {
				if (array[j].compareTo(array[j - 1]) < 0) {
					Util.swap(array, j, j - 1);
					swapped = true;
				}
			}
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
