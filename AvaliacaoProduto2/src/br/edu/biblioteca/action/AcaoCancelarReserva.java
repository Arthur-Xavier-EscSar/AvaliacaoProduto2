package br.edu.biblioteca.action;

import br.edu.biblioteca.model.Reserva;
import br.edu.biblioteca.service.ReservaService;

public class AcaoCancelarReserva implements Acao {
    private ReservaService reservaService;
    private Reserva reserva;

    public AcaoCancelarReserva(ReservaService reservaService, Reserva reserva) {
        this.reservaService = reservaService;
        this.reserva = reserva;
    }

    @Override
    public void executar() {
        reservaService.cancelarReserva(reserva.getId());
    }

    @Override
    public void desfazer() {
        reservaService.reservarLivro(reserva);
    }

    @Override
    public String descricao() {
        return "Cancelar reserva " + reserva.getId();
    }
}