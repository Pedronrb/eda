package estruturaDadosSimples;

public class Fila {
   private int[] fila;
   private int capacidade;
   private int tamanho;
   private int inicio;
   private int fim;

   public Fila(int capacidade) {
    this.capacidade = capacidade;
    fila = new int[capacidade];
    tamanho = 0;
    inicio = 0;
    fim = -1;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public boolean estaCheia(){
        return tamanho == capacidade;
    }

    public void enfileirar(int elemento){
        if(!estaCheia()){
            fim = (fim + 1) % capacidade;
            fila[fim] = elemento;
            tamanho ++;
        }else{
            System.out.println("A fila está cheia");
        }

    }

    public int desenfileirar(){
        if (!estaVazia()) {
            int elemento = fila[inicio];
            // é usada para garantir que, quando o índice de início da fila alcançar o final do array, ele volte para o início. 
            //Isso é necessário para que a fila possa continuar a funcionar corretamente como uma estrutura circula
            inicio = (inicio + 1) % capacidade;
            tamanho --;
            return elemento;
        }else{
            System.out.println("A fila está cheia");
            return - 1;
        }
    }

    public int primeiro(){
        if (!estaVazia()) {
            return fila[inicio];
        }
        else{
            System.out.println("A fila está vazia");
            return - 1;
        }
    }

  

}
