package br.edu.biblioteca.model;

public class Livro {

    private String isbn;
    private String titulo;
    private int ano;
    private String categorias;
    private String autores;
    private String palavrasChave;

    public Livro(String isbn, String titulo, int ano, String categorias, String autores, String palavrasChave) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        this.categorias = categorias;
        this.autores = autores;
        this.palavrasChave = palavrasChave;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getCategorias() {
        return categorias;
    }

    public String getAutores() {
        return autores;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    @Override
    public String toString() {
        return titulo + " - " + isbn;
    }
}
