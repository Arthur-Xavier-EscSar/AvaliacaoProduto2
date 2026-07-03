package br.edu.biblioteca.ui;

import br.edu.biblioteca.Main;
import br.edu.biblioteca.model.Usuario;
import br.edu.biblioteca.service.UsuarioService;
import br.edu.biblioteca.structures.Vetor;

import java.util.Scanner;

public class TelaUsuarios {

    public void mostrar(Scanner sc) {
        UsuarioService service = Main.usuarioService;
        int op;
        do {
            System.out.println("\n--- Usuários ---");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Bloquear/Desbloquear");
            System.out.println("0. Voltar");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Tipo (ALUNO, PROFESSOR, SERVIDOR): ");
                    String tipoStr = sc.nextLine();
                    Usuario.Tipo tipo = Usuario.Tipo.valueOf(tipoStr.toUpperCase());
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    Usuario u = new Usuario(id, nome, tipo, email);
                    service.cadastrarUsuario(u);
                    System.out.println("Usuário cadastrado.");
                    break;
                case 2:
                    Vetor<Usuario> usuarios = service.getUsuarios();
                    if (usuarios.size() == 0)
                        System.out.println("Nenhum usuário.");
                    else
                        for (int i = 0; i < usuarios.size(); i++)
                            System.out.println(usuarios.get(i).getId() + " - " + usuarios.get(i).getNome());
                    break;
                case 3:
                    System.out.print("ID do usuário: ");
                    int idUser = sc.nextInt();
                    sc.nextLine();
                    Usuario user = service.buscarPorId(idUser);
                    if (user != null) {
                        user.setBloqueado(!user.isBloqueado());
                        System.out.println("Usuário " + (user.isBloqueado() ? "bloqueado" : "desbloqueado"));
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
            }
        } while (op != 0);
    }
}