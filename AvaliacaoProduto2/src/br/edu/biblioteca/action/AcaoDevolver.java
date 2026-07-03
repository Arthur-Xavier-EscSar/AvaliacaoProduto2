package br.edu.biblioteca.action;

import br.edu.biblioteca.model.Emprestimo;
import br.edu.biblioteca.model.Exemplar;
import br.edu.biblioteca.service.EmprestimoService;
import br.edu.biblioteca.service.CatalogoService;

public class AcaoDevolver implements Acao {
    private EmprestimoService emprestimoService;
    private CatalogoService catalogoService;
    private int idEmprestimo;
    private int exemplarId;
    private Exemplar.Status statusAnterior;

    public AcaoDevolver(EmprestimoService emprestimoService, CatalogoService catalogoService,
                        int idEmprestimo, int exemplarId) {
        this.emprestimoService = emprestimoService;
        this.catalogoService = catalogoService;
        this.idEmprestimo = idEmprestimo;
        this.exemplarId = exemplarId;
    }

    @Override
    public void executar() {
        Emprestimo emp = emprestimoService.buscarPorId(idEmprestimo);
        if (emp != null) {
            emp.finalizarEmprestimo();
            // Busca o exemplar e atualiza status
            Exemplar ex = catalogoService.getExemplares().get(exemplarId);
            statusAnterior = ex.getStatus();
            ex.setStatus(Exemplar.Status.DISPONIVEL);
        }
    }

    @Override
    public void desfazer() {
        Emprestimo emp = emprestimoService.buscarPorId(idEmprestimo);
        if (emp != null) {
            // Reabre o empréstimo (simplificado)
            emp.status = "EMPRESTADO";
            Exemplar ex = catalogoService.getExemplares().get(exemplarId);
            ex.setStatus(statusAnterior);
        }
    }

    @Override
    public String descricao() {
        return "Devolução do empréstimo " + idEmprestimo;
    }
}
