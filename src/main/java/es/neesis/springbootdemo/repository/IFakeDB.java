package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Usuario;

import java.util.List;

public interface IFakeDB {

    void inicializarUsuarios();

    List<Usuario> listarUsuarios();

}
