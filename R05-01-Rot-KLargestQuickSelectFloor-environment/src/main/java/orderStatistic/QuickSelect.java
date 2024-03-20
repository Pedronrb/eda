package orderStatistic;

import util.Util;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 *
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 *
 * @author adalberto e campelo
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calcular o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado
	 * array de dados comparaveis. Primeiro ele escolhe um elemento como o pivot
	 * e particiona os dados em duas partes, baseando-se no pivot (exatemente da
	 * mesma forma que o quicksort). Depois disso, ele chama recursivamente o
	 * mesmo algoritmo em apenas uma das metades (a que contem o k-esimo menor
	 * elemento). Isso reduz a complexidade de O(n.log n) para O(n).
	 *
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja
	 * fora do tamanho do array, o metodo deve retornar null.
	 *
	 *
	 * @param array
	 *              o array de dados a procurar o k-esimo menor elemento
	 *              este array normalmente nao esta ordenado
	 * @param k
	 *              a ordem do elemento desejado. 1 significa primeiro menor
	 *              elemento, 2 significa segundo menor elemento e assim por
	 *              diante
	 * @return
	 *
	 */

	// Verificacao
	public T quickSelect(T[] array, int k) {
		if (array == null || k < 1 || k > array.length) {
			return null;
		}
		return quickSelect(array, 0, array.length - 1, k);
	}

	// Seleciona o menor elemento recursivamente
	private T quickSelect(T[] array, int left, int right, int k) {
		if (left == right) {
			return array[left];
		}
		// Particiona o array em torno do pivot
		int pivotIndex = partition(array, left, right);
		// Posicao do pivot
		int kthIndex = pivotIndex - left + 1;

		// Compara o pivot com o k
		if (k == kthIndex) {
			return array[pivotIndex];
			// Busca k na parte esquerda do pivot recursivamente
		} else if (k < kthIndex) {
			return quickSelect(array, left, pivotIndex - 1, k);
			// Busca k na parte direita do pivot recursivamente
		} else {
			return quickSelect(array, pivotIndex + 1, right, k - kthIndex);
		}
	}

	// Método para particionar o array em torno de um pivô.
	private int partition(T[] array, int left, int right) {
		// Ultimo elemento sera o pivot
		T pivot = array[right];
		int i = left - 1;
		// Itera sobre o subarray, colocando os elementos menores que o pivô à esquerda
		for (int j = left; j < right; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		// Coloca o pivô em sua posição correta
		Util.swap(array, i + 1, right);
		return i + 1;
	}
}