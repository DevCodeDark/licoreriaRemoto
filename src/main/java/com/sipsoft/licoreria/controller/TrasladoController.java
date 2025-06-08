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

import com.sipsoft.licoreria.entity.Traslado;
import com.sipsoft.licoreria.services.ITrasladoService;

@RestController
@RequestMapping("/sipsoft")
public class TrasladoController {
    @Autowired
    private ITrasladoService serviceTraslado;

    @GetMapping("/traslados")
    public List<Traslado> buscarTodos() {
        return serviceTraslado.bucarTodos();
    }
    @PostMapping("/traslados")
    public Traslado guardar(@RequestBody Traslado traslado) {
        serviceTraslado.guardar(traslado);
        return traslado;
    }

    @PutMapping("/traslados")
    public Traslado modificar(@RequestBody Traslado traslado) {
        serviceTraslado.modificar(traslado);
        return traslado;
    }

    @GetMapping("/traslados/{idTraslado}")
    public Optional<Traslado> buscarId(@PathVariable("idTraslado") Integer idTraslado) {
        return serviceTraslado.buscarId(idTraslado);
    }

    @DeleteMapping("/traslados/{idTraslado}")
    public String eliminar(@PathVariable Integer idTraslado){
        serviceTraslado.eliminar(idTraslado);
        return "Traslado eliminado";
    }
}
