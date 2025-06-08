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

import com.sipsoft.licoreria.entity.Proveedor;
import com.sipsoft.licoreria.services.IProveedorService;

@RestController
@RequestMapping("/sipsoft")
public class ProveedorController {
    @Autowired
    private IProveedorService serviceProveedor;

    @GetMapping("/proveedores")
    public List<Proveedor> buscarTodos() {
        return serviceProveedor.bucarTodos();
    }
    @PostMapping("/proveedores")
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        serviceProveedor.guardar(proveedor);
        return proveedor;
    }

    @PutMapping("/proveedores")
    public Proveedor modificar(@RequestBody Proveedor proveedor) {
        serviceProveedor.modificar(proveedor);
        return proveedor;
    }

    @GetMapping("/proveedores/{idProveedor}")
    public Optional<Proveedor> buscarId(@PathVariable("idProveedor") Integer idProveedor) {
        return serviceProveedor.buscarId(idProveedor);
    }

    @DeleteMapping("/proveedores/{idProveedor}")
    public String eliminar(@PathVariable Integer idProveedor){
        serviceProveedor.eliminar(idProveedor);
        return "Proveedor eliminado";
    }
}
