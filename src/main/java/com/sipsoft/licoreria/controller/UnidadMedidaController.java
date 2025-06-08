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

import com.sipsoft.licoreria.entity.UnidadMedida;
import com.sipsoft.licoreria.services.IUnidadMedidaService;

@RestController
@RequestMapping("/sipsoft")
public class UnidadMedidaController {
    @Autowired
    private IUnidadMedidaService serviceUnidadMedida;

    @GetMapping("/unidades-medida")
    public List<UnidadMedida> buscarTodos() {
        return serviceUnidadMedida.bucarTodos();
    }
    @PostMapping("/unidades-medida")
    public UnidadMedida guardar(@RequestBody UnidadMedida unidadMedida) {
        serviceUnidadMedida.guardar(unidadMedida);
        return unidadMedida;
    }

    @PutMapping("/unidades-medida")
    public UnidadMedida modificar(@RequestBody UnidadMedida unidadMedida) {
        serviceUnidadMedida.modificar(unidadMedida);
        return unidadMedida;
    }

    @GetMapping("/unidades-medida/{idUnidadMedida}")
    public Optional<UnidadMedida> buscarId(@PathVariable("idUnidadMedida") Integer idUnidadMedida) {
        return serviceUnidadMedida.buscarId(idUnidadMedida);
    }

    @DeleteMapping("/unidades-medida/{idUnidadMedida}")
    public String eliminar(@PathVariable Integer idUnidadMedida){
        serviceUnidadMedida.eliminar(idUnidadMedida);
        return "Unidad Medida eliminada";
    }
}
