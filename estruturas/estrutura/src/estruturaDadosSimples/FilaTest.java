package estruturaDadosSimples;
import estruturaDadosSimples.Fila;
public class FilaTest {

    @Test
    public void testeEnfileirarEDesenfileirar() {
        Fila fila = new Fila(5);
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);

        assertEquals(10, fila.desenfileirar());
        assertEquals(20, fila.desenfileirar());
        assertEquals(30, fila.desenfileirar());
    }

    private void assertEquals(int i, int desenfileirar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    public void testeFilaVazia() {
        Fila fila = new Fila(5);
        assertTrue(fila.estaVazia());
    }

    private void assertTrue(boolean estaVazia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }

    @Test
    public void testeFilaCheia() {
        Fila fila = new Fila(3);
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        assertTrue(fila.estaCheia());
    }
}