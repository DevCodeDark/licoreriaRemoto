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

import com.sipsoft.licoreria.entity.MovimientosStock;
import com.sipsoft.licoreria.services.IMovimientosStockService;

@RestController
@RequestMapping("/sipsoft")
public class MovimientosStockController {
    @Autowired
    private IMovimientosStockService serviceMovimientosStock;

    @GetMapping("/movimientos-stock")
    public List<MovimientosStock> buscarTodos() {
        return serviceMovimientosStock.bucarTodos();
    }
    @PostMapping("/movimientos-stock")
    public MovimientosStock guardar(@RequestBody MovimientosStock movimientosStock) {
        serviceMovimientosStock.guardar(movimientosStock);
        return movimientosStock;
    }

    @PutMapping("/movimientos-stock")
    public MovimientosStock modificar(@RequestBody MovimientosStock movimientosStock) {
        serviceMovimientosStock.modificar(movimientosStock);
        return movimientosStock;
    }

    @GetMapping("/movimientos-stock/{idMovimientoStock}")
    public Optional<MovimientosStock> buscarId(@PathVariable("idMovimientoStock") Integer idMovimientoStock) {
        return serviceMovimientosStock.buscarId(idMovimientoStock);
    }

    @DeleteMapping("/movimientos-stock/{idMovimientoStock}")
    public String eliminar(@PathVariable Integer idMovimientoStock){
        serviceMovimientosStock.eliminar(idMovimientoStock);
        return "Movimiento Stock eliminado";
    }
}
