package br.edu.biblioteca.repository;

import br.edu.biblioteca.model.Reserva;
import br.edu.biblioteca.structures.Vetor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private static final String ARQUIVO = "reservas.csv";

    public static Vetor<Reserva> carregarTodas() {
        Vetor<Reserva> reservas = new Vetor<>();
        List<String[]> dados = FileStorage.lerCSV(ARQUIVO);
        for (String[] c : dados) {
            if (c.length >= 4) {
                Reserva r = new Reserva(Integer.parseInt(c[0]),
                        Integer.parseInt(c[1]), c[2]);
                r.dataReserva = LocalDate.parse(c[3]);
                r.status = c[4];
                reservas.add(r);
            }
        }
        return reservas;
    }

    public static void salvar(Vetor<Reserva> reservas) {
        List<String[]> dados = new ArrayList<>();
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            dados.add(new String[] {
                    String.valueOf(r.getId()), String.valueOf(r.getUsuarioId()),
                    r.getIsbnLivro(), r.getDataReserva().toString(), r.getStatus()
            });
        }
        FileStorage.escreverCSV(ARQUIVO, dados);
    }
}