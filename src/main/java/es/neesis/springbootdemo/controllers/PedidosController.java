package es.neesis.springbootdemo.controllers;

import es.neesis.springbootdemo.model.Pedido;
import es.neesis.springbootdemo.services.IPedidosService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Listado de pedidos")
    public ArrayList<Pedido> listarPedidos() {
        return pedidosService.listarPedidos();
    }

    @PostMapping()
    @Operation(summary = "Alta de pedido")
    public int altaPedido(){
        return pedidosService.altaPedido();
    }

    @PostMapping(value = "/{idPedido}/producto/{idProducto}")
    @Operation(summary = "Asignar producto a un pedido")
    public boolean addComida(@PathVariable int idPedido, @PathVariable int idProducto){
        return pedidosService.addComida(idPedido,idProducto);
    }

    @PostMapping(value = "/{idPedido}/personal/")
    @Operation(summary = "Asignar trabajador aleatorio a un pedido")
    public boolean addPeronal(@PathVariable int idPedido){
        return pedidosService.addPeronal(idPedido);
    }

    @PostMapping(value = "/{idPedido}/personal/{idTrabajador}")
    @Operation(summary = "Asignar trabajador concreto a un pedido")
    public boolean addPeronal(@PathVariable int idPedido, @PathVariable int idTrabajador){
        return pedidosService.addPeronal(idPedido,idTrabajador);
    }

    @PostMapping(value = "/{idPedido}/finalizar")
    @Operation(summary = "Finalizar un pedido")
    public Pedido finalizar(@PathVariable int idPedido){
        return pedidosService.finalizar(idPedido);
    }


}
