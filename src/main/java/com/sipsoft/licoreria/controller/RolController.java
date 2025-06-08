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

import com.sipsoft.licoreria.entity.Rol;
import com.sipsoft.licoreria.services.IRolService;

@RestController
@RequestMapping("/sipsoft")
public class RolController {
    @Autowired
    private IRolService serviceRol;

    @GetMapping("/roles")
    public List<Rol> buscarTodos() {
        return serviceRol.bucarTodos();
    }
    @PostMapping("/roles")
    public Rol guardar(@RequestBody Rol rol) {
        serviceRol.guardar(rol);
        return rol;
    }

    @PutMapping("/roles")
    public Rol modificar(@RequestBody Rol rol) {
        serviceRol.modificar(rol);
        return rol;
    }

    @GetMapping("/roles/{idRol}")
    public Optional<Rol> buscarId(@PathVariable("idRol") Integer idRol) {
        return serviceRol.buscarId(idRol);
    }

    @DeleteMapping("/roles/{idRol}")
    public String eliminar(@PathVariable Integer idRol){
        serviceRol.eliminar(idRol);
        return "Rol eliminado";
    }
}
