package br.edu.biblioteca.structures;

public class MinhaPilha<T> {

    private Vetor<T> dados;

    public MinhaPilha() {
        dados = new Vetor<>();
    }

    public void push(T valor) {
        dados.add(valor);
    }

    public T pop() {

        if (isEmpty()) {
            return null;
        }

        T valor = dados.get(dados.size() - 1);
        dados.remove(dados.size() - 1);
        return valor;
    }

    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return dados.get(dados.size() - 1);
    }

    public boolean isEmpty() {
        return dados.size() == 0;
    }
}
