package br.edu.biblioteca.repository;

import br.edu.biblioteca.model.Livro;
import br.edu.biblioteca.structures.Vetor;

import java.util.ArrayList;
import java.util.List;

public class LivroRepository {
    private static final String ARQUIVO = "livros.csv";

    public static Vetor<Livro> carregar() {
        Vetor<Livro> livros = new Vetor<>();
        List<String[]> dados = FileStorage.lerCSV(ARQUIVO);
        for (String[] c : dados) {
            if (c.length >= 6) {
                Livro l = new Livro(c[0], c[1], Integer.parseInt(c[2]), c[3], c[4], c[5]);
                livros.add(l);
            }
        }
        return livros;
    }

    public static void salvar(Vetor<Livro> livros) {
        List<String[]> dados = new ArrayList<>();
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            dados.add(new String[]{
                l.getIsbn(), l.getTitulo(), String.valueOf(l.getAno()),
                l.getCategorias(), l.getAutores(), l.getPalavrasChave()
            });
        }
        FileStorage.escreverCSV(ARQUIVO, dados);
    }
}