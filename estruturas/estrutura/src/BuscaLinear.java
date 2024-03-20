import java.util.Scanner;

public class BuscaLinear {
    public static void main(String[] args) {
        int [] vetor = new int[8];

        for (int i = 0; i < vetor.length; i++) {
            //casting
            vetor[i] = (int) (Math.random() * 10);
            System.out.println(vetor[i]);
        }

        System.out.println("Qual valor ?");

        Scanner leitor = new Scanner(System.in);
        int buscado = leitor.nextInt();

        boolean achou = false;

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] == buscado){
                achou = true;
                break;
            }
        }
        if(achou == true){
            System.out.println("Achou");
        }else{
            System.out.println("Não achou");
        }
    }
}
