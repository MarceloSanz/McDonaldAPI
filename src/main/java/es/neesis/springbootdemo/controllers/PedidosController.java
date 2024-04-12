package es.neesis.springbootdemo.controllers;

import es.neesis.springbootdemo.model.Pedido;
import es.neesis.springbootdemo.services.IPedidosService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosController {
    private final IPedidosService pedidosService;

    public PedidosController(IPedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @GetMapping(value = "/list")
    public ArrayList<Pedido> listarPedidos() {
        return pedidosService.listarPedidos();
    }

    @PostMapping(value = "/altaPedido")
    public int altaPedido(){
        return pedidosService.altaPedido();
    }

    @PutMapping(value = "/addComida")
    public boolean addComida(int idPedido, int idProducto){
        return pedidosService.addComida(idPedido,idProducto);
    }

    @PutMapping(value = "/addPersonal")
    public boolean addPeronal(int idPedido){
        return pedidosService.addPeronal(idPedido);
    }

    @PutMapping(value = "/addPersonal")
    public boolean addPeronal(int idPedido, int idTrabajador){
        return pedidosService.addPeronal(idPedido,idTrabajador);
    }

    @PutMapping(value = "/finalizar")
    public Pedido finalizar(int id){
        return pedidosService.finalizar(id);
    }


}
