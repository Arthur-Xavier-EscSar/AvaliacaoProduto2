package br.edu.biblioteca.structures;

public class MinhaFila<T> {

    private Vetor<T> dados;

    public MinhaFila() {
        dados = new Vetor<>();
    }

    public void enqueue(T valor) {
        dados.add(valor);
    }

    public T dequeue() {

        if (isEmpty()) {
            return null;
        }

        T valor = dados.get(0);
        dados.remove(0);
        return valor;
    }

    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return dados.get(0);
    }

    public boolean isEmpty() {
        return dados.size() == 0;
    }
}
