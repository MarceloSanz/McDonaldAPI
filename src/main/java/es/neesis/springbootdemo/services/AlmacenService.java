package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.repository.IAlmacenDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenService {

    private final IAlmacenDB almacenDB;

    public AlmacenService(IAlmacenDB almacenDB) {
        this.almacenDB = almacenDB;
    }

    public void iniciarAlmacen() {
        mostrarCosasPorConsola();
        almacenDB.inicializarAlmacen();
        almacenDB.listarProductosAlmacen();
    }

    private void mostrarCosasPorConsola() {
        System.out.println("Hola, soy el servicio de almacen");
        System.out.println("Los productos almacenados en el almacen son los siguientes: ");
    }
}
