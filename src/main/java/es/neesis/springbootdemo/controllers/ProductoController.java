package es.neesis.springbootdemo.controllers;


import es.neesis.springbootdemo.model.Producto;
import es.neesis.springbootdemo.repository.IAlmacenDB;
import es.neesis.springbootdemo.services.IAlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {
    private final IAlmacenService almacenService;

    public ProductoController(IAlmacenService almacenService) {
        this.almacenService = almacenService;
    }
    @PostMapping(value = "/list")
    public List<Producto> listarTodosLosProductos(){
        return almacenService.listarProductosAlmacen();
    }
    @PostMapping(value = "/cantidad/{id}")
    public Producto obtenerCantidadPorID(@PathVariable int id){
        return almacenService.productoPorId(id);
    }
    @GetMapping(value = "/add/{id}/{cantidad}")
    public boolean push(@PathVariable  int id,@PathVariable int cantidad){
        return almacenService.pushProducto(id,cantidad);
    }
    @GetMapping(value = "/delete/{id}/{cantidad}")
    public boolean pop(@PathVariable int id, @PathVariable int cantidad){
        return almacenService.popProducto(id, cantidad);
    }
}


