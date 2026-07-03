package br.edu.biblioteca.service;

import br.edu.biblioteca.model.*;
import br.edu.biblioteca.structures.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmprestimoService {

    private Vetor<Emprestimo> emprestimos = new Vetor<>();

    public void emprestarExemplar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void devolverExemplar(int idEmprestimo) {

        for (int i = 0; i < emprestimos.size(); i++) {

            if (emprestimos.get(i).getId() == idEmprestimo) {
                emprestimos.get(i).finalizarEmprestimo();
            }
        }
    }

    public void renovar(int idEmprestimo, int dias) {

        for (int i = 0; i < emprestimos.size(); i++) {

            if (emprestimos.get(i).getId() == idEmprestimo) {

                LocalDate novaData = emprestimos.get(i)
                        .getDataPrevista()
                        .plusDays(dias);

                System.out.println("Nova data prevista: " + novaData);
            }
        }
    }

    public double calcularMulta(Emprestimo emprestimo) {

        if (emprestimo.getDataDevolucao() == null) {
            return 0;
        }

        long dias = ChronoUnit.DAYS.between(
                emprestimo.getDataPrevista(),
                emprestimo.getDataDevolucao());

        if (dias > 0) {
            return dias * 2.5;
        }

        return 0;
    }

    public Emprestimo buscarPorId(int id) {
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo e = emprestimos.get(i);
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    public Vetor<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
