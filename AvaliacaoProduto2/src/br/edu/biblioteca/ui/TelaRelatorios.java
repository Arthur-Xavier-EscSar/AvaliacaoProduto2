package br.edu.biblioteca.ui;

import br.edu.biblioteca.service.RelatorioService;
import java.util.Scanner;

public class TelaRelatorios {

    public void mostrar(Scanner sc) {
        RelatorioService rel = new RelatorioService();
        int op;
        do {
            System.out.println("\n--- Relatórios ---");
            System.out.println("1. Livros mais emprestados");
            System.out.println("2. Empréstimos em atraso");
            System.out.println("3. Usuários inadimplentes");
            System.out.println("4. Estatísticas mensais");
            System.out.println("0. Voltar");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1: rel.topMaisEmprestados(); break;
                case 2: rel.emAtraso(); break;
                case 3: rel.usuariosComMaisAtrasos(); break;
                case 4: rel.estatisticasMensais(); break;
            }
        } while (op != 0);
    }
}