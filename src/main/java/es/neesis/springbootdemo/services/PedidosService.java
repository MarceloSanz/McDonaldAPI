package es.neesis.springbootdemo.services;

import es.neesis.springbootdemo.model.Pedido;
import es.neesis.springbootdemo.repository.IPedidosDB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PedidosService implements IPedidosService {


    private final IPedidosDB pedidosDB;


    public PedidosService(IPedidosDB pedidosDB) {
        this.pedidosDB = pedidosDB;
    }

    @Override
    public ArrayList<Pedido> listarPedidos() {
        return this.pedidosDB.listarPedidos();
    }

    @Override
    public int altaPedido() {
        return this.pedidosDB.altaPedido();
    }

    @Override
    public boolean addComida(int idPedido, int idProducto) {
        return this.pedidosDB.addComida(idPedido, idProducto);
    }

    @Override
    public boolean addPeronal(int idPedido) {
        return this.pedidosDB.addPeronal(idPedido);
    }

    @Override
    public boolean addPeronal(int idPedido,int idTrabajador) {
        return this.pedidosDB.addPeronal(idPedido,idTrabajador);
    }

    @Override
    public Pedido finalizar(int id) {
        return this.pedidosDB.finalizar(id);
    }
}
