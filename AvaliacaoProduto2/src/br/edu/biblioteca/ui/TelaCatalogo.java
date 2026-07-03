package br.edu.biblioteca.ui;

import br.edu.biblioteca.Main;
import br.edu.biblioteca.action.AcaoCadastrarLivro;
import br.edu.biblioteca.action.AcaoRemoverLivro;
import br.edu.biblioteca.model.Exemplar;
import br.edu.biblioteca.model.Livro;
import br.edu.biblioteca.service.CatalogoService;
import br.edu.biblioteca.structures.Vetor;

import java.util.Scanner;

public class TelaCatalogo {

    public void mostrar(Scanner sc) {
        CatalogoService catalogo = Main.catalogoService;
        int op;
        do {
            System.out.println("\n--- Catálogo ---");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar exemplar");
            System.out.println("3. Listar livros");
            System.out.println("4. Remover livro");
            System.out.println("0. Voltar");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("ISBN: "); String isbn = sc.nextLine();
                    System.out.print("Título: "); String titulo = sc.nextLine();
                    System.out.print("Ano: "); int ano = sc.nextInt(); sc.nextLine();
                    System.out.print("Categorias: "); String cat = sc.nextLine();
                    System.out.print("Autores: "); String aut = sc.nextLine();
                    System.out.print("Palavras-chave: "); String pc = sc.nextLine();
                    Livro livro = new Livro(isbn, titulo, ano, cat, aut, pc);
                    AcaoCadastrarLivro acao = new AcaoCadastrarLivro(catalogo, livro);
                    acao.executar();
                    Main.historico.executar(acao);
                    System.out.println("Livro cadastrado.");
                    break;
                case 2:
                    System.out.print("ISBN do livro: "); String isbnEx = sc.nextLine();
                    System.out.print("ID do exemplar: "); int idEx = sc.nextInt(); sc.nextLine();
                    catalogo.cadastrarExemplar(new Exemplar(idEx, isbnEx));
                    System.out.println("Exemplar cadastrado.");
                    break;
                case 3:
                    Vetor<Livro> livros = catalogo.getLivros();
                    if (livros.size() == 0) System.out.println("Nenhum livro.");
                    else for (int i = 0; i < livros.size(); i++) System.out.println(livros.get(i));
                    break;
                case 4:
                    System.out.print("ISBN do livro a remover: "); String isbnRem = sc.nextLine();
                    Livro remov = catalogo.buscar(isbnRem);
                    if (remov != null) {
                        AcaoRemoverLivro acaoRem = new AcaoRemoverLivro(catalogo, remov);
                        acaoRem.executar();
                        Main.historico.executar(acaoRem);
                        System.out.println("Livro removido.");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
            }
        } while (op != 0);
    }
}
