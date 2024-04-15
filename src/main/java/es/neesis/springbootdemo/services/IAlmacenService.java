package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.model.Producto;
import java.util.List;
import java.util.Map;

public interface IAlmacenService {
    void inicializarAlmacen();

    Producto productoPorId(int id);

    Map<Integer,Producto> listarProductosAlmacen();
    boolean pushProducto(int id, int cantidad);
    boolean popProducto(int id, int cantidad);
}
