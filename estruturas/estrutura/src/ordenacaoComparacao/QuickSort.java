package ordenacaoComparacao;

public class QuickSort {
    public static void main(String[] args) {
        int[] vetor = new int[10];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) Math.floor(Math.random() * vetor.length);
        }

        System.out.println("Desordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println(); // Adicionando uma nova linha após a impressão do vetor

        quickSort(vetor, 0, vetor.length - 1); // Chamando a função de ordenação
        
        System.out.println("\n\nOrdenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    static void quickSort(int[] vetor, int left, int right) {
        if (left < right) { //Condição para quando os índices se encontrarem
            int p = partition(vetor, left, right);
            quickSort(vetor, left, p);  //Inicio até o pivot.
            quickSort(vetor, p + 1, right); //Pivot até o final.
        }
    }

    // Método para particionar o vetor
static int partition(int[] vetor, int left, int right) {
    int pivot = vetor[(left + right) / 2];
    int i = left;
    int j = right;

    while (i <= j) {
        // Encontra elemento maior ou igual ao pivot na parte esquerda do vetor
        while (vetor[i] < pivot) {
            i++;
        }
        // Encontra elemento menor ou igual ao pivot na parte direita do vetor
        while (vetor[j] > pivot) {
            j--;
        }
        // Realiza a troca de elementos, se necessário
        if (i <= j) {
            swap(vetor, i, j);
            i++;
            j--;
        }
    }
    return i;
}
    // Método para trocar elementos de posição no vetor
    static void swap(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
