package listaLigada;


public class Elemento {
    private String valor;
    private Elemento proximo;

    public Elemento(String novoValor){
        this.valor = novoValor;
    }
    
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public Elemento getProximo() {
        return proximo;
    }
    public Elemento setProximo(Elemento proximo) {
        return this.proximo = proximo;
    }

}
