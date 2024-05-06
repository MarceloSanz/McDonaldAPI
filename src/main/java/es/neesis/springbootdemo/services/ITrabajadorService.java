package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.model.Trabajador;

import java.util.HashMap;

public interface ITrabajadorService {
    void inicializarTrabajadores();
    Trabajador buscarTrabajadorPorId(int idTrabajador);
    HashMap<Integer,Trabajador> listarTodosLosTrabajadores();
    boolean agregarTrabajador(Trabajador trabajador);
    boolean borrarTrabajador(int idTrabajador);
}
