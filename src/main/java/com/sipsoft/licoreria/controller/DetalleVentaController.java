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

import com.sipsoft.licoreria.entity.DetalleVenta;
import com.sipsoft.licoreria.services.IDetalleVentaService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleVentaController {
    @Autowired
    private IDetalleVentaService serviceDetalleVenta;

    @GetMapping("/detalle-ventas")
    public List<DetalleVenta> buscarTodos() {
        return serviceDetalleVenta.bucarTodos();
    }
    @PostMapping("/detalle-ventas")
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        serviceDetalleVenta.guardar(detalleVenta);
        return detalleVenta;
    }

    @PutMapping("/detalle-ventas")
    public DetalleVenta modificar(@RequestBody DetalleVenta detalleVenta) {
        serviceDetalleVenta.modificar(detalleVenta);
        return detalleVenta;
    }

    @GetMapping("/detalle-ventas/{idDetalleVenta}")
    public Optional<DetalleVenta> buscarId(@PathVariable("idDetalleVenta") Integer idDetalleVenta) {
        return serviceDetalleVenta.buscarId(idDetalleVenta);
    }

    @DeleteMapping("/detalle-ventas/{idDetalleVenta}")
    public String eliminar(@PathVariable Integer idDetalleVenta){
        serviceDetalleVenta.eliminar(idDetalleVenta);
        return "Detalle Venta eliminado";
    }
}
