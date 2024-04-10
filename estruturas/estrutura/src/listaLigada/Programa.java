package listaLigada;

public class Programa {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.adicionar("AC");
        lista.adicionar("BA");
        lista.adicionar("PB");
        lista.adicionar("CE");
        System.out.println("Tamanho " + lista.getTamanho());
        System.out.println("Primeiro " + lista.getPrimeiro().getValor()); //Existe a bola e dentro da bola há o elemento (valor)
        System.out.println("Ultimo " + lista.getUltimo().getValor());
    

        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.println(lista.get(i).getValor());
        }

        //remover elemento
        System.out.println("Removeu");
        lista.remover("pb");
        lista.remover("ac");
        lista.remover("ba");


        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.println(lista.get(i).getValor());
        }
        
    }

}
