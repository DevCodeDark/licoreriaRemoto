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

import com.sipsoft.licoreria.entity.ContratoProveedor;
import com.sipsoft.licoreria.services.IContratoProveedorService;

@RestController
@RequestMapping("/sipsoft")
public class ContratoProveedorController {
    @Autowired
    private IContratoProveedorService serviceContratoProveedor;

    @GetMapping("/contratos-proveedor")
    public List<ContratoProveedor> buscarTodos() {
        return serviceContratoProveedor.bucarTodos();
    }
    @PostMapping("/contratos-proveedor")
    public ContratoProveedor guardar(@RequestBody ContratoProveedor contratoProveedor) {
        serviceContratoProveedor.guardar(contratoProveedor);
        return contratoProveedor;
    }

    @PutMapping("/contratos-proveedor")
    public ContratoProveedor modificar(@RequestBody ContratoProveedor contratoProveedor) {
        serviceContratoProveedor.modificar(contratoProveedor);
        return contratoProveedor;
    }

    @GetMapping("/contratos-proveedor/{idContratoProveedor}")
    public Optional<ContratoProveedor> buscarId(@PathVariable("idContratoProveedor") Integer idContratoProveedor) {
        return serviceContratoProveedor.buscarId(idContratoProveedor);
    }

    @DeleteMapping("/contratos-proveedor/{idContratoProveedor}")
    public String eliminar(@PathVariable Integer idContratoProveedor){
        serviceContratoProveedor.eliminar(idContratoProveedor);
        return "Contrato Proveedor eliminado";
    }
}
