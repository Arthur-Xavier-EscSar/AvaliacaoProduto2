package br.edu.biblioteca;

import br.edu.biblioteca.action.Acao;
import br.edu.biblioteca.structures.MinhaPilha;

public class Historico {
    private MinhaPilha<Acao> desfazer = new MinhaPilha<>();

    public void executar(Acao acao) {
        acao.executar();
        desfazer.push(acao);
    }

    public void desfazer() {
        if (!desfazer.isEmpty()) {
            Acao ultima = desfazer.pop();
            ultima.desfazer();
            System.out.println("Desfeito: " + ultima.descricao());
        } else {
            System.out.println("Nada a desfazer.");
        }
    }
}