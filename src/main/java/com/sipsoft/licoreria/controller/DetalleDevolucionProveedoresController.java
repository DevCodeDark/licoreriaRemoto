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

import com.sipsoft.licoreria.entity.DetalleDevolucionProveedores;
import com.sipsoft.licoreria.services.IDetalleDevolucionProveedoresService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleDevolucionProveedoresController {
    @Autowired
    private IDetalleDevolucionProveedoresService serviceDetalleDevolucionProveedores;

    @GetMapping("/detalle-devolucion-proveedores")
    public List<DetalleDevolucionProveedores> buscarTodos() {
        return serviceDetalleDevolucionProveedores.bucarTodos();
    }
    @PostMapping("/detalle-devolucion-proveedores")
    public DetalleDevolucionProveedores guardar(@RequestBody DetalleDevolucionProveedores detalleDevolucionProveedores) {
        serviceDetalleDevolucionProveedores.guardar(detalleDevolucionProveedores);
        return detalleDevolucionProveedores;
    }

    @PutMapping("/detalle-devolucion-proveedores")
    public DetalleDevolucionProveedores modificar(@RequestBody DetalleDevolucionProveedores detalleDevolucionProveedores) {
        serviceDetalleDevolucionProveedores.modificar(detalleDevolucionProveedores);
        return detalleDevolucionProveedores;
    }

    @GetMapping("/detalle-devolucion-proveedores/{idDetalleDevolucion}")
    public Optional<DetalleDevolucionProveedores> buscarId(@PathVariable("idDetalleDevolucion") Integer idDetalleDevolucion) {
        return serviceDetalleDevolucionProveedores.buscarId(idDetalleDevolucion);
    }

    @DeleteMapping("/detalle-devolucion-proveedores/{idDetalleDevolucion}")
    public String eliminar(@PathVariable Integer idDetalleDevolucion){
        serviceDetalleDevolucionProveedores.eliminar(idDetalleDevolucion);
        return "Detalle Devolucion Proveedor eliminado";
    }
}
