package br.edu.biblioteca.action;

import br.edu.biblioteca.model.Livro;
import br.edu.biblioteca.service.CatalogoService;

public class AcaoCadastrarLivro implements Acao {
    private CatalogoService catalogo;
    private Livro livro;

    public AcaoCadastrarLivro(CatalogoService catalogo, Livro livro) {
        this.catalogo = catalogo;
        this.livro = livro;
    }

    @Override
    public void executar() {
        catalogo.cadastrarLivro(livro);
    }

    @Override
    public void desfazer() {
        catalogo.remover(livro.getIsbn());
    }

    @Override
    public String descricao() {
        return "Cadastrar livro: " + livro.getTitulo() + " (ISBN " + livro.getIsbn() + ")";
    }
}
