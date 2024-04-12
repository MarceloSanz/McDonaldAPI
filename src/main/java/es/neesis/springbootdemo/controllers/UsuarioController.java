package es.neesis.springbootdemo.controllers;

import es.neesis.springbootdemo.model.Usuario;
import es.neesis.springbootdemo.services.IUsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/init")
    public void inicializarUsuarios() {
        usuarioService.inicializarUsuarios();
    }

    @GetMapping(value = "/list")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

}
