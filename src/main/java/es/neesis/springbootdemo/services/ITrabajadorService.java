package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.model.Trabajador;

import java.util.HashMap;
import java.util.List;

public interface ITrabajadorService {
    void inicializarTrabajadores();
    Trabajador buscarTrabajadorPorId(int idTrabajador);
    HashMap<Integer,Trabajador> listarTodosLosTrabajadores();
    boolean añadirTrabajador(Trabajador trabajador);
    boolean borrarTrabajador(int idTrabajador);
}
