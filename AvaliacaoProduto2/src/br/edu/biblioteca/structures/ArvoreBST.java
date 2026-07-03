package br.edu.biblioteca.structures;

public class ArvoreBST<K extends Comparable<K>, V> {

    private NoBST<K, V> raiz;

    public void put(K chave, V valor) {
        raiz = inserir(raiz, chave, valor);
    }

    private NoBST<K, V> inserir(NoBST<K, V> no, K chave, V valor) {

        if (no == null) {
            return new NoBST<>(chave, valor);
        }

        if (chave.compareTo(no.chave) < 0) {
            no.esquerda = inserir(no.esquerda, chave, valor);
        } else if (chave.compareTo(no.chave) > 0) {
            no.direita = inserir(no.direita, chave, valor);
        }

        return no;
    }

    public V get(K chave) {
        return buscar(raiz, chave);
    }

    private V buscar(NoBST<K, V> no, K chave) {

        if (no == null) {
            return null;
        }

        if (chave.equals(no.chave)) {
            return no.valor;
        }

        if (chave.compareTo(no.chave) < 0) {
            return buscar(no.esquerda, chave);
        }

        return buscar(no.direita, chave);
    }

    public void inOrder() {
        exibir(raiz);
    }

    private void exibir(NoBST<K, V> no) {

        if (no != null) {
            exibir(no.esquerda);
            System.out.println(no.chave);
            exibir(no.direita);
        }
    }
}