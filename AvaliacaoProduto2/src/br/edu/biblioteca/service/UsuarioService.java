package br.edu.biblioteca.service;

import br.edu.biblioteca.model.*;
import br.edu.biblioteca.structures.*;



public class UsuarioService {

    private Vetor<Usuario> usuarios = new Vetor<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void bloquear(int id) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getId() == id) {
                usuarios.get(i).setBloqueado(true);
            }
        }
    }

    public void desbloquear(int id) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getId() == id) {
                usuarios.get(i).setBloqueado(false);
            }
        }
    }

    public void listar() {

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getNome());
        }
    }

    public Usuario buscarPorId(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getId() == id)
                return u;
        }
        return null;
    }

    public Vetor<Usuario> getUsuarios() {
        return usuarios;
    }
}
