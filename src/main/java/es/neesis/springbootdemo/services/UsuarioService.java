package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.model.Usuario;
import es.neesis.springbootdemo.repository.IFakeDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private final IFakeDB fakeDB;

    public UsuarioService(IFakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    @Override
    public void inicializarUsuarios() {
        this.mostrarCosasPorConsola();
        this.fakeDB.inicializarUsuarios();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return this.fakeDB.listarUsuarios();
    }

    private void mostrarCosasPorConsola() {
        System.out.println("Hola, soy el servicio de usuarios");
    }

}
