package br.edu.biblioteca.service;

import br.edu.biblioteca.model.*;
import br.edu.biblioteca.structures.*;


public class CatalogoService {

    private Vetor<Livro> livros = new Vetor<>();
    private Vetor<Exemplar> exemplares = new Vetor<>();
    private ArvoreBST<String, Livro> indiceLivros = new ArvoreBST<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        indiceLivros.put(livro.getIsbn(), livro);
    }

    public void cadastrarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public void remover(String isbn) {

        for (int i = 0; i < livros.size(); i++) {

            if (livros.get(i).getIsbn().equals(isbn)) {
                livros.remove(i);
                break;
            }
        }
    }

    public Livro buscar(String isbn) {
        return indiceLivros.get(isbn);
    }

    public void listar() {

        for (int i = 0; i < livros.size(); i++) {
            System.out.println(livros.get(i));
        }
    }

    public Vetor<Livro> getLivros() {
        return livros;
    }

    public Vetor<Exemplar> getExemplares() {
        return exemplares;
    }

    // Retorna exemplar disponível para um ISBN (útil para empréstimo)
    public Exemplar getExemplarDisponivel(String isbn) {
        for (int i = 0; i < exemplares.size(); i++) {
            Exemplar e = exemplares.get(i);
            if (e.getIsbnLivro().equals(isbn) && e.getStatus() == Exemplar.Status.DISPONIVEL) {
                return e;
            }
        }
        return null;
    }
}
