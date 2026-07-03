package br.edu.biblioteca.model;
import java.time.LocalDate;

public class Reserva {

    private int id;
    private int usuarioId;
    private String isbnLivro;
    public LocalDate dataReserva;
    public String status;

    public Reserva(int id, int usuarioId, String isbnLivro) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.isbnLivro = isbnLivro;
        this.dataReserva = LocalDate.now();
        this.status = "RESERVADO";
    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public String getStatus() {
        return status;
    }
}

