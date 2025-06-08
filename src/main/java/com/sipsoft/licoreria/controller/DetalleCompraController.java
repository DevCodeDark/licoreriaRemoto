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

import com.sipsoft.licoreria.entity.DetalleCompra;
import com.sipsoft.licoreria.services.IDetalleCompraService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleCompraController {
    @Autowired
    private IDetalleCompraService serviceDetalleCompra;

    @GetMapping("/detalle-compras")
    public List<DetalleCompra> buscarTodos() {
        return serviceDetalleCompra.bucarTodos();
    }
    @PostMapping("/detalle-compras")
    public DetalleCompra guardar(@RequestBody DetalleCompra detalleCompra) {
        serviceDetalleCompra.guardar(detalleCompra);
        return detalleCompra;
    }

    @PutMapping("/detalle-compras")
    public DetalleCompra modificar(@RequestBody DetalleCompra detalleCompra) {
        serviceDetalleCompra.modificar(detalleCompra);
        return detalleCompra;
    }

    @GetMapping("/detalle-compras/{idDetalleCompra}")
    public Optional<DetalleCompra> buscarId(@PathVariable("idDetalleCompra") Integer idDetalleCompra) {
        return serviceDetalleCompra.buscarId(idDetalleCompra);
    }

    @DeleteMapping("/detalle-compras/{idDetalleCompra}")
    public String eliminar(@PathVariable Integer idDetalleCompra){
        serviceDetalleCompra.eliminar(idDetalleCompra);
        return "Detalle Compra eliminado";
    }
}
