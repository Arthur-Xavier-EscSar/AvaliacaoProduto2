package br.edu.biblioteca.action;

import br.edu.biblioteca.model.Reserva;
import br.edu.biblioteca.service.ReservaService;

public class AcaoReservar implements Acao {
    private ReservaService reservaService;
    private Reserva reserva;

    public AcaoReservar(ReservaService reservaService, Reserva reserva) {
        this.reservaService = reservaService;
        this.reserva = reserva;
    }

    @Override
    public void executar() {
        reservaService.reservarLivro(reserva);
    }

    @Override
    public void desfazer() {
        reservaService.cancelarReserva(reserva.getId());
    }

    @Override
    public String descricao() {
        return "Reserva: usuário " + reserva.getUsuarioId() + " para ISBN " + reserva.getIsbnLivro();
    }
}
