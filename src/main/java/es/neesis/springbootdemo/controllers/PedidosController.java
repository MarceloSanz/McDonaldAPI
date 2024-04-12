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

    @PutMapping(value = "/addComida/{idPedido}/{idProducto}")
    public boolean addComida(@PathVariable int idPedido, @PathVariable int idProducto){
        return pedidosService.addComida(idPedido,idProducto);
    }

    @PutMapping(value = "/addPersonal/{idPedido}")
    public boolean addPeronal(@PathVariable int idPedido){
        return pedidosService.addPeronal(idPedido);
    }

    @PutMapping(value = "/addPersonal/{idPedido}/{idTrabajador}")
    public boolean addPeronal(@PathVariable int idPedido, @PathVariable int idTrabajador){
        return pedidosService.addPeronal(idPedido,idTrabajador);
    }

    @PutMapping(value = "/finalizar/{id}")
    public Pedido finalizar(@PathVariable int id){
        return pedidosService.finalizar(id);
    }


}
