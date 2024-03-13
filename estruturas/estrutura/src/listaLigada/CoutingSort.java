package listaLigada;

public class CoutingSort {

    void sort(int arr[]) {
        int n = arr.length;

        // O array de saída que terá os números ordenados
        int output[] = new int[n];

        // O array de contagem para armazenar a contagem de cada número
        int count[] = new int[getMax(arr) + 1];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        // Armazena a contagem de cada número
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Altera count[i] para que count[i] agora contenha a posição atual deste número na saída
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copia o array de saída para arr, para que arr agora contenha os números ordenados
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Função auxiliar para obter o valor máximo no arr[]
    int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Método para teste
    public static void main(String args[]) {
        CoutingSort ob = new CoutingSort();
        int arr[] = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Array original:");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        ob.sort(arr);

        System.out.println("\nArray ordenado:");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}
