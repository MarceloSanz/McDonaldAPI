package es.neesis.springbootdemo.repository;
import es.neesis.springbootdemo.model.Producto;


import java.util.List;

public interface IAlmacenDB {

    void inicializarAlmacen();

    List<Producto> listarProductosAlmacen();

    int cantidadProductoAlmacenado(int id);

    Producto productoPorId(int id);
}
