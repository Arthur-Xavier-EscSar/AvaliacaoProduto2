package br.edu.biblioteca.structures;

public class MatrizInt {

    private int[][] matriz;

    public MatrizInt(int linhas, int colunas) {
        matriz = new int[linhas][colunas];
    }

    public void set(int linha, int coluna, int valor) {
        matriz[linha][coluna] = valor;
    }

    public int get(int linha, int coluna) {
        return matriz[linha][coluna];
    }
}
