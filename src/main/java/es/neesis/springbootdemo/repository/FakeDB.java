package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeDB implements IFakeDB{

    private List<Usuario> userRepository;

    @Override
    public void inicializarUsuarios() {
        userRepository = new ArrayList<>();
        userRepository.add(new Usuario(1, "Juan", "Perez", "juan.perez@gmail.com"));
        userRepository.add(new Usuario(2, "Sergio", "Piedras", "sergio.piedras@gmail.com"));
        userRepository.add(new Usuario(3, "Jacinto", "Mauro", "jaci.mauro@gmail.com"));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return userRepository;
    }
}
