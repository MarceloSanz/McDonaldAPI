package es.neesis.springbootdemo.repository;

import java.util.ArrayList;
import es.neesis.springbootdemo.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlmacenDB implements IAlmacenDB{
    private Map<Integer, Producto> productosAlmacenados;

    @Override
    public void inicializarAlmacen() {

        productosAlmacenados = new HashMap<>();

        productosAlmacenados.put(1, new Producto(1, "Big Mac", 50));
        productosAlmacenados.put(2, new Producto(2, "Royale Deluxe", 30));
        productosAlmacenados.put(3, new Producto(3, "Patatas Gajo", 15));
        productosAlmacenados.put(4, new Producto(4, "Patatas Fritas", 20));
        productosAlmacenados.put(5, new Producto(5, "McFlurry", 10));
        productosAlmacenados.put(6, new Producto(6, "Coca-Cola", 50));

    }


    @Override
    public List<Producto> listarProductosAlmacen() {
        return new ArrayList<Producto>(productosAlmacenados.values());
    }

    @Override
    public Producto productoPorId(int id) {
        return productosAlmacenados.get(id);
    }

    @Override
    public int cantidadProductoAlmacenado(int id) {
        return productoPorId(id).getCantidad();
    }

    public boolean pushProducto(int id, int cantidad){

        boolean productoAumentado = false;
        try{
            Producto producto = productoPorId(id);
            producto.setCantidad(producto.getCantidad() + cantidad);
            productoAumentado = true;
        } catch (Exception e){
            System.out.println("El producto no existe");
        }
        return productoAumentado;
    }

    public boolean popProducto(int id, int cantidad) {
        boolean hayProducto = false;
        try {
            Producto producto = productoPorId(id);
            producto.setCantidad(producto.getCantidad() - cantidad);
            hayProducto = true;
        } catch (Exception e) {
            System.out.println("El producto no existe");
        }
        return hayProducto;
    }

}
