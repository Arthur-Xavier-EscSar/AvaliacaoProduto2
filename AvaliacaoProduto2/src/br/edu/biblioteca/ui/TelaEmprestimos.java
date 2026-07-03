package br.edu.biblioteca.ui;

import br.edu.biblioteca.Main;
import br.edu.biblioteca.action.AcaoEmpresta;
import br.edu.biblioteca.action.AcaoDevolver;
import br.edu.biblioteca.model.Emprestimo;
import br.edu.biblioteca.model.Exemplar;
import br.edu.biblioteca.model.Usuario;
import br.edu.biblioteca.service.CatalogoService;
import br.edu.biblioteca.service.EmprestimoService;
import br.edu.biblioteca.service.UsuarioService;

import java.time.LocalDate;
import java.util.Scanner;

public class TelaEmprestimos {
    public void mostrar(Scanner sc) {
        EmprestimoService empService = Main.emprestimoService;
        CatalogoService catService = Main.catalogoService;
        UsuarioService userService = Main.usuarioService;
        int op;
        do {
            System.out.println("\n--- Empréstimos ---");
            System.out.println("1. Realizar empréstimo");
            System.out.println("2. Devolver exemplar");
            System.out.println("3. Listar empréstimos ativos");
            System.out.println("0. Voltar");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID do usuário: ");
                    int idUser = sc.nextInt();
                    sc.nextLine();
                    Usuario user = userService.buscarPorId(idUser);
                    if (user == null || user.isBloqueado()) {
                        System.out.println("Usuário inválido ou bloqueado.");
                        break;
                    }
                    System.out.print("ISBN do livro: ");
                    String isbn = sc.nextLine();
                    Exemplar ex = catService.getExemplarDisponivel(isbn);
                    if (ex == null) {
                        System.out.println("Nenhum exemplar disponível.");
                        break;
                    }
                    int dias = (user.getTipo() == Usuario.Tipo.PROFESSOR) ? 30 : 15;
                    Emprestimo emp = new Emprestimo(
                            empService.getEmprestimos().size() + 1, idUser, ex.getId(),
                            LocalDate.now(), LocalDate.now().plusDays(dias));
                    AcaoEmpresta acao = new AcaoEmpresta(empService, catService, userService, emp, ex);
                    acao.executar();
                    Main.historico.executar(acao);
                    System.out.println("Empréstimo registrado. Devolução em " + emp.getDataPrevista());
                    break;
                case 2:
                    System.out.print("ID do empréstimo: ");
                    int idEmp = sc.nextInt();
                    sc.nextLine();
                    Emprestimo e = empService.buscarPorId(idEmp);
                    if (e == null || e.getStatus().equals("DEVOLVIDO")) {
                        System.out.println("Empréstimo não encontrado ou já devolvido.");
                        break;
                    }
                    AcaoDevolver acaoDev = new AcaoDevolver(empService, catService, idEmp, e.getExemplarId());
                    acaoDev.executar();
                    Main.historico.executar(acaoDev);
                    double multa = empService.calcularMulta(e);
                    System.out.println("Devolvido. Multa: R$ " + multa);
                    break;
                case 3:
                    for (int i = 0; i < empService.getEmprestimos().size(); i++) {
                        Emprestimo em = empService.getEmprestimos().get(i);
                        if (em.getStatus().equals("EMPRESTADO"))
                            System.out.println("ID: " + em.getId() + " - Usuário: " + em.getUsuarioId() +
                                    " - Exemplar: " + em.getExemplarId() + " - Devolução: " + em.getDataPrevista());
                    }
                    break;
            }
        } while (op != 0);
    }
}