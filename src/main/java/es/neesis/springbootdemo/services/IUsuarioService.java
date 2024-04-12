package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    void inicializarUsuarios();

    List<Usuario> listarUsuarios();

}
