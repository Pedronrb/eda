package tempoLinear;


import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    // Método para Bucket Sort
    public static void bucketSort(int[] arr) {
        int n = arr.length;
        int maxVal = getMaxValue(arr);
        int numOfBuckets = maxVal / 10 + 1;

        // Criação dos baldes
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Adiciona elementos nos baldes
        for (int num : arr) {
            int bucketIndex = num / 10;
            buckets[bucketIndex].add(num);
        }

        // Ordena os elementos em cada balde (usando Collections.sort para simplicidade)
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatena os baldes ordenados
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Método auxiliar para obter o valor máximo no array
    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Método para teste
    public static void main(String[] args) {
        int[] arr = {29, 5, 14, 85, 42, 38, 92, 71, 3, 51};
        System.out.println("Array original:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }

    // Método auxiliar para impressão do array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
