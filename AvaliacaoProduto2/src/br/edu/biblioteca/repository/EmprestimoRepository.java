package br.edu.biblioteca.repository;

import br.edu.biblioteca.model.Emprestimo;
import br.edu.biblioteca.structures.Vetor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {
    private static final String ARQUIVO = "emprestimos.csv";

    public static Vetor<Emprestimo> carregar() {
        Vetor<Emprestimo> emprestimos = new Vetor<>();
        List<String[]> dados = FileStorage.lerCSV(ARQUIVO);
        for (String[] c : dados) {
            if (c.length >= 6) {
                Emprestimo e = new Emprestimo(Integer.parseInt(c[0]),
                        Integer.parseInt(c[1]), Integer.parseInt(c[2]),
                        LocalDate.parse(c[3]), LocalDate.parse(c[4]));
                if (!c[5].equals("null")) {
                    e.dataDevolucao = LocalDate.parse(c[5]);
                }
                e.status = c[6];
                emprestimos.add(e);
            }
        }
        return emprestimos;
    }

    public static void salvar(Vetor<Emprestimo> emprestimos) {
        List<String[]> dados = new ArrayList<>();
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo e = emprestimos.get(i);
            dados.add(new String[] {
                    String.valueOf(e.getId()), String.valueOf(e.getUsuarioId()),
                    String.valueOf(e.getExemplarId()), e.getDataEmprestimo().toString(),
                    e.getDataPrevista().toString(),
                    e.getDataDevolucao() != null ? e.getDataDevolucao().toString() : "null",
                    e.getStatus()
            });
        }
        FileStorage.escreverCSV(ARQUIVO, dados);
    }
}