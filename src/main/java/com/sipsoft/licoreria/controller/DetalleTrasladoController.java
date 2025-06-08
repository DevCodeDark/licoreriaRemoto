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

import com.sipsoft.licoreria.entity.DetalleTraslado;
import com.sipsoft.licoreria.services.IDetalleTrasladoService;

@RestController
@RequestMapping("/sipsoft")
public class DetalleTrasladoController {
    @Autowired
    private IDetalleTrasladoService serviceDetalleTraslado;

    @GetMapping("/detalle-traslado")
    public List<DetalleTraslado> buscarTodos() {
        return serviceDetalleTraslado.bucarTodos();
    }
    @PostMapping("/detalle-traslado")
    public DetalleTraslado guardar(@RequestBody DetalleTraslado detalleTraslado) {
        serviceDetalleTraslado.guardar(detalleTraslado);
        return detalleTraslado;
    }

    @PutMapping("/detalle-traslado")
    public DetalleTraslado modificar(@RequestBody DetalleTraslado detalleTraslado) {
        serviceDetalleTraslado.modificar(detalleTraslado);
        return detalleTraslado;
    }

    @GetMapping("/detalle-traslado/{idDetalleTraslado}")
    public Optional<DetalleTraslado> buscarId(@PathVariable("idDetalleTraslado") Integer idDetalleTraslado) {
        return serviceDetalleTraslado.buscarId(idDetalleTraslado);
    }

    @DeleteMapping("/detalle-traslado/{idDetalleTraslado}")
    public String eliminar(@PathVariable Integer idDetalleTraslado){
        serviceDetalleTraslado.eliminar(idDetalleTraslado);
        return "Detalle Traslado eliminado";
    }
}
