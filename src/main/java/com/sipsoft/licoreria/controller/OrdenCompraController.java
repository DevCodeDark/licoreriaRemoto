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

import com.sipsoft.licoreria.entity.OrdenCompra;
import com.sipsoft.licoreria.services.IOrdenCompraService;

@RestController
@RequestMapping("/sipsoft")
public class OrdenCompraController {
    @Autowired
    private IOrdenCompraService serviceOrdenCompra;

    @GetMapping("/ordenes-compra")
    public List<OrdenCompra> buscarTodos() {
        return serviceOrdenCompra.bucarTodos();
    }
    @PostMapping("/ordenes-compra")
    public OrdenCompra guardar(@RequestBody OrdenCompra ordenCompra) {
        serviceOrdenCompra.guardar(ordenCompra);
        return ordenCompra;
    }

    @PutMapping("/ordenes-compra")
    public OrdenCompra modificar(@RequestBody OrdenCompra ordenCompra) {
        serviceOrdenCompra.modificar(ordenCompra);
        return ordenCompra;
    }

    @GetMapping("/ordenes-compra/{idOrden}")
    public Optional<OrdenCompra> buscarId(@PathVariable("idOrden") Integer idOrden) {
        return serviceOrdenCompra.buscarId(idOrden);
    }

    @DeleteMapping("/ordenes-compra/{idOrden}")
    public String eliminar(@PathVariable Integer idOrden){
        serviceOrdenCompra.eliminar(idOrden);
        return "Orden Compra eliminada";
    }
}
