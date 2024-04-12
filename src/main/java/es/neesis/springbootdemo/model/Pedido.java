package es.neesis.springbootdemo.model;

import java.util.ArrayList;

public class Pedido {
    private int idPedido;

    private Trabajador trabajador;

    private ArrayList<Producto> productos;

    private boolean estado;


    public Pedido() {
        this.productos = new ArrayList<Producto>();
        this.estado = true;
    }

    public Pedido(int idPedido, Trabajador trabajador, ArrayList<Producto> productos, boolean estado) {
        this.idPedido = idPedido;
        this.trabajador = trabajador;
        this.productos = productos;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProducto(Producto producto) {
        this.productos.add(producto);
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
