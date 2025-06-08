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

import com.sipsoft.licoreria.entity.PagosDeuda;
import com.sipsoft.licoreria.services.IPagosDeudaService;

@RestController
@RequestMapping("/sipsoft")
public class PagosDeudaController {
    @Autowired
    private IPagosDeudaService servicePagosDeuda;

    @GetMapping("/pagos-deuda")
    public List<PagosDeuda> buscarTodos() {
        return servicePagosDeuda.bucarTodos();
    }
    @PostMapping("/pagos-deuda")
    public PagosDeuda guardar(@RequestBody PagosDeuda pagosDeuda) {
        servicePagosDeuda.guardar(pagosDeuda);
        return pagosDeuda;
    }

    @PutMapping("/pagos-deuda")
    public PagosDeuda modificar(@RequestBody PagosDeuda pagosDeuda) {
        servicePagosDeuda.modificar(pagosDeuda);
        return pagosDeuda;
    }

    @GetMapping("/pagos-deuda/{idPagosDeuda}")
    public Optional<PagosDeuda> buscarId(@PathVariable("idPagosDeuda") Integer idPagosDeuda) {
        return servicePagosDeuda.buscarId(idPagosDeuda);
    }

    @DeleteMapping("/pagos-deuda/{idPagosDeuda}")
    public String eliminar(@PathVariable Integer idPagosDeuda){
        servicePagosDeuda.eliminar(idPagosDeuda);
        return "Pago Deuda eliminado";
    }
}
