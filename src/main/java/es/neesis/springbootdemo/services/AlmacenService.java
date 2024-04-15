package es.neesis.springbootdemo.services;


import es.neesis.springbootdemo.model.Producto;
import es.neesis.springbootdemo.repository.IAlmacenDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenService implements IAlmacenService{

    private final IAlmacenDB almacenDB;

    public AlmacenService(IAlmacenDB almacenDB) {
        this.almacenDB = almacenDB;
    }

    public void inicializarAlmacen() {
        //mostrarCosasPorConsola();
        almacenDB.inicializarAlmacen();
    }

    @Override
    public Producto productoPorId(int id) {
        return almacenDB.productoPorId(id);
    }

    @Override
    public List<Producto> listarProductosAlmacen() {
        return almacenDB.listarProductosAlmacen();
    }

    @Override
    public boolean pushProducto(int id, int cantidad) {
        return almacenDB.pushProducto(id, cantidad);
    }

    @Override
    public boolean popProducto(int id, int cantidad) {
        return almacenDB.popProducto(id, cantidad);
    }

    private void mostrarCosasPorConsola() {
        System.out.println("Hola, soy el servicio de almacen");
        System.out.println("Los productos almacenados en el almacen son los siguientes: ");
    }
}
