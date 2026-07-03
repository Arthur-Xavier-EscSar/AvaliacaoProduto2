package br.edu.biblioteca.service;

import br.edu.biblioteca.model.Reserva;
import br.edu.biblioteca.structures.*;





public class ReservaService {

    private MinhaFila<Reserva> reservas = new MinhaFila<>();

    public void reservarLivro(Reserva reserva) {
        reservas.enqueue(reserva);
    }

    public void cancelarReserva() {
        reservas.dequeue();
    }

    public Reserva atenderProximaReserva(String isbn) {

        if (!reservas.isEmpty()) {
            return reservas.dequeue();
        }

        return null;
    }

    public MinhaFila<Reserva> getReservas() {
        return reservas;
    }

    // Remove uma reserva específica (para cancelar)
    public boolean cancelarReserva(int idReserva) {
        // A fila simples não permite remoção arbitrária; usaremos uma lista auxiliar.
        MinhaFila<Reserva> nova = new MinhaFila<>();
        boolean removida = false;
        while (!reservas.isEmpty()) {
            Reserva r = reservas.dequeue();
            if (r.getId() == idReserva && !removida) {
                removida = true;
                // não reinsere
            } else {
                nova.enqueue(r);
            }
        }
        reservas = nova;
        return removida;
    }
}
