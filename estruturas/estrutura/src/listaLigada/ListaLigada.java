package listaLigada;
/*
 * A lista é uma estrutura onde a posição do subjacente está linkada com a anteriror.
 * Diferente do vetor (array) onde ele tem acesso direto.
 */

public class ListaLigada {
        private Elemento primeiro;
        private Elemento ultimo;
        private int tamanho;

        public ListaLigada() {
            this.tamanho = 0;
        }

        public void adicionar( String novoValor){
            Elemento novoElemento = new Elemento(novoValor);

            if(this.primeiro == null && this.ultimo == null){
                this.primeiro = novoElemento;
                this.ultimo = novoElemento;
                
            }else{
                this.ultimo.setProximo(novoElemento);
                this.ultimo = novoElemento;
            }
            this.tamanho++;
        }
        
        public void remover(String valorProcurado) {
            Elemento anterior = null;
            Elemento atual = this.primeiro;
            while (atual != null) {
                if (atual.getValor().equalsIgnoreCase(valorProcurado)) {
                    if (this.tamanho == 1) {
                        this.primeiro = null;
                        this.ultimo = null;
                    } else if (atual == this.primeiro) {
                        this.primeiro = atual.getProximo();
                        atual.setProximo(null);
                    } else if (atual == this.ultimo) {
                        this.ultimo = anterior;
                        anterior.setProximo(null);
                    } else {
                        anterior.setProximo(atual.getProximo());
                        atual.setProximo(null);
                    }
                    this.tamanho--;
                    break;
                }
                anterior = atual;
                atual = atual.getProximo();
            }
        }
        
        public Elemento get(int posicao){
            Elemento atual = this.primeiro;
            for(int i=0;  i < posicao; i++){
                if(atual.getProximo() != null){
                    atual = atual.getProximo();
                }
            }
            return atual;
        }

        public Elemento getPrimeiro() {
            return primeiro;
        }
        public void setPrimeiro(Elemento primeiro) {
            this.primeiro = primeiro;
        }
        public Elemento getUltimo() {
            return ultimo;
        }
        public void setUltimo(Elemento ultimo) {
            this.ultimo = ultimo;
        }
        public int getTamanho() {
            return tamanho;
        }
        public void setTamanho(int tamanho) {
            this.tamanho = tamanho;
        }

        

}

