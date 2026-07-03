package br.edu.biblioteca.structures;

public class NoBST<K extends Comparable<K>, V> {

    K chave;
    V valor;
    NoBST<K, V> esquerda;
    NoBST<K, V> direita;

    public NoBST(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }
}
