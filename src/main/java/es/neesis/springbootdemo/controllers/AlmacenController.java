package es.neesis.springbootdemo.controllers;

import es.neesis.springbootdemo.model.Producto;
import es.neesis.springbootdemo.model.Trabajador;
import es.neesis.springbootdemo.services.IAlmacenService;
import es.neesis.springbootdemo.services.IPedidosService;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/almacen")
public class AlmacenController {
    private final IAlmacenService almacenService;

    public AlmacenController(IAlmacenService almacenService) {
        this.almacenService = almacenService;
    }
    @PostMapping(value = "/list")
    public Producto listarTodosLosProductos(){
        return almacenService.listarProductos(id);
    }
    @PostMapping(value = "/cantidad/{id}")
    public int obtenerCantidadPorID(@PathVariable  int id){
        return almacenService.cantidadProducto(id);
    }
    @GetMapping(value = "/add/{id}")
    public int push(@PathVariable  int id){
        return almacenService.añadirProducto(id);
    }
    @GetMapping(value = "/delete/{id}")
    public int pop(@PathVariable int id){
        return almacenService.borrarProducto(id);
    }
}
