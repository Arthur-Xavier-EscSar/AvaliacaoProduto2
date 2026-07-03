package br.edu.biblioteca.structures;

public  class Vetor<T> {

    private Object[] elementos;
    private int size;

    public Vetor() {
        elementos = new Object[10];
        size = 0;
    }

    public void add(T valor) {

        if (size == elementos.length) {
            aumentarCapacidade();
        }

        elementos[size] = valor;
        size++;
    }
    @SuppressWarnings("unchecked")
    public T get(int indice) {
        return (T) elementos[indice];
    }

    public void set(int indice, T valor) {
        elementos[indice] = valor;
    }

    public void remove(int indice) {

        for (int i = indice; i < size - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        size--;
    }

    public int size() {
        return size;
    }

    private void aumentarCapacidade() {

        Object[] novo = new Object[elementos.length * 2];

        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }

        elementos = novo;
    }
}
