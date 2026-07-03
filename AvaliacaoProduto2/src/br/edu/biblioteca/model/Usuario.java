package br.edu.biblioteca.model;

public class Usuario {

    public enum Tipo {
        ALUNO,
        PROFESSOR,
        SERVIDOR
    }

    private int id;
    private String nome;
    private Tipo tipo;
    private String email;
    private boolean bloqueado;

    public Usuario(int id, String nome, Tipo tipo, String email) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.bloqueado = false;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getEmail() {
        return email;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}

