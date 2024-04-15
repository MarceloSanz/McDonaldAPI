package es.neesis.springbootdemo.repository;

import es.neesis.springbootdemo.model.Pedido;
import es.neesis.springbootdemo.model.Producto;
import es.neesis.springbootdemo.model.Trabajador;
import es.neesis.springbootdemo.services.IAlmacenService;
import es.neesis.springbootdemo.services.ITrabajadorService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PedidosDB implements IPedidosDB{
    private final ITrabajadorService trabajadorService;
    private final IAlmacenService almacenService;

    private HashMap<Integer,Pedido> pedidos = new HashMap<>();

    public PedidosDB(ITrabajadorService iTrabajadorService, IAlmacenService iAlmacenService) {
        this.trabajadorService = iTrabajadorService;
        this.almacenService = iAlmacenService;
    }

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
        Producto producto = almacenService.productoPorId(idProducto);
        if (producto != null){
            Pedido pedido = pedidos.get(idPedido);
            if (pedido != null && pedido.isEstado()){
                pedido.setProducto(producto);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addPeronal(int idPedido) {
        HashMap<Integer,Trabajador> lista = trabajadorService.listarTodosLosTrabajadores();
        int numPersonal = (int) (Math.random()*lista.size()-1);
        Trabajador trabajador = lista.get(numPersonal);
        Pedido pedido = pedidos.get(idPedido);
        if (pedido != null && pedido.isEstado()){
            pedido.setTrabajador(trabajador);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPeronal(int idPedido, int idTrabajador) {
        HashMap<Integer,Trabajador> listaTrabajadores = trabajadorService.listarTodosLosTrabajadores();
        Trabajador trabajador = listaTrabajadores.get(idTrabajador);
        if (trabajador != null ){
            Pedido pedido = pedidos.get(idPedido);
            if (pedido != null  && pedido.isEstado()){
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
