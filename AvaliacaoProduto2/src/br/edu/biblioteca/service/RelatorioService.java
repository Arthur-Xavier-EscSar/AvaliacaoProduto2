package br.edu.biblioteca.service;
import br.edu.biblioteca.model.*;
import br.edu.biblioteca.structures.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class RelatorioService {

    public void topMaisEmprestados() {
        System.out.println("Relatório de livros mais emprestados");
    }

    public void emAtraso() {
        System.out.println("Relatório de empréstimos em atraso");
    }

    public void usuariosComMaisAtrasos() {
        System.out.println("Relatório de usuários inadimplentes");
    }

    public void estatisticasMensais() {

        MatrizInt estatisticas = new MatrizInt(12, 5);
        estatisticas.set(0, 0, 20);

        System.out.println("Total do mês: " + estatisticas.get(0, 0));
    }
}
