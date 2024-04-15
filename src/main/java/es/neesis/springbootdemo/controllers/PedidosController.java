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

    @GetMapping()
    public ArrayList<Pedido> listarPedidos() {
        return pedidosService.listarPedidos();
    }

    @PostMapping()
    public int altaPedido(){
        return pedidosService.altaPedido();
    }

    @PostMapping(value = "/{idPedido}/producto/{idProducto}")
    public boolean addComida(@PathVariable int idPedido, @PathVariable int idProducto){
        return pedidosService.addComida(idPedido,idProducto);
    }

    @PostMapping(value = "/{idPedido}/personal/")
    public boolean addPeronal(@PathVariable int idPedido){
        return pedidosService.addPeronal(idPedido);
    }

    @PostMapping(value = "/{idPedido}/personal/{idTrabajador}")
    public boolean addPeronal(@PathVariable int idPedido, @PathVariable int idTrabajador){
        return pedidosService.addPeronal(idPedido,idTrabajador);
    }

    @PostMapping(value = "/{idPedido}/finalizar")
    public Pedido finalizar(@PathVariable int idPedido){
        return pedidosService.finalizar(idPedido);
    }


}
