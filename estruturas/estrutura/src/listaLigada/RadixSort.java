package listaLigada;

public class RadixSort {
    // Método para obter o valor máximo na array
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // Método para fazer a contagem e ordenar a array de acordo com o dígito representado por exp
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // array de saída
        int i;
        int[] count = new int[10];
        java.util.Arrays.fill(count,0);

        // Armazena a contagem de ocorrências
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Muda count[i] para que count[i] agora contenha
        // a posição real desse dígito na array de saída
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Constrói a array de saída
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copia a array de saída para arr[], de modo que arr[] agora
        // contenha os números ordenados de acordo com o dígito atual
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Método principal para o Radix Sort
    static void radixsort(int[] arr, int n) {
        // Encontra o número máximo para saber o número de dígitos
        int m = getMax(arr, n);

        // Faz a contagem para cada dígito. Note que, em vez de passar o número do dígito,
        // exp é passado. exp é 10^i, onde i é o número do dígito atual
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // Método para teste
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
