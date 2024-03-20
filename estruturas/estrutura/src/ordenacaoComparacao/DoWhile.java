package ordenacaoComparacao;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String resposta;

        do {
            System.out.println("Você gosta de programar? (SIM/NAO)");
            resposta = entrada.nextLine();
        } while (!resposta.equalsIgnoreCase("sim"));
            System.out.println("Então continue");
    }   
}
