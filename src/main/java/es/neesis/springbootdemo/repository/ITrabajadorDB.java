package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Trabajador;

import java.util.HashMap;
import java.util.List;

public interface ITrabajadorDB {
    void inicializarTrabajadores();
    Trabajador buscarTrabajadorPorId(int idTrabajador);
    HashMap<Integer,Trabajador> listarTodosLosTrabajadores();
    boolean añadirTrabajador(Trabajador trabajador);
    boolean borrarTrabajador(int idTrabajador);
    /*
    buscarTrabajadorPorID(int id)
		return trabajador;
	listarTodosLosTrabajadores
		return ArrayList<Trabajador>;
	añadirTrabajador(@RequestBody Trabajador trabajador)
		return bool;
	borrarTrabajador(int id)
		return bool;
     */
}
