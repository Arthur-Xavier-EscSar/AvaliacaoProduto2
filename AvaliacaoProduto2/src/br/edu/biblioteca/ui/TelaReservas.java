package br.edu.biblioteca.ui;

import br.edu.biblioteca.Main;
import br.edu.biblioteca.model.Reserva;
import br.edu.biblioteca.service.ReservaService;
import br.edu.biblioteca.structures.MinhaFila;

import java.util.Scanner;

public class TelaReservas {

    public void mostrar(Scanner sc) {
        ReservaService service = Main.reservaService;
        int op;
        do {
            System.out.println("\n--- Reservas ---");
            System.out.println("1. Nova reserva");
            System.out.println("2. Listar fila de reservas");
            System.out.println("3. Cancelar reserva");
            System.out.println("0. Voltar");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID da reserva: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("ID do usuário: "); int idUser = sc.nextInt(); sc.nextLine();
                    System.out.print("ISBN do livro: "); String isbn = sc.nextLine();
                    Reserva r = new Reserva(id, idUser, isbn);
                    service.reservarLivro(r);
                    System.out.println("Reserva efetuada.");
                    break;
                case 2:
                    MinhaFila<Reserva> fila = service.getReservas();
                    if (fila.isEmpty()) {
                        System.out.println("Nenhuma reserva.");
                    } else {
                        // não podemos iterar sem perder a fila, faremos uma cópia auxiliar
                        MinhaFila<Reserva> aux = new MinhaFila<>();
                        System.out.println("Reservas na fila:");
                        while (!fila.isEmpty()) {
                            Reserva res = fila.dequeue();
                            System.out.println("Reserva " + res.getId() + " - Usuário: " + res.getUsuarioId() + " - ISBN: " + res.getIsbnLivro());
                            aux.enqueue(res);
                        }
                        while (!aux.isEmpty()) {
                            fila.enqueue(aux.dequeue());
                        }
                    }
                    break;
                case 3:
                    System.out.print("ID da reserva a cancelar: "); int idCanc = sc.nextInt(); sc.nextLine();
                    boolean ok = service.cancelarReserva(idCanc);
                    System.out.println(ok ? "Reserva cancelada." : "Reserva não encontrada.");
                    break;
            }
        } while (op != 0);
    }
}
