package es.neesis.springbootdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.ArrayList;

public class Pedido {
    @Schema(description = "Identificador del Pedido")
    @NotNull(message = "El ID no puede ser null")
    @PositiveOrZero(message = "El ID minimo es 0")
    private int idPedido;

    @Schema(description = "Trabajador a Cargo del Pedido")
    private Trabajador trabajador;


    @Schema(description = "Lista de productos del Pedido")
    private ArrayList<Producto> productos;

    @Schema(description = "Estado del Pedido")
    @NotNull(message = "El estado no puede ser null")
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
