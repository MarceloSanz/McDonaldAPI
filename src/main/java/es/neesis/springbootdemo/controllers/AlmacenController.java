package es.neesis.springbootdemo.controllers;


import es.neesis.springbootdemo.model.Producto;
import es.neesis.springbootdemo.services.IAlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/almacen")
public class AlmacenController {
    private final IAlmacenService almacenService;

    public AlmacenController(IAlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @PostMapping(value = "/init")
    public void inicializarAlmacen() {
        this.almacenService.inicializarAlmacen();
    }

    @GetMapping()
    public List<Producto> listarTodosLosProductos(){
        return almacenService.listarProductosAlmacen();
    }
    @GetMapping(value = "/{id}")
    public Producto obtenerProductoPorID(@PathVariable int id){
        return almacenService.productoPorId(id);
    }
    @PutMapping(value = "/{id}/add/{cantidad}")
    public boolean push(@PathVariable  int id,@PathVariable int cantidad){
        return almacenService.pushProducto(id,cantidad);
    }
    @PostMapping(value = "/{id}/disminuir/{cantidad}")
    public boolean pop(@PathVariable int id, @PathVariable int cantidad){
        return almacenService.popProducto(id, cantidad);
    }
}


