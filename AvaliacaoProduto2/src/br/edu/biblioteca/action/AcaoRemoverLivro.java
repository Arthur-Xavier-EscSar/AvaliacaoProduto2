package br.edu.biblioteca.action;

import br.edu.biblioteca.model.Livro;
import br.edu.biblioteca.service.CatalogoService;

public class AcaoRemoverLivro implements Acao {
    private CatalogoService catalogo;
    private Livro livroRemovido;

    public AcaoRemoverLivro(CatalogoService catalogo, Livro livro) {
        this.catalogo = catalogo;
        this.livroRemovido = livro;
    }

    @Override
    public void executar() {
        catalogo.remover(livroRemovido.getIsbn());
    }

    @Override
    public void desfazer() {
        catalogo.cadastrarLivro(livroRemovido);
    }

    @Override
    public String descricao() {
        return "Remover livro: " + livroRemovido.getTitulo();
    }
}
