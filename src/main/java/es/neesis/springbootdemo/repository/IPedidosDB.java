package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Pedido;

import java.util.ArrayList;

public interface IPedidosDB {

    public ArrayList<Pedido> listarPedidos();

    public int altaPedido();

    public boolean addComida(int idPedido, int idProducto);

    public boolean addPeronal(int idPedido);
    public boolean addPeronal(int idPedido, int idTrabajador);

    public Pedido finalizar(int id);
}
