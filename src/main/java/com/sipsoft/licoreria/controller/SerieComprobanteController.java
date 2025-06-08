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

import com.sipsoft.licoreria.entity.SerieComprobante;
import com.sipsoft.licoreria.services.ISerieComprobanteService;

@RestController
@RequestMapping("/sipsoft")
public class SerieComprobanteController {
    @Autowired
    private ISerieComprobanteService serviceSerieComprobante;

    @GetMapping("/series-comprobante")
    public List<SerieComprobante> buscarTodos() {
        return serviceSerieComprobante.bucarTodos();
    }
    @PostMapping("/series-comprobante")
    public SerieComprobante guardar(@RequestBody SerieComprobante serieComprobante) {
        serviceSerieComprobante.guardar(serieComprobante);
        return serieComprobante;
    }

    @PutMapping("/series-comprobante")
    public SerieComprobante modificar(@RequestBody SerieComprobante serieComprobante) {
        serviceSerieComprobante.modificar(serieComprobante);
        return serieComprobante;
    }

    @GetMapping("/series-comprobante/{idSerie}")
    public Optional<SerieComprobante> buscarId(@PathVariable("idSerie") Integer idSerie) {
        return serviceSerieComprobante.buscarId(idSerie);
    }

    @DeleteMapping("/series-comprobante/{idSerie}")
    public String eliminar(@PathVariable Integer idSerie){
        serviceSerieComprobante.eliminar(idSerie);
        return "Serie Comprobante eliminada";
    }
}
