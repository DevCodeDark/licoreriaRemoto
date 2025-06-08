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

import com.sipsoft.licoreria.entity.Sucursal;
import com.sipsoft.licoreria.services.ISucursalService;

@RestController
@RequestMapping("/sipsoft")
public class SucursalController {
    @Autowired
    private ISucursalService serviceSucursal;

    @GetMapping("/sucursales")
    public List<Sucursal> buscarTodos() {
        return serviceSucursal.bucarTodos();
    }
    @PostMapping("/sucursales")
    public Sucursal guardar(@RequestBody Sucursal sucursal) {
        serviceSucursal.guardar(sucursal);
        return sucursal;
    }

    @PutMapping("/sucursales")
    public Sucursal modificar(@RequestBody Sucursal sucursal) {
        serviceSucursal.modificar(sucursal);
        return sucursal;
    }

    @GetMapping("/sucursales/{idSucursal}")
    public Optional<Sucursal> buscarId(@PathVariable("idSucursal") Integer idSucursal) {
        return serviceSucursal.buscarId(idSucursal);
    }

    @DeleteMapping("/sucursales/{idSucursal}")
    public String eliminar(@PathVariable Integer idSucursal){
        serviceSucursal.eliminar(idSucursal);
        return "Sucursal eliminada";
    }
}
