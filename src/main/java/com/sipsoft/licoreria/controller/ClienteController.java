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

import com.sipsoft.licoreria.entity.Cliente;
import com.sipsoft.licoreria.services.IClienteService;

@RestController
@RequestMapping("/sipsoft")
public class ClienteController {
    @Autowired
    private IClienteService serviceCliente;

    @GetMapping("/clientes")
    public List<Cliente> buscarTodos() {
        return serviceCliente.bucarTodos();
    }
    @PostMapping("/clientes")
    public Cliente guardar(@RequestBody Cliente cliente) {
        serviceCliente.guardar(cliente);
        return cliente;
    }

    @PutMapping("/clientes")
    public Cliente modificar(@RequestBody Cliente cliente) {
        serviceCliente.modificar(cliente);
        return cliente;
    }

    @GetMapping("/clientes/{idCliente}")
    public Optional<Cliente> buscarId(@PathVariable("idCliente") Integer idCliente) {
        return serviceCliente.buscarId(idCliente);
    }

    @DeleteMapping("/clientes/{idCliente}")
    public String eliminar(@PathVariable Integer idCliente){
        serviceCliente.eliminar(idCliente);
        return "Cliente eliminado";
    }
}
