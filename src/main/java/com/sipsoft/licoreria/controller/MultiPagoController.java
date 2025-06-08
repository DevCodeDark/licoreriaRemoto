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

import com.sipsoft.licoreria.entity.MultiPago;
import com.sipsoft.licoreria.services.IMultiPagoService;

@RestController
@RequestMapping("/sipsoft")
public class MultiPagoController {
    @Autowired
    private IMultiPagoService serviceMultiPago;

    @GetMapping("/multi-pago")
    public List<MultiPago> buscarTodos() {
        return serviceMultiPago.bucarTodos();
    }
    @PostMapping("/multi-pago")
    public MultiPago guardar(@RequestBody MultiPago multiPago) {
        serviceMultiPago.guardar(multiPago);
        return multiPago;
    }

    @PutMapping("/multi-pago")
    public MultiPago modificar(@RequestBody MultiPago multiPago) {
        serviceMultiPago.modificar(multiPago);
        return multiPago;
    }

    @GetMapping("/multi-pago/{idMultiPago}")
    public Optional<MultiPago> buscarId(@PathVariable("idMultiPago") Integer idMultiPago) {
        return serviceMultiPago.buscarId(idMultiPago);
    }

    @DeleteMapping("/multi-pago/{idMultiPago}")
    public String eliminar(@PathVariable Integer idMultiPago){
        serviceMultiPago.eliminar(idMultiPago);
        return "Multi Pago eliminado";
    }
}
