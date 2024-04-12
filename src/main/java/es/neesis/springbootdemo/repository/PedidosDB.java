package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Pedido;

import java.util.ArrayList;
import java.util.HashMap;

public class PedidosDB implements IPedidosDB{

    private HashMap<Integer,Pedido> pedidos = new HashMap<>();
    @Override
    public ArrayList<Pedido> listarPedidos() {
        return new ArrayList<Pedido>(pedidos.values());
    }

    @Override
    public int altaPedido() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(pedidos.keySet().size());
        pedidos.put(pedido.getIdPedido(),pedido);
        return pedido.getIdPedido();
    }

    @Override
    public boolean addComida(int idPedido, int idProducto) {
        boolean productoEncontrado = false;
        ArrayList<Producto> listaProductos = listarTodosLosProductos;
        Producto producto;
        for (int i = 0;!productoEncontrado && i < listaProductos.size() ; i++) {
            Producto producto1 = listaProductos.get(i);
            if (producto1.id == idProducto){
                producto = producto1;
                productoEncontrado = true;
            }
        }
        if (productoEncontrado){
            Pedido pedido = pedidos.get(idPedido);
            if (pedido != null){
                pedido.setProducto(producto);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addPeronal(int idPedido) {
        ArrayList<Trabajadores> litaTrabajadores = listarTodosLosTrabajadores;
        int numPersonal = (int) (Math.random()*litaTrabajadores.size()-1);
        Trabajador trabajador = litaTrabajadores.get(numPersonal);
        Pedido pedido = pedidos.get(idPedido);
        if (pedido != null){
            pedido.setTrabajador(trabajador);
        }
        return false;
    }

    @Override
    public boolean addPeronal(int idPedido, int idTrabajador) {
        boolean trabajadorEncontrado = false;
        ArrayList<Trabajadores> litaTrabajadores = listarTodosLosTrabajadores;
        Trabajador trabajador;
        for (Trabajador trabajador1 : litaTrabajadores){
            if (trabajador1.id == idTrabajador){
                trabajador = trabajador1;
                trabajadorEncontrado = true;
            }
        }
        if (trabajadorEncontrado){
            Pedido pedido = pedidos.get(idPedido);
            if (pedido != null){
                pedido.setTrabajador(trabajador);
                return true;
            }
        }
        return false;
    }

    @Override
    public Pedido finalizar(int id) {
        Pedido pedido = pedidos.get(id);
        if (pedido != null){
            pedido.setEstado(false);
        }
        return pedido;
    }

}
