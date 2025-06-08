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

import com.sipsoft.licoreria.entity.Permiso;
import com.sipsoft.licoreria.services.IPermisoService;

@RestController
@RequestMapping("/sipsoft")
public class PermisoController {
    @Autowired
    private IPermisoService servicePermiso;

    @GetMapping("/permisos")
    public List<Permiso> buscarTodos() {
        return servicePermiso.bucarTodos();
    }
    @PostMapping("/permisos")
    public Permiso guardar(@RequestBody Permiso permiso) {
        servicePermiso.guardar(permiso);
        return permiso;
    }

    @PutMapping("/permisos")
    public Permiso modificar(@RequestBody Permiso permiso) {
        servicePermiso.modificar(permiso);
        return permiso;
    }

    @GetMapping("/permisos/{idPermiso}")
    public Optional<Permiso> buscarId(@PathVariable("idPermiso") Integer idPermiso) {
        return servicePermiso.buscarId(idPermiso);
    }

    @DeleteMapping("/permisos/{idPermiso}")
    public String eliminar(@PathVariable Integer idPermiso){
        servicePermiso.eliminar(idPermiso);
        return "Permiso eliminado";
    }
}
