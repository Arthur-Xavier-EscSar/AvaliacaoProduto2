package br.edu.biblioteca.action;

import br.edu.biblioteca.model.Emprestimo;
import br.edu.biblioteca.model.Exemplar;
import br.edu.biblioteca.service.EmprestimoService;
import br.edu.biblioteca.service.CatalogoService;
import br.edu.biblioteca.service.UsuarioService;

public class AcaoEmpresta implements Acao {
    private EmprestimoService emprestimoService;
    private Emprestimo emprestimo;
    private Exemplar exemplar;

    public AcaoEmpresta(EmprestimoService emprestimoService, CatalogoService catalogoService,
                        UsuarioService usuarioService, Emprestimo emprestimo, Exemplar exemplar) {
        this.emprestimoService = emprestimoService;
        this.emprestimo = emprestimo;
        this.exemplar = exemplar;
    }

    @Override
    public void executar() {
        // Atualiza status do exemplar
        exemplar.setStatus(Exemplar.Status.EMPRESTADO);
        emprestimoService.emprestarExemplar(emprestimo);
    }

    @Override
    public void desfazer() {
        // Devolve o exemplar e remove o empréstimo (simplificado)
        exemplar.setStatus(Exemplar.Status.DISPONIVEL);
        emprestimoService.getEmprestimos().remove(emprestimoService.getEmprestimos().size() - 1);
    }

    @Override
    public String descricao() {
        return "Empréstimo: exemplar " + exemplar.getId() + " para usuário " + emprestimo.getUsuarioId();
    }
}
