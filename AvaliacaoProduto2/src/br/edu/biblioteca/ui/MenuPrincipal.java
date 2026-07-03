package br.edu.biblioteca.ui;
import br.edu.biblioteca.Historico;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner sc = new Scanner(System.in);
    private TelaCatalogo telaCatalogo;
    private TelaUsuarios telaUsuarios;
    private TelaEmprestimos telaEmprestimos;
    private TelaReservas telaReservas;
    private TelaRelatorios telaRelatorios;
    private Historico historico = new Historico();

    public MenuPrincipal() {
        // Os serviços e histórico serão compartilhados via uma classe Context (ou Main)
        telaCatalogo = new TelaCatalogo();
        telaUsuarios = new TelaUsuarios();
        telaEmprestimos = new TelaEmprestimos();
        telaReservas = new TelaReservas();
        telaRelatorios = new TelaRelatorios();
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("\n==== SISTEMA BIBLIOTECA ====");
            System.out.println("1. Catálogo");
            System.out.println("2. Usuários");
            System.out.println("3. Empréstimos");
            System.out.println("4. Reservas");
            System.out.println("5. Relatórios");
            System.out.println("6. Desfazer última ação");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: telaCatalogo.mostrar(sc); break;
                case 2: telaUsuarios.mostrar(sc); break;
                case 3: telaEmprestimos.mostrar(sc); break;
                case 4: telaReservas.mostrar(sc); break;
                case 5: telaRelatorios.mostrar(sc); break;
                case 6: historico.desfazer(); break;
            }
        } while (opcao != 0);
    }
}
