package es.neesis.springbootdemo.repository;
import es.neesis.springbootdemo.model.Producto;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IAlmacenDB {

    void inicializarAlmacen();

    Map<Integer,Producto> listarProductosAlmacen();

    int cantidadProductoAlmacenado(int id);

    Producto productoPorId(int id);

    boolean pushProducto(int id, int cantidad);

    boolean popProducto(int id, int cantidad);
}
