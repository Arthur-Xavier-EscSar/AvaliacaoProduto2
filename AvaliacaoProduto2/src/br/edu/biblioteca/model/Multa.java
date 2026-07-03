package br.edu.biblioteca.model;

public class Multa {

    private int id;
    private int emprestimoId;
    private double valor;
    private int diasAtraso;
    private boolean quitada;

    public Multa(int id, int emprestimoId, double valor, int diasAtraso) {
        this.id = id;
        this.emprestimoId = emprestimoId;
        this.valor = valor;
        this.diasAtraso = diasAtraso;
        this.quitada = false;
    }

    public int getId() {
        return id;
    }

    public int getEmprestimoId() {
        return emprestimoId;
    }

    public double getValor() {
        return valor;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public boolean isQuitada() {
        return quitada;
    }

    public void quitar() {
        this.quitada = true;
    }
}
