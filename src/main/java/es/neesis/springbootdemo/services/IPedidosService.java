package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IPedidosService {

    public ArrayList<Pedido> listarPedidos();

    public int altaPedido();

    public boolean addComida(int idPedido, int idProducto);

    public boolean addPeronal(int idPedido);
    public boolean addPeronal(int idPedido, int idTrabajador);

    public Pedido finalizar(int id);
}
