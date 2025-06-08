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

import com.sipsoft.licoreria.entity.Almacen;
import com.sipsoft.licoreria.services.IAlmacenesService;

@RestController
@RequestMapping("/sipsoft")
public class AlmacenController {
    @Autowired
    private IAlmacenesService serviceAlmacenes;

    @GetMapping("/almacenes")
    public List<Almacen> buscarTodos() {
        return serviceAlmacenes.bucarTodos();
    }
    @PostMapping("/almacenes")
    public Almacen guardar(@RequestBody Almacen almacen) {
        serviceAlmacenes.guardar(almacen);
        return almacen;
    }

    @PutMapping("/almacenes")
    public Almacen modificar(@RequestBody Almacen almacen) {
        serviceAlmacenes.modificar(almacen);
        return almacen;
    }

    @GetMapping("/almacenes/{idAlmacen}")
    public Optional<Almacen> buscarId(@PathVariable("idAlmacen") Integer idAlmacen) {
        return serviceAlmacenes.buscarId(idAlmacen);
    }

    @DeleteMapping("/almacenes/{idAlmacen}")
    public String eliminar(@PathVariable Integer idAlmacen){
        serviceAlmacenes.eliminar(idAlmacen);
        return "Almacen eliminado";
    }
}
