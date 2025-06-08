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

import com.sipsoft.licoreria.entity.Compra;
import com.sipsoft.licoreria.services.ICompraService;

@RestController
@RequestMapping("/sipsoft")
public class CompraController {
    @Autowired
    private ICompraService serviceCompra;

    @GetMapping("/compras")
    public List<Compra> buscarTodos() {
        return serviceCompra.bucarTodos();
    }
    @PostMapping("/compras")
    public Compra guardar(@RequestBody Compra compra) {
        serviceCompra.guardar(compra);
        return compra;
    }

    @PutMapping("/compras")
    public Compra modificar(@RequestBody Compra compra) {
        serviceCompra.modificar(compra);
        return compra;
    }

    @GetMapping("/compras/{idCompra}")
    public Optional<Compra> buscarId(@PathVariable("idCompra") Integer idCompra) {
        return serviceCompra.buscarId(idCompra);
    }

    @DeleteMapping("/compras/{idCompra}")
    public String eliminar(@PathVariable Integer idCompra){
        serviceCompra.eliminar(idCompra);
        return "Compra eliminada";
    }
}
