package br.edu.biblioteca.repository;

import br.edu.biblioteca.model.Exemplar;
import br.edu.biblioteca.structures.Vetor;

import java.util.ArrayList;
import java.util.List;

public class ExemplarRepository {
    private static final String ARQUIVO = "exemplares.csv";

    public static Vetor<Exemplar> carregar() {
        Vetor<Exemplar> exemplares = new Vetor<>();
        List<String[]> dados = FileStorage.lerCSV(ARQUIVO);
        for (String[] c : dados) {
            if (c.length >= 3) {
                Exemplar e = new Exemplar(Integer.parseInt(c[0]), c[1]);
                e.setStatus(Exemplar.Status.valueOf(c[2]));
                exemplares.add(e);
            }
        }
        return exemplares;
    }

    public static void salvar(Vetor<Exemplar> exemplares) {
        List<String[]> dados = new ArrayList<>();
        for (int i = 0; i < exemplares.size(); i++) {
            Exemplar e = exemplares.get(i);
            dados.add(new String[] {
                    String.valueOf(e.getId()), e.getIsbnLivro(), e.getStatus().name()
            });
        }
        FileStorage.escreverCSV(ARQUIVO, dados);
    }
}
