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

import com.sipsoft.licoreria.entity.DetalleOrdenCompra;
import com.sipsoft.licoreria.services.IDetalleOrdenCompraService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleOrdenCompraController {
    @Autowired
    private IDetalleOrdenCompraService serviceDetalleOrdenCompra;

    @GetMapping("/detalle-orden-compra")
    public List<DetalleOrdenCompra> buscarTodos() {
        return serviceDetalleOrdenCompra.bucarTodos();
    }
    @PostMapping("/detalle-orden-compra")
    public DetalleOrdenCompra guardar(@RequestBody DetalleOrdenCompra detalleOrdenCompra) {
        serviceDetalleOrdenCompra.guardar(detalleOrdenCompra);
        return detalleOrdenCompra;
    }

    @PutMapping("/detalle-orden-compra")
    public DetalleOrdenCompra modificar(@RequestBody DetalleOrdenCompra detalleOrdenCompra) {
        serviceDetalleOrdenCompra.modificar(detalleOrdenCompra);
        return detalleOrdenCompra;
    }

    @GetMapping("/detalle-orden-compra/{idDetalleOrden}")
    public Optional<DetalleOrdenCompra> buscarId(@PathVariable("idDetalleOrden") Integer idDetalleOrden) {
        return serviceDetalleOrdenCompra.buscarId(idDetalleOrden);
    }

    @DeleteMapping("/detalle-orden-compra/{idDetalleOrden}")
    public String eliminar(@PathVariable Integer idDetalleOrden){
        serviceDetalleOrdenCompra.eliminar(idDetalleOrden);
        return "Detalle Orden Compra eliminado";
    }
}
