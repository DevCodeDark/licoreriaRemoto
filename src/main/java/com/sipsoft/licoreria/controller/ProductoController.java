package com.sipsoft.licoreria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipsoft.licoreria.entity.Producto;
import com.sipsoft.licoreria.services.IProductoService;

@RestController
@RequestMapping("/sipsoft")
public class ProductoController {
    @Autowired
    private IProductoService serviceProducto;

    @GetMapping("/productos")
    public List<Producto> buscarTodos() {
        return serviceProducto.bucarTodos();
    }
    @PostMapping("/productos")
    public Producto guardar(@RequestBody Producto producto) {
        serviceProducto.guardar(producto);
        return producto;
    }

    @PutMapping("/productos")
    public Producto modificar(@RequestBody Producto producto) {
        serviceProducto.modificar(producto);
        return producto;
    }

    @GetMapping("/productos/{idProducto}")
    public Optional<Producto> buscarId(@PathVariable("idProducto") Integer idProducto) {
        return serviceProducto.buscarId(idProducto);
    }

    @DeleteMapping("/productos/{idProducto}")
    public String eliminar(@PathVariable Integer idProducto){
        serviceProducto.eliminar(idProducto);
        return "Producto eliminado";
    }
}
