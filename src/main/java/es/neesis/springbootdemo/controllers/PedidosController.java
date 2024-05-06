package es.neesis.springbootdemo.controllers;

import es.neesis.springbootdemo.model.Pedido;
import es.neesis.springbootdemo.services.IPedidosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/pedidos")
@Tag(
        name = "Peidos",
        description = "Este controlador tiene la función de tratar los pedidos de McDonald's."
)
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta.", content = @Content(schema = @Schema(implementation = BindingResult.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor.", content = @Content(schema = @Schema(implementation = String.class, example = "Error interno del servidor.")))
})
public class PedidosController {
    private final IPedidosService pedidosService;

    public PedidosController(IPedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @GetMapping()
    @Operation(summary = "Obtener pedidos.",
            description = "Obtienes listado de todos los pedidos")
    @ApiResponse(responseCode = "200", description = "Pedidos obtenidos correctamente.",
            content = @Content(schema = @Schema(implementation = Pedido.class)))
    public ArrayList<Pedido> listarPedidos() {
        return pedidosService.listarPedidos();
    }

    @PostMapping()
    @Operation(summary = "Registrar un pedido nuevo.",
            description = "Sin informacion crea un nuevo Pedido")
    @ApiResponse(responseCode = "201", description = "Pedido dado de alta correctamente.",
            content = @Content(schema = @Schema(implementation = Integer.class, example = "30")))
    public int altaPedido(){
        return pedidosService.altaPedido();
    }

    @PostMapping(value = "/{idPedido}/producto/{idProducto}")
    @Operation(summary = "Asignar producto a un pedido.",
            description = "Actualiza un pedido ya existente con nuevos productos.")
    @ApiResponse(responseCode = "200", description = "Pedido actualizado exitosamente.",
            content = @Content(schema = @Schema(implementation = Boolean.class, example = "True")))
    public boolean addComida(@PathVariable int idPedido, @PathVariable int idProducto){
        return pedidosService.addComida(idPedido,idProducto);
    }

    @PostMapping(value = "/{idPedido}/personal/")
    @Operation(summary = "Asignar Trabajador a un pedido.",
            description = "Actualiza un pedido ya existente con nuevo trabajador aleatorio.")
    @ApiResponse(responseCode = "200", description = "Pedido actualizado exitosamente.",
            content = @Content(schema = @Schema(implementation = Boolean.class, example = "True")))
    public boolean addPeronal(@PathVariable int idPedido){
        return pedidosService.addPeronal(idPedido);
    }

    @PostMapping(value = "/{idPedido}/personal/{idTrabajador}")
    @Operation(summary = "Asignar Trabajador a un pedido.",
            description = "Actualiza un pedido ya existente con nuevo trabajador definido.")
    @ApiResponse(responseCode = "200", description = "Pedido actualizado exitosamente.",
            content = @Content(schema = @Schema(implementation = Boolean.class, example = "True")))
    public boolean addPeronal(@PathVariable int idPedido, @PathVariable int idTrabajador){
        return pedidosService.addPeronal(idPedido,idTrabajador);
    }

    @PostMapping(value = "/{idPedido}/finalizar")
    @Operation(summary = "Finaliza un pedido.",
            description = "Finaliza un pedido ya existente.")
    @ApiResponse(responseCode = "200", description = "Pedido actualizado exitosamente.",
            content = @Content(schema = @Schema(implementation = Pedido.class)))
    public Pedido finalizar(@PathVariable int idPedido){
        return pedidosService.finalizar(idPedido);
    }


}
