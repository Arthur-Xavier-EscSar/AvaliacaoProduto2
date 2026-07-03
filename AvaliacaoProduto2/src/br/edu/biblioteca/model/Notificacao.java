package br.edu.biblioteca.model;
import java.time.LocalDate;

public class Notificacao {

    private int id;
    private int usuarioId;
    private String mensagem;
    private LocalDate data;
    private boolean lida;

    public Notificacao(int id, int usuarioId, String mensagem) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mensagem = mensagem;
        this.data = LocalDate.now();
        this.lida = false;
    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isLida() {
        return lida;
    }

    public void marcarComoLida() {
        this.lida = true;
    }
}