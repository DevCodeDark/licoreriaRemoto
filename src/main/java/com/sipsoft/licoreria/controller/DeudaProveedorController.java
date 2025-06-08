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

import com.sipsoft.licoreria.entity.DeudaProveedor;
import com.sipsoft.licoreria.services.IDeudaProveedorService;

@RestController
@RequestMapping("/sipsoft")
public class DeudaProveedorController {
    @Autowired
    private IDeudaProveedorService serviceDeudaProveedor;

    @GetMapping("/deuda-proveedor")
    public List<DeudaProveedor> buscarTodos() {
        return serviceDeudaProveedor.bucarTodos();
    }
    @PostMapping("/deuda-proveedor")
    public DeudaProveedor guardar(@RequestBody DeudaProveedor deudaProveedor) {
        serviceDeudaProveedor.guardar(deudaProveedor);
        return deudaProveedor;
    }

    @PutMapping("/deuda-proveedor")
    public DeudaProveedor modificar(@RequestBody DeudaProveedor deudaProveedor) {
        serviceDeudaProveedor.modificar(deudaProveedor);
        return deudaProveedor;
    }

    @GetMapping("/deuda-proveedor/{idDeuda}")
    public Optional<DeudaProveedor> buscarId(@PathVariable("idDeuda") Integer idDeuda) {
        return serviceDeudaProveedor.buscarId(idDeuda);
    }

    @DeleteMapping("/deuda-proveedor/{idDeuda}")
    public String eliminar(@PathVariable Integer idDeuda){
        serviceDeudaProveedor.eliminar(idDeuda);
        return "Deuda Proveedor eliminada";
    }
}
