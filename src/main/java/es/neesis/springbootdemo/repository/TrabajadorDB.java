package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Producto;
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
        if(response!=null){
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
        boolean trabajadorAñadido = false;
        try {
            trabajadorRepo.put(trabajadorRepo.size()+1,trabajador);
            trabajadorAñadido = true;
        } catch (Exception e) {
            System.out.println("El trabajador no se pudo añadir");
        }
        return trabajadorAñadido;
    }

    @Override
    public boolean borrarTrabajador(int idTrabajador) {
        boolean trabajdorBorrado = false;
        try {
            trabajadorRepo.remove(idTrabajador);
            trabajdorBorrado = true;
        } catch (Exception e) {
            System.out.println("El trabajador no se pudo añadir");
        }
        return trabajdorBorrado;
    }
}
