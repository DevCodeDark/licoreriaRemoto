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

import com.sipsoft.licoreria.entity.Lote;
import com.sipsoft.licoreria.services.ILoteService;

@RestController
@RequestMapping("/sipsoft")
public class LoteController {
    @Autowired
    private ILoteService serviceLote;

    @GetMapping("/lotes")
    public List<Lote> buscarTodos() {
        return serviceLote.bucarTodos();
    }
    @PostMapping("/lotes")
    public Lote guardar(@RequestBody Lote lote) {
        serviceLote.guardar(lote);
        return lote;
    }

    @PutMapping("/lotes")
    public Lote modificar(@RequestBody Lote lote) {
        serviceLote.modificar(lote);
        return lote;
    }

    @GetMapping("/lotes/{idLote}")
    public Optional<Lote> buscarId(@PathVariable("idLote") Integer idLote) {
        return serviceLote.buscarId(idLote);
    }

    @DeleteMapping("/lotes/{idLote}")
    public String eliminar(@PathVariable Integer idLote){
        serviceLote.eliminar(idLote);
        return "Lote eliminado";
    }
}
