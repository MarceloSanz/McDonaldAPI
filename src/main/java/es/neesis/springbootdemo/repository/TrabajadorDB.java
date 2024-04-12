package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Trabajador;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class TrabajadorDB implements ITrabajadorDB{
    private HashMap<Integer,Trabajador> trabajadorRepo;



    @Override
    public void inicializarTrabajadores() {
        trabajadorRepo = new HashMap<Integer,Trabajador>();
        trabajadorRepo.put(1,new Trabajador(1, "Juan", "Cocinero", "22334455Y"));
        trabajadorRepo.put(2,new Trabajador(2, "Luis", "Cocinero", "12334455Y"));
        trabajadorRepo.put(3,new Trabajador(3, "Sergio", "Encargado", "11223344T"));
        trabajadorRepo.put(4,new Trabajador(4, "Jacinto", "Cajero", "33445566A"));
        trabajadorRepo.put(5,new Trabajador(5, "Jose", "Cajero", "43445566A"));
        System.out.println(trabajadorRepo.get(trabajadorRepo.size()-1));
    }
    @Override
    public Trabajador buscarTrabajadorPorId(int idTrabajador) {
        Trabajador response = trabajadorRepo.get(idTrabajador);
        if (response!=null){
            return response;
        }
        return null;
    }

    @Override
    public HashMap<Integer,Trabajador> listarTodosLosTrabajadores() {
        return trabajadorRepo;
    }

    @Override
    public boolean añadirTrabajador(Trabajador trabajador) {
        trabajadorRepo.put(trabajadorRepo.size()+1,trabajador);
        return false;
    }

    @Override
    public boolean borrarTrabajador(int idTrabajador) {
        trabajadorRepo.remove(idTrabajador);
        return false;
    }
}
