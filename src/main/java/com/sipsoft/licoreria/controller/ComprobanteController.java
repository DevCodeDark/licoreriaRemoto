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

import com.sipsoft.licoreria.entity.Comprobante;
import com.sipsoft.licoreria.services.IComprobanteService;

@RestController
@RequestMapping("/sipsoft")
public class ComprobanteController {
    @Autowired
    private IComprobanteService serviceComprobante;

    @GetMapping("/comprobantes")
    public List<Comprobante> buscarTodos() {
        return serviceComprobante.bucarTodos();
    }
    @PostMapping("/comprobantes")
    public Comprobante guardar(@RequestBody Comprobante comprobante) {
        serviceComprobante.guardar(comprobante);
        return comprobante;
    }

    @PutMapping("/comprobantes")
    public Comprobante modificar(@RequestBody Comprobante comprobante) {
        serviceComprobante.modificar(comprobante);
        return comprobante;
    }

    @GetMapping("/comprobantes/{idComprobante}")
    public Optional<Comprobante> buscarId(@PathVariable("idComprobante") Integer idComprobante) {
        return serviceComprobante.buscarId(idComprobante);
    }

    @DeleteMapping("/comprobantes/{idComprobante}")
    public String eliminar(@PathVariable Integer idComprobante){
        serviceComprobante.eliminar(idComprobante);
        return "Comprobante eliminado";
    }
}
