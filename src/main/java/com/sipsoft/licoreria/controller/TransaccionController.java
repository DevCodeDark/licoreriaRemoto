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

import com.sipsoft.licoreria.entity.Transaccion;
import com.sipsoft.licoreria.services.ITransaccionService;

@RestController
@RequestMapping("/sipsoft")
public class TransaccionController {
    @Autowired
    private ITransaccionService serviceTransaccion;

    @GetMapping("/transacciones")
    public List<Transaccion> buscarTodos() {
        return serviceTransaccion.bucarTodos();
    }
    @PostMapping("/transacciones")
    public Transaccion guardar(@RequestBody Transaccion transaccion) {
        serviceTransaccion.guardar(transaccion);
        return transaccion;
    }

    @PutMapping("/transacciones")
    public Transaccion modificar(@RequestBody Transaccion transaccion) {
        serviceTransaccion.modificar(transaccion);
        return transaccion;
    }

    @GetMapping("/transacciones/{idTransaccion}")
    public Optional<Transaccion> buscarId(@PathVariable("idTransaccion") Integer idTransaccion) {
        return serviceTransaccion.buscarId(idTransaccion);
    }

    @DeleteMapping("/transacciones/{idTransaccion}")
    public String eliminar(@PathVariable Integer idTransaccion){
        serviceTransaccion.eliminar(idTransaccion);
        return "Transaccion eliminada";
    }
}
