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

import com.sipsoft.licoreria.entity.Caja;
import com.sipsoft.licoreria.services.ICajaService;

@RestController
@RequestMapping("/sipsoft")
public class CajaController {
    @Autowired
    private ICajaService serviceCaja;

    @GetMapping("/cajas")
    public List<Caja> buscarTodos() {
        return serviceCaja.bucarTodos();
    }
    @PostMapping("/cajas")
    public Caja guardar(@RequestBody Caja caja) {
        serviceCaja.guardar(caja);
        return caja;
    }

    @PutMapping("/cajas")
    public Caja modificar(@RequestBody Caja caja) {
        serviceCaja.modificar(caja);
        return caja;
    }

    @GetMapping("/cajas/{idCaja}")
    public Optional<Caja> buscarId(@PathVariable("idCaja") Integer idCaja) {
        return serviceCaja.buscarId(idCaja);
    }

    @DeleteMapping("/cajas/{idCaja}")
    public String eliminar(@PathVariable Integer idCaja){
        serviceCaja.eliminar(idCaja);
        return "Caja eliminada";
    }
}
