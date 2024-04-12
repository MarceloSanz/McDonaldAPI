package es.neesis.springbootdemo.services;


import es.neesis.springbootdemo.model.Trabajador;
import es.neesis.springbootdemo.repository.TrabajadorDB;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class TrabajadorService implements ITrabajadorService {
    private final TrabajadorDB trabajadorDB;
    public TrabajadorService(TrabajadorDB trabajadorDB){
        this.trabajadorDB = trabajadorDB;
    }
    @Override
    public void inicializarTrabajadores() {
        trabajadorDB.inicializarTrabajadores();
    }

    @Override
    public Trabajador buscarTrabajadorPorId(int idTrabajador) {
        return trabajadorDB.buscarTrabajadorPorId(idTrabajador);
    }

    @Override
    public HashMap<Integer,Trabajador> listarTodosLosTrabajadores() {
        return trabajadorDB.listarTodosLosTrabajadores();
    }

    @Override
    public boolean añadirTrabajador(Trabajador trabajador) {
        return trabajadorDB.añadirTrabajador(trabajador);
    }

    @Override
    public boolean borrarTrabajador(int idTrabajador) {
        return trabajadorDB.borrarTrabajador(idTrabajador);
    }
}
