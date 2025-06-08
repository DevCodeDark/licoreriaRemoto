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

import com.sipsoft.licoreria.entity.TipoPago;
import com.sipsoft.licoreria.services.ITipoPagoService;

@RestController
@RequestMapping("/sipsoft")
public class TipoPagoController {
    @Autowired
    private ITipoPagoService serviceTipoPago;

    @GetMapping("/tipos-pago")
    public List<TipoPago> buscarTodos() {
        return serviceTipoPago.bucarTodos();
    }
    @PostMapping("/tipos-pago")
    public TipoPago guardar(@RequestBody TipoPago tipoPago) {
        serviceTipoPago.guardar(tipoPago);
        return tipoPago;
    }

    @PutMapping("/tipos-pago")
    public TipoPago modificar(@RequestBody TipoPago tipoPago) {
        serviceTipoPago.modificar(tipoPago);
        return tipoPago;
    }

    @GetMapping("/tipos-pago/{idTipoPago}")
    public Optional<TipoPago> buscarId(@PathVariable("idTipoPago") Integer idTipoPago) {
        return serviceTipoPago.buscarId(idTipoPago);
    }

    @DeleteMapping("/tipos-pago/{idTipoPago}")
    public String eliminar(@PathVariable Integer idTipoPago){
        serviceTipoPago.eliminar(idTipoPago);
        return "Tipo Pago eliminado";
    }
}
