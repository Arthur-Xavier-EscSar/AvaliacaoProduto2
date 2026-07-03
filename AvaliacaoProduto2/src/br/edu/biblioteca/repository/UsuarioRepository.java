package br.edu.biblioteca.repository;

import br.edu.biblioteca.model.Usuario;
import br.edu.biblioteca.structures.Vetor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private static final String ARQUIVO = "usuarios.csv";

    public static Vetor<Usuario> carregar() {
        Vetor<Usuario> usuarios = new Vetor<>();
        List<String[]> dados = FileStorage.lerCSV(ARQUIVO);
        for (String[] c : dados) {
            if (c.length >= 5) {
                Usuario u = new Usuario(Integer.parseInt(c[0]), c[1],
                        Usuario.Tipo.valueOf(c[2]), c[3]);
                u.setBloqueado(Boolean.parseBoolean(c[4]));
                usuarios.add(u);
            }
        }
        return usuarios;
    }

    public static void salvar(Vetor<Usuario> usuarios) {
        List<String[]> dados = new ArrayList<>();
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            dados.add(new String[] {
                    String.valueOf(u.getId()), u.getNome(), u.getTipo().name(),
                    u.getEmail(), String.valueOf(u.isBloqueado())
            });
        }
        FileStorage.escreverCSV(ARQUIVO, dados);
    }
}