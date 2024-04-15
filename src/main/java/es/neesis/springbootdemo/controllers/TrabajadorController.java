package es.neesis.springbootdemo.controllers;

import es.neesis.springbootdemo.model.Trabajador;
import es.neesis.springbootdemo.services.TrabajadorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/trabajador")
public class TrabajadorController {
    private final TrabajadorService trabajadorService;
    public TrabajadorController(TrabajadorService trabajadorService){
        this.trabajadorService = trabajadorService;
    }
    @PostMapping(value = "/init")
    public void inicializarTrabajadores() {
        trabajadorService.inicializarTrabajadores();
    }
    @GetMapping(value = "/getById/{id}")
    public Trabajador mostrarTrabajador(@PathVariable int id) {
        return trabajadorService.buscarTrabajadorPorId(id);
    }
    @GetMapping(value = "/list")
    public List<Trabajador> listarTrabajadores() {
        return new ArrayList<>(trabajadorService.listarTodosLosTrabajadores().values());
    }
    @PostMapping(value = "/add")
    public boolean añadirTrabajador(@RequestBody Trabajador trabajador){
        return trabajadorService.añadirTrabajador(trabajador);
    }
    @DeleteMapping(value = "/delete/{id}")
    public boolean borrarTrabajador(@PathVariable int id){
        return trabajadorService.borrarTrabajador(id);
    }
}
