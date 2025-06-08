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

import com.sipsoft.licoreria.entity.DevolucionCompra;
import com.sipsoft.licoreria.services.IDevolucionCompraService;

@RestController
@RequestMapping("/sipsoft")
public class DevolucionCompraController {
    @Autowired
    private IDevolucionCompraService serviceDevolucionCompra;

    @GetMapping("/devolucion-compra")
    public List<DevolucionCompra> buscarTodos() {
        return serviceDevolucionCompra.bucarTodos();
    }
    @PostMapping("/devolucion-compra")
    public DevolucionCompra guardar(@RequestBody DevolucionCompra devolucionCompra) {
        serviceDevolucionCompra.guardar(devolucionCompra);
        return devolucionCompra;
    }

    @PutMapping("/devolucion-compra")
    public DevolucionCompra modificar(@RequestBody DevolucionCompra devolucionCompra) {
        serviceDevolucionCompra.modificar(devolucionCompra);
        return devolucionCompra;
    }

    @GetMapping("/devolucion-compra/{idDevolucionCompra}")
    public Optional<DevolucionCompra> buscarId(@PathVariable("idDevolucionCompra") Integer idDevolucionCompra) {
        return serviceDevolucionCompra.buscarId(idDevolucionCompra);
    }

    @DeleteMapping("/devolucion-compra/{idDevolucionCompra}")
    public String eliminar(@PathVariable Integer idDevolucionCompra){
        serviceDevolucionCompra.eliminar(idDevolucionCompra);
        return "Devolucion Compra eliminada";
    }
}
