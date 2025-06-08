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

import com.sipsoft.licoreria.entity.Modulo;
import com.sipsoft.licoreria.services.IModuloService;

@RestController
@RequestMapping("/sipsoft")
public class ModuloController {
    @Autowired
    private IModuloService serviceModulo;

    @GetMapping("/modulos")
    public List<Modulo> buscarTodos() {
        return serviceModulo.bucarTodos();
    }
    @PostMapping("/modulos")
    public Modulo guardar(@RequestBody Modulo modulo) {
        serviceModulo.guardar(modulo);
        return modulo;
    }

    @PutMapping("/modulos")
    public Modulo modificar(@RequestBody Modulo modulo) {
        serviceModulo.modificar(modulo);
        return modulo;
    }

    @GetMapping("/modulos/{idModulo}")
    public Optional<Modulo> buscarId(@PathVariable("idModulo") Integer idModulo) {
        return serviceModulo.buscarId(idModulo);
    }

    @DeleteMapping("/modulos/{idModulo}")
    public String eliminar(@PathVariable Integer idModulo){
        serviceModulo.eliminar(idModulo);
        return "Modulo eliminado";
    }
}
