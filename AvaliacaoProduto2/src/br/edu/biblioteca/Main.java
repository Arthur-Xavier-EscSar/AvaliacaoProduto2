package br.edu.biblioteca;

import br.edu.biblioteca.model.*;
import br.edu.biblioteca.service.*;
import br.edu.biblioteca.repository.*;
import br.edu.biblioteca.structures.*;
import br.edu.biblioteca.ui.MenuPrincipal;

public class Main {
    public static CatalogoService catalogoService;
    public static UsuarioService usuarioService;
    public static EmprestimoService emprestimoService;
    public static ReservaService reservaService;
    public static Historico historico;

    public static void main(String[] args) {
        // Inicializa serviços
        catalogoService = new CatalogoService();
        usuarioService = new UsuarioService();
        emprestimoService = new EmprestimoService();
        reservaService = new ReservaService();
        historico = new Historico();

        // Carrega dados dos arquivos CSV
        Vetor<Livro> livrosCarregados = LivroRepository.carregar();
        for (int i = 0; i < livrosCarregados.size(); i++) {
            catalogoService.cadastrarLivro(livrosCarregados.get(i));
        }

        Vetor<Exemplar> exemplaresCarregados = ExemplarRepository.carregar();
        for (int i = 0; i < exemplaresCarregados.size(); i++) {
            catalogoService.cadastrarExemplar(exemplaresCarregados.get(i));
        }

        Vetor<Usuario> usuariosCarregados = UsuarioRepository.carregar();
        for (int i = 0; i < usuariosCarregados.size(); i++) {
            usuarioService.cadastrarUsuario(usuariosCarregados.get(i));
        }

        Vetor<Emprestimo> emprestimosCarregados = EmprestimoRepository.carregar();
        for (int i = 0; i < emprestimosCarregados.size(); i++) {
            emprestimoService.emprestarExemplar(emprestimosCarregados.get(i));
        }

        // Reservas são carregadas na fila
        Vetor<Reserva> resCarregadas = ReservaRepository.carregarTodas();
        for (int i = 0; i < resCarregadas.size(); i++) {
            reservaService.reservarLivro(resCarregadas.get(i));
        }

        // Menu principal
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibir();

        // Salva dados antes de sair
        LivroRepository.salvar(catalogoService.getLivros());
        ExemplarRepository.salvar(catalogoService.getExemplares());
        UsuarioRepository.salvar(usuarioService.getUsuarios());
        EmprestimoRepository.salvar(emprestimoService.getEmprestimos());

        // Converte a fila de reservas para Vetor e salva
        MinhaFila<Reserva> filaReservas = reservaService.getReservas();
        Vetor<Reserva> resParaSalvar = new Vetor<>();
        while (!filaReservas.isEmpty()) {
            resParaSalvar.add(filaReservas.dequeue());
        }
        ReservaRepository.salvar(resParaSalvar);

        System.out.println("Dados salvos. Encerrando...");
    }
}