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

import com.sipsoft.licoreria.entity.Empresa;
import com.sipsoft.licoreria.services.IEmpresaService;

@RestController
@RequestMapping("/sipsoft")
public class EmpresaController {
    @Autowired
    private IEmpresaService serviceEmpresa;

    @GetMapping("/empresas")
    public List<Empresa> buscarTodos() {
        return serviceEmpresa.bucarTodos();
    }
    @PostMapping("/empresas")
    public Empresa guardar(@RequestBody Empresa empresa) {
        serviceEmpresa.guardar(empresa);
        return empresa;
    }

    @PutMapping("/empresas")
    public Empresa modificar(@RequestBody Empresa empresa) {
        serviceEmpresa.modificar(empresa);
        return empresa;
    }

    @GetMapping("/empresas/{idEmpresa}")
    public Optional<Empresa> buscarId(@PathVariable("idEmpresa") Integer idEmpresa) {
        return serviceEmpresa.buscarId(idEmpresa);
    }

    @DeleteMapping("/empresas/{idEmpresa}")
    public String eliminar(@PathVariable Integer idEmpresa){
        serviceEmpresa.eliminar(idEmpresa);
        return "Empresa eliminada";
    }
}
