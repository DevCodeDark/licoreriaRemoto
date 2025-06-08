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

import com.sipsoft.licoreria.entity.ProveedorCategoria;
import com.sipsoft.licoreria.services.IProveedorCategoriaService;

@RestController
@RequestMapping("/sipsoft")
public class ProveedorCategoriaController {
    @Autowired
    private IProveedorCategoriaService serviceProveedorCategoria;

    @GetMapping("/proveedor-categoria")
    public List<ProveedorCategoria> buscarTodos() {
        return serviceProveedorCategoria.bucarTodos();
    }
    @PostMapping("/proveedor-categoria")
    public ProveedorCategoria guardar(@RequestBody ProveedorCategoria proveedorCategoria) {
        serviceProveedorCategoria.guardar(proveedorCategoria);
        return proveedorCategoria;
    }

    @PutMapping("/proveedor-categoria")
    public ProveedorCategoria modificar(@RequestBody ProveedorCategoria proveedorCategoria) {
        serviceProveedorCategoria.modificar(proveedorCategoria);
        return proveedorCategoria;
    }

    @GetMapping("/proveedor-categoria/{idProveedorCategoria}")
    public Optional<ProveedorCategoria> buscarId(@PathVariable("idProveedorCategoria") Integer idProveedorCategoria) {
        return serviceProveedorCategoria.buscarId(idProveedorCategoria);
    }

    @DeleteMapping("/proveedor-categoria/{idProveedorCategoria}")
    public String eliminar(@PathVariable Integer idProveedorCategoria){
        serviceProveedorCategoria.eliminar(idProveedorCategoria);
        return "Proveedor Categoria eliminado";
    }
}
