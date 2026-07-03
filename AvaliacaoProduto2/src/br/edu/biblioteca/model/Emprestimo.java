package br.edu.biblioteca.model;
import java.time.LocalDate;

public class Emprestimo {

    private int id;
    private int usuarioId;
    private int exemplarId;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;
    public LocalDate dataDevolucao;
    public String status;

    public Emprestimo(int id, int usuarioId, int exemplarId, LocalDate dataEmprestimo, LocalDate dataPrevista) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.exemplarId = exemplarId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
        this.status = "EMPRESTADO";
    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getExemplarId() {
        return exemplarId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void finalizarEmprestimo() {
        this.dataDevolucao = LocalDate.now();
        this.status = "DEVOLVIDO";
    }
}

