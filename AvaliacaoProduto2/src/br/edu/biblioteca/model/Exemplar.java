package br.edu.biblioteca.model;

public class Exemplar {

    public enum Status {
        DISPONIVEL,
        EMPRESTADO,
        RESERVADO,
        INATIVO
    }

    private int id;
    private String isbnLivro;
    private Status status;

    public Exemplar(int id, String isbnLivro) {
        this.id = id;
        this.isbnLivro = isbnLivro;
        this.status = Status.DISPONIVEL;
    }   
    public int getId() {
        return id;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}